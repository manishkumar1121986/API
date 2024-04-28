package com.api.crm.service;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Named;

import com.api.crm.businessobject.*;
import com.api.crm.domainobject.*;

@Named("masterService")
public class MasterService implements IMasterService {

	@Inject
	@Named("productBusinessObject")
	private IProductBusinessObject productBusinessobject;
	
	@Inject
	@Named("countryBusinessObject")
	private ICountryBusinessObject countryBusinessObject;
	
	@Override
	public ArrayList<ProductDomainObject> getProduct(){
		
		return productBusinessobject.getProduct();
	}
	@Override
	public ArrayList<CountryDomainObject> getCountry(){
		return countryBusinessObject.getCountry();
	}
}
