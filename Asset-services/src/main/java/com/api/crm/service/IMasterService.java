package com.api.crm.service;

import java.util.ArrayList;

import com.api.crm.domainobject.*;

public interface IMasterService {
	
	ArrayList<ProductDomainObject> getProduct();
	ArrayList<CountryDomainObject> getCountry();

}
