package com.api.util;

import java.security.DigestException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.DESedeKeySpec;

//import sun.misc.BASE64Encoder;
//import  java.util.Base64;
public class GenericUtilityMProductService {


	private static final MBaseLogger LOGGER= new MBaseLogger();


	  public static String getDt (Date pDt)
	  {
	    if (pDt!=null)
	    {
			return new SimpleDateFormat("dd/MM/yyyy").format(pDt);
		}
	    else
	    {
			return null;
		}
	  }
	  public static java.sql.Time getSystemTime()
	  {
		  return new java.sql.Time(System.currentTimeMillis());
	  }

	  public static java.sql.Timestamp getSystemTimestamp()
	  {
		  return new java.sql.Timestamp(System.currentTimeMillis());
	  }

	  /**
	   * Returns the current System Date
	   * @return System Date
	   */
	  public static java.sql.Date getSystemDate()
	  {
		  return new java.sql.Date(System.currentTimeMillis());
	  }

	  /**
	   * Returns the current System Date and Time
	   * @return System Date-Time
	   */
	  public static java.sql.Timestamp getSystemDateTime()
	  {
		  return new java.sql.Timestamp(System.currentTimeMillis());
	  }


	  public static Date setDt (String pDt) throws ParseException
	  {
	    if ((pDt!=null)&&(!pDt.trim().equals("")))
	    {
			return new Date (new SimpleDateFormat("dd/MM/yyyy").parse(pDt).getTime());
		}
	    else
	    {
			return null;
		}
	  }


	  public static Date setSQLDt (String pDt) throws ParseException
	  {
	    if ((pDt!=null)&&(!pDt.trim().equals("")))
	    {
			return new java.sql.Date (new SimpleDateFormat("dd/MM/yyyy").parse(pDt).getTime());
		}
	    else
	    {
			return null;
		}
	  }


	  public static String getInt (int pInt)
	  {
	    if (pInt!=0)
	    {
			return Integer.toString(pInt);
		}
	    else
	    {
			return "";
		}
	  }


	  public static int setInt (String pInt) throws ParseException
	  {
	    if ((pInt!=null)&&(!pInt.trim().equals("")))
	    {
			return Integer.parseInt(pInt);
		}
	    else
	    {
			return 0;
		}
	  }


	  public static String getInteger (Integer pInt)
	  {
	    if (pInt!=null)
	    {
			return pInt.toString();
		}
	    else
	    {
			return "";
		}
	  }


	  public static Integer setInteger (String pInt) throws ParseException
	  {
	    if ((pInt!=null)&&(!pInt.trim().equals("")))
	    {
			return Integer.valueOf(pInt);
		}
	    else
	    {
			return null;
		}
	  }

	  public static Integer setEmptyInteger (String pInt) throws ParseException
	  {
	    if ((pInt!=null)&&(!pInt.trim().equals("")))
	    {
			return Integer.valueOf(pInt);
		}
	    else
	    {
			return Integer.valueOf("0");
		}
	  }

	  public static Integer setInteger (int pInt) throws ParseException
	  {
		return Integer.valueOf(pInt+"");
	  }


	  public static String getDouble (Double pDbl)
	  {
	    if (pDbl!=null)
	    {
			return GenericUtilityMProductService.getDbl (pDbl.doubleValue());
		}
	    else
	    {
			return "";
		}
	  }


	  public static Double setDouble (String pDbl) throws ParseException
	  {
	    if ((pDbl!=null)&&(!pDbl.trim().equals("")))
	    {
			return Double.valueOf(GenericUtilityMProductService.setDbl(pDbl));
		}
	    else
	    {
			return null;
		}
	  }

	  public static Double setEmptyDouble (String pDbl) throws ParseException
	  {
	    if ((pDbl!=null)&&(!pDbl.trim().equals("")))
	    {
			return Double.valueOf(GenericUtilityMProductService.setDbl (pDbl));
		}
	    else
	    {
			return new Double ("0");
		}
	  }



	  public static String getDbl (double pDbl)
	  {
	    if (pDbl!=0.0)
	    {
			return GenericUtilityMProductService.removeLiteral(pDbl+"",",");
		}
	    else
	    {
			return "";
		}
	  }

	  public static double setDbl (String pDblInput) throws ParseException
	  {
		String pDbl = pDblInput;
	    if ((pDbl!=null)&&(!pDbl.trim().equals("")))
	    {
	    	pDbl = GenericUtilityMProductService.removeLiteral(pDbl,",");
			return Double.parseDouble(pDbl);
		}
	    else
	    {
			return 0.00;
		}
	  }

	  public static String getLng (long pLng)
	  {
	    if (pLng!=0.0)
	    {
			return pLng+"";
		}
	    else
	    {
			return "";
		}
	  }

	  public static long setLng (String pLng) throws ParseException
	  {
	    if ((pLng!=null)&&(!pLng.trim().equals("")))
	    {
			return Long.parseLong(pLng);
		}
	    else
	    {
			return 0L;
		}
	  }

	  public static String getString (String pStr)
	  {
	    if (pStr!=null)
	    {
			return pStr;
		}
	    else
	    {
			return "";
		}
	  }

