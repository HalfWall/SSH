package com.ssh.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.ssh.dao.UserDao;
import com.ssh.model.User;

@Component("userDao")
public class UserDaoImpl implements UserDao{
	private SessionFactory sessionFactory;

	public void save(User u) {
		Session s = sessionFactory.getCurrentSession();
		//s.beginTransaction();
		s.save(u);
		//s.getTransaction().commit();
		
	}


	public List<User> getUsers() {
		Session s = sessionFactory.getCurrentSession();
		//s.beginTransaction();
		//List<User> users = (List<User>)s.createCriteria("from User");
		List<User> users = (List<User>)s.createQuery("from User").list();
		//s.getTransaction().commit();
		return users;
	}

	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}




	





	

	


}
