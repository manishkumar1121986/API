package com.api.model.httpheader;

import java.io.Serializable;

public class AssetRESTServiceRequestHeader implements Serializable{

	private static final long serialVersionUID = 5500796012918801355L;
	
    private String sessionId;
    private String applicationDBDate;
    private String webServiceVersion;
    private String operationFlag;
    private String requestId;
    private String userAgent;
    private String hostServer;
    private String randomSessionId;
    private String userId;
    
    
    
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRandomSessionId() {
		return randomSessionId;
	}
	public void setRandomSessionId(String randomSessionId) {
		this.randomSessionId = randomSessionId;
	}
	public String getUserAgent() {
		return userAgent;
	}
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}
	public String getHostServer() {
		return hostServer;
	}
	public void setHostServer(String hostServer) {
		this.hostServer = hostServer;
	}
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getOperationFlag() {
		return operationFlag;
	}
	public void setOperationFlag(String operationFlag) {
		this.operationFlag = operationFlag;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getApplicationDBDate() {
		return applicationDBDate;
	}
	public void setApplicationDBDate(String applicationDBDate) {
		this.applicationDBDate = applicationDBDate;
	}
	public String getWebServiceVersion() {
		return webServiceVersion;
	}
	public void setWebServiceVersion(String webServiceVersion) {
		this.webServiceVersion = webServiceVersion;
	}	
    
    
	
}
