package com.api.crm.businessobject;

import javax.inject.Inject;
import javax.inject.Named;

import com.api.crm.dao.ILoginServiceDAO;
import com.api.crm.domainobject.LoginDomainObject;
import com.api.util.MBaseLogger;

@Named("loginbusinessobject")
public class Loginbusinessobject implements ILoginbusinessobject{

	
	@Inject
	@Named("loginServiceDAO")
	private ILoginServiceDAO loginServiceDAO;
	
	@Override
	public LoginDomainObject getApiDetails(LoginDomainObject loginDomainobject) {
		
		//LoginDomainObject apiObject=dueDtlDomainobject;
		
		final MBaseLogger logger = new MBaseLogger();
		
		
		
		String ServiceName= loginDomainobject.getReqType();
		
		logger.debug("MANSIH-->>ServiceName---->>"+ServiceName);	
			
			logger.debug("MANSIH-->>ServiceName---->>"+ServiceName+"----------------Started----------------------------------");
			
				
				
				
				loginDomainobject = loginServiceDAO.validateLogin(loginDomainobject.getUserid(),loginDomainobject.getPassword() );
			
				
				
				
			logger.debug("MANSIH-->>ServiceName---->>"+ServiceName+"----------------END----------------------------------");
			
		
		
		
		
		return loginDomainobject;
	}

}