	  public static String setString (String pStr)
	  {
	    if ((pStr!=null)&&(!pStr.trim().equals("")))
	    {
			return pStr;
		}
	    else
	    {
			return null;
		}
	  }


	  public static double doubleFromDouble (Double pDbl)
	  {
	    try
	    {
	    	return setDbl(getDouble(pDbl));
	    }
	    catch(ParseException e)
	    {
		}
	    return 0.00;
	  }


	  public static int intFromInteger (Integer pInt)
	  {
	    try
	    {
	      return setInt(getInteger(pInt));
	    }
	    catch(ParseException e)
	    {
		}
	    return 0;
	  }


	  public static String getDtTime (Timestamp pDt)
	  {
	    if (pDt!=null)
	    {
			return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(pDt);
		}
	    else
	    {
			return null;
		}
	  }


	  public static Timestamp setDtTime (String pDt) throws ParseException
	  {
	    if ((pDt!=null)&&(!pDt.trim().equals("")))
	    {
			return new Timestamp (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(pDt).getTime());
		}
	    else
	    {
			return null;
		}
	  }


	  public static java.util.Date getUtilDate(String pDt) throws ParseException
	  {
	    if ((pDt!=null)&&(!pDt.trim().equals("")))
	    {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			sdf.setLenient(false);
			return sdf.parse(pDt);
		}
	    else
	    {
			return null;
		}
	  }

	  public static java.util.Date getUtilTDate(String pDt) throws ParseException
	  {
	    if ((pDt!=null)&&(!pDt.trim().equals("")))
	    {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			sdf.setLenient(false);
			return sdf.parse(pDt);
		}
	    else
	    {
			return null;
		}
	  }


	 public static String toDateFunction(String oldDate, String toFormat)
			throws ParseException {
		try{
	 	SimpleDateFormat formatter, formatterFinal;
		formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		java.util.Date date = formatter.parse(oldDate.substring(0, oldDate.length()));
		formatterFinal = new SimpleDateFormat(toFormat);
		return formatterFinal.format(date);
		}catch(Exception e){
			return oldDate;
		}
	}



	 public static String toDateDDMMYYYY(String oldDate, String toFormat)
			throws ParseException {
		try{
			SimpleDateFormat formatter, formatterFinal;
			formatter = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = formatter.parse(oldDate.substring(0, oldDate.length()));
			formatterFinal = new SimpleDateFormat(toFormat);
			return formatterFinal.format(date);
		}catch(Exception e){
			return oldDate;
		}
	}

	 public static String toDateDDMMYYYYwithSlash(String oldDate, String toFormat)
			throws ParseException {
		try{
			SimpleDateFormat formatter, formatterFinal;
			formatter = new SimpleDateFormat("dd-MM-yyyy");
			java.util.Date date = formatter.parse(oldDate.substring(0, oldDate.length()));
			formatterFinal = new SimpleDateFormat(toFormat);
			return formatterFinal.format(date);
		}catch(Exception e){
			return oldDate;
		}
	}


	  public static String getStringFromUtil(java.util.Date pDt)
	  {
	    if (pDt!=null)
	    {
			return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(pDt);
		}
	    else
	    {
			return null;
		}
	  }


    public static String getStringFromUtilSearch(java.util.Date pDt)
    {
        if (pDt!=null)
        {
            return new SimpleDateFormat("dd/MM/yyyy").format(pDt);
        }
        else
        {
            return null;
        }
    }


    public static String replaceSingleQuote(String pStr)
    {
        if(pStr==null){
        	return pStr;
        }
        StringBuffer sBuffer = new StringBuffer();
        for(int i=0;i<pStr.length();i++)
        {
            if(pStr.charAt(i) == '\'')
            {
                sBuffer.append("''");
            }
            else
            {
                sBuffer.append(pStr.charAt(i));
            }
        }
        return sBuffer.toString();
    }


	public static String replaceDoubleQuote(String pStr)
	{
		if(pStr==null){
			return pStr;
		} 
		StringBuffer sBuffer = new StringBuffer();
		for(int i=0;i<pStr.length();i++)
		{
			if(pStr.charAt(i) == '"')
			{
				sBuffer.append("'");
			}
			else
			{
				sBuffer.append(pStr.charAt(i));
			}
		}
		return sBuffer.toString();
	}


    public static String removeLiteral(String pStrInput,String rStr)
    {
    	String pStr = pStrInput;
        boolean rStrExist = true;
        StringBuffer sBuffer = new StringBuffer();

        while(rStrExist)
        {
            if(pStr.indexOf(rStr) != -1)
            {
                sBuffer.append(pStr.substring(0,pStr.indexOf(rStr))).append("");
                pStr = pStr.substring(pStr.indexOf(rStr)+rStr.length());
            }
            else
            {
                sBuffer.append(pStr);
                rStrExist = false;
            }
        }
        return sBuffer.toString();
    }
	public static String replaceString(String str1, String str2, String rStr)
	{
	 if(str1==null || str2==null || rStr==null){
		return str1; 
	 }
	  int i =str1.indexOf(str2);
	  int j =str2.length()+i;
	  StringBuffer sbfr = new StringBuffer(str1);
	  if(i>=0){
		  sbfr.replace(i,j,rStr); 
	  }
	  return sbfr.toString();
	}


