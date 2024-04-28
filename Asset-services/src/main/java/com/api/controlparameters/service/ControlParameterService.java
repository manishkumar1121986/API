package com.api.controlparameters.service;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Service;

import com.api.common.exceptions.BusinessException;
import com.api.common.exceptions.ServiceRequestException;
import com.api.controlparameters.businessobject.IControlParameterBusinessObject;
import com.api.controlparameters.serviceinterface.IControlParameterService;
import com.api.util.MBaseLogger;
@Service("controlParameterService")
public class ControlParameterService implements IControlParameterService {


	@Inject
	@Named("controlParameterBusinessObject")
	private IControlParameterBusinessObject controlParameterBusinessObject;

	private static final MBaseLogger LOGGER= new MBaseLogger();

	public String get(String controlParameterIdentifier) throws BusinessException{
		try{
			return controlParameterBusinessObject.get(controlParameterIdentifier);
		}catch(BusinessException se){
			LOGGER.error("Error in Class =["+this.getClass().getName()+"] and Method =[get()], Error is "+se);
			throw new ServiceRequestException(se);
		}
	}
	
	public String getQuery(String controlParameterIdentifier) throws BusinessException{
		try{
			return controlParameterBusinessObject.getQuery(controlParameterIdentifier);
		}catch(BusinessException se){
			LOGGER.error("Error in Class =["+this.getClass().getName()+"] and Method =[getQuery()], Error is "+se);
			throw new ServiceRequestException(se);
		}
	}


	
	
	public String getServiceFlag(String controlParameterIdentifier) throws BusinessException{
		try{
			return controlParameterBusinessObject.getServiceFlag(controlParameterIdentifier);
		}catch(BusinessException se){
			LOGGER.error("Error in Class =["+this.getClass().getName()+"] and Method =[getServiceFlag()], Error is "+se);
			throw new ServiceRequestException(se);
		}
	}

	@Override
	public String getFollowValidationData(String controlParameterIdentifier) throws ServiceRequestException {
		try{
			return controlParameterBusinessObject.getFollowValidationData(controlParameterIdentifier);
		}catch(BusinessException se){
			LOGGER.error("Error in Class =["+this.getClass().getName()+"] and Method =[getFollowValidationData()], Error is "+se);
			throw new ServiceRequestException(se);
		}
	}

}
