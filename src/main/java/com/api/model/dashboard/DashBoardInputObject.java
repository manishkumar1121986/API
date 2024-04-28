package com.api.model.dashboard;

import java.io.Serializable;


public class DashBoardInputObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 902828427389199023L;
	private RequestObject request;

	public RequestObject getRequest() {
		return request;
	}

	public void setRequest(RequestObject request) {
		this.request = request;
	}
}
