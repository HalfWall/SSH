package com.ssh.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.model.User;
import com.ssh.service.UserService;


public class UserAction extends ActionSupport{
	private User user = new User();
	private UserService userService;
	private List<User> users;
	
	
	public String register(){
		if(userService.userExist(user)&&userService.check(user)){
			userService.add(user);
			return SUCCESS;
		}else 
			return ERROR;
	}
	
	public String list(){
		users=userService.getUsers();
		return "list";
	}
	
	
	
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
