package com.api.common.keyvaluepair;

import java.io.Serializable;

public class KeyValuePair implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = -5748153368487910817L;
	private String parentKey;
	private String key;
	private String value;
	private String description;
	
	public String getParentKey() {
		return parentKey;
	}
	public void setParentKey(String parentKey) {
		this.parentKey = parentKey;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
