package com.api.model.dashboard;

import java.io.Serializable;

import com.api.model.HeaderObject;

public class RequestObject implements Serializable {

	private static final long serialVersionUID = -3008332449717058085L;

	private HeaderObject header;
	

	public HeaderObject getHeader() {
		return header;
	}

	public void setHeader(HeaderObject header) {
		this.header = header;
	}

	

}
