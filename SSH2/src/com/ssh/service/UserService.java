package com.ssh.service;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.UserDao;
import com.ssh.dao.impl.UserDaoImpl;
import com.ssh.model.User;

@Component("userService")
public class UserService {
	
	private UserDao userDao;
	
	//@Transactional
	public void add(User user){
		userDao.save(user);
	}

	public List<User> getUsers(){
		return userDao.getUsers();
	}
	
	
	
	public UserDao getUserDao() {
		return userDao;
	}

	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
