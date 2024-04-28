package com.api.crm.dao;


import com.api.crm.domainobject.LoginDomainObject;


public interface ILoginServiceDAO {
	
	
	LoginDomainObject validateLogin(String userid,String password) ;
	

}
