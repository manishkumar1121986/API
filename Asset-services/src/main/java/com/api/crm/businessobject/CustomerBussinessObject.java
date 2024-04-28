package com.api.crm.businessobject;

import javax.inject.Inject;
import javax.inject.Named;

import com.api.crm.dao.ICommonServiceDAO;
import com.api.crm.domainobject.CustomerDomainObject;
import com.api.crm.domainobject.ListCustomerDomainObject;

@Named("customerBusinessObject")
public class CustomerBussinessObject implements ICustomerBussinessObject {
	@Inject
	@Named("commonServiceDAO")
	private ICommonServiceDAO commonServiceDAO;
	
	
	public CustomerDomainObject customer(CustomerDomainObject customerDomainObject) {
		return commonServiceDAO.customer(customerDomainObject);
	}
	public ListCustomerDomainObject getCoustomerList() {
		return commonServiceDAO.getCoustomerList();
	}
}
