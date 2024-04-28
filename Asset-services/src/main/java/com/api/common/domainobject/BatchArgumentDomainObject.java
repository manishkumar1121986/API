package com.api.common.domainobject;

import java.util.ArrayList;
import java.util.List;
public class BatchArgumentDomainObject {

	public BatchArgumentDomainObject(int iArgumentLength)
    {
        lstArguments = null;
        if(iArgumentLength == 0){
        	throw new IllegalArgumentException("Invalid argument passed. Length of arguments for batch execution has to be greater than 0");
        }
            
        lstArguments = new ArrayList<Object>(iArgumentLength);
        for(int i = 0; i < iArgumentLength; i++){
        	lstArguments.add(null);
        }

    }

    public void setType(int iIndex, String strType)
    {
        lstArguments.set(iIndex, strType);
    }

    public String getTypeAt(int iIndex)
    {
        return (String)lstArguments.get(iIndex);
    }

    public int getSize()
    {
        return lstArguments.size();
    }

    public static final String DATA_TYPE_INT = "INT";
    public static final String DATA_TYPE_STRING = "STRING";
    public static final String DATA_TYPE_LONG = "LONG";
    public static final String DATA_TYPE_DOUBLE = "DOUBLE";
    public static final String DATA_TYPE_FLOAT = "FLOAT";
    public static final String DATA_TYPE_DATE = "DATE";
    public static final String DATA_TYPE_TIME_STAMP = "TIME_STAMP";
    private List<Object> lstArguments;
}