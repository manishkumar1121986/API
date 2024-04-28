package com.api.util;



import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.api.environment.EnvironmentProperties;


public final class ServiceLocator extends MBaseLogger
{

    private ServiceLocator()
    {
        try
        {
            context = getInitialContext();
            cacheMap = Collections.synchronizedMap(new HashMap<Object,Object>());
        }
        catch(Exception ex)
        {
            error(ex);
        }
    }

    public static ServiceLocator getInstance()
    {
    	//sonar change
        if(serviceLocatorInstance == null)
        {
            serviceLocatorInstance = new ServiceLocator();
          
        }
        return serviceLocatorInstance;
    }

  
    public DataSource getDataSource()
        throws Exception
    {
        DataSource dataSource = null;
        String dbJndi = EnvironmentProperties.getProperty("database.JNDI_NAME");
        try
        {

            if(cacheMap.containsKey(dbJndi))
            {
                dataSource = (DataSource)cacheMap.get(dbJndi);
             } else
            {
                dataSource = (DataSource)context.lookup(dbJndi);
                cacheMap.put(dbJndi, dataSource);
            }
        }
        catch(Exception ex)
        {
            debug(ex);
            throw ex;
        }
        return dataSource;
    }

    public DataSource getDataSource(String dbJndi)
            throws Exception
        {
            DataSource dataSource = null;
            try
            {

                if(cacheMap.containsKey(dbJndi))
                {
                    dataSource = (DataSource)cacheMap.get(dbJndi);
                 } else
                {
                    dataSource = (DataSource)context.lookup(dbJndi);
                    cacheMap.put(dbJndi, dataSource);
                }
            }
            catch(Exception ex)
            {
                debug(ex);
                throw ex;
            }
            return dataSource;
        }

    public static Context getInitialContext()
        throws NamingException
    {
        Hashtable<Object,Object> env = new Hashtable<Object,Object>();
        env.put("java.naming.factory.initial", EnvironmentProperties.getProperty("jndi.INITIAL_CONTEXT_FACTORY"));
        env.put("java.naming.security.principal", EnvironmentProperties.getProperty("jndi.SECURITY_PRINCIPAL"));
        env.put("java.naming.security.credentials", EnvironmentProperties.getProperty("jndi.SECURITY_CREDENTIALS"));
        env.put("java.naming.provider.url", EnvironmentProperties.getProperty("jndi.PROVIDER_URL"));
        return new InitialContext(env);
    }

    public String getFilePath()
    {
        String filePath = null;
        filePath = getEnvValue("CrsPath");
        if(filePath == null || filePath.equals("")){
        	filePath = ".";
        }
            
        return filePath;
    }

    private String getEnvValue(String envNameP)
    {
        String envValue = null;
        String envName = envNameP;
        envName = "java:comp/env/" + envName;
        try
        {
            if(cacheMap.containsKey(envName))
            {
                envValue = (String)cacheMap.get(envName);
            } else
            {
                envValue = (String)context.lookup(envName);
                debug("Picking : " + envName + " from jndi. The value is : " + envValue);
                cacheMap.put(envName, envValue);
            }
        }
        catch(NamingException ne)
        {
            cacheMap.put(envName, null);
        }
        catch(Exception e)
        {
        	cacheMap.put(envName, null);
        }
        return envValue;
    }

    public String getSearchPath()
    {
        String search = null;
        search = EnvironmentProperties.getProperty("DynamicSearch");
        if(search == null || search.equals("")){
        	search = ".";
        }
            
        return search;
    }

    private Context context;
    private Map<Object,Object> cacheMap;
    private static volatile ServiceLocator serviceLocatorInstance;
}