package com.api.crm.domainobject;

import java.io.Serializable;
import java.util.List;

public class ListCustomerDomainObject implements Serializable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1483155358894993710L;
	
	private List<CustomerDomainObject> listCustomerDomainObject;

	public List<CustomerDomainObject> getListCustomerDomainObject() {
		return listCustomerDomainObject;
	}

	public void setListCustomerDomainObject(List<CustomerDomainObject> listCustomerDomainObject) {
		this.listCustomerDomainObject = listCustomerDomainObject;
	}
private String status;
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
}
}