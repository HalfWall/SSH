package com.ssh.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

@Entity
public class User {
	private int id;
	private String name;
	private String password;
	private String password2;
	private String email;
	private String sex;
	private int acSum;
	private String pinCode;
	private Set<Problem> problems = new HashSet<Problem>();
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Transient
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAcSum() {
		return acSum;
	}
	public void setAcSum(int acSum) {
		this.acSum = acSum;
	}
	@Transient
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	
	
	@ManyToMany
	@JoinTable(name="status",
			joinColumns=@JoinColumn(name="user_id"),
			inverseJoinColumns=@JoinColumn(name="problem_id"))
	public Set<Problem> getProblems() {
		return problems;
	}
	public void setProblems(Set<Problem> problems) {
		this.problems = problems;
	}
	
	
	
	

}
