package com.api.util;

import static com.api.util.WEBConstants.ASSET_USER_ID;
import static com.api.util.WEBConstants.HEADER_REQUEST_ID;
import static com.api.util.WEBConstants.HOST_SERVER;
import static com.api.util.WEBConstants.OPERATION_FLAG;
import static com.api.util.WEBConstants.RANDOM_SESSION_ID;
import static com.api.util.WEBConstants.SESSIONID;
import static com.api.util.WEBConstants.USER_AGENT;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.MultiValueMap;

import com.api.model.httpheader.AssetRESTServiceRequestHeader;



public class AssetUtil {
	
	public static Map<String,String> getHTTPRequestHeaderValue(HttpServletRequest httpServletRequest){
		HashMap<String,String> httpRequestheaders = new HashMap<String,String>();
		for (Enumeration<?> names = httpServletRequest.getHeaderNames(); names.hasMoreElements();) {
		    String name = (String)names.nextElement();
		    for (Enumeration<?> values = httpServletRequest.getHeaders(name); values.hasMoreElements();) {
		        String value = (String)values.nextElement();
		        httpRequestheaders.put(name,value);
		    }
		}
		return httpRequestheaders;
	}
	
	
	public static AssetRESTServiceRequestHeader getHTTPRequestHeaderValue(MultiValueMap<String,String> requestHeaders){
		AssetRESTServiceRequestHeader theAssetRESTServiceRequestHeader = new AssetRESTServiceRequestHeader();
		theAssetRESTServiceRequestHeader.setSessionId(requestHeaders.getFirst(SESSIONID));
		theAssetRESTServiceRequestHeader.setOperationFlag(requestHeaders.getFirst(OPERATION_FLAG));
		theAssetRESTServiceRequestHeader.setRequestId(requestHeaders.getFirst(HEADER_REQUEST_ID));
		theAssetRESTServiceRequestHeader.setUserAgent(requestHeaders.getFirst(USER_AGENT));
		theAssetRESTServiceRequestHeader.setHostServer(requestHeaders.getFirst(HOST_SERVER));
		theAssetRESTServiceRequestHeader.setRandomSessionId(requestHeaders.getFirst(RANDOM_SESSION_ID));
		theAssetRESTServiceRequestHeader.setUserId(requestHeaders.getFirst(ASSET_USER_ID));
	return theAssetRESTServiceRequestHeader;	
	}
	
	public static String generateChecksum(String checkSumStr){
		
		StringBuilder sb = new StringBuilder();
		java.security.MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
			md.update(checkSumStr.getBytes());
			byte[] byteData = md.digest();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
				.substring(1));
			
			}
		} catch (NoSuchAlgorithmException e) {
			e.getMessage();
		}
		return sb.toString();
	}
	
	public static boolean getRegexValidation(String patternInput, String valueInput)
    {
    	boolean isValid = false;
    	
    	Pattern pattern = Pattern.compile(patternInput);
        Matcher matcher = pattern.matcher(valueInput);
        isValid = matcher.matches();
    	return isValid;
    }	
	
	
	public static String getDecryptedString(String encryptedData){
        StringBuilder dataBuilder = new StringBuilder();
        int increment = Integer.parseInt(Character.toString(encryptedData.charAt(0)));
        int decrement = Integer.parseInt(Character.toString(encryptedData.charAt(encryptedData.length() - 1)));
        
        String subString = encryptedData.substring(1, encryptedData.length()-1);
        for(int i = 0; i < subString.length(); i++){
           char perCharacter = subString.charAt(i);
           if(i % 2 == 0){
                 dataBuilder.append((char)(perCharacter-increment));
           }else{
                 dataBuilder.append((char)(perCharacter+decrement));
           }
        }
        return dataBuilder.toString();
	}
}