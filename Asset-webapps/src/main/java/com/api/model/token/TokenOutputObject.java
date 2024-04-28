package com.api.model.token;

import java.io.Serializable;

public class TokenOutputObject implements Serializable {

	private static final long serialVersionUID = -7757415050114809164L;

	private ResponseObject response;

	public ResponseObject getResponse() {
		return response;
	}

	public void setResponse(ResponseObject response) {
		this.response = response;
	}

}
