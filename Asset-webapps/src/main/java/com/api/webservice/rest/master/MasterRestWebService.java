package com.api.webservice.rest.master;

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


import com.api.model.master.MasterInputObject;
import com.api.model.master.MasterOutputObject;

import com.api.servicebroker.rest.master.MasterRestService;
import com.api.util.AssetUtil;

@Controller
@RequestMapping("rest")

public class MasterRestWebService {
	

	
	
	@Inject
	private MasterRestService masterRestService;
	
	
	
	
	@RequestMapping(value = "master", method = RequestMethod.POST, headers = ACCEPTABLE_HEADER_TYPE_JSON)
	@ResponseBody
	public MasterOutputObject getAllSignDetails(@RequestBody MasterInputObject masterInputObject,
			@RequestHeader MultiValueMap<String, String> requestHeaders, HttpServletResponse httpServletResponse,
			WebRequest webRequest) {
		return masterRestService.getDetails(masterInputObject,
				AssetUtil.getHTTPRequestHeaderValue(requestHeaders));
	}
	

}
