package com.api.controlparameters.businessobject;

import javax.inject.Inject;
import javax.inject.Named;

import com.api.common.exceptions.BusinessException;
import com.api.common.exceptions.DAOException;
import com.api.controlparameters.dao.IControlParameterDAO;
import com.api.util.MBaseLogger;
@Named("controlParameterBusinessObject")
public class ControlParameterBusinessObject implements IControlParameterBusinessObject{

	@Inject
	@Named("controlParameterDAO")
	private IControlParameterDAO controlParameterDAO;

	private static final MBaseLogger LOGGER= new MBaseLogger();


	public String get(String controlParameterIdentifier) throws BusinessException{
		try{
			return controlParameterDAO.get(controlParameterIdentifier);
		}catch(Exception e){
			LOGGER.error("Error in Class =["+this.getClass().getName()+"] and Method =[get()], Error is "+e);
			throw new BusinessException(e);
		}
	}
	
	public String getQuery(String controlParameterIdentifier) throws BusinessException{
		try{
			return controlParameterDAO.getQuery(controlParameterIdentifier);
		}catch(DAOException e){
			LOGGER.error("Error in Class =["+this.getClass().getName()+"] and Method =[getQuery()], Error is "+e);
			throw new BusinessException(e);
		}catch(Exception e){
			LOGGER.error("Error in Class =["+this.getClass().getName()+"] and Method =[getQuery()], Error is "+e);
			throw new BusinessException(e);
		}
	}

	public String getServiceFlag(String controlParameterIdentifier) throws BusinessException{
		try{
			return controlParameterDAO.getServiceFlag(controlParameterIdentifier);
		}catch(DAOException e){
			LOGGER.error("Error in Class =["+this.getClass().getName()+"] and Method =[getServiceFlag()], Error is "+e);
			throw new BusinessException(e);
		}catch(Exception e){
			LOGGER.error("Error in Class =["+this.getClass().getName()+"] and Method =[getServiceFlag()], Error is "+e);
			throw new BusinessException(e);
		}
	}

	@Override
	public String getFollowValidationData(String controlParameterIdentifier) throws BusinessException {
		try{
			return controlParameterDAO.getFollowValidationData(controlParameterIdentifier);
		}catch(DAOException e){
			LOGGER.error("Error in Class =["+this.getClass().getName()+"] and Method =[getFollowValidationData()], Error is "+e);
			throw new BusinessException(e);
		}catch(Exception e){
			LOGGER.error("Error in Class =["+this.getClass().getName()+"] and Method =[getFollowValidationData()], Error is "+e);
			throw new BusinessException(e);
		}
	}

}