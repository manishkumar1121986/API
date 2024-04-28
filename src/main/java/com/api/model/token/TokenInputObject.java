package com.api.model.token;

import java.io.Serializable;

public class TokenInputObject implements Serializable {

	private static final long serialVersionUID = -4023592815505358087L;

	private RequestObject request;

	public RequestObject getRequest() {
		return request;
	}

	public void setRequest(RequestObject request) {
		this.request = request;
	}

}
