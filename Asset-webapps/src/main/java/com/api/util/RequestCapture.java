package com.api.util;

import java.util.HashMap;


import javax.inject.Inject;
import javax.inject.Named;

import com.api.common.dao.ICommonFunctionsDAO;
import com.api.common.domainobject.RequestCaptureDomainObject;
import com.api.controlparameters.dao.IControlParameterDAO;


@Named("requestCapture")
public class RequestCapture implements IRequestCapture{
	
	@Inject
	@Named("commonFunctionsDAO")
	private ICommonFunctionsDAO commonFunctionsDAO;
	
	@Inject
	@Named("controlParameterDAO")
	private IControlParameterDAO controlParameterDAO;
	
	
	public void CaptureRequest(RequestCaptureDomainObject requestCaptureDomainObject){
		
		commonFunctionsDAO.captureRequest(requestCaptureDomainObject);
		
	}
	
	
	public void UpdateToken(String msgid,String token,String tokenenc){
		
		commonFunctionsDAO.tokenUpdate(msgid,token,tokenenc);
	}
	
	
	
	public String getTokenFlag(String service){
		
		return commonFunctionsDAO.getTokenFlag(service);
		
	}
	public String validateTokenFlag(String service,String msgid,String token){
		
		return commonFunctionsDAO.validateToken(msgid, token);
	}
	
	public void UpdateSecondReq(String msgid){
		commonFunctionsDAO.UpdateSecondReq(msgid);
		
	}
	
	
	public String validateUser(String userId, String password){
		return commonFunctionsDAO.validateUser(userId, password);
				
	}
	public String validateUser(String userId){
		return commonFunctionsDAO.validateUser(userId);
				
	}
	public String validateStationService(String station,String service){
		return commonFunctionsDAO.validateStationService(station, service);
				
	}
	
	public String validateStation(String station){
		return commonFunctionsDAO.validateStation(station);
				
	}
	
	public String validateMsgid(String msgid,String system,String service){
		return commonFunctionsDAO.validateMsgid(msgid,system,service);
				
	}
	
	public String validateService(String service){
		return commonFunctionsDAO.validateService(service);		
	}
	public String getErrMsg(String errorCode){
		return commonFunctionsDAO.dynaErrMSG(errorCode);
				
	}
	
	
	public void UpdateReq(String RESPONSE_CODE,String RESPONSE_STATUS,String MSGID ,String SERVICENAME ,String STATION_NAME)
	{
		
		commonFunctionsDAO.UpdateRequest(RESPONSE_CODE, RESPONSE_STATUS, MSGID, SERVICENAME, STATION_NAME);
	}
	
	
	public String getAgreementNo(String query){
		return commonFunctionsDAO.getAgreementno(query);
				
	}
	
	public String validateAgreementNo(String query){
		return commonFunctionsDAO.validateAgreementno(query);
				
	}
	public String validateAgreementID(String query){
		return commonFunctionsDAO.validateAgreementID(query);
				
	}


	@Override
	public HashMap<String, String> validateRequestParameter() {
		
		return commonFunctionsDAO.grtReqparameter();
	}
	
	
	public String getRegEx(String service,String tag) {
		
		return commonFunctionsDAO.getRegEx(service, tag);
	}
	
	public String fnValidateProductKey(String productKey, String mapping, String ip,String entd) {
		return commonFunctionsDAO.fnValidateProductKey(productKey,mapping,ip,entd);
	}
	
	public String getParameter(String Key)  {
		return controlParameterDAO.get(Key);
	}
	
}
