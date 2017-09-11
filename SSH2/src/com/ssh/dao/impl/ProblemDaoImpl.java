package com.ssh.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.ssh.dao.ProblemDao;
import com.ssh.model.Problem;

@Component("problemDao")
public class ProblemDaoImpl implements ProblemDao{
	private SessionFactory sessionFactory;

	
	//�����Ŀ
	public void add(Problem pro) {
		Session s = sessionFactory.getCurrentSession();
		s.save(pro);
	}

	//�г�������Ŀ
	public List<Problem> list() {
		Session s = sessionFactory.getCurrentSession();
		List<Problem> problems = (List<Problem>)s.createQuery("from Problem").list();
		return problems;
	}

	//ɾ����Ŀ
	public void delete(int id) {
		Session s = sessionFactory.getCurrentSession();
		Problem pro =(Problem)s.get(Problem.class, id);
		s.delete(pro);
	}

	//load��Ŀ��Ϣ
	public Problem load(int id) {
		Session s = sessionFactory.getCurrentSession();
		Problem pro = (Problem)s.load(Problem.class, id);
		return pro;
	}
	
	//������Ŀ
	public void update(Problem pro) {
		Session s = sessionFactory.getCurrentSession();
		s.createQuery("update Problem pro set pro.title = :title,pro.content = :content," +
				"pro.testIn = :testIn,pro.testOut = :testOut where pro.id = :id")
			.setString("title", pro.getTitle())
			.setString("content", pro.getContent())
			.setString("testIn", pro.getTestIn())
			.setString("testOut",pro.getTestOut())
			.setInteger("id", pro.getId())
			.executeUpdate();
		
	}

	
	
	
	
	
	
	
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	
}
