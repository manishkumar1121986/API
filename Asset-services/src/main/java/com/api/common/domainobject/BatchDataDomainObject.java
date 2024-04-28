package com.api.common.domainobject;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.api.util.GenericUtilityMProductService;

public class BatchDataDomainObject {
	
	public BatchDataDomainObject(BatchArgumentDomainObject theBatchArgumentDomainObject)
    {
        lstData = null;
        this.theBatchArgumentDomainObject = theBatchArgumentDomainObject;
        lstData = new ArrayList<Object>(theBatchArgumentDomainObject.getSize());
        for(int i = 0; i < theBatchArgumentDomainObject.getSize(); i++){
        	lstData.add(null);
        }
            

    }

    public int getInt(int iIndex)
    {
        return ((Integer)lstData.get(iIndex)).intValue();
    }

    public void setInt(int iIndex, int iData)
    {
        try
        {
            if(!"INT".equals(theBatchArgumentDomainObject.getTypeAt(iIndex))){
            	throw new IllegalArgumentException("Attempt to add int data at an index for which int data is not acceptable.");
            }
                
            setData(iIndex, GenericUtilityMProductService.setInteger(iData));
        }
        catch(ParseException pe)
        {
            throw new IllegalArgumentException("Attempt to add int data is not acceptable.");
        }
    }

    public void setInteger(int iIndex, Integer iData)
    {
        setIntWrapper(iIndex, iData);
    }

    public void setIntWrapper(int iIndex, Integer iData)
    {
        if(!"INT".equals(theBatchArgumentDomainObject.getTypeAt(iIndex)))
        {
            throw new IllegalArgumentException("Attempt to add int data at an index for which int data is not acceptable.");
        } else
        {
            setData(iIndex, iData);
            return;
        }
    }

    public double getDouble(int iIndex)
    {
        return ((Double)lstData.get(iIndex)).doubleValue();
    }

    public void setDouble(int iIndex, double dblData)
    {
        if(!"DOUBLE".equals(theBatchArgumentDomainObject.getTypeAt(iIndex)))
        {
            throw new IllegalArgumentException("Attempt to add double data at an index for which double data is not acceptable.");
        } else
        {
            setData(iIndex, Double.valueOf(dblData));
            return;
        }
    }

    public void setDoubleWrapper(int iIndex, Double dblData)
    {
        if(!"DOUBLE".equals(theBatchArgumentDomainObject.getTypeAt(iIndex)))
        {
            throw new IllegalArgumentException("Attempt to add double data at an index for which double data is not acceptable.");
        } else
        {
            setData(iIndex, dblData);
            return;
        }
    }

    public float getFloat(int iIndex)
    {
        return ((Float)lstData.get(iIndex)).floatValue();
    }

    public void setFloat(int iIndex, float fltData)
    {
        if(!"FLOAT".equals(theBatchArgumentDomainObject.getTypeAt(iIndex)))
        {
            throw new IllegalArgumentException("Attempt to add float data at an index for which float data is not acceptable.");
        } else
        {
            setData(iIndex, Float.valueOf(fltData));
            return;
        }
    }

    public void setFloatWrapper(int iIndex, Float fltData)
    {
        if(!"FLOAT".equals(theBatchArgumentDomainObject.getTypeAt(iIndex)))
        {
            throw new IllegalArgumentException("Attempt to add float data at an index for which float data is not acceptable.");
        } else
        {
            setData(iIndex, fltData);
            return;
        }
    }

    public long getLong(int iIndex)
    {
        return ((Long)lstData.get(iIndex)).longValue();
    }

    public void setLong(int iIndex, long lngData)
    {
        if(!"LONG".equals(theBatchArgumentDomainObject.getTypeAt(iIndex)))
        {
            throw new IllegalArgumentException("Attempt to add long data at an index for which long data is not acceptable.");
        } else
        {
            setData(iIndex, Long.valueOf(lngData));
            return;
        }
    }

    public void setLongWrapper(int iIndex, Long lngData)
    {
        if(!"LONG".equals(theBatchArgumentDomainObject.getTypeAt(iIndex)))
        {
            throw new IllegalArgumentException("Attempt to add long data at an index for which long data is not acceptable.");
        } else
        {
            setData(iIndex, lngData);
            return;
        }
    }

    public String getString(int iIndex)
    {
        return (String)lstData.get(iIndex);
    }

    public void setString(int iIndex, String strData)
    {
        if(!"STRING".equals(theBatchArgumentDomainObject.getTypeAt(iIndex)))
        {
            throw new IllegalArgumentException("Attempt to add String data at an index for which String data is not acceptable.");
        } else
        {
            setData(iIndex, strData);
            return;
        }
    }

    public Date getDate(int iIndex)
    {
        return (Date)lstData.get(iIndex);
    }

    public Timestamp getTimeStamp(int iIndex)
    {
        return (Timestamp)lstData.get(iIndex);
    }

    public void setTimeStamp(int iIndex, Timestamp dtDate)
    {
        if(!"TIME_STAMP".equals(theBatchArgumentDomainObject.getTypeAt(iIndex)))
        {
            throw new IllegalArgumentException("Attempt to add Date data at an index for which Date data is not acceptable.");
        } else
        {
            setData(iIndex, dtDate);
            return;
        }
    }

    public void setDate(int iIndex, Date dtDate)
    {
        if(!"DATE".equals(theBatchArgumentDomainObject.getTypeAt(iIndex)))
        {
            throw new IllegalArgumentException("Attempt to add Date data at an index for which Date data is not acceptable.");
        } else
        {
            setData(iIndex, dtDate);
            return;
        }
    }

    private void setData(int iIndex, Object objData)
    {
        lstData.set(iIndex, objData);
    }

    public boolean isDataNull(int iIndex)
    {
        boolean bData = false;
        if(lstData.get(iIndex) == null){
        	bData = true;
        }
            
        return bData;
    }

    private List<Object> lstData;
    private BatchArgumentDomainObject theBatchArgumentDomainObject;
}