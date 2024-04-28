package com.api.common.domainobject;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;

import com.api.util.GenericUtilityMProductService;

public class PreparedStatementDomainObject {

	    public PreparedStatementDomainObject()
	    {
	        nullFlag = false;
	    }

	    public void setNullFlag()
	    {
	        nullFlag = true;
	    }

	    public boolean getNullFlag()
	    {
	        return nullFlag;
	    }

	    public void setFloatValue(float floatValue)
	    {
	        this.floatValue = floatValue;
	    }

	    public float getFloatValue()
	    {
	        return floatValue;
	    }

	    public void setIntValue(int intValue)
	    {
	        this.intValue = intValue;
	    }

	    public void setIntValue(String intValue)
	        throws ParseException
	    {
	        this.intValue = GenericUtilityMProductService.setInt(intValue);
	    }

	    public int getIntValue()
	    {
	        return intValue;
	    }

	    public void setStringValue(String stringValue)
	    {
	    	this.stringValue=stringValue;
	    }

	    public Date getDateValue()
	    {
	        return dateValue;
	    }

	    public void setDateValue(Date dateValue)
	    {
	        this.dateValue = dateValue;
	    }

	    public double getDoubleValue()
	    {
	        return doubleValue;
	    }

	    public void setDoubleValue(double doubleValue)
	    {
	        this.doubleValue = doubleValue;
	    }

	    public long getLongValue()
	    {
	        return longValue;
	    }

	    public void setLongValue(long longValue)
	    {
	        this.longValue = longValue;
	    }

	    public Timestamp getTimestampValue()
	    {
	        return timestampValue;
	    }

	    public void setTimestampValue(Timestamp timestampValue)
	    {
	        this.timestampValue = timestampValue;
	    }

	    public String getStringValue()
	    {
	        return stringValue;
	    }

	    public void setTypeAt(int typeAtP)
	    {
	        typeAt = typeAtP;
	    }

	    public int getTypeAt()
	    {
	        return typeAt;
	    }

	    public void setType(int typeP)
	    {
	        type = typeP;
	    }

	    public int getType()
	    {
	        return type;
	    }

	    public static final int DATA_TYPE_INT = 0;
	    public static final int DATA_TYPE_STRING = 1;
	    public static final int DATA_TYPE_LONG = 2;
	    public static final int DATA_TYPE_DOUBLE = 3;
	    public static final int DATA_TYPE_FLOAT = 4;
	    public static final int DATA_TYPE_DATE = 5;
	    public static final int DATA_TYPE_TIME_STAMP = 6;
	    private int type;
	    private int typeAt;
	    private int intValue;
	    private String stringValue;
	    private float floatValue;
	    private long longValue;
	    private double doubleValue;
	    private Date dateValue;
	    private Timestamp timestampValue;
	    private boolean nullFlag;
	}