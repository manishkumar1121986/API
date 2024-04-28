package com.api.servicebroker.rest.dashboard;

import static com.api.util.WEBConstants.EXCEPTION_OCCURED;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;

import com.api.common.exceptions.ServiceRequestException;
import com.api.crm.service.ICustomerService;
import com.api.crm.domainobject.CountryDomainObject;
import com.api.crm.domainobject.CustomerDomainObject;
import com.api.crm.domainobject.ListCustomerDomainObject;
import com.api.interceptor.AssetRequestInterceptor;
import com.api.model.HeaderObject;
import com.api.model.dashboard.*;
import com.api.model.httpheader.AssetRESTServiceRequestHeader;
import com.api.util.MBaseLogger;

@Named("dashboardRestService")
public class DashBoardRestService {
	

	@Inject
	@Named("customerService")
	private ICustomerService customerService;
	
	private static final MBaseLogger logger = new MBaseLogger();
	
	
	
	
	public DashBoardOutputObject getDetails(DashBoardInputObject customerInputObject,
			AssetRESTServiceRequestHeader theAssetRESTServiceRequestHeader) {
		DashBoardOutputObject customeroutputObject = new DashBoardOutputObject();
		//String appStatus="";

		HeaderObject header = new HeaderObject();
		ResponseObject response = new ResponseObject();
		try {
			
			
			logger.debug("Dashboard 1");
			
			

				
				
				
				
				
			ListCustomerDomainObject listCustomerDomainObject=new ListCustomerDomainObject();
			listCustomerDomainObject=	customerService.getCoustomerList();
			logger.debug("Dashboard 2");
			List<CustomerDomainObject> listCustomerDomainObjectAL =new ArrayList<CustomerDomainObject>();
			listCustomerDomainObjectAL=listCustomerDomainObject.getListCustomerDomainObject();
			
			logger.debug("Dashboard 3");
			List<CustomerObject> CustomerObjectAL =new ArrayList<CustomerObject>();
			
			for (int i=0;i<listCustomerDomainObjectAL.size();i++)
			{
				logger.debug("Dashboard FOR");
				CustomerDomainObject customerObjectin1 = new  CustomerDomainObject();
				customerObjectin1=listCustomerDomainObjectAL.get(i);
				
				
			
			
			
				CustomerObject cdr1 =new CustomerObject();
				
				
				cdr1.setAction(customerObjectin1.getAction());
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
				CustomerObjectAL.add(cdr1);
			
			}
			logger.debug("Dashboard end FOR");
			CustomerListObject customerListObject=new CustomerListObject();
			customerListObject.setCustomerObject(CustomerObjectAL);
				DataObject data=new DataObject();
			
			
				data.setCustomerListObject(customerListObject);
				
				
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
