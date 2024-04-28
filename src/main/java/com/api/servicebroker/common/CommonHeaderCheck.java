package com.api.servicebroker.common;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.inject.Named;

import com.api.common.domainobject.RequestCaptureDomainObject;
import com.api.model.HeaderObject;
import com.api.util.IRequestCapture;
import com.api.util.MBaseLogger;


@Named("commonHeaderCheck")
public class CommonHeaderCheck {
	
	
	@Inject
	@Named("requestCapture")
	private IRequestCapture requestCapture;
	
	
	RequestCaptureDomainObject requestCaptureDomainObject=new RequestCaptureDomainObject();
	
	private static final MBaseLogger logger = new MBaseLogger();
	
	public HeaderObject HeaderValidate(HeaderObject headerObject){
		HeaderObject retHeaderObject = new HeaderObject(); 
		
		
		String status="S";
		String codevalue="0000";
		
		
		codevalue=validateRequestParameter(headerObject);
		
		
		if(codevalue.equalsIgnoreCase("0000")){
		
		if ("".equalsIgnoreCase(headerObject.getMsgID()) || headerObject.getMsgID()==null)
		{
			codevalue="1111";
			status="Fail";
		}
		if ("".equalsIgnoreCase(headerObject.getReqSystem()) || headerObject.getReqSystem()==null)
		{
			codevalue="1111";
			status="Fail";
		}
		if ("".equalsIgnoreCase(headerObject.getUserId()) || headerObject.getUserId()==null)
		{
			codevalue="1111";
			status="Fail";
		}
		if ("".equalsIgnoreCase(headerObject.getReqType()) || headerObject.getReqType()==null)
		{
			codevalue="1111";
			status="Fail";
		}
		
		
		if("0000".equalsIgnoreCase(codevalue))
		{
		codevalue=requestCapture.validateMsgid(headerObject.getMsgID(),headerObject.getReqSystem(),headerObject.getReqType());
		retHeaderObject.setStatus("F");
		
		logger.debug("request msgid validate:---->"+codevalue);
		try {
			if("0000".equalsIgnoreCase(codevalue))
			{
				
				requestCaptureDomainObject.setMsgid(headerObject.getMsgID());
				requestCaptureDomainObject.setServicename(headerObject.getReqType());
				requestCaptureDomainObject.setStation_name(headerObject.getReqSystem());
				requestCaptureDomainObject.setUserid(headerObject.getUserId());
				requestCapture.CaptureRequest(requestCaptureDomainObject);
				
				
				//validate user only
				 codevalue =requestCapture.validateUser(headerObject.getUserId());
				;
				logger.debug("user channel:---->"+codevalue);
				if("0000".equalsIgnoreCase(codevalue))
				{
					// validate channel
					
					codevalue=requestCapture.validateStation(headerObject.getReqSystem());
					logger.debug("validate channel:---->"+codevalue);
					if("0000".equalsIgnoreCase(codevalue)){
						
						// valid channel-service
						codevalue=requestCapture.validateStationService(headerObject.getReqSystem(),headerObject.getReqType());
						logger.debug("validate-service channel:---->"+codevalue);
						if("0000".equalsIgnoreCase(codevalue)){
							//
							 codevalue =requestCapture.validateService(headerObject.getReqType());
							 logger.debug("request service:---->"+codevalue);
							 if("0000".equalsIgnoreCase(codevalue)){
								 // get token flag and validate the same
								 String tokenFlag=requestCapture.getTokenFlag(headerObject.getReqType());
								 logger.debug("request token:---->"+codevalue);
								 retHeaderObject.setStatus("S");
									if("Y".equalsIgnoreCase(tokenFlag)){
									
										codevalue =requestCapture.validateTokenFlag(headerObject.getReqType(), headerObject.getMsgID(), headerObject.getToken());
										logger.debug("request token velidate:---->"+codevalue);
										if("0000".equalsIgnoreCase(codevalue)){
											
											retHeaderObject.setStatus("S");
										}else{
											retHeaderObject.setStatus("F");											
										}
									}	
//								else{
//									retHeaderObject.setStatus("S");
//								}
						 } 
						
					}
				}
			
				
			}
			
			
			
			
			}
			
			
		} catch (Exception e) {
			
			codevalue="9999";
			//e.printStackTrace();
			logger.error(e);
		}
			
		}	
			
		
			logger.debug("HEARER VE---->>>>>"+codevalue);
		
	}
		else{
			
			status="Fail";
		}
		
		retHeaderObject=headerObject;
		retHeaderObject.setResponseCode(codevalue);
		retHeaderObject.setResponseMsg(requestCapture.getErrMsg(codevalue));
		retHeaderObject.setStatus(status);
		
		
		return retHeaderObject;
		
	}
	
	
	public String validateRequestParameter(HeaderObject headerObject)
	{
		HashMap<String,String> hmValidat=requestCapture.validateRequestParameter();
		
		String returnStr="0000";
		
		int lengthCheck;
		
		int vlengthCheck;
		
		lengthCheck=Integer.parseInt(hmValidat.get("HEADERMSGIDVLENGTH"));
		vlengthCheck=(headerObject.getMsgID()).length();
		if(lengthCheck<vlengthCheck)
		{
			return "1111";
		}
		
		lengthCheck=Integer.parseInt(hmValidat.get("HEADERREQSYSTEMVLENGTH"));
		vlengthCheck=(headerObject.getReqSystem()).length();
		if(lengthCheck<vlengthCheck)
		{
			return "1111";
		}
		
		lengthCheck=Integer.parseInt(hmValidat.get("HEADERREQTYPEVLENGTH"));
		vlengthCheck=(headerObject.getReqType()).length();
		if(lengthCheck<vlengthCheck)
		{
			return "1111";
		}
		
		lengthCheck=Integer.parseInt(hmValidat.get("HEADERUSERIDVLENGTH"));
		vlengthCheck=(headerObject.getUserId()).length();
		if(lengthCheck<vlengthCheck)
		{
			return "1111";
		}
		
		
		
		String regexOnly = "^[a-zA-Z0-9]+$";
		 
		Pattern pattern = Pattern.compile(regexOnly);
		
		//splCharFlag=hmValidat.get("HEADERMSGIDSPL_CHAR_FLAG");
		pattern = Pattern.compile(hmValidat.get("HEADERMSGIDSPL_CHAR_ALLOWED"));
		
			Matcher matcher = pattern.matcher(headerObject.getMsgID());
			if(!matcher.matches()){
				return "1111";
			}
			
		
		
		//splCharFlag=hmValidat.get("HEADERREQSYSTEMSPL_CHAR_FLAG");
		pattern = Pattern.compile(hmValidat.get("HEADERREQSYSTEMSPL_CHAR_ALLOWED"));
		
			 matcher = pattern.matcher(headerObject.getReqSystem());
			if(!matcher.matches()){
				return  "1111";
			}
			
		
		
		
		//splCharFlag=hmValidat.get("HEADERREQTYPESPL_CHAR_FLAG");
		pattern = Pattern.compile(hmValidat.get("HEADERREQTYPESPL_CHAR_ALLOWED"));
		 matcher = pattern.matcher(headerObject.getReqType());
			if(!matcher.matches()){
				return  "1111";
			}
			
		
		
		
		
		//splCharFlag=hmValidat.get("HEADERUSERIDSPL_CHAR_FLAG");
			pattern = Pattern.compile(hmValidat.get("HEADERUSERIDSPL_CHAR_ALLOWED"));
			 matcher = pattern.matcher(headerObject.getUserId());
			if(!matcher.matches()){
				return "1111";
			}
			
		
		
		
		return returnStr;
		
		
	}

}