	public static java.sql.Date getUtilFromTimestamp(Timestamp pDt)
	{
		if (pDt!=null)
		{
			return new java.sql.Date(pDt.getTime());
		}
		else
		{
			return null;
		}
	}


    public static String getLetterGenerationDateString() throws Exception
    {
		java.util.Date dtDate = (java.util.Date)getSystemDateTime();
        String messageDateFormat = "yyyy-MM-dd'T'HH_mm_ss";

        SimpleDateFormat obFmtOutgoing = new SimpleDateFormat(messageDateFormat);
        obFmtOutgoing.setLenient(false);
        return obFmtOutgoing.format(dtDate);
    }

 	public static java.sql.Date getSqlDateFromUtilDate(java.util.Date pDt)
 	{
 		if (pDt!=null)
 		{
 			return new java.sql.Date(pDt.getTime());
 		}
 		else
 		{
 			return null;
 		}
    }

   public static String setFormatDbl(String pDbl) throws ParseException
   {
		if(pDbl==null || pDbl.equals(""))
		{
			return "0.00";
		}
		else
		{
			return GenericUtilityMProductService.removeLiteral(pDbl,",");
		}
   }


   public static String getCorrectAmount(String pamtInput)
   {
	   String pamt = pamtInput;
	   if(pamt==null || pamt.equals(""))
	   {
		   return "0.00";
	   }
	   else if (pamt.equals("0") || pamt.equals("0.0") || pamt.equals("0.00"))
	   {
		   return "0.00";
	   }
	   else if(pamt.contains("-") || pamt.startsWith("-,")||pamt.startsWith("-"))
	   {
		   pamt=pamt.trim();
		   pamt = GenericUtilityMProductService.replaceString(pamt,",","");
		   pamt = GenericUtilityMProductService.replaceString(pamt,"-","");
		   pamt	= GenericUtilityMProductService.getFormatDbl(pamt);
		   pamt = "("+pamt+")";
	   }

	   return pamt;
   }

	 public static String getFormatDbl(String pDblInput)
	  {
		   String pDbl = pDblInput;
		   if(pDbl==null || pDbl.equals(""))
		   {
			   return "0.00";
		   }
		   else if (pDbl.equals("0") || pDbl.equals("0.0") || pDbl.equals("0.00"))
		   {
			   return "0.00";
		   }
		   pDbl=pDbl.trim();
		   pDbl = GenericUtilityMProductService.removeLiteral(pDbl,",");
		   pDbl = GenericUtilityMProductService.replaceString(pDbl,",","");

		   try
		   {
			  Double.parseDouble(pDbl);
		   }
		   catch(Exception e)
		   {
			   return pDbl;
		   }

		   String decimalString = "";
		   String noAfterDec="00";
		   if(pDbl.indexOf('.') > -1)
		   {
			   noAfterDec=pDbl.substring(pDbl.indexOf('.')+1);
			   noAfterDec="0."+noAfterDec;
			   noAfterDec=getRoundedDblFormat(noAfterDec);
			   noAfterDec=noAfterDec.substring(noAfterDec.indexOf('.')+1);
		   }

		   int decimalPosition = pDbl.indexOf('.');
		   String numberBfr = null;
		   if(decimalPosition > -1)
		   {
	
			   numberBfr =  pDbl.substring(0,decimalPosition);
			   
			   decimalString=noAfterDec;
			   if(decimalString.length()==1)
			   {
				   decimalString=decimalString+"0";
			   }
		   }
		   else
		   {
			   numberBfr =  pDbl;
			   decimalString="00";
		   }

		   int commaGap = 3;
		   String numberString = setNumberPlaces(numberBfr, commaGap);
		   String returnValue=numberString+"."+decimalString;

		   return returnValue;
	   }

	 public static String getRoundedDblFormat(String pDblInput)
	   {
		   String pDbl = pDblInput;
		   double dblno=0.00;
		   if(pDbl.equals("0.") || pDbl.equals("0.0") || pDbl.equals("0.00"))
		   {
			   return "0.00";
		   }
		   try
		   {
			   dblno = setDbl(pDbl);
		   } catch (ParseException e)
		   {
			   return pDbl;
		   }
		   dblno=dblno*100;
		   dblno=Math.round(dblno);
		   dblno=dblno/100;

		   pDbl=getDbl(dblno);

		   return pDbl;
	   }

	   public static String removeE(String field)
	   {
		   long temp = (long) Double.parseDouble(field);
		   return temp+"";
	   }

		public static String getEmptyFormatDbl(String pDbl)
		{
		    if ((pDbl!=null)&&(!pDbl.trim().equals("")))
		    {
				return getFormatDbl(pDbl);
			}
		    else
		    {
				return "0.00";
			}
		}

		public static String getEmptyFormatRate(String pDbl, int rateLength) throws ParseException
		{
		    if ((pDbl!=null)&&(!pDbl.trim().equals("")))
		    {
				return getFormatRate(pDbl,rateLength);
			}
		    else
		    {
				return getFormatRate("0",rateLength);
			}
		}

