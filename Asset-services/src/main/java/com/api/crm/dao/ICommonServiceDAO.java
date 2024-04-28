package com.api.crm.dao;


import java.util.ArrayList;

import com.api.crm.domainobject.*;


public interface ICommonServiceDAO {
	
	
	ArrayList<CountryDomainObject>  country() ;
	ArrayList<ProductDomainObject> product();
	CustomerDomainObject customer(CustomerDomainObject customerDomainObject);
	ListCustomerDomainObject getCoustomerList();
	

}
