package com.api.common.dao;

import java.util.HashMap;

import com.api.common.domainobject.RequestCaptureDomainObject;
import com.api.common.exceptions.DAOException;

public interface ICommonFunctionsDAO {
	int dateDiffUsingCurrentDate(String dateP) throws DAOException; 
	String dynaQuery(String query);
	String dynaErrMSG(String query);
	
	String validateUser(String userId, String password);
	String validateUser(String userId);
	String validateStation(String station);
	String validateStationService(String station,String service);
	String getTokenFlag(String service);
	String validateService(String service);
	
	String captureRequest(RequestCaptureDomainObject requestCaptureDomainObject);
	String validateToken(String msgid,String Token);
	String tokenUpdate(String msgid,String Token,String Tokenenc);	
	String UpdateSecondReq(String msgid);	
	String validateMsgid(String msgid,String system,String service);
	String UpdateRequest(String RESPONSE_CODE,String RESPONSE_STATUS,String MSGID ,String SERVICENAME ,String STATION_NAME);
	
	 String getAgreementno(String query);
	 
	 String validateAgreementno(String query);
	 String validateAgreementID(String query);
	 HashMap<String, String> grtReqparameter();
	 String getRegEx(String service,String tag);
	 String fnValidateProductKey(String productKey, String mapping, String ip,String entd);
	
}