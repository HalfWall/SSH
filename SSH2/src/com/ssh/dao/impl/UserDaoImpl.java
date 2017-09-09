package com.ssh.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.ssh.dao.UserDao;
import com.ssh.model.User;

@Component("userDao")
public class UserDaoImpl implements UserDao{
	private SessionFactory sessionFactory;

	
	//注册
	public void save(User u) {
		Session s = sessionFactory.getCurrentSession();
		s.save(u);
	}
	
	//判断用户是否存在
	public boolean exist(User u) {
		Session s = sessionFactory.getCurrentSession();
		long count =(Long) s.createQuery("select count(*) from User u where u.name= :name")
					.setString("name", u.getName())
					.uniqueResult();
		
		if(count>0){
			ActionContext.getContext().getSession().put("tip", "用户名已存在");
			return false;
		}
		else{
			ActionContext.getContext().getSession().put("tip2", "用户名不存在");
			return true;
		}
	}

	//登录
	public boolean login(User u) {
		Session s = sessionFactory.getCurrentSession();
		
		int id =(Integer) s.createQuery("select id from User u where u.name = :name")
				.setString("name", u.getName())
				.uniqueResult();
		
		User user = (User)s.get(User.class, id);
		
		if(user.getPassword().equals(u.getPassword())){
			ActionContext.getContext().getSession().put("userId", id);
			ActionContext.getContext().getSession().put("userName", u.getName());
			ActionContext.getContext().getSession().put("userSum", user.getAcSum());
			
			return true;
		}else
			ActionContext.getContext().getSession().put("tip2", "密码错误");
			return false;
	}
	
	//返回用户列表
	public List<User> getUsers() {
		Session s = sessionFactory.getCurrentSession();
		List<User> users = (List<User>)s.createQuery("from User").list();
		return users;
	}

	
	public void delete(int id){
		Session s = sessionFactory.getCurrentSession();
		User u =(User)s.get(User.class, id);
		s.delete(u);
	}
	
	public void sum() {
		Session s = sessionFactory.getCurrentSession();
		
		String ans  = (String)ActionContext.getContext().getSession().get("ans");
		int sum = (Integer) ActionContext.getContext().getSession().get("userSum");
		int id  = (Integer) ActionContext.getContext().getSession().get("userId");
		
		if(ans.equals("Accepted")){
			sum=sum+1;
		}
		s.createQuery("update User u set u.acSum = :acSum where u.id = :id")
			.setInteger("acSum", sum)
			.setInteger("id", id)
			.executeUpdate();
		
		ActionContext.getContext().getSession().put("userSum", sum);
			
	}
	
	
	
	
	
	
	
	
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}	


}
