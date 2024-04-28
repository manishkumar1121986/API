package com.api.crm.businessobject;

import com.api.crm.domainobject.CustomerDomainObject;
import com.api.crm.domainobject.ListCustomerDomainObject;

public interface ICustomerBussinessObject {

	
	CustomerDomainObject customer(CustomerDomainObject customerDomainObject);
	ListCustomerDomainObject getCoustomerList();
}