	   public static String getFormatRate(String pDblInput, int rateLength) throws ParseException
	   {
		   String pDbl = pDblInput;
			if(pDbl==null || pDbl.equals(""))
			{
				return "";
			}
			pDbl = GenericUtilityMProductService.replaceString(pDbl,",","");
			try{
			   Double.parseDouble(pDbl);
			}catch(Exception e)
			{
				throw new ParseException("Not able to parse - "+ pDbl,0);
			}
			String decimalString = "";
			int decimalPosition = pDbl.indexOf('.');
			String numberString = null;
			if(decimalPosition > -1)
			{
				numberString =  pDbl.substring(0,decimalPosition);
				decimalString = pDbl.substring(decimalPosition+1);
			}
			else
			{
				numberString =  pDbl;
			}
			decimalString = setDecimalPlaces(decimalString,decimalPosition,rateLength);
			if(numberString==null || numberString.equals(""))
			{
				numberString = "0";
			}
			return numberString+"."+decimalString;
	   }

		public static String setNumberPlaces(String numberBfrInput, int commaGap)
		{
			String numberBfr = numberBfrInput;
			String numberString = null;
			if(numberBfr==null || numberBfr.equals(""))
			{
				numberString = "0";
			}
			else if(numberBfr.length()<=commaGap)
			{
				numberString = numberBfr;
			}
			else
			{
				while(true)
				{
					if (numberBfr.length() > 0 && numberBfr.length()<=commaGap)
					{
						numberString = numberBfr +"," +numberString;
						break;
					}
					numberString = numberBfr.substring(numberBfr.length()-3) +(numberString!=null?","+ numberString:"") ;
					numberBfr = numberBfr.substring(0,numberBfr.length()-3);
				}
			}
			return numberString;
		}
		public static String setDecimalPlaces(String decimalStringInput, int decimalPosition, int lengthRequiredInput)
		{
			String decimalString = decimalStringInput;
			int lengthRequired = lengthRequiredInput;
					
			if(decimalString.length() == lengthRequired)
			{
				return decimalString;
			}
			if(decimalPosition>-1)
			{
				if(decimalString.length()>lengthRequired)
				{
					decimalString = decimalString.substring(0,lengthRequired);
					lengthRequired=0;
				}
				else if(decimalString.length()<lengthRequired)
				{
					lengthRequired = lengthRequired-decimalString.length();
				}
			}
			for(int counter=0; counter<lengthRequired; counter++)
			{
				decimalString = decimalString.concat("0");
			}
			return decimalString;
		}

	  	public static String quotesSeperatedString(String commonSeperateString)
	  	{
			StringTokenizer tokenizer = new StringTokenizer(commonSeperateString,",");
			int count = tokenizer.countTokens();
			StringBuffer buffer = new StringBuffer("");
			for(int i = 0 ; i < count; i ++){
				buffer.append("'").append(tokenizer.nextToken()).append("'").append(",");
			}
			String tempString = buffer.toString();
			return tempString.substring(0,tempString.length() - 1);
	  	}

	  	public static String getStringToBePassedInLikeStatement(ArrayList<String> listOfStrings)
	  	{
			StringBuffer buffer = new StringBuffer("");
			for(int i = 0 ; i < listOfStrings.size() ; i ++){
				buffer.append("'").append(listOfStrings.get(i)).append("'").append(",");
			}
			String tempString = buffer.toString();
			return tempString.substring(0,tempString.length() - 1);
	  	}

	  	public static String getddMMyyyyDate(String dateMMddyyyy) throws ParseException
	  	{
			String strddMMyyyy = null;
			java.util.Date utilDate = null;
			try{
				SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
				utilDate = sdf.parse(dateMMddyyyy);
			}
			catch(ParseException pe){
				strddMMyyyy = "";
			}

			if(utilDate != null)
			{
				strddMMyyyy = (new SimpleDateFormat("dd/MM/yyyy")).format(utilDate);
			}
			else
			{
				strddMMyyyy = "";
			}

			return strddMMyyyy;
	  	}

	  	public static String getddmmyyyyformat(String dateMMddyyyy) throws ParseException
	  	{
			String strddMMyyyy = null;
			java.util.Date utilDate = null;
			try{
				SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy HH:mm:ss");
				utilDate = sdf.parse(dateMMddyyyy);
			}catch(ParseException pe)
			{
				strddMMyyyy = "";
			}

			if(utilDate != null)
			{
				strddMMyyyy = (new SimpleDateFormat("dd/MM/yyyy")).format(utilDate);
			}
			else
			{
				strddMMyyyy = "";
			}

			return strddMMyyyy;
	 	}

		public static String replaceStringStr(String original, String oldString, String newString)
		{
			String strOriginal = original;
			int oldStringlen = oldString.length();
			int firstIndex = strOriginal.indexOf(oldString);
			int cntr=0;
			while (strOriginal.indexOf(oldString) !=-1)
			{
				int posOldString = strOriginal.indexOf(oldString);
				if (firstIndex>=posOldString && cntr>0)
				{
					break;
				}
				strOriginal = strOriginal.substring(0,posOldString) + newString + strOriginal.substring(posOldString+oldStringlen,strOriginal.length());
				cntr++;
			}
			return strOriginal;
		}

