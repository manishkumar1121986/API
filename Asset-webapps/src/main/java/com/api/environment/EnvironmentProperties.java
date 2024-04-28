package com.api.environment;

import org.jconfig.Configuration;
import org.jconfig.ConfigurationManager;

import com.api.util.MBaseLogger;

public final class EnvironmentProperties
{

    public static String getProperty(String name)
    {
    	String str = null;
        try
        {
        	str = CONFIGURATION.getProperty(name);
        }
        catch(Exception ex)
        {
        	logger.error(ex);
        }
        return str;
    }

    private static MBaseLogger logger = new MBaseLogger();
    private static final Configuration CONFIGURATION = ConfigurationManager.getConfiguration();

}