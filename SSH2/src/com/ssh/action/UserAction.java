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
	private int id;
	
	
	public String register(){
		if(userService.userExist(user)&&userService.check(user)){
			userService.add(user);
			return SUCCESS;
		}else 
			return ERROR;
	}
	
	public String login(){
		if(userService.loginManager(user)&&userService.checkPIN(user))
			return "manager";
		else if((!userService.userExist(user))&&userService.login(user)&&userService.checkPIN(user))
				return "success"; 
		else
			return ERROR;
	} 
	
	
	public String list(){
		users=userService.getUsers();
		return "u_list";
	}
	
	public String delete(){
		userService.delete(id);
		users=userService.getUsers();
		return "u_list";
	}
	
	public String cancel(){
		userService.cancel();
		return "cancel";
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
