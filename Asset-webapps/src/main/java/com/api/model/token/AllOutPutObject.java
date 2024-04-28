package com.api.model.token;

import java.io.Serializable;

import com.api.model.token.ResponseObject;

public class AllOutPutObject implements Serializable {

	private static final long serialVersionUID = -7757415050114809164L;

	private ResponseObject response;

	public ResponseObject getResponse() {
		return response;
	}

	public void setResponse(ResponseObject response2) {
		this.response = response2;
	}

}
