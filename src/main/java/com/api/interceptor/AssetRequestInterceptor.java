package com.api.interceptor;

import static com.api.util.WEBConstants.HEADER_LOCATION;
import static com.api.util.WEBConstants.HEADER_RESPONSE_CODE;
import static com.api.util.WEBConstants.HEADER_RESPONSE_TIME_MILLS;
import static com.api.util.WEBConstants.HEADER_RESPONSE_TIME_NANO;
import static com.api.util.WEBConstants.HEADER_UNIQUE_REQUEST_ID;

import java.util.Enumeration;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.api.util.IRequestCapture;
import com.api.util.MBaseLogger;
import com.weilerhaus.productKeys.IGenVeriKey;



public class AssetRequestInterceptor extends HandlerInterceptorAdapter {
	
	
	@Inject
	@Named("requestCapture")
	private IRequestCapture requestCapture;
	
	@Inject
	@Named("genVeriKey")
	private IGenVeriKey iGenVeriKey;
	

	private static final MBaseLogger LOGGER = new MBaseLogger();
	private long requestReceivedTimeMills;
	private long requestReceivedTimeNano;
	private long responseSentTimeMills;
	private long responseSentTimeNano;
	private static ThreadLocal<String> reponseCodeL = new ThreadLocal<String>();
	private static ThreadLocal<String> uniqueRequestIdL = new ThreadLocal<String>();
	private static String localAddress;
	private static String localName;
	private static String localPort;
	private static String serverName;
	private static String serverPort;
	private static String servletPath;
	private static String contextPath;
//	private static String checkSumFlag = "N";
	private static String contextIP;
	private static String validateProductKey;
	
	public static String getValidateProductKey() {
		return validateProductKey;
	}

	public static void setValidateProductKey(String validateProductKey) {
		AssetRequestInterceptor.validateProductKey = validateProductKey;
	}

	public static String getContextIP() {
		return contextIP;
	}

	public static void setContextIP(String contextIP) {
		AssetRequestInterceptor.contextIP = contextIP;
	}

	public static String getContextProductKey() {
		return contextProductKey;
	}

	public static void setContextProductKey(String contextProductKey) {
		AssetRequestInterceptor.contextProductKey = contextProductKey;
	}

	public static String getContextMapping() {
		return contextMapping;
	}

	public static void setContextMapping(String contextMapping) {
		AssetRequestInterceptor.contextMapping = contextMapping;
	}

	private static String contextProductKey;
	private static String contextMapping;

	
	
	public static String getLocalAddress() {
		return localAddress;
	}

	public static void setLocalAddress(String localAddress) {
		AssetRequestInterceptor.localAddress = localAddress;
	}

	public static String getLocalName() {
		return localName;
	}

	public static void setLocalName(String localName) {
		AssetRequestInterceptor.localName = localName;
	}

	public static String getLocalPort() {
		return localPort;
	}

	public static void setLocalPort(String localPort) {
		AssetRequestInterceptor.localPort = localPort;
	}

	public static String getServerName() {
		return serverName;
	}

	public static void setServerName(String serverName) {
		AssetRequestInterceptor.serverName = serverName;
	}

	public static String getServerPort() {
		return serverPort;
	}

	public static void setServerPort(String serverPort) {
		AssetRequestInterceptor.serverPort = serverPort;
	}

	public static String getServletPath() {
		return servletPath;
	}

	public static void setServletPath(String servletPath) {
		AssetRequestInterceptor.servletPath = servletPath;
	}

	public static String getContextPath() {
		return contextPath;
	}

	public static void setContextPath(String contextPath) {
		AssetRequestInterceptor.contextPath = contextPath;
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		Enumeration<?> headerNames;
		String sessionId = "";
		String randomSessionId = "";
		setRequestReceivedTime();
		String mapping = "";
		String uniqueKey = "";
		String checkSumMobile = "";
		String networkCode = "";
		String checkSumStr = "";
		String requestId = "";
		String operationFlag = "";
		String entd="";

		mapping = request.getRequestURI().substring(request.getContextPath().length());
		LOGGER.debug(":::*******mapping*****::::::" + mapping);

		 String ip = request.getRemoteAddr();
		 LOGGER.debug(":::*******ip*****::::::" + ip);
		 String productKey="";
		headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String headerName = (String) headerNames.nextElement();
			LOGGER.debug(
					"** headerName =[" + headerName + "], and Header value = [" + request.getHeader(headerName) + "]");
			if ("session-id".equalsIgnoreCase(headerName)) {
				sessionId = request.getHeader(headerName);
			} else if ("random-session-id".equalsIgnoreCase(headerName)) {
				randomSessionId = request.getHeader(headerName);
			} else if ("unique-key".equalsIgnoreCase(headerName)) {
				uniqueKey = request.getHeader(headerName);
			} else if ("check-sum-key".equalsIgnoreCase(headerName)) {
				checkSumMobile = request.getHeader(headerName);
			} else if ("network-code".equalsIgnoreCase(headerName)) {
				networkCode = request.getHeader(headerName);
			} else if ("operation-flag".equalsIgnoreCase(headerName)) {
				operationFlag = request.getHeader(headerName);
			} else if ("request-id".equalsIgnoreCase(headerName)) {
				requestId = request.getHeader(headerName);
			}
			else if ("Authorization".equalsIgnoreCase(headerName)) {
				productKey = request.getHeader(headerName);
			}
			else if ("ENTD".equalsIgnoreCase(headerName)) {
				entd = request.getHeader(headerName);
			}
			
			LOGGER.debug("productKey--->"+productKey);
		}
		
		
//		if(!validateProductKey(productKey,mapping,ip))
//		{
//			return false;
//		}

