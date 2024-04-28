package com.api.crm.businessobject;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Named;

import com.api.crm.dao.ICommonServiceDAO;
import com.api.crm.dao.ILoginServiceDAO;
import com.api.crm.domainobject.LoginDomainObject;
import com.api.crm.domainobject.ProductDomainObject;

@Named("productBusinessObject")
public class ProductBusinessObject implements IProductBusinessObject {

	@Inject
	@Named("commonServiceDAO")
	private ICommonServiceDAO commonServiceDAO;
	
	
	@Override
	public ArrayList<ProductDomainObject> getProduct() {
		
		return commonServiceDAO.product();
	}
}
