package com.api.model.token;

import java.io.Serializable;

public class DataObject implements Serializable {

	private static final long serialVersionUID = 2427839129268442701L;

	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
