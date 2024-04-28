package com.api.controlparameters.dao;

import static com.api.controlparameters.dao.constants.ControlParameterDAOConstants.GET_CONFIGURATION_DATA;
import static com.api.controlparameters.dao.constants.ControlParameterDAOConstants.GET_FOLLOW_VALI_DATA;
import static com.api.controlparameters.dao.constants.ControlParameterDAOConstants.GET_QUERY_LISTVIEW_DATA;
import static com.api.controlparameters.dao.constants.ControlParameterDAOConstants.GET_QUERY_SERVICE_FLAG;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.inject.Named;
import javax.naming.NamingException;

import com.api.common.dao.daofactory.DAOCachedRowSet;
import com.api.common.dao.daofactory.OracleDAOFactory;
import com.api.common.domainobject.PreparedStatementDomainObject;
import com.api.common.exceptions.DAOException;
import com.api.util.MBaseLogger;

@Named("controlParameterDAO")
public class ControlParameterDAO implements IControlParameterDAO{
	
	private static final MBaseLogger LOGGER = new MBaseLogger();
	
	private static HashMap<String, String> parameter = new HashMap<String, String>();
	
	private String getCacheConfigParameter(String queryIdentifier) {
        if(parameter.containsKey(queryIdentifier) && (parameter.get(queryIdentifier) != null && parameter.get(queryIdentifier).length()>0)){
               return parameter.get(queryIdentifier);
        }else{
           try{
                 
        	   parameter.put(queryIdentifier, getParameter(queryIdentifier));
                 return parameter.get(queryIdentifier);
           }catch(Exception e){
        	   return "";
           }
        }
	}
	
	private String getCacheQuery(String queryIdentifier) throws DAOException {
        if(parameter.containsKey(queryIdentifier) && (parameter.get(queryIdentifier) != null && parameter.get(queryIdentifier).length()>0)){
               return parameter.get(queryIdentifier);
        }else{
           try{
                 
        	   parameter.put(queryIdentifier, getQueryParameter(queryIdentifier));
                 return parameter.get(queryIdentifier);
           }catch(Exception e){
        	   return "";
           }
        }
	}
	
	private String getCacheServiceFlag(String queryIdentifier) throws DAOException {
        if(parameter.containsKey(queryIdentifier) && (parameter.get(queryIdentifier) != null && parameter.get(queryIdentifier).length()>0)){
               return parameter.get(queryIdentifier);
        }else{
           try{
                 
        	   parameter.put(queryIdentifier, getQueryServiceFlag(queryIdentifier));
               return parameter.get(queryIdentifier);
           }catch(Exception e){
        	   return "";
           }
        }
	}
	
	private String getFollowValiData(String queryIdentifier) throws DAOException {
        if(parameter.containsKey(queryIdentifier) && (parameter.get(queryIdentifier) != null && parameter.get(queryIdentifier).length()>0)){
               return parameter.get(queryIdentifier);
        }else{
           try{
                 
        	   parameter.put(queryIdentifier, getFollowUpValidationData(queryIdentifier));
               return parameter.get(queryIdentifier);
           }catch(Exception e){
        	   return "";
           }
        }
	}

	public String get(String controlParameterIdentifier) {
		return getCacheConfigParameter(controlParameterIdentifier);
	}
	
	public String getServiceFlag(String controlParameterIdentifier) throws DAOException{
		return getCacheServiceFlag(controlParameterIdentifier);
	}
	
	public String getQuery(String controlParameterIdentifier) throws DAOException{
		return getCacheQuery(controlParameterIdentifier);
	}
	
	public String getFollowValidationData(String controlParameterIdentifier) throws DAOException{
		return getFollowValiData(controlParameterIdentifier);
	}
	