		 public static String dateDiff(java.util.Date date1, java.util.Date date2)
		 {
			String dateDiff="";
			if(date1!=null && date2!=null)
			{
				long secDiff = (date2.getTime() - date1.getTime())/1000;
				long dayDiff = secDiff / 86400;
				secDiff  = secDiff - (dayDiff*86400);
				long hourDiff = secDiff/3600;
				secDiff = secDiff - (hourDiff*3600);
				long minDiff = secDiff / 60;
				secDiff = secDiff - minDiff*60;

				if (dayDiff>0){
					dateDiff +=(dayDiff)+" Day(s) ";
				}	
				if (hourDiff>0){
					dateDiff +=hourDiff+" - hour(s) ";
				}	
				if (minDiff>0){
					dateDiff +=minDiff+" - minute(s) ";
				}	
				if (secDiff>0){
					dateDiff +=secDiff + " - second(s)";
				}

				return dateDiff;
			}
			return "";
		 }

		 public static  ArrayList<String> splitString(String str, String delimiter)
		{

		 	ArrayList<String> alReturn=new ArrayList<String>();

			if(str!=null &&  delimiter!=null)
			{
			 	StringTokenizer tokenizer = new StringTokenizer(str,delimiter);
			 	int count = tokenizer.countTokens();
				for(int i = 0 ; i < count; i ++)
				{
					alReturn.add(tokenizer.nextToken());

				}
			}

		 	return alReturn;
		 }

		public static String getNull(String val){
			if ((val==null)||(val.trim().equals("")))
			{
			return "null";
			}
			else
			{
			return val;
			}
		}


		 public static float getFltValue (String pFlt) throws ParseException
		 {
		    if ((pFlt!=null)&&(!pFlt.trim().equals("")))
		    {
				return Float.parseFloat(pFlt);
			}
		    else
		    {
				return 0.00f;
			}
		 }


		public static String replaceNull(String value)
		{
			return value==null?"":value;
		}

		public static boolean checkNull(String strCheckNull){
		   return (strCheckNull==null || (strCheckNull.trim().equals("")))?false:true;
		}

        public static String stringToUpperCase(String processStr){
            String returnProcessString="";
            try{
                returnProcessString = processStr.toUpperCase();
            }catch(Exception e ){
            }
             return returnProcessString;
        }

      public static String getBase64String(String encryptedStringInput){

    	  String encryptedString = encryptedStringInput;
    	  String base64EncryptedString = "";
    	  try{
    	  for(int i=0;i<=15;i++)
		    {
		      encryptedString=encryptedString.substring(2);
		      encryptedString=encryptedString.substring(2);
		      base64EncryptedString=base64EncryptedString.concat(encryptedString.substring(0,2));
		      encryptedString=encryptedString.substring(2);
		      }

		 return base64EncryptedString;
    	  } catch(Exception e){
    		  return "1";

		 }

      }

      public static String getSHA1String(String encryptedStringInput){
    	  
    	  String encryptedString = encryptedStringInput;
    	  String sha1EncryptedString = "";

    	  for(int i=0;i<=15;i++)
		    {
    		  sha1EncryptedString=sha1EncryptedString.concat(encryptedString.substring(0,2));
		      encryptedString=encryptedString.substring(2);
		      encryptedString=encryptedString.substring(2);
		      encryptedString=encryptedString.substring(2);
		      }

    	  return sha1EncryptedString;
      }

      public static String getMD5String(String encryptedStringInput)
      {
    	  String encryptedString = encryptedStringInput;
    	  String md5EncryptedString = "";
    	  
    	  for(int i=0;i<=15;i++)
		  {
		      encryptedString=encryptedString.substring(2);
		      md5EncryptedString=md5EncryptedString.concat(encryptedString.substring(0,2));
		      encryptedString=encryptedString.substring(2);
		      encryptedString=encryptedString.substring(2);
		 }
    	  return md5EncryptedString;
      }



	  public String convertListToString(List<String> applications)
	  {
			StringBuffer sBuffer =new StringBuffer();
			Iterator<String> listIterator =applications.iterator();
			Boolean ifNotFirstAttribute=false;
			for(;listIterator.hasNext();){
				if(ifNotFirstAttribute){
					sBuffer.append("','");
				}else{
					ifNotFirstAttribute=true;
				}
					
					sBuffer.append(listIterator.next());
	
	
			}
			return sBuffer.toString();
	  }
	  
	  public  static String rPad(String str, int num, int d)
	  {
			StringBuffer sb = new StringBuffer(str);
			for (int i = 0; i < num; i++)
			{
				sb.append((char) d);
			}
			return sb.toString();
	  }
	  
	  public static String decrypt(String encTextL, String keyL)
		{
			StringBuffer textL = new StringBuffer();
			String keyS = rPad(keyL, 16, 0);
			String decTextS = "";
			String tempS = rPad(encTextL, 32, 0);
			int a = 0;
			int b = 0;
			int i = 0;
			try
			{
				for (int j = 0; j < 15; j++)
				{
					a = (int) tempS.charAt((j * 2) + 0);
					b = (int) tempS.charAt((j * 2) + 1);
					if (a >= 65){
						a = (a + 10) - 65;
					}
					else{
						a = a - 48;
					}
					if (b >= 65){
						b = (b + 10) - 65;
					}
					else{
						b = b - 48;
					}
						
					i = (a * 16) + b;
					i = i - (int) keyS.charAt(j);
					if (i < 0){
						i = i + 126;
					}
					textL.append((char) i);
				}
				decTextS = textL.toString();
				decTextS = decTextS.trim();
			}
			catch (Exception e)
			{
				LOGGER.error("Decrypt exp "+e);
			}

			return decTextS;
		}


