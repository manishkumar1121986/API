package com.api.environment;

import org.jconfig.Configuration;
import org.jconfig.ConfigurationManager;

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
            
        }
        return str;
    }

    private static final Configuration CONFIGURATION = ConfigurationManager.getConfiguration();

}