package com.api.common.dao.daofactory;
import java.sql.SQLException;

public abstract class DAOFactory
{

    public abstract Object getDAOObject(String s)
        throws SQLException;

    public static DAOFactory getDAOFactory()
    {
        DAOFactory objDAOFactory = null;
        switch(1)
        {
        case 1: 
            objDAOFactory = OracleDAOFactory.getInstance();
            break;
        default:
			break;
        }
        return objDAOFactory;
    }

    public static final int ORACLE = 1;
    public static final int DATABASETYPE = 1;
}