package com.api.servicebroker.rest.customer;

import static com.api.util.WEBConstants.EXCEPTION_OCCURED;

import java.util.Date;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;

import com.api.common.exceptions.ServiceRequestException;
import com.api.crm.service.ICustomerService;
import com.api.crm.domainobject.CustomerDomainObject;
import com.api.interceptor.AssetRequestInterceptor;
import com.api.model.HeaderObject;
import com.api.model.customer.*;
import com.api.model.httpheader.AssetRESTServiceRequestHeader;
import com.api.util.MBaseLogger;

@Named("customerRestService")
public class CustomerRestService {
	

	@Inject
	@Named("customerService")
	private ICustomerService customerService;
	
	private static final MBaseLogger logger = new MBaseLogger();
	
	
	
	
	public CustomerOutputObject getDetails(CustomerInputObject customerInputObject,
			AssetRESTServiceRequestHeader theAssetRESTServiceRequestHeader) {
		CustomerOutputObject customeroutputObject = new CustomerOutputObject();
		//String appStatus="";

		HeaderObject header = new HeaderObject();
		ResponseObject response = new ResponseObject();
		try {
			
			logger.debug("MANISH");


				
			
				
				CustomerDomainObject cdr=new CustomerDomainObject();
				cdr.setAction(customerInputObject.getRequest().getData().getCustomer().getAction());
				cdr.setActiveStatus(customerInputObject.getRequest().getData().getCustomer().getActiveStatus());
				cdr.setActivity1(customerInputObject.getRequest().getData().getCustomer().getActivity1());
				cdr.setActivity2(customerInputObject.getRequest().getData().getCustomer().getActivity2());
				cdr.setActivity3(customerInputObject.getRequest().getData().getCustomer().getActivity3());
				cdr.setActivity4(customerInputObject.getRequest().getData().getCustomer().getActivity4());
				cdr.setActivity5(customerInputObject.getRequest().getData().getCustomer().getActivity5());
				cdr.setActivity6(customerInputObject.getRequest().getData().getCustomer().getActivity6());
				cdr.setActivity7(customerInputObject.getRequest().getData().getCustomer().getActivity7());
				cdr.setActivity8(customerInputObject.getRequest().getData().getCustomer().getActivity8());
				cdr.setActivity9(customerInputObject.getRequest().getData().getCustomer().getActivity9());
				cdr.setActivity10(customerInputObject.getRequest().getData().getCustomer().getActivity10());
				cdr.setAddress(customerInputObject.getRequest().getData().getCustomer().getAddress());
				cdr.setClosingDate(customerInputObject.getRequest().getData().getCustomer().getClosingDate());
				cdr.setCompany1(customerInputObject.getRequest().getData().getCustomer().getCompany1());
				cdr.setCompany2(customerInputObject.getRequest().getData().getCustomer().getCompany2());
				cdr.setCompany3(customerInputObject.getRequest().getData().getCustomer().getCompany3());
				cdr.setCompanyNameCreated(customerInputObject.getRequest().getData().getCustomer().getCompanyNameCreated());
				cdr.setCostOffer(customerInputObject.getRequest().getData().getCustomer().getCostOffer());
				cdr.setCostPaid(customerInputObject.getRequest().getData().getCustomer().getCostPaid());
				cdr.setCountry(customerInputObject.getRequest().getData().getCustomer().getCountry());
				cdr.setDob(customerInputObject.getRequest().getData().getCustomer().getDob());
				cdr.setEmail(customerInputObject.getRequest().getData().getCustomer().getEmail());
				cdr.setFname(customerInputObject.getRequest().getData().getCustomer().getFname());
				cdr.setLname(customerInputObject.getRequest().getData().getCustomer().getLname());
				cdr.setMobile(customerInputObject.getRequest().getData().getCustomer().getMobile());
				cdr.setPassportNo(customerInputObject.getRequest().getData().getCustomer().getPassportNo());
				cdr.setPhone(customerInputObject.getRequest().getData().getCustomer().getPhone());
				cdr.setIssueDate(customerInputObject.getRequest().getData().getCustomer().getIssueDate());
				cdr.setNextRenewDate(customerInputObject.getRequest().getData().getCustomer().getNextRenewDate());
				cdr.setTradeLicNo(customerInputObject.getRequest().getData().getCustomer().getTradeLicNo());
				cdr.setStatus(customerInputObject.getRequest().getData().getCustomer().getActiveStatus());
				cdr.setCustomerId(customerInputObject.getRequest().getData().getCustomer().getCustomerId());
				logger.debug("MANISH1");
				
				CustomerDomainObject customerObjectin1=new CustomerDomainObject();
				customerObjectin1=	customerService.customer(cdr);
				CustomerObject cdr1 =new CustomerObject();
				
				
				cdr1.setAction(customerObjectin1.getAction());
				cdr1.setCustomerId(customerObjectin1.getCustomerId());
				cdr1.setActiveStatus(customerObjectin1.getActiveStatus());
				cdr1.setActivity1(customerObjectin1.getActivity1());
				cdr1.setActivity2(customerObjectin1.getActivity2());
				cdr1.setActivity3(customerObjectin1.getActivity3());
				cdr1.setActivity4(customerObjectin1.getActivity4());
				cdr1.setActivity5(customerObjectin1.getActivity5());
				cdr1.setActivity6(customerObjectin1.getActivity6());
				cdr1.setActivity7(customerObjectin1.getActivity7());
				cdr1.setActivity8(customerObjectin1.getActivity8());
				cdr1.setActivity9(customerObjectin1.getActivity9());
				cdr1.setActivity10(customerObjectin1.getActivity10());
				cdr1.setAddress(customerObjectin1.getAddress());
				cdr1.setClosingDate(customerObjectin1.getClosingDate());
				cdr1.setCompany1(customerObjectin1.getCompany1());
				cdr1.setCompany2(customerObjectin1.getCompany2());
				cdr1.setCompany3(customerObjectin1.getCompany3());
				cdr1.setCompanyNameCreated(customerObjectin1.getCompanyNameCreated());
				cdr1.setCostOffer(customerObjectin1.getCostOffer());
				cdr1.setCostPaid(customerObjectin1.getCostPaid());
				cdr1.setCountry(customerObjectin1.getCustomerId());
cdr1.setDob(customerObjectin1.getDob());
cdr1.setEmail(customerObjectin1.getEmail());
cdr1.setFname(customerObjectin1.getFname());
cdr1.setLname(customerObjectin1.getLname());
cdr1.setMobile(customerObjectin1.getMobile());
cdr1.setPassportNo(customerObjectin1.getPassportNo());
cdr1.setPhone(customerObjectin1.getPhone());
cdr1.setIssueDate(customerObjectin1.getIssueDate());
cdr1.setNextRenewDate(customerObjectin1.getNextRenewDate());
				cdr1.setTradeLicNo(customerObjectin1.getTradeLicNo());
				cdr1.setStatus(customerObjectin1.getActiveStatus());
				
				
				DataObject data=new DataObject();
			
				logger.debug("MANISH2");
				data.setCustomer(cdr1);
				
				
			response.setData(data);
			header.setResponseCode("S");
			
			header.setResponseMsg("S");
			
			
			
	//		HeaderObject header = new HeaderObject();
			header.setMsgID(customerInputObject.getRequest().getHeader().getMsgID());
			header.setReqSystem(customerInputObject.getRequest().getHeader().getReqSystem());
			header.setReqType(customerInputObject.getRequest().getHeader().getReqType());
			//header.setResponseCode(dueDtlDomainobject.getStatucCode());
			header.setResponseTimeStamp(new Date()+"");
			//header.setStatus(dueDtlDomainobject.getStatus());
			header.setUserId(customerInputObject.getRequest().getHeader().getUserId());
			
			
			
		//	ResponseObject response = new ResponseObject();
			response.setHeader(header);
			
			
			customeroutputObject.setResponse(response);
						

			AssetRequestInterceptor.setResponseCode("OK");

		} catch (ServiceRequestException se) {
			logger.error("Error in Class =[" + this.getClass().getName() + "] and Method =[getLetterDetails()], Error is "
					+ se);
			AssetRequestInterceptor.setResponseCode(EXCEPTION_OCCURED);
		} catch (Exception e) {
			logger.error(
					"Error in Class =[" + this.getClass().getName() + "] and Method =[getLetterDetails()], Error is " + e);
			AssetRequestInterceptor.setResponseCode(EXCEPTION_OCCURED);
			e.printStackTrace();
		}
		return customeroutputObject;
	}


}