	private String getParameter(String controlParameterIdentifier) throws DAOException{
		
		String currValue = "";
		DAOCachedRowSet theDAOCachedRowSet = null;
		ArrayList<PreparedStatementDomainObject> alPreparedStatementDomainObject;
		PreparedStatementDomainObject thePreparedStatementDomainObject;
		try{

			alPreparedStatementDomainObject = new ArrayList<PreparedStatementDomainObject>();
	
			thePreparedStatementDomainObject = new PreparedStatementDomainObject();
			thePreparedStatementDomainObject.setTypeAt(1);
			thePreparedStatementDomainObject.setType(PreparedStatementDomainObject.DATA_TYPE_STRING);
			thePreparedStatementDomainObject.setStringValue(controlParameterIdentifier);
			alPreparedStatementDomainObject.add(thePreparedStatementDomainObject);
			theDAOCachedRowSet = OracleDAOFactory.executePreparedQuery(GET_CONFIGURATION_DATA,alPreparedStatementDomainObject);
	
			if(theDAOCachedRowSet.next())
			{
				currValue = theDAOCachedRowSet.getString("VALUE");
			}

	}catch(SQLException e){
		LOGGER.error("Error in Class =["+this.getClass().getName()+"] and Method =[getParameter()], Error is "+e);
		throw new DAOException(e);
	} catch (NamingException e) {
		LOGGER.error("Error in Class =["+this.getClass().getName()+"] and Method =[getParameter()], Error is "+e);
		throw new DAOException(e);
	} catch (Exception e) {
		LOGGER.error("Error in Class =["+this.getClass().getName()+"] and Method =[getParameter()], Error is "+e);
		throw new DAOException(e);
	}finally{
		try{
			
			if(theDAOCachedRowSet!=null){
				theDAOCachedRowSet.release();
				theDAOCachedRowSet.close();
			}
			alPreparedStatementDomainObject=null;
			thePreparedStatementDomainObject = null;
 		}catch(Exception se){
 			LOGGER.error("Error in Class =["+this.getClass().getName()+"] and Method =[getParameter finally()], Error is "+se);
 		}
		
		}
		return currValue;
	}
	
	private String getQueryParameter(String controlParameterIdentifier) throws DAOException{
		
		String currValue = "";
		DAOCachedRowSet theDAOCachedRowSet = null;
		ArrayList<PreparedStatementDomainObject> alPreparedStatementDomainObject;
		PreparedStatementDomainObject thePreparedStatementDomainObject;
		try{

			alPreparedStatementDomainObject = new ArrayList<PreparedStatementDomainObject>();
	
			thePreparedStatementDomainObject = new PreparedStatementDomainObject();
			thePreparedStatementDomainObject.setTypeAt(1);
			thePreparedStatementDomainObject.setType(PreparedStatementDomainObject.DATA_TYPE_STRING);
			thePreparedStatementDomainObject.setStringValue(controlParameterIdentifier);
			alPreparedStatementDomainObject.add(thePreparedStatementDomainObject);
			
			theDAOCachedRowSet = OracleDAOFactory.executePreparedQuery(GET_QUERY_LISTVIEW_DATA,alPreparedStatementDomainObject);
	
			if(theDAOCachedRowSet.next())
			{
				currValue = theDAOCachedRowSet.getString("LV_DATA_QRY");
			}

		}catch(SQLException e){
			LOGGER.error("Error in Class =["+this.getClass().getName()+"] and Method =[getQueryParameter()], Error is "+e);
			throw new DAOException(e);
		} catch (NamingException e) {
			LOGGER.error("Error in Class =["+this.getClass().getName()+"] and Method =[getQueryParameter()], Error is "+e);
			throw new DAOException(e);
		} catch (Exception e) {
			LOGGER.error("Error in Class =["+this.getClass().getName()+"] and Method =[getQueryParameter()], Error is "+e);
			throw new DAOException(e);
		}finally{
			try{
				
				if(theDAOCachedRowSet!=null){
					theDAOCachedRowSet.release();
					theDAOCachedRowSet.close();
				}
				alPreparedStatementDomainObject=null;
				thePreparedStatementDomainObject = null;
	 		}catch(Exception se){
	 			LOGGER.error("Error in Class =["+this.getClass().getName()+"] and Method =[getQueryParameter finally()], Error is "+se);
	 		}
		
		}
		return currValue;
	}
	
