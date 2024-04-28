package com.api.controlparameters.domainobject;

import java.io.Serializable;

public class MailingContentParameter implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1753980849322440310L;
	private String key;
	private String value;
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
