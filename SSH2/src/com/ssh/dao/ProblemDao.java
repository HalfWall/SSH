package com.ssh.dao;

import java.util.List;

import com.ssh.model.Problem;

public interface ProblemDao {
	public void add(Problem pro);
	public List<Problem> list();
	public void delete(int id);
	public Problem load(int id);
	public void update(Problem pro);

}