	private String getQueryServiceFlag(String controlParameterIdentifier) throws DAOException{
		
		String currValue = "";
		DAOCachedRowSet theDAOCachedRowSet = null;
		ArrayList<PreparedStatementDomainObject> alPreparedStatementDomainObject;
		PreparedStatementDomainObject thePreparedStatementDomainObject;
		try{

			alPreparedStatementDomainObject = new ArrayList<PreparedStatementDomainObject>();
	
			thePreparedStatementDomainObject = new PreparedStatementDomainObject();
			thePreparedStatementDomainObject.setTypeAt(1);
			thePreparedStatementDomainObject.setType(PreparedStatementDomainObject.DATA_TYPE_STRING);
			thePreparedStatementDomainObject.setStringValue(controlParameterIdentifier);
			alPreparedStatementDomainObject.add(thePreparedStatementDomainObject);
			
			theDAOCachedRowSet = OracleDAOFactory.executePreparedQuery(GET_QUERY_SERVICE_FLAG,alPreparedStatementDomainObject);
	
			if(theDAOCachedRowSet.next())
			{
				currValue = theDAOCachedRowSet.getString("MOB_SESSION_CHECK");
			}

		}catch(SQLException e){
			LOGGER.error("Error in Class =["+this.getClass().getName()+"] and Method =[getQueryServiceFlag()], Error is "+e);
			throw new DAOException(e);
		} catch (NamingException e) {
			LOGGER.error("Error in Class =["+this.getClass().getName()+"] and Method =[getQueryServiceFlag()], Error is "+e);
			throw new DAOException(e);
		} catch (Exception e) {
			LOGGER.error("Error in Class =["+this.getClass().getName()+"] and Method =[getQueryServiceFlag()], Error is "+e);
			throw new DAOException(e);
		}finally{
			try{
				
				if(theDAOCachedRowSet!=null){
					theDAOCachedRowSet.release();
					theDAOCachedRowSet.close();
				}
				alPreparedStatementDomainObject=null;
				thePreparedStatementDomainObject = null;
	 		}catch(Exception se){
	 			LOGGER.error("Error in Class =["+this.getClass().getName()+"] and Method =[getQueryServiceFlag finally()], Error is "+se);
	 		}
		
		}
		return currValue;
	}
	
	private String getFollowUpValidationData(String controlParameterIdentifier) throws DAOException{
		
		String currValue = "";
		DAOCachedRowSet theDAOCachedRowSet = null;
		ArrayList<PreparedStatementDomainObject> alPreparedStatementDomainObject;
		PreparedStatementDomainObject thePreparedStatementDomainObject;
		try{

			alPreparedStatementDomainObject = new ArrayList<PreparedStatementDomainObject>();
	
			thePreparedStatementDomainObject = new PreparedStatementDomainObject();
			thePreparedStatementDomainObject.setTypeAt(1);
			thePreparedStatementDomainObject.setType(PreparedStatementDomainObject.DATA_TYPE_STRING);
			thePreparedStatementDomainObject.setStringValue(controlParameterIdentifier);
			alPreparedStatementDomainObject.add(thePreparedStatementDomainObject);
			
			theDAOCachedRowSet = OracleDAOFactory.executePreparedQuery(GET_FOLLOW_VALI_DATA,alPreparedStatementDomainObject);
	
			if(theDAOCachedRowSet.next())
			{
				currValue = theDAOCachedRowSet.getString("MFV_KEY");
			}
	
		}catch(SQLException e){
			LOGGER.error("Error in Class =["+this.getClass().getName()+"] and Method =[getFollowUpValidationData()], Error is "+e);
			throw new DAOException(e);
		} catch (NamingException e) {
			LOGGER.error("Error in Class =["+this.getClass().getName()+"] and Method =[getFollowUpValidationData()], Error is "+e);
			throw new DAOException(e);
		} catch (Exception e) {
			LOGGER.error("Error in Class =["+this.getClass().getName()+"] and Method =[getFollowUpValidationData()], Error is "+e);
			throw new DAOException(e);
		}finally{
			try{
				
				if(theDAOCachedRowSet!=null){
					theDAOCachedRowSet.release();
					theDAOCachedRowSet.close();
				}
				alPreparedStatementDomainObject=null;
				thePreparedStatementDomainObject = null;
	 		}catch(Exception se){
	 			LOGGER.error("Error in Class =["+this.getClass().getName()+"] and Method =[getFollowUpValidationData finally()], Error is "+se);
	 		}
		
		}
		return currValue;
	}
	
}
