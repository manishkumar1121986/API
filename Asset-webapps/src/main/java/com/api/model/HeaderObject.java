package com.api.model;

import java.io.Serializable;

public class HeaderObject implements Serializable {

	private static final long serialVersionUID = 3944887710719855277L;

	private String msgID;
	private String reqSystem;
	private String reqType;
	private String userId;
	private String responseCode;
	private String responseTimeStamp;
	private String status;
	private String token;
	private String password;
	private String responseMsg;

	public String getMsgID() {
		return msgID;
	}

	public void setMsgID(String msgID) {
		this.msgID = msgID;
	}

	public String getReqSystem() {
		return reqSystem;
	}

	public void setReqSystem(String reqSystem) {
		this.reqSystem = reqSystem;
	}

	public String getReqType() {
		return reqType;
	}

	public void setReqType(String reqType) {
		this.reqType = reqType;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseTimeStamp() {
		return responseTimeStamp;
	}

	public void setResponseTimeStamp(String responseTimeStamp) {
		this.responseTimeStamp = responseTimeStamp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getResponseMsg() {
		return responseMsg;
	}

	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}

}