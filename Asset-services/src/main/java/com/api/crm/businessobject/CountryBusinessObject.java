package com.api.crm.businessobject;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Named;

import com.api.crm.dao.ICommonServiceDAO;
import com.api.crm.domainobject.CountryDomainObject;
import com.api.crm.domainobject.ProductDomainObject;

@Named("countryBusinessObject")
public class CountryBusinessObject implements ICountryBusinessObject {
	@Inject
	@Named("commonServiceDAO")
	private ICommonServiceDAO commonServiceDAO;
	
	@Override
	public ArrayList<CountryDomainObject> getCountry() {
		
		return commonServiceDAO.country();
	}
}
