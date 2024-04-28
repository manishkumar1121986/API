package com.api.crm.service;

import javax.inject.Inject;
import javax.inject.Named;

import com.api.crm.businessobject.*;
import com.api.crm.domainobject.CustomerDomainObject;
import com.api.crm.domainobject.ListCustomerDomainObject;

@Named("customerService")
public class CustomerService implements ICustomerService {

	@Inject
	@Named("customerBusinessObject")
	private ICustomerBussinessObject customerBussinessObject;
	
	
	@Override
	public CustomerDomainObject customer(CustomerDomainObject customerDomainObject) {
		// TODO Auto-generated method stub
		return customerBussinessObject.customer(customerDomainObject);
	}

	@Override
	public ListCustomerDomainObject getCoustomerList() {
		// TODO Auto-generated method stub
		return customerBussinessObject.getCoustomerList();
	}

}