		/**
		 * Encryption logic used for request channel handler
		 * @param args
		 */

			public static  String encryptedPassword(String userNameP, String passwordP) {

					String encryptedPassword = "";
					String shaPassword = sha1(passwordP.trim());
					try {
						String rsaPassword = rsa(passwordP.trim());
						rsaPassword = rsaPassword.substring(0, 32);
						String basePassword = base(passwordP.trim(), userNameP.trim());
						for (int i = 0; i <= 15; i++) {
							encryptedPassword = encryptedPassword.concat(shaPassword
									.substring(0, 2));
							shaPassword = shaPassword.substring(2);
							encryptedPassword = encryptedPassword.concat(rsaPassword
									.substring(0, 2));
							rsaPassword = rsaPassword.substring(2);
							encryptedPassword = encryptedPassword.concat(basePassword
									.substring(0, 2));
							basePassword = basePassword.substring(2);
						}
						encryptedPassword = encryptedPassword.concat(shaPassword);

					} catch (Exception e) {
						LOGGER.error("Exp "+e);
					}
					return encryptedPassword;
				}

			private static  String rsa(String textP) throws NoSuchAlgorithmException,
			InvalidKeySpecException, NoSuchPaddingException,
			InvalidKeyException, IllegalStateException, ShortBufferException,
			IllegalBlockSizeException, BadPaddingException {

		X509EncodedKeySpec pks = new X509EncodedKeySpec(RSA_PUBLIC_KEY);
		KeyFactory kf = KeyFactory.getInstance("RSA");
		PublicKey publicKey = kf.generatePublic(pks);
		byte[] plainText = textP.getBytes();
		byte[] ciphertext = new byte[256];
		Cipher cipher1 = Cipher.getInstance("RSA");
		cipher1.init(Cipher.ENCRYPT_MODE, publicKey);
		cipher1.doFinal(plainText, 0, plainText.length, ciphertext, 0);
		return toHex(ciphertext);
	}

	public static String sha1(String sInput) {
		int nDigestLen = 20;
		byte[] plainText = sInput.getBytes();
		byte[] encryptedText = new byte[nDigestLen];
		MessageDigest cipher = null;
		try {
			cipher = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException ex) {
			LOGGER.error("sha exp "+ex.getMessage());
		}
		cipher.update(plainText, 0, plainText.length);
		try {
			cipher.digest(encryptedText, 0, nDigestLen);
		} catch (DigestException ex) {
			LOGGER.error("sha exp "+ex.getMessage());
		}
		return toHex(encryptedText);
	}

	private static String toHex(byte[] bsData) {
		int nDataLen = bsData.length;
		String sHex = "";
		for (int nIter = 0; nIter < nDataLen; nIter++) {
			int nValue = (bsData[nIter] + 256) % 256;
			int nIndex1 = nValue >> 4;
			sHex += Integer.toHexString(nIndex1);
			int nIndex2 = nValue & 0x0f;
			sHex = sHex.concat(Integer.toHexString(nIndex2)+"");
		}
		return sHex;
	}

	private static String base(String textInput, String keyInput) {
		
		String textP = textInput;
		String keyP = keyInput;
		
		String tempS = "";
		String tempS1 = "";
		int i = 0;
		int t = 0;
		int a = 0;
		int b = 0;

		int z4 = textP.length();
		if (z4 < 16) {
			int aa = 16 - z4;
			for (int ie = 0; ie < aa; ie++) {
				textP = textP.concat("|");
			}
		}

		int z5 = keyP.length();
		if (z5 < 16) {
			int aa = 16 - z5;
			for (int ie = 0; ie < aa; ie++) {
				keyP = keyP.concat("|");
			}
		}

		for (int j = 0; j < 16; j++) {

			String z = (textP.substring(j, j + 1));
			char z1 = z.charAt(0);
			int z2 = (int) z1;
			if (z2 == 124) {
				z2 = 0;
			}

			String y = (keyP.substring(j, j + 1));
			char y1 = y.charAt(0);
			int y2 = (int) y1;
			if (y2 == 124) {
				y2 = 0;
			}

			i = y2 + z2;

			i = i % 255;
			tempS = tempS.concat(i+"");
		}
		for (i = 0; i < 16; i++) {
			String x = (tempS.substring(i, i + 1));
			char x1 = x.charAt(0);
			int x2 = (int) x1;
			t = x2;
			a = t % 16;
			b = (t - a) / 16;
			if (b < 10) {
				int ss = b + 48;
				char digit = (char) ss;
				String aaa = "" + digit;
				tempS1 = tempS1.concat(aaa);
			} else {
				int ss = b - 10 + 65;
				char digit = (char) ss;
				String aaa = "" + digit;
				tempS1 = tempS1.concat(aaa);
			}

			if (a < 10) {
				int ss = a + 48;
				char digit = (char) ss;
				String aaa = "" + digit;
				tempS1 = tempS1.concat(aaa);
			} else {
				int ss = a - 10 + 65;
				char digit = (char) ss;
				String aaa = "" + digit;
				tempS1 = tempS1.concat(aaa);
			}
		}
		return tempS1;
	}

