package com.api.model.token;

import java.io.Serializable;

import com.api.model.HeaderObject;

public class ResponseObject implements Serializable {

	private static final long serialVersionUID = 426802430714214571L;

	private HeaderObject header;
	private DataObject data;

	public HeaderObject getHeader() {
		return header;
	}

	public void setHeader(HeaderObject header) {
		this.header = header;
	}

	public DataObject getData() {
		return data;
	}

	public void setData(DataObject data) {
		this.data = data;
	}

}
