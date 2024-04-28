package com.api.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Date;
import java.util.Random;
import java.util.ResourceBundle;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;



public class CommonFunctions {
	
	public static final int ITERATION_INDEX = 0;
    public static final int SALT_INDEX = 1;
    public static final int PBKDF2_INDEX = 2;
    public static final String PBKDF2_ALGORITHM = "PBKDF2WithHmacSHA1";
    
	private static String string = "";
	private static final String STR_ONE[] = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven","Eight", "Nine", };
	private static final String STR_TWO[] = { "Hundred", "Thousand", "Lakh", "Crore" };
	private static final String STR_THREE[] = { "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen","Fifteen", "Sixteen", "Seventeen", "Eighteen", "Ninteen", };
	private static final String STR_FOUR[] = { "Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Seventy","Eighty", "Ninty" };  
	
	public static String getValueFromPropertyFile(String inputKey) {
		String value = "";
		try {
			ResourceBundle myProp = ResourceBundle.getBundle("AssetParameters");
			value = myProp.getString(inputKey);
		} catch (Exception e) {
			value = "";
		}	 
		
		return value;

	}

	
	public static String getMaskingApplication(String applIdL,String loanNoMasking){
		
		String newApplicationNoMask = "";
		String maskLoanNumber= applIdL;
		String maskLoanNumberFirst=maskLoanNumber.substring(0,Integer.parseInt(loanNoMasking));
		int lengthLoanNumber=applIdL.length();
		String maskLoanNumberMiddle=maskLoanNumber.substring(Integer.parseInt(loanNoMasking),lengthLoanNumber-(Integer.parseInt(loanNoMasking)));
		String middleX="";
		
		for(int i=1;i<=maskLoanNumberMiddle.length();i++)
		{
			middleX=middleX.concat("X");
		}
		
		String maskLoanNumberLast=maskLoanNumber.substring(lengthLoanNumber-(Integer.parseInt(loanNoMasking)));
		newApplicationNoMask=maskLoanNumberFirst.concat(middleX).concat(maskLoanNumberLast);
		
		return newApplicationNoMask;
		
	}
	
	public static String getMaskingApplicationBothSide(String applIdL,String loanNoMaskingLeft,String loanNoMaskingRight){
		
		int firstnPlacesP 	=	2;
		int lastnPlacesP 	=	2;
		
		try {
			firstnPlacesP = Integer.parseInt(loanNoMaskingLeft);
		} catch (Exception e) {
			firstnPlacesP = 2;
		}
		try {
			lastnPlacesP = Integer.parseInt(loanNoMaskingRight);
		} catch (Exception e) {
			lastnPlacesP = 2;
		}

	  	  StringBuilder maskedNumberL = new StringBuilder();
	  	  String maskedNumberToReturnL =applIdL;
	  	  try{
         int lengthL = applIdL.length();
         int lastnPlacesL = lengthL-lastnPlacesP;
         int firstnPlacesL = firstnPlacesP;
         String maskL ="";
         
         
         
         for (int iL = 1; iL <= lengthL; iL++) {
                
                if(iL<=firstnPlacesL){
                      
              	  maskL= maskL.concat("#");
                      
                }else if(iL>lastnPlacesL){
                      maskL= maskL.concat("#");
                }else{
              	  maskL= maskL.concat("X");
                }
                
         }
     
      for (int il = 0; il < maskL.length(); il++) {
          char lChar = maskL.charAt(il);
          if (lChar == '#') {
              maskedNumberL.append(applIdL.charAt(il));
             
          } else {
              maskedNumberL.append(lChar);
          }
      }

      maskedNumberToReturnL = maskedNumberL.toString();
	  	  }catch(Exception e){
	  		  
	  		  
	  	  }
	  	  
      return maskedNumberToReturnL;
  }
	
	public static String convert(String amountEnteredInput,String currencyLeft, String currencyRight){
		
		String amountEntered = amountEnteredInput.replaceAll(",", "");
	    if(!amountEntered.contains(".")){
	    	amountEntered = amountEntered.concat(".00");
	    }

		String[] values=amountEntered.split("\\.");
		String amountInWords = "";
	 
		 
		int number= Integer.parseInt(values[0]);
		int number2=Integer.parseInt(values[1]);
		
		if(number2==0){
			amountInWords = toWords(number)+" <ruppp>"+ " And Zero <paaa> Only";
		}else{
			amountInWords = toWords(number)+" <ruppp>"+ " And "+toWords(number2)+" <paaa>" +" Only";	
		}
		 
		
		
		amountInWords = amountInWords.replace("<ruppp>",currencyLeft);
		amountInWords = amountInWords.replace("<paaa>",currencyRight);
		return amountInWords;
		
	}
	
