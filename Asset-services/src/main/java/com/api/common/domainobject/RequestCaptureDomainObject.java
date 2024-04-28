package com.api.common.domainobject;

import java.io.Serializable;

public class RequestCaptureDomainObject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4516539887198918446L;
	
	
	

	private String 	station_name;
	private String 	servicename;
	private String 	userid;
	private String 	msgid;
	private String 	token;
	private String 	token_used;
	public String getStation_name() {
		return station_name;
	}
	public void setStation_name(String station_name) {
		this.station_name = station_name;
	}
	public String getServicename() {
		return servicename;
	}
	public void setServicename(String servicename) {
		this.servicename = servicename;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getMsgid() {
		return msgid;
	}
	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getToken_used() {
		return token_used;
	}
	public void setToken_used(String token_used) {
		this.token_used = token_used;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
