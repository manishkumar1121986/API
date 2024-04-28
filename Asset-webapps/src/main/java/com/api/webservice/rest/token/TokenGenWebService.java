package com.api.webservice.rest.token;

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

import com.api.model.token.AllInputObject;
import com.api.model.token.AllOutPutObject;
import com.api.servicebroker.rest.token.TokenGen;
import com.api.util.AssetUtil;

@Controller
@RequestMapping("rest/token")



public class TokenGenWebService {
	
	@Inject
	private TokenGen tokenGen;
	
	
	@RequestMapping(value = "callToken", method = RequestMethod.POST, headers = ACCEPTABLE_HEADER_TYPE_JSON)
	@ResponseBody
	public AllOutPutObject getAllSignDetails(@RequestBody AllInputObject allInputObject,
			@RequestHeader MultiValueMap<String, String> requestHeaders, HttpServletResponse httpServletResponse,
			WebRequest webRequest) {
		return tokenGen.getApiDetails(allInputObject,
				AssetUtil.getHTTPRequestHeaderValue(requestHeaders));
	}

}
