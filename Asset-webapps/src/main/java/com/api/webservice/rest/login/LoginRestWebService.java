package com.api.webservice.rest.login;

import static com.api.util.WEBConstants.ACCEPTABLE_HEADER_TYPE_JSON;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;


import com.api.model.login.LoginInputObject;
import com.api.model.login.LoginOutputObject;

import com.api.servicebroker.rest.login.LoginRestService;


import com.api.util.AssetUtil;

@Controller
@RequestMapping("rest")

public class LoginRestWebService {
	

	
	@Inject
	private LoginRestService loginRestService;
	
	
	
	@RequestMapping(value = "login", method = RequestMethod.POST, headers = ACCEPTABLE_HEADER_TYPE_JSON)
	@ResponseBody
	public LoginOutputObject getAllSignDetails(@RequestBody LoginInputObject loginInputObject,
			@RequestHeader MultiValueMap<String, String> requestHeaders, HttpServletResponse httpServletResponse,
			WebRequest webRequest) {
		return loginRestService.getDetails(loginInputObject,
				AssetUtil.getHTTPRequestHeaderValue(requestHeaders));
	}
	
	

}
