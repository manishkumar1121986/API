package com.api.model.httpheader;

import java.io.Serializable;

public class AssetRESTServiceResponseHeader implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8873809855219802560L;
	private String responseCode;
	private String globalId;
	
	
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getGlobalId() {
		return globalId;
	}
	public void setGlobalId(String globalId) {
		this.globalId = globalId;
	}

	
	
}
