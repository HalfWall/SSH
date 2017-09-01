package com.ssh.service;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;
import com.ssh.dao.UserDao;
import com.ssh.dao.impl.UserDaoImpl;
import com.ssh.model.User;

@Component("userService")
public class UserService {
	
	private UserDao userDao;
	
	
	//--------------------ע��---------------------------
	//@Transactional
	public void add(User user){
		userDao.save(user);
	}
	
	public boolean userExist(User user){
		return userDao.exist(user);
	}
	
	public boolean check(User user){
		
		if(!this.checkUser(user.getName()))return false;
		if(!this.checkPwd1(user.getPassword()))return false;
		if(!this.checkPwd2(user.getPassword(),user.getPassword2()))return false;
		if(!this.checkEmail(user.getEmail()))return false;
		return true;
	}
	
	public boolean checkUser(String user){
		if(user.length()==0){
			ActionContext.getContext().getSession().put("tip", "�û�������Ϊ��");
			System.out.println("�û�������Ϊ��");
			return false;
		}
		else
			return true;
		
	}
	
	public boolean checkPwd1(String pwd1){
		if(pwd1.length()==0){
			ActionContext.getContext().getSession().put("tip", "���벻��Ϊ��");
			System.out.println("���벻��Ϊ��");
			return false;
		}
		else
			return true;
		
	}
	
	public boolean checkPwd2(String pwd1,String pwd2){
		if(!pwd1.equals(pwd2)){
			ActionContext.getContext().getSession().put("tip", "�������벻ͬ");
			System.out.println("�������벻ͬ");
			return false;
		}
		else
			return true;
		
	}
	
	public boolean checkEmail(String email){
		if(email.indexOf("@") == -1){
			ActionContext.getContext().getSession().put("tip", "�����ʽ����");
			System.out.println("�����ʽ����");
			return false;
		}
		else
			return true;
		
	}

	
	//------------------------------��¼------------------------------
	public boolean login(User user){
		return userDao.login(user);
	}
	
	public boolean loginManager(User user){
		if(user.getName().equals("admin")&&user.getPassword().equals("123456"))
			return true;
		else
			return false;
	}
	
	public boolean checkPIN(User user){
		
		HttpSession sessions = ServletActionContext.getRequest().getSession();
		String validateC = (String) sessions.getAttribute("checkCode");
//		System.out.println(validateC);
//		System.out.println(user.getPinCode());
//		System.out.println(user.getName());
		if (user.getPinCode().equals(validateC)) {
			return true;
		} else {
			ActionContext.getContext().getSession().put("tip2", "��֤�����");
			return false;
		}

	}
	
	
	
	public List<User> getUsers(){
		return userDao.getUsers();
	}
	
	
	public void delete(int id){
		 userDao.delete(id);
	}
	
	public void cancel() {
		ActionContext.getContext().getSession().put("userName", null);
	}

	
	
	
	
	
	
	
	
	public UserDao getUserDao() {
		return userDao;
	}

	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	
}
