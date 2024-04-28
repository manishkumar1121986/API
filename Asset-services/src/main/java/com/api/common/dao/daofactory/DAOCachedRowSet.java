package com.api.common.dao.daofactory;

import java.sql.SQLException;

import com.sun.rowset.CachedRowSetImpl;




public class DAOCachedRowSet extends CachedRowSetImpl
{

	private static final long serialVersionUID = -5387970780930593441L;

	public DAOCachedRowSet()
        throws SQLException
    {
    }

    public String getString(String inParam)
        throws SQLException
    {
        String resultStr = super.getString(inParam);
        if(resultStr != null){
        	return resultStr.trim();
        }
        else{
        	return "";
        }
            
    }

    public String getString(int inParam)
        throws SQLException
    {
        String resultStr = super.getString(inParam);
        if(resultStr != null){
        	return resultStr.trim();
        }
        else{
        	return "";
        }
            
    }
}