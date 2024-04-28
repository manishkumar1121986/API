package com.api.controlparameters.businessobject;

import com.api.common.exceptions.BusinessException;

public interface IControlParameterBusinessObject {

	 String get(String controlParameterIdentifier) throws BusinessException;
	 String getServiceFlag(String controlParameterIdentifier) throws BusinessException;
	 String getQuery(String controlParameterIdentifier) throws BusinessException;
	 String getFollowValidationData(String controlParameterIdentifier) throws BusinessException;
}
