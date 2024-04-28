package com.api.servicebroker.rest.token;

import static com.api.util.WEBConstants.EXCEPTION_OCCURED;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;
import javax.inject.Named;

import com.api.common.domainobject.RequestCaptureDomainObject;
import com.api.common.exceptions.ServiceRequestException;
import com.api.interceptor.AssetRequestInterceptor;
import com.api.model.HeaderObject;
import com.api.model.httpheader.AssetRESTServiceRequestHeader;
import com.api.model.token.AllInputObject;
import com.api.model.token.AllOutPutObject;
import com.api.model.token.DataObject;
import com.api.model.token.ResponseObject;
import com.api.util.IRequestCapture;
import com.api.util.MBaseLogger;
import com.interf.crypto.Encrypt;
import com.interf.crypto.IEncrypt;


@Named("tokenGen")
public class TokenGen {

	
	@Inject
	@Named("requestCapture")
	private IRequestCapture requestCapture;
	
	
//	@Inject
//	@Named("encrypt")
//	private IEncrypt encrypt;
	
	
	
	RequestCaptureDomainObject requestCaptureDomainObject=new RequestCaptureDomainObject();
	
	Encrypt encrypt=new Encrypt();

	private static final MBaseLogger logger = new MBaseLogger();

	public AllOutPutObject getApiDetails(AllInputObject allInputObject,
			AssetRESTServiceRequestHeader theAssetRESTServiceRequestHeader) {
		AllOutPutObject allOutputObject = new AllOutPutObject();

		try {
			
			logger.debug("Token");
			
			requestCaptureDomainObject.setMsgid(allInputObject.getRequest().getHeader().getMsgID());
			requestCaptureDomainObject.setServicename(allInputObject.getRequest().getHeader().getReqSystem());
			requestCaptureDomainObject.setStation_name(allInputObject.getRequest().getHeader().getReqType());
			requestCaptureDomainObject.setUserid(allInputObject.getRequest().getHeader().getUserId());
			requestCapture.CaptureRequest(requestCaptureDomainObject);
			
			//validate user
			
			String validUser=requestCapture.validateUser(allInputObject.getRequest().getHeader().getUserId(), allInputObject.getRequest().getHeader().getPassword());
			DataObject data= new DataObject();
			HeaderObject header = new HeaderObject();
			if (validUser.equalsIgnoreCase("Sucessfully"))
			{
			 Random rand = new Random(); 
			 int rand_int1 = rand.nextInt(1000000000); 
			 String token=Integer.toString(rand_int1);
			
			 String msgId=allInputObject.getRequest().getHeader().getMsgID(); 
			 String tokenenc=encrypt.encryptString(token, "SHA-512");
			 requestCapture.UpdateToken(msgId, token,tokenenc);
			
			data.setToken(token);
			
			
			header.setMsgID(allInputObject.getRequest().getHeader().getMsgID());
			header.setReqSystem(allInputObject.getRequest().getHeader().getReqSystem());
			header.setReqType(allInputObject.getRequest().getHeader().getReqType());
			header.setResponseCode(validUser);
			header.setResponseTimeStamp(new Date()+"");
			header.setStatus("S");
			header.setUserId(allInputObject.getRequest().getHeader().getUserId());
			}
			else{
				
				header.setMsgID(allInputObject.getRequest().getHeader().getMsgID());
				header.setReqSystem(allInputObject.getRequest().getHeader().getReqSystem());
				header.setReqType(allInputObject.getRequest().getHeader().getReqType());
				header.setResponseCode(validUser);
				header.setResponseTimeStamp(new Date()+"");
				header.setStatus("F");
				header.setUserId(allInputObject.getRequest().getHeader().getUserId());
					
				
			}
			
			
			
			ResponseObject response = new ResponseObject();
			response.setHeader(header);
			response.setData(data);
			
			allOutputObject.setResponse(response);
			

			AssetRequestInterceptor.setResponseCode("OK");

		} catch (ServiceRequestException se) {
			logger.error("Error in Class =[" + this.getClass().getName() + "] and Method =[getAPIDetails()], Error is "
					+ se);
			AssetRequestInterceptor.setResponseCode(EXCEPTION_OCCURED);
		} catch (Exception e) {
			logger.error(
					"Error in Class =[" + this.getClass().getName() + "] and Method =[getApiDetails()], Error is " + e);
			AssetRequestInterceptor.setResponseCode(EXCEPTION_OCCURED);
		}
		return allOutputObject;
	}


}
