package com.api.controlparameters.dao;

import com.api.common.exceptions.DAOException;

public interface IControlParameterDAO {

	 String get(String controlParameterIdentifier);
	 String getServiceFlag(String controlParameterIdentifier) throws DAOException;
	 String getQuery(String controlParameterIdentifier) throws DAOException;
	 String getFollowValidationData(String controlParameterIdentifier) throws DAOException;
}
