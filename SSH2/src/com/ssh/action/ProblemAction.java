package com.ssh.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.model.Problem;
import com.ssh.service.ProblemService;

public class ProblemAction extends ActionSupport{
	private Problem problem;
	private ProblemService problemService;
	private List<Problem> problems;
	private int id;
	
	
	public String add(){
		if(problemService.add(problem)){
			problemService.fileAdd(problem);
			return SUCCESS;
		}
		else 
			return ERROR; 
	}
	
	public String list(){
		problems = problemService.list();
		return "p_list";
	}
	
	public String delete(){
		if(problemService.delete(id)){
			problemService.fileDelete(id);
			problems = problemService.list();
			return "p_list";
		}
		else 
			return ERROR;
		
		
	}
	
	public String load(){
		this.problem = this.problemService.load(id);
		return "load";
	}
	
	public String update(){
		if(problemService.update(problem)){
			problemService.fileAdd(problem);
			return "success";
		}
		else
			return "error";
	}
	
	
	
	
	
	
	
	
	public Problem getProblem() {
		return problem;
	}
	public void setProblem(Problem problem) {
		this.problem = problem;
	}
	public ProblemService getProblemService() {
		return problemService;
	}
	public void setProblemService(ProblemService problemService) {
		this.problemService = problemService;
	}
	public List<Problem> getProblems() {
		return problems;
	}
	public void setProblems(List<Problem> problems) {
		this.problems = problems;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