		/*
		 * if ("Y".equalsIgnoreCase(checkSumFlag)) {
		 * 
		 * checkSumStr = "Acceptapplication/jsonContent-Typeapplication/json" +
		 * "network-code" + networkCode + "operation-flag" + operationFlag +
		 * "random-session-id" + randomSessionId + "request-id" + requestId +
		 * "session-id" + sessionId + "unique-key" + uniqueKey + "uri" +
		 * mapping;
		 * 
		 * String checkSumServer = AssetUtil.generateChecksum(checkSumStr);
		 * 
		 * if (!checkSumMobile.equalsIgnoreCase(checkSumServer)) {
		 * LOGGER.debug("CHECKSUM OF HEADER NOT MATCHES");
		 * AssetRequestInterceptor.setResponseCode(SESSION_ID_EXPIRED);
		 * response.setHeader(HEADER_RESPONSE_CODE,SESSION_ID_EXPIRED);
		 * response.setStatus(HttpStatus.CREATED.value()); return false; } }
		 */

		AssetRequestInterceptor.setLocalAddress(request.getLocalAddr());
		AssetRequestInterceptor.setLocalName(request.getLocalName());
		AssetRequestInterceptor.setLocalPort("" + request.getLocalPort());
		AssetRequestInterceptor.setServerName(request.getServerName());
		AssetRequestInterceptor.setServerPort("" + request.getServerPort());
		AssetRequestInterceptor.setServletPath(request.getServletPath());
		AssetRequestInterceptor.setContextPath(request.getContextPath());
		
		AssetRequestInterceptor.setContextIP(ip);
		AssetRequestInterceptor.setContextProductKey(productKey);
		AssetRequestInterceptor.setContextMapping(mapping);
		
		
		
		
			AssetRequestInterceptor.setValidateProductKey("SUCCESS");

			

		/*
		 * if
		 * (!isTransactionAllowed(requestId,mapping,sessionId,randomSessionId,
		 * uniqueKey)) {
		 * AssetRequestInterceptor.setResponseCode(SESSION_ID_EXPIRED);
		 * response.setHeader(HEADER_RESPONSE_CODE,SESSION_ID_EXPIRED);
		 * response.setStatus(HttpStatus.CREATED.value()); return false; }else{
		 * return true; }
		 */
		
		
		return true;
	}

	
	
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) {
		// setNewRequestId(request);
		setResponseSentTime();
		response.setHeader(HEADER_RESPONSE_TIME_MILLS, "" + computeResponseTimeMills());
		response.setHeader(HEADER_RESPONSE_TIME_NANO, "" + computeResponseTimeNano());
		response.setHeader(HEADER_RESPONSE_CODE, getResponseCode());
		response.setHeader(HEADER_UNIQUE_REQUEST_ID, getUniqueRequestId());
		response.setHeader(HEADER_LOCATION, request.getRequestURI());
		response.setStatus(HttpStatus.OK.value());

		LOGGER.debug("Headers Finished:::::::::::::::::::::::::::::::");

		LOGGER.debug("RESPONSE IS [" + ((response.isCommitted()) ? "" : "NOT ") + "COMMITED]");
		LOGGER.debug("Response Code : " + getResponseCode() + "and Time = " + computeResponseTimeMills() + " ms");
	}

	private void setRequestReceivedTime() {
		requestReceivedTimeMills = System.currentTimeMillis();
		requestReceivedTimeNano = System.nanoTime();
	}

	private void setResponseSentTime() {
		responseSentTimeMills = System.currentTimeMillis();
		responseSentTimeNano = System.nanoTime();
	}

	private long computeResponseTimeMills() {
		return (responseSentTimeMills - requestReceivedTimeMills);
	}

	private long computeResponseTimeNano() {
		return (responseSentTimeNano - requestReceivedTimeNano);
	}

	public static String getResponseCode() {
		return (String) ((reponseCodeL.get() == null) ? "" : reponseCodeL.get());
	}

	public static void setResponseCode(String value) {
		reponseCodeL.set(value);
	}

	public static String getUniqueRequestId() {
		return (String) ((uniqueRequestIdL.get() == null) ? "" : uniqueRequestIdL.get());
	}

	public static void setUniqueRequestId(String value) {
		uniqueRequestIdL.set(value);
	}

	

}