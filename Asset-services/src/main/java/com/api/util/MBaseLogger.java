package com.api.util;

import org.apache.log4j.Logger;
import org.jconfig.Configuration;
import org.jconfig.ConfigurationManager;


public class MBaseLogger {


	public static void initialize(String fileName)
	        throws Exception
	    {
	        /*try
	        {
	            PropertyConfigurator.configure(fileName);
	        }
	        catch(Exception e)
	        {
	           e.getMessage();
	        }*/
	        initialize = true;
	    }

	    public static boolean isInitialized()
	    {
	        return initialize;
	    }

	    public MBaseLogger()
	    {
	        if(!initialize)
	        {
	            throw new RuntimeException("Initialize first");
	        } else
	        {
	            LOGGER = Logger.getLogger("com.api");
	            return;
	        }
	    }

	    public void debug(Object message)
	    {
	        if(LOGGER.isDebugEnabled()){
	        	LOGGER.debug(message);
	        }
	            
	    }

	    public void info(Object message)
	    {
	        LOGGER.info(message);
	    }

	    public void warn(Object message)
	    {
	        LOGGER.warn(message);
	    }

	    public void error(Object message)
	    {
	        LOGGER.error(message);
	    }

	    public void fatal(Object message)
	    {
	        LOGGER.fatal(message);
	    }

	    public boolean isDebugEnabled()
	    {
	        return LOGGER.isDebugEnabled();
	    }

	    private static boolean initialize;
	    private Logger LOGGER;
	    private static final Configuration LOGCONFIG;

	    static
	    {
	        LOGCONFIG = ConfigurationManager.getConfiguration();
	        try
	        {
	            String logprop = LOGCONFIG.getProperty("log4j");
	            initialize(logprop);
	        }
	        catch(Exception e)
	        {
	            e.getMessage();
	        }
	    }
	}