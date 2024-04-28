package com.api.util;

import java.util.HashMap;

import com.api.common.domainobject.RequestCaptureDomainObject;

public interface IRequestCapture {

	void CaptureRequest(RequestCaptureDomainObject requestCaptureDomainObject);
	void UpdateToken(String msgid,String token,String tokenenc);
	String getTokenFlag(String service);
	String validateTokenFlag(String service,String msgid,String token);
	void UpdateSecondReq(String msgid);
	String validateUser(String userId, String password);
	String validateStationService(String station,String service);
	String validateStation(String station);
	String getErrMsg(String errorCode);
	String validateMsgid(String msgid,String system,String service);
	String validateUser(String userId);
	String validateService(String service);
	
	void UpdateReq(String RESPONSE_CODE,String RESPONSE_STATUS,String MSGID ,String SERVICENAME ,String STATION_NAME);
	String getAgreementNo(String query);
	String validateAgreementNo(String query);
	String validateAgreementID(String query);
	HashMap<String, String> validateRequestParameter();
	
	String getRegEx(String service,String tag);
	
	String fnValidateProductKey(String productKey, String mapping, String ip,String entd);
	String getParameter(String key);
	
}
