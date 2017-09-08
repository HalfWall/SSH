package com.ssh.dao;

import java.util.List;

import com.ssh.model.Status;


public interface StatusDao {

	public void add(int id);
	public List<Status> list();

}
