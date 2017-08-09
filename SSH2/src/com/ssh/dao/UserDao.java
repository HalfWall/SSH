package com.ssh.dao;

import java.util.List;

import com.ssh.model.User;

public interface UserDao {
	public void save(User u);
	public boolean exist(User u);
	public List<User> getUsers();

}