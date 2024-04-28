package com.api.crm.service;

import javax.inject.Inject;
import javax.inject.Named;

import com.api.crm.businessobject.ILoginbusinessobject;
import com.api.crm.domainobject.LoginDomainObject;

@Named("loginService")
public class LoginService implements ILoginService{
	
	@Inject
	@Named("loginbusinessobject")
	private ILoginbusinessobject loginbusinessobject;

	@Override
	public LoginDomainObject getApiDetails(LoginDomainObject loginDomainObject) {
		return loginbusinessobject.getApiDetails(loginDomainObject);
	}

}
