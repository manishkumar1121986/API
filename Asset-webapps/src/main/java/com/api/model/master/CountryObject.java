package com.api.model.master;

import java.io.Serializable;

public class CountryObject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3126592564242242702L;
	
	
	private String key;
	private String value;
	private String status;
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	

}
