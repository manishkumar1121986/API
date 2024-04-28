package com.api.controlparameters.serviceinterface;

import com.api.common.exceptions.ServiceRequestException;

public interface IControlParameterService {
	 String get(String controlParameterIdentifier) throws ServiceRequestException;
	 String getServiceFlag(String controlParameterIdentifier) throws ServiceRequestException;
	 String getQuery(String controlParameterIdentifier) throws ServiceRequestException;
	 String getFollowValidationData(String controlParameterIdentifier) throws ServiceRequestException;
}
