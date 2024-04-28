package com.api.common.dao.daofactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.api.util.MBaseLogger;

public class MySqlConnection {
	
private static MBaseLogger LOGGER = new MBaseLogger();
	
	public Connection getConnection(){
		
		Connection connection=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			 connection=DriverManager.getConnection(  
			"jdbc:mysql://118.139.180.148:3306/infinitylinkuae","CRM","Mani@01121986");  
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.debug("Godaddy Access not available");
		}
		
				return connection;
	}
}