	public static String toWords(int numberInput){
		string = "";
		int number = numberInput;
		try{
			int n = 1;
			int word;

			while (number != 0) 
			{
				switch (n) 
				{
				case 1:
					word = number % 100;
					pass(word);
					if (number > 100 && number % 100 != 0) 
					{
						show("and ");
					}
					number /= 100;
					break;
				case 2:
					word = number % 10;
					if (word != 0) {
						show(" ");
						show(STR_TWO[0]);
						show(" ");
						pass(word);
					}
					number /= 10;
					break;
				case 3:
					word = number % 100;
					if (word != 0) {
						show(" ");
						show(STR_TWO[1]);
						show(" ");
						pass(word); 
					} 
					number /= 100; 
					break;       
				case 4:      
					word = number % 100;  
					if (word != 0) {    
						show(" ");    
						show(STR_TWO[2]);  
						show(" ");     
						pass(word);    
					}               
					number /= 100;   
					break;           
				case 5:         
					word = number % 100; 
					if (word != 0) { 
						show(" ");   
						show(STR_TWO[3]); 
						show(" ");     
						pass(word);    
					}              
					number /= 100;     
					break; 
				default:
					break;
				}                  
				n++;                }
		}
		catch(Exception e)
		{
			string = "";
		}
		return string;        
	}
	
	public static void pass(int number) {

		try{
			int word, q;  
			if (number < 10) {  
				show(STR_ONE[number]);  
			}                if (number > 9 && number < 20) {
				show(STR_THREE[number - 10]); 
			}                if (number > 19) { 
				word = number % 10;  
				if (word == 0) {     
					q = number / 10;  
					show(STR_FOUR[q - 2]);  
				} else {   
					q = number / 10; 
					show(STR_ONE[word]);   
					show(" ");         
					show(STR_FOUR[q - 2]);  
				}                }
		}
		catch(Exception e)
		{
			e.getMessage();
		}
	}
	
	public static void show(String s) 
	{               
		
		String st;
		st = string; 
		string = s;  
		string += st;
		
	}
	
	public static boolean validatePassword(char[] password, String correctHash)
	        throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        String[] params = correctHash.split(":");
        int iterations = Integer.parseInt(params[ITERATION_INDEX]);
        byte[] salt = fromHex(params[SALT_INDEX]);
        byte[] hash = fromHex(params[PBKDF2_INDEX]);
        byte[] testHash = pbkdf2(password, salt, iterations, hash.length);
        return slowEquals(hash, testHash);
    }
	
	private static boolean slowEquals(byte[] a, byte[] b)
    {
        int diff = a.length ^ b.length;
        for(int i = 0; i < a.length && i < b.length; i++){
        	diff |= a[i] ^ b[i];
        }
        return diff == 0;
    }
	
	private static byte[] pbkdf2(char[] password, byte[] salt, int iterations, int bytes)
	        throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, bytes * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance(PBKDF2_ALGORITHM);
        return skf.generateSecret(spec).getEncoded();
    }
	
	private static byte[] fromHex(String hex)
    {
        byte[] binary = new byte[hex.length() / 2];
        for(int i = 0; i < binary.length; i++)
        {
            binary[i] = (byte)Integer.parseInt(hex.substring(2*i, 2*i+2), 16);
        }
        return binary;
    }
	
	public static String generateSessionId( ){
        String userSessionId = null;
        try{
               java.util.Date date = new Date();
               java.util.Random random = new Random();
               userSessionId = date.getTime()+"xx"+random.nextDouble();

        } catch (Exception e) {
               e.getMessage();
        }
        return userSessionId;
	}
	
	public static String mdFive(String text) 
		    throws NoSuchAlgorithmException, UnsupportedEncodingException  {
		        MessageDigest md;
		        md = MessageDigest.getInstance("MD5");
		        byte[] md5hash;
		        md.update(text.getBytes("iso-8859-1"), 0, text.length());
		        md5hash = md.digest();
		        return convertToHex(md5hash);
	}
	
	private static String convertToHex(byte[] data) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            int halfbyte = (data[i] >>> 4) & 0x0F;
            int twoHalfs = 0;
            do {
                if ((0 <= halfbyte) && (halfbyte <= 9)){
                	buf.append((char) ('0' + halfbyte));
                }else{
                	buf.append((char) ('a' + (halfbyte - 10)));
                }
                halfbyte = data[i] & 0x0F;
            } while(twoHalfs++ < 1);
        }
        return buf.toString();
    }
	
	public static String commonEscapeSql(String pStr) {
        String tempVal = "";

        try {
            tempVal = EscapeUtils.escapeSql(pStr);
        } catch (Exception ex) {
        }

        return tempVal;
    }


}
