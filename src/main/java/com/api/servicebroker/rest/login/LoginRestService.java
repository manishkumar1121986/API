package com.api.servicebroker.rest.login;

import static com.api.util.WEBConstants.EXCEPTION_OCCURED;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;

import com.api.common.exceptions.ServiceRequestException;
import com.api.crm.service.ILoginService;
import com.api.crm.domainobject.LoginDomainObject;
import com.api.interceptor.AssetRequestInterceptor;
import com.api.model.HeaderObject;
import com.api.model.httpheader.AssetRESTServiceRequestHeader;
import com.api.model.login.ApplicationObject;
import com.api.model.login.DataObject;
import com.api.model.login.LoginInputObject;
import com.api.model.login.LoginOutputObject;
import com.api.model.login.ResponseObject;
import com.api.servicebroker.common.CommonHeaderCheck;
import com.api.util.MBaseLogger;

@Named("loginRestService")
public class LoginRestService {
	

	@Inject
	@Named("loginService")
	private ILoginService loginService;
	
	private static final MBaseLogger logger = new MBaseLogger();
	
	
	
	
	public LoginOutputObject getDetails(LoginInputObject loginInputObject,
			AssetRESTServiceRequestHeader theAssetRESTServiceRequestHeader) {
		LoginOutputObject loginoutputObject = new LoginOutputObject();
		String appStatus="";

		HeaderObject header = new HeaderObject();
		ResponseObject response = new ResponseObject();
		try {
			
			


				
				String userid=	loginInputObject.getRequest().getData().getApplication().getUserid();
				String password=	loginInputObject.getRequest().getData().getApplication().getPassword();
			
			DataObject data=new DataObject();
			
			
			
			
			
			LoginDomainObject loginDomainobject= new LoginDomainObject();
			
			loginDomainobject.setUserid(userid);
			loginDomainobject.setPassword(password);
			
			loginDomainobject = loginService.getApiDetails(loginDomainobject);
			
			
			if("S".equalsIgnoreCase(loginDomainobject.getStatucCode())){
				
				
						
			
			ApplicationObject appobj= new ApplicationObject();
			appobj.setFirstname(loginDomainobject.getFname());
			appobj.setLastname(loginDomainobject.getLname());
			data.setApplication(appobj);
			response.setData(data);
			header.setResponseCode("S");
			
			header.setResponseMsg("S");
			
			}
			
	//		HeaderObject header = new HeaderObject();
			header.setMsgID(loginInputObject.getRequest().getHeader().getMsgID());
			header.setReqSystem(loginInputObject.getRequest().getHeader().getReqSystem());
			header.setReqType(loginInputObject.getRequest().getHeader().getReqType());
			//header.setResponseCode(dueDtlDomainobject.getStatucCode());
			header.setResponseTimeStamp(new Date()+"");
			//header.setStatus(dueDtlDomainobject.getStatus());
			header.setUserId(loginInputObject.getRequest().getHeader().getUserId());
			
			
			
		//	ResponseObject response = new ResponseObject();
			response.setHeader(header);
			
			
			loginoutputObject.setResponse(response);
						

			AssetRequestInterceptor.setResponseCode("OK");

		} catch (ServiceRequestException se) {
			logger.error("Error in Class =[" + this.getClass().getName() + "] and Method =[getLetterDetails()], Error is "
					+ se);
			AssetRequestInterceptor.setResponseCode(EXCEPTION_OCCURED);
		} catch (Exception e) {
			logger.error(
					"Error in Class =[" + this.getClass().getName() + "] and Method =[getLetterDetails()], Error is " + e);
			AssetRequestInterceptor.setResponseCode(EXCEPTION_OCCURED);
		}
		return loginoutputObject;
	}


}
