package com.ssh.dao;

import java.util.List;

import com.ssh.model.User;

public interface UserDao {
	public void save(User u);
	public boolean exist(User u);
	public boolean login(User u);
	public List<User> getUsers();
	public void delete(int id);
	public void sum();

}
