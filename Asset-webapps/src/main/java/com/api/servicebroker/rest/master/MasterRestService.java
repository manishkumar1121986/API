package com.api.servicebroker.rest.master;

import static com.api.util.WEBConstants.EXCEPTION_OCCURED;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;

import com.api.common.exceptions.ServiceRequestException;
import com.api.crm.domainobject.*;
import com.api.crm.service.IMasterService;
import com.api.interceptor.AssetRequestInterceptor;
import com.api.model.HeaderObject;
import com.api.model.httpheader.AssetRESTServiceRequestHeader;
import com.api.model.master.*;

import com.api.util.MBaseLogger;

@Named("masterRestService")
public class MasterRestService {
	

	@Inject
	@Named("masterService")
	private IMasterService masterService;
	
	private static final MBaseLogger logger = new MBaseLogger();
	
	
	
	
	public MasterOutputObject getDetails(MasterInputObject masterInputObject,
			AssetRESTServiceRequestHeader theAssetRESTServiceRequestHeader) {
		MasterOutputObject masteroutputObject = new MasterOutputObject();
		String appStatus="";

		HeaderObject header = new HeaderObject();
		ResponseObject response = new ResponseObject();
		try {
			
			


				
			
			DataObject data=new DataObject();
			
			
			
			
			
		//	CountryDomainObject countryDomainobject= new CountryDomainObject();
			List<CountryDomainObject> countryDomainObjectAL =new ArrayList<CountryDomainObject>();
			List<ProductDomainObject> productDomainObjectAL =new ArrayList<ProductDomainObject>();
			
			List<CountryObject> countryObjectAL =new ArrayList<CountryObject>();
			List<ProductObject> productObjectAL =new ArrayList<ProductObject>();
			
			countryDomainObjectAL = masterService.getCountry();
			
			for (int i=0;i<countryDomainObjectAL.size();i++)
			{
				CountryDomainObject countryDomainObject =new CountryDomainObject();
				CountryObject countryObject =new CountryObject();
				countryDomainObject = countryDomainObjectAL.get(i);
				
				countryObject.setKey(countryDomainObject.getKey());
				countryObject.setValue(countryDomainObject.getValue());
				
				
				countryObjectAL.add(countryObject);
				
			}
			productDomainObjectAL = masterService.getProduct();
			for (int i=0;i<productDomainObjectAL.size();i++)
			{
				ProductDomainObject productDomainObject =new ProductDomainObject();
				ProductObject productObject =new ProductObject();
				productDomainObject = productDomainObjectAL.get(i);
				
				productObject.setKey(productDomainObject.getKey());
				productObject.setDescription(productDomainObject.getDescription());
				productObject.setCost(productDomainObject.getCost());
				
				
				productObjectAL.add(productObject);
			}
			
			data.setCountryObject(countryObjectAL);
			data.setProductObject(productObjectAL);
			response.setData(data);
			header.setResponseCode("S");
			
			header.setResponseMsg("S");
			
			
			
	//		HeaderObject header = new HeaderObject();
			header.setMsgID(masterInputObject.getRequest().getHeader().getMsgID());
			header.setReqSystem(masterInputObject.getRequest().getHeader().getReqSystem());
			header.setReqType(masterInputObject.getRequest().getHeader().getReqType());
			//header.setResponseCode(dueDtlDomainobject.getStatucCode());
			header.setResponseTimeStamp(new Date()+"");
			//header.setStatus(dueDtlDomainobject.getStatus());
			header.setUserId(masterInputObject.getRequest().getHeader().getUserId());
			
			
			
		//	ResponseObject response = new ResponseObject();
			response.setHeader(header);
			
			
			masteroutputObject.setResponse(response);
						

			AssetRequestInterceptor.setResponseCode("OK");

		} catch (ServiceRequestException se) {
			logger.error("Error in Class =[" + this.getClass().getName() + "] and Method =[getLetterDetails()], Error is "
					+ se);
			AssetRequestInterceptor.setResponseCode(EXCEPTION_OCCURED);
		} catch (Exception e) {
			logger.error(
					"Error in Class =[" + this.getClass().getName() + "] and Method =[getLetterDetails()], Error is " + e);
			AssetRequestInterceptor.setResponseCode(EXCEPTION_OCCURED);
		}
		return masteroutputObject;
	}


}
