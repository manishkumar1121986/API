package com.api.model.customer;

import java.io.Serializable;


public class CustomerInputObject implements Serializable {

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
