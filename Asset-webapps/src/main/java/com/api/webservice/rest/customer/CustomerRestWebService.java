package com.api.webservice.rest.customer;

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

import com.api.model.customer.CustomerInputObject;
import com.api.model.customer.CustomerOutputObject;

import com.api.servicebroker.rest.customer.CustomerRestService;

import com.api.util.AssetUtil;

@Controller
@RequestMapping("rest")

public class CustomerRestWebService {
	

	
	@Inject
	private CustomerRestService customerRestService;
	
	
	
	@RequestMapping(value = "customer", method = RequestMethod.POST, headers = ACCEPTABLE_HEADER_TYPE_JSON)
	@ResponseBody
	public CustomerOutputObject getAllSignDetails(@RequestBody CustomerInputObject customerInputObject,
			@RequestHeader MultiValueMap<String, String> requestHeaders, HttpServletResponse httpServletResponse,
			WebRequest webRequest) {
		return customerRestService.getDetails(customerInputObject,
				AssetUtil.getHTTPRequestHeaderValue(requestHeaders));
	}

}
