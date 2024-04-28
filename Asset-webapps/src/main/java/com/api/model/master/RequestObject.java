package com.api.model.master;

import java.io.Serializable;

import com.api.model.HeaderObject;

public class RequestObject implements Serializable {

	private static final long serialVersionUID = -3008332449717058085L;

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
