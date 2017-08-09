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
			System.out.println("�û�������Ϊ��");
			return false;
		}
		else
			return true;
		
	}
	
	public boolean checkPwd1(String pwd1){
		if(pwd1.length()==0){
			System.out.println("���벻��Ϊ��");
			return false;
		}
		else
			return true;
		
	}
	
	public boolean checkPwd2(String pwd1,String pwd2){
		if(!pwd1.equals(pwd2)){
			System.out.println("�������벻ͬ");
			return false;
		}
		else
			return true;
		
	}
	
	public boolean checkEmail(String email){
		if(email.indexOf("@") == -1){
			System.out.println("�����ʽ����");
			return false;
		}
		else
			return true;
		
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