	private static final byte[] RSA_PUBLIC_KEY = { (byte) 0x30, (byte) 0x82,
			(byte) 0x1, (byte) 0x22, (byte) 0x30, (byte) 0xd, (byte) 0x6,
			(byte) 0x9, (byte) 0x2a, (byte) 0x86, (byte) 0x48, (byte) 0x86,
			(byte) 0xf7, (byte) 0xd, (byte) 0x1, (byte) 0x1, (byte) 0x1,
			(byte) 0x5, (byte) 0x0, (byte) 0x3, (byte) 0x82, (byte) 0x1,
			(byte) 0xf, (byte) 0x0, (byte) 0x30, (byte) 0x82, (byte) 0x1,
			(byte) 0xa, (byte) 0x2, (byte) 0x82, (byte) 0x1, (byte) 0x1,
			(byte) 0x0, (byte) 0xe0, (byte) 0xe2, (byte) 0x9f, (byte) 0xc2,
			(byte) 0x75, (byte) 0x4c, (byte) 0x10, (byte) 0x53, (byte) 0xbb,
			(byte) 0x48, (byte) 0xcb, (byte) 0x54, (byte) 0x23, (byte) 0xe4,
			(byte) 0x91, (byte) 0x17, (byte) 0xa2, (byte) 0xec, (byte) 0x59,
			(byte) 0x9f, (byte) 0x6f, (byte) 0x57, (byte) 0x7f, (byte) 0x9b,
			(byte) 0x6a, (byte) 0x1f, (byte) 0x93, (byte) 0x5e, (byte) 0x69,
			(byte) 0xf1, (byte) 0xd4, (byte) 0x56, (byte) 0xb9, (byte) 0x65,
			(byte) 0x9e, (byte) 0x14, (byte) 0x27, (byte) 0xb8, (byte) 0xb1,
			(byte) 0xb5, (byte) 0x9d, (byte) 0xea, (byte) 0xd6, (byte) 0xef,
			(byte) 0xc2, (byte) 0x3, (byte) 0x4e, (byte) 0x9b, (byte) 0x28,
			(byte) 0x1e, (byte) 0x1b, (byte) 0x8, (byte) 0x1a, (byte) 0x5,
			(byte) 0x4d, (byte) 0xf7, (byte) 0xb5, (byte) 0xe7, (byte) 0x92,
			(byte) 0xcd, (byte) 0x3a, (byte) 0x59, (byte) 0xd8, (byte) 0xb6,
			(byte) 0xb6, (byte) 0x20, (byte) 0xf3, (byte) 0xc8, (byte) 0x2b,
			(byte) 0xf8, (byte) 0x1e, (byte) 0x38, (byte) 0xd9, (byte) 0xb4,
			(byte) 0xf4, (byte) 0x23, (byte) 0xc0, (byte) 0x3, (byte) 0xc9,
			(byte) 0x2, (byte) 0x71, (byte) 0x7a, (byte) 0xac, (byte) 0x40,
			(byte) 0x25, (byte) 0x67, (byte) 0xfe, (byte) 0xc2, (byte) 0x6a,
			(byte) 0xd2, (byte) 0x3b, (byte) 0x25, (byte) 0x14, (byte) 0x29,
			(byte) 0xf5, (byte) 0x99, (byte) 0x8c, (byte) 0xef, (byte) 0x51,
			(byte) 0x25, (byte) 0xa4, (byte) 0x37, (byte) 0xda, (byte) 0xb1,
			(byte) 0x65, (byte) 0xb6, (byte) 0x49, (byte) 0xf7, (byte) 0x9d,
			(byte) 0x1e, (byte) 0x5a, (byte) 0x34, (byte) 0xe, (byte) 0x17,
			(byte) 0xf2, (byte) 0x50, (byte) 0x92, (byte) 0x85, (byte) 0xbb,
			(byte) 0x1c, (byte) 0x6c, (byte) 0xae, (byte) 0x6a, (byte) 0xe4,
			(byte) 0xe0, (byte) 0x29, (byte) 0xe5, (byte) 0xfd, (byte) 0xcd,
			(byte) 0x10, (byte) 0x1a, (byte) 0xab, (byte) 0x7, (byte) 0xc7,
			(byte) 0xa4, (byte) 0x32, (byte) 0xd7, (byte) 0xbd, (byte) 0x70,
			(byte) 0x24, (byte) 0xc6, (byte) 0x53, (byte) 0x73, (byte) 0x33,
			(byte) 0x95, (byte) 0x62, (byte) 0x84, (byte) 0x99, (byte) 0xb5,
			(byte) 0x3b, (byte) 0x83, (byte) 0x90, (byte) 0xe, (byte) 0xbc,
			(byte) 0x91, (byte) 0x58, (byte) 0xf0, (byte) 0x95, (byte) 0x96,
			(byte) 0x15, (byte) 0xf, (byte) 0xed, (byte) 0x68, (byte) 0xba,
			(byte) 0x46, (byte) 0x5, (byte) 0x22, (byte) 0x99, (byte) 0x55,
			(byte) 0x1e, (byte) 0x39, (byte) 0xbe, (byte) 0xf5, (byte) 0x34,
			(byte) 0xcd, (byte) 0xb9, (byte) 0x43, (byte) 0xde, (byte) 0x1c,
			(byte) 0xeb, (byte) 0xf0, (byte) 0x79, (byte) 0xee, (byte) 0x9d,
			(byte) 0x60, (byte) 0xa5, (byte) 0x50, (byte) 0x78, (byte) 0xe0,
			(byte) 0x38, (byte) 0xf9, (byte) 0x28, (byte) 0x96, (byte) 0xaf,
			(byte) 0x7, (byte) 0x99, (byte) 0xd6, (byte) 0xce, (byte) 0x7c,
			(byte) 0xbc, (byte) 0x3b, (byte) 0x4, (byte) 0xfd, (byte) 0xd,
			(byte) 0x9, (byte) 0x70, (byte) 0xb1, (byte) 0xad, (byte) 0xcf,
			(byte) 0xa5, (byte) 0x46, (byte) 0xc8, (byte) 0x41, (byte) 0x5c,
			(byte) 0x7, (byte) 0xd8, (byte) 0x9b, (byte) 0xcb, (byte) 0xd7,
			(byte) 0xcb, (byte) 0x5c, (byte) 0xc4, (byte) 0x96, (byte) 0xe,
			(byte) 0x41, (byte) 0x84, (byte) 0x3b, (byte) 0x28, (byte) 0x91,
			(byte) 0x7, (byte) 0xc5, (byte) 0xdc, (byte) 0x9e, (byte) 0x71,
			(byte) 0x78, (byte) 0x10, (byte) 0x41, (byte) 0x8d, (byte) 0x5,
			(byte) 0x3d, (byte) 0x36, (byte) 0x3f, (byte) 0x78, (byte) 0xa1,
			(byte) 0x9c, (byte) 0xb3, (byte) 0x37, (byte) 0x81, (byte) 0x2a,
			(byte) 0xa5, (byte) 0xd0, (byte) 0x25, (byte) 0xad, (byte) 0xfe,
			(byte) 0x71, (byte) 0x7, (byte) 0x2, (byte) 0x3, (byte) 0x1,
			(byte) 0x0, (byte) 0x1 };

