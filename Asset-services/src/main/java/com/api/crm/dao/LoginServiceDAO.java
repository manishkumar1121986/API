package com.api.crm.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.naming.NamingException;

import com.api.common.dao.daofactory.DAOCachedRowSet;
import com.api.common.dao.daofactory.MsAccessConnection;
import com.api.common.dao.daofactory.MySqlConnection;
import com.api.crm.domainobject.LoginDomainObject;
import com.api.util.MBaseLogger;

@Named("loginServiceDAO")
public class LoginServiceDAO implements ILoginServiceDAO{

	
	private static final MBaseLogger LOGGER = new MBaseLogger();
	//ICommonFunctionsDAO DBQUERY =null;
	

	
	public LoginDomainObject validateLogin(String userid,String password) {
		
		
		LoginDomainObject loginDomainobject =new LoginDomainObject();
		DAOCachedRowSet theDAOCachedRowSet = null;
		String query="";
		
		
		try {
			//MsAccessConnection dbconn = new MsAccessConnection();
			MySqlConnection dbconn = new MySqlConnection();
			Connection conn = dbconn.getConnection();
			query = "select * from USERS where userid='"+userid+"' and password='"+password+"'";
			LOGGER.debug("*********Login****query***" + query);
			Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(query);
             
            while (result.next()) {
            	LOGGER.debug("Inside result--->");
                loginDomainobject.setFname(result.getString("FNAME"));
                loginDomainobject.setLname(result.getString("LNAME"));
                loginDomainobject.setStatucCode("S");
                 
               
            }
			
			

		} catch (Exception e) {
			LOGGER.error("Exception EXCEPTION IN RepaymentADomainObject");
			e.printStackTrace();
		}
		
		
		
		return loginDomainobject;
	}



}
