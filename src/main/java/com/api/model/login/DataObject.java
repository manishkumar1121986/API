package com.api.model.login;

import java.io.Serializable;

public class DataObject implements Serializable {

	private static final long serialVersionUID = 2427839129268442701L;

	private ApplicationObject application;
	
	public ApplicationObject getApplication() {
		return application;
	}

	public void setApplication(ApplicationObject application) {
		this.application = application;
	}

	
	

}
