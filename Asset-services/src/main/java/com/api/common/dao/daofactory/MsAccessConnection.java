package com.api.common.dao.daofactory;

import java.sql.*;

import com.api.util.MBaseLogger;



public class MsAccessConnection {

	private static MBaseLogger LOGGER = new MBaseLogger();
	
	public Connection getConnection(){
		
		Connection connection=null;
		try {
			String databaseURL = "jdbc:ucanaccess://E://OneDrive//Database//CRM.accdb";
			connection = DriverManager.getConnection(databaseURL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.debug("Manish Access not available");
		}
		
				return connection;
	}
	
}
