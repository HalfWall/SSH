package com.ssh.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.ssh.dao.StatusDao;
import com.ssh.model.Problem;
import com.ssh.model.Status;
import com.ssh.model.User;

@Component("statusDao")
public class StatusDaoImpl implements StatusDao{
	private SessionFactory sessionFactory;


	public void add(int proId) {

		Status status = new Status();
		
		String date = (String)ActionContext.getContext().getSession().get("date");
		String code = (String)ActionContext.getContext().getSession().get("code");
		String time = (String)ActionContext.getContext().getSession().get("time");
		String ans = (String)ActionContext.getContext().getSession().get("ans");
		int userId = (Integer)ActionContext.getContext().getSession().get("userId");

		Session s = sessionFactory.getCurrentSession();
		User u = (User)s.get(User.class, userId);
		Problem pro  = (Problem)s.get(Problem.class, proId);
		
		status.setDate(date);
		status.setCode(code);
		status.setTime(time);
		status.setResult(ans);
		status.setUser(u);
		status.setProblem(pro);
		
		s.save(status);
	}

	public List<Status> list() {
		Session s = sessionFactory.getCurrentSession();
		List<Status> statuses =(List<Status>)s.createQuery("from Status order by id desc").list();
		return statuses;
	}
	
	
	
	
	

	
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



}
