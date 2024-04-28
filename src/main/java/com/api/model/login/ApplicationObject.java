package com.api.model.login;

import java.io.Serializable;

public class ApplicationObject implements Serializable {

	private static final long serialVersionUID = -386678168389172599L;

	private String userid;
	private String password;
	private String firstname;
	private String lastname;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	

}
