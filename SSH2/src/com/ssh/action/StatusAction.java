package com.ssh.action;

import java.io.IOException;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.model.Status;
import com.ssh.service.StatusService;
import com.ssh.service.UserService;

public class StatusAction extends ActionSupport{
	private Status status;
	private List<Status> statuses;
	private StatusService statusService;
	private int id;
	private UserService userService;
	
	
	public String judge() throws IOException, InterruptedException{
		statusService.judge(status,id);
		statusService.add(id);
		statuses = statusService.list();
		userService.sum();
		return SUCCESS;
	}



	
	
	
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}


	public List<Status> getStatuses() {
		return statuses;
	}

	public void setStatuses(List<Status> statuses) {
		this.statuses = statuses;
	}

	
	public StatusService getStatusService() {
		return statusService;
	}

	public void setStatusService(StatusService statusService) {
		this.statusService = statusService;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	

}
