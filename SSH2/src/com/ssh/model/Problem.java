package com.ssh.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Problem {
	private int id;
	private String title;
	private String content;
	private String testIn;
	private String testOut;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTestIn() {
		return testIn;
	}
	public void setTestIn(String testIn) {
		this.testIn = testIn;
	}
	public String getTestOut() {
		return testOut;
	}
	public void setTestOut(String testOut) {
		this.testOut = testOut;
	}

}