	public static String convertToCamelCase(String stringToBeConvertedL){
        String resultL =stringToBeConvertedL;

        try{
               String[] wordsL = stringToBeConvertedL.split(" ");
               StringBuilder sbL = new StringBuilder();
               if (wordsL[0].length() > 0) {
                   sbL.append(Character.toUpperCase(wordsL[0].charAt(0)) + wordsL[0].subSequence(1, wordsL[0].length()).toString().toLowerCase());
                   for (int iL = 1; iL < wordsL.length; iL++) {
                       sbL.append(" ");
                       sbL.append(Character.toUpperCase(wordsL[iL].charAt(0)) + wordsL[iL].subSequence(1, wordsL[iL].length()).toString().toLowerCase());
                   }
               }
               resultL = sbL.toString();
               }catch (Exception e) {

               }
        return resultL;

	}
	
	public static boolean validateConId(String userId, String tempApplicationId){
		
		String tempApplicationIdPart1="";
		String tempApplicationIdPart2="";
		boolean isLong = true;
		boolean isValidate = false;
		
		tempApplicationIdPart1 = tempApplicationId.substring(0,tempApplicationId.length()-14);
		tempApplicationIdPart2 = tempApplicationId.substring(tempApplicationId.length()-14);
	
		try { 
		      Long.parseLong(tempApplicationIdPart2);
		 } catch (NumberFormatException e) {
			 isLong = false;
		 }
		
		if(tempApplicationIdPart1.equals(userId) && isLong){
			isValidate = true;
		}else{
			isValidate = false;
		}
		return isValidate;
	}
	
    public static int getRandomNumber(){
        
        Random rn = new Random();
        return  rn.nextInt(100000000);
    }
    
    public static String encrypt(String s, String s1)
	{
		String s2 = null;
		try
		{
			s2 = performEncryption(generateKey(s), s1);
		}
		catch(Exception exception)
		{
			LOGGER.error("error in encrpt method"+exception);
		}
		return s2;
	}
    private static SecretKey generateKey(String s) throws Exception
	{
		byte abyte0[] = new byte[24];
		byte abyte1[] = s.getBytes();
		for(int i = 0; i < 24; i++){
			if(i < abyte1.length){
				abyte0[i] = abyte1[i];
			}else{
				abyte0[i] = -103;
			}
		}
			
		DESedeKeySpec desedekeyspec = new DESedeKeySpec(abyte0);
		SecretKeyFactory secretkeyfactory = SecretKeyFactory.getInstance("DESede");
		return secretkeyfactory.generateSecret(desedekeyspec);
	}
    private static String performEncryption(SecretKey secretkey, String s) throws Exception
	{
		byte abyte0[];
		byte abyte1[];
		abyte0 = null;
		abyte1 = null;
		try
		{
			Cipher cipher = Cipher.getInstance("DESede");
			cipher.init(1, secretkey);
			abyte0 = s.getBytes();
			abyte1 = cipher.doFinal(abyte0);
		}
		catch(Exception exception)
		{
			LOGGER.error("performEncryption "+exception.getMessage());
		}
//		return (new BASE64Encoder()).encode(abyte1);
		return ("");

	}
    
    

}