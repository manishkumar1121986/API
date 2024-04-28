package com.api.crm.domainobject;

import java.io.Serializable;
import java.util.List;



public class LoginDomainObject  implements Serializable {


	private static final long serialVersionUID = 4658931175257588920L;
	
	
	private String reqType;
	private String userid;
	private String password;
	private String statucCode;
	
	private String fname;
	private String lname;
	public String getReqType() {
		return reqType;
	}
	public void setReqType(String reqType) {
		this.reqType = reqType;
	}
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
	public String getStatucCode() {
		return statucCode;
	}
	public void setStatucCode(String statucCode) {
		this.statucCode = statucCode;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
