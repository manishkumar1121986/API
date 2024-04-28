package com.api.webservice.rest.dashboard;

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


import com.api.model.dashboard.DashBoardInputObject;
import com.api.model.dashboard.DashBoardOutputObject;

import com.api.servicebroker.rest.dashboard.DashBoardRestService;

import com.api.util.AssetUtil;

@Controller
@RequestMapping("rest")

public class DashBoardRestWebService {
	

	
	@Inject
	private DashBoardRestService dashBoardRestService;
	
	
	
	@RequestMapping(value = "dashboard", method = RequestMethod.POST, headers = ACCEPTABLE_HEADER_TYPE_JSON)
	@ResponseBody
	public DashBoardOutputObject getAllSignDetails(@RequestBody DashBoardInputObject dashBoardInputObject,
			@RequestHeader MultiValueMap<String, String> requestHeaders, HttpServletResponse httpServletResponse,
			WebRequest webRequest) {
		return dashBoardRestService.getDetails(dashBoardInputObject,
				AssetUtil.getHTTPRequestHeaderValue(requestHeaders));
	}
	
	

}
