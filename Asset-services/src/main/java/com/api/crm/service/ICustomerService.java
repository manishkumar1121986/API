package com.api.crm.service;

import com.api.crm.domainobject.CustomerDomainObject;
import com.api.crm.domainobject.ListCustomerDomainObject;

public interface ICustomerService {
	
	CustomerDomainObject customer(CustomerDomainObject customerDomainObject);
	ListCustomerDomainObject getCoustomerList();

}
