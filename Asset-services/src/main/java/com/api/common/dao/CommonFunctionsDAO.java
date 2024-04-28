package com.api.common.dao;

import static com.api.common.dao.constants.CommonFunctionsDAOConstants.GET_DATE_DIFF_USING_SYSDATE;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.naming.NamingException;

import com.api.common.dao.daofactory.DAOCachedRowSet;
import com.api.common.dao.daofactory.OracleDAOFactory;
import com.api.common.domainobject.PreparedStatementDomainObject;
import com.api.common.domainobject.RequestCaptureDomainObject;
import com.api.common.exceptions.DAOException;
import com.api.controlparameters.serviceinterface.IControlParameterService;

import com.api.util.MBaseLogger;

@Named("commonFunctionsDAO")
public class CommonFunctionsDAO implements ICommonFunctionsDAO {
	
	private static final MBaseLogger LOGGER= new MBaseLogger();
	
	@Inject
	@Named("controlParameterService")
	private IControlParameterService controlParameterService;
	
	
	@Override
	public String dynaErrMSG(String query){
		String rQuery="";
		
		
		DAOCachedRowSet theDAOCachedRowSet = null;
		String exeQuery = "select ERR_MSG from INT_SERVICE_ERR_MSG where ERR_CODE='"
				+ query + "'";
		LOGGER.debug("*************ERR_CODE***" + query);
		LOGGER.debug("*************exeQuery***" + exeQuery);
		try {
			theDAOCachedRowSet = OracleDAOFactory.executeQuery(exeQuery);

			while (theDAOCachedRowSet.next()) {
				rQuery=theDAOCachedRowSet.getString(1);
			}

		} catch (SQLException e) {
			LOGGER.error("SQL EXCEPTION IN CommonFunctionsDAO");
			e.printStackTrace();
		} catch (NamingException e) {
			LOGGER.error("NamingException EXCEPTION IN CommonFunctionsDAO");
			e.printStackTrace();
		} catch (Exception e) {
			LOGGER.error("Exception EXCEPTION IN CommonFunctionsDAO");
			e.printStackTrace();
		}
		finally {
			try{
				
				if(theDAOCachedRowSet!=null){
					theDAOCachedRowSet.release();
					theDAOCachedRowSet.close();
				}

	}catch(Exception se){
	 			LOGGER.error(this.getClass().getName()+" Insert structure finally() "+se);
	 			se.printStackTrace();
	 		}

		
		}	
		return rQuery;
	}

	@Override
	public String dynaQuery(String query){
		String rQuery="";
		
		
		DAOCachedRowSet theDAOCachedRowSet = null;
		String exeQuery = "select ISQ_DATA_QRY from INT_SERVICE_QUERY where ISQ_CODE='"
				+ query + "'";
		LOGGER.debug("*************query***" + query);
		LOGGER.debug("*************exeQuery***" + exeQuery);
		try {
			theDAOCachedRowSet = OracleDAOFactory.executeQuery(exeQuery);

			while (theDAOCachedRowSet.next()) {
				rQuery=theDAOCachedRowSet.getString(1);
			}

		} catch (SQLException e) {
			LOGGER.error("SQL EXCEPTION IN CommonFunctionsDAO");
			e.printStackTrace();
		} catch (NamingException e) {
			LOGGER.error("NamingException EXCEPTION IN CommonFunctionsDAO");
			e.printStackTrace();
		} catch (Exception e) {
			LOGGER.error("Exception EXCEPTION IN CommonFunctionsDAO");
			e.printStackTrace();
		}
		finally {
			try{
				
				if(theDAOCachedRowSet!=null){
					theDAOCachedRowSet.release();
					theDAOCachedRowSet.close();
				}

	}catch(Exception se){
	 			se.printStackTrace();
	 		}

		
		}
		return rQuery;
	}

	@Override
	public int dateDiffUsingCurrentDate(String dateP) throws DAOException {
		
		ArrayList<PreparedStatementDomainObject> alPreparedStatementDomainObject ;
		PreparedStatementDomainObject thePreparedStatementDomainObject;
		DAOCachedRowSet theDAOCachedRowSet=null;
		try{

				alPreparedStatementDomainObject = new ArrayList<PreparedStatementDomainObject>();

			   thePreparedStatementDomainObject = new PreparedStatementDomainObject();
			   thePreparedStatementDomainObject.setTypeAt(1);
			   thePreparedStatementDomainObject.setType(PreparedStatementDomainObject.DATA_TYPE_STRING);
			   thePreparedStatementDomainObject.setStringValue(dateP);
			   alPreparedStatementDomainObject.add(thePreparedStatementDomainObject);

			   theDAOCachedRowSet=OracleDAOFactory.executePreparedQuery(GET_DATE_DIFF_USING_SYSDATE, alPreparedStatementDomainObject);


			   if(theDAOCachedRowSet.next()){
				   return theDAOCachedRowSet.getInt("DATE_DIFF");
			   }


		}catch(SQLException e){
		   LOGGER.error("Error in Class =["+this.getClass().getName()+"] and Method =[dateDiffUsingCurrentDate()], Error is "+e);
	 		throw new DAOException(e);
	 	} catch (NamingException e) {
	 		LOGGER.error("Error in Class =["+this.getClass().getName()+"] and Method =[dateDiffUsingCurrentDate()], Error is "+e);
	 		throw new DAOException(e);
	 	} catch (Exception e) {
	 		LOGGER.error("Error in Class =["+this.getClass().getName()+"] and Method =[dateDiffUsingCurrentDate()], Error is "+e);
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
	 			LOGGER.error("Error in Class =["+this.getClass().getName()+"] and Method =[dateDiffUsingCurrentDate finally()], Error is "+se);
	 		}

	 	}
		return 0;
	}
	
	public String validateUser(String userId, String password){
		String rQuery="1002";
		
		
		DAOCachedRowSet theDAOCachedRowSet = null;
		String exeQuery = "select COUNT(1) from INT_USERS where userid='"
				+ userId + "' and active='A'";
		LOGGER.debug("*************userId***" + userId);
		LOGGER.debug("*************exeQuery***" + exeQuery);
		try {
			theDAOCachedRowSet = OracleDAOFactory.executeQuery(exeQuery);

			while (theDAOCachedRowSet.next()) {
				int i=theDAOCachedRowSet.getInt(1);
				if(i>0)
				{
					rQuery="0000";
					
				}
			}
			
			if(rQuery.equalsIgnoreCase("0000"))
			{
				rQuery="1003";
				String exeQuery1 = "select COUNT(1) from INT_USERS where userid='"
						+ userId + "' and active='A'  and PASSWORD='"+ password + "'";
				LOGGER.debug("*************userId***" + userId);
				LOGGER.debug("*************exeQuery***" + exeQuery1);
				 theDAOCachedRowSet = null;
				theDAOCachedRowSet = OracleDAOFactory.executeQuery(exeQuery1);
				while (theDAOCachedRowSet.next()) {
					int i=theDAOCachedRowSet.getInt(1);
					if(i>0)
					{
						rQuery="0000";
						
					}
				}
			}
			
			 theDAOCachedRowSet = null;

		} catch (SQLException e) {
			LOGGER.error("SQL EXCEPTION IN CommonFunctionsDAO");
			e.printStackTrace();
		} catch (NamingException e) {
			LOGGER.error("NamingException EXCEPTION IN CommonFunctionsDAO");
			e.printStackTrace();
		} catch (Exception e) {
			LOGGER.error("Exception EXCEPTION IN CommonFunctionsDAO");
			e.printStackTrace();
		}
		finally {
			try{
				
				if(theDAOCachedRowSet!=null){
					theDAOCachedRowSet.release();
					theDAOCachedRowSet.close();
				}

	}catch(Exception se){
	 			se.printStackTrace();
	 		}

		
		}
		
		return dynaErrMSG(rQuery);
	}
	
	public String validateUser(String userId){
		String rQuery="1002";
		
		
		DAOCachedRowSet theDAOCachedRowSet = null;
		String exeQuery = "select COUNT(1) from INT_USERS where userid='"
				+ userId + "' and active='A'";
		LOGGER.debug("*************userId***" + userId);
		LOGGER.debug("*************exeQuery***" + exeQuery);
		try {
			theDAOCachedRowSet = OracleDAOFactory.executeQuery(exeQuery);

			while (theDAOCachedRowSet.next()) {
				int i=theDAOCachedRowSet.getInt(1);
				if(i>0)
				{
					rQuery="0000";
					
				}
			}
			
			

		} catch (SQLException e) {
			LOGGER.error("SQL EXCEPTION IN CommonFunctionsDAO");
			e.printStackTrace();
		} catch (NamingException e) {
			LOGGER.error("NamingException EXCEPTION IN CommonFunctionsDAO");
			e.printStackTrace();
		} catch (Exception e) {
			LOGGER.error("Exception EXCEPTION IN CommonFunctionsDAO");
			e.printStackTrace();
		}
		finally {
			try{
				
				if(theDAOCachedRowSet!=null){
					theDAOCachedRowSet.release();
					theDAOCachedRowSet.close();
				}

	}catch(Exception se){
	 			se.printStackTrace();
	 		}

		
		}
		
		return rQuery;
	}
	
	public String validateStation(String station){
		String rQuery="1005";
		
		DAOCachedRowSet theDAOCachedRowSet = null;
		String exeQuery = "select COUNT(1) from INT_STATION_DTL where STATION_NAME='"
				+ station + "' and active='A'";
		LOGGER.debug("*************query***" + station);
		LOGGER.debug("*************exeQuery***" + exeQuery);
		try {
			theDAOCachedRowSet = OracleDAOFactory.executeQuery(exeQuery);

			while (theDAOCachedRowSet.next()) {
				int i=theDAOCachedRowSet.getInt(1);
				if(i>0)
				{
					rQuery="0000";
					
				}
			}

		} catch (SQLException e) {
			LOGGER.error("SQL EXCEPTION IN CommonFunctionsDAO");
			e.printStackTrace();
		} catch (NamingException e) {
			LOGGER.error("NamingException EXCEPTION IN CommonFunctionsDAO");
			e.printStackTrace();
		} catch (Exception e) {
			LOGGER.error("Exception EXCEPTION IN CommonFunctionsDAO");
			e.printStackTrace();
		}
		finally {
			try{
				
				if(theDAOCachedRowSet!=null){
					theDAOCachedRowSet.release();
					theDAOCachedRowSet.close();
				}

	}catch(Exception se){
	 			se.printStackTrace();
	 		}

		
		}
		
		return rQuery;
	}
	
	public String validateService(String service){
		String rQuery="1004";
		
		DAOCachedRowSet theDAOCachedRowSet = null;
		String exeQuery = "select COUNT(1) from INT_SERVICE_DTL where service_name='"
				+ service + "' and active='A'";
		LOGGER.debug("*************query***" + service);
		LOGGER.debug("*************exeQuery***" + exeQuery);
		try {
			theDAOCachedRowSet = OracleDAOFactory.executeQuery(exeQuery);

			while (theDAOCachedRowSet.next()) {
				int i=theDAOCachedRowSet.getInt(1);
				if(i>0)
				{
					rQuery="0000";
					
				}
			}

		} catch (SQLException e) {
			LOGGER.error("SQL EXCEPTION IN CommonFunctionsDAO");
			e.printStackTrace();
		} catch (NamingException e) {
			LOGGER.error("NamingException EXCEPTION IN CommonFunctionsDAO");
			e.printStackTrace();
		} catch (Exception e) {
			LOGGER.error("Exception EXCEPTION IN CommonFunctionsDAO");
			e.printStackTrace();
		}
		finally {
			try{
				
				if(theDAOCachedRowSet!=null){
					theDAOCachedRowSet.release();
					theDAOCachedRowSet.close();
				}

	}catch(Exception se){
	 			se.printStackTrace();
	 		}

		
		}
		
		return rQuery;
	}
		
	public String validateStationService(String station,String service){
		String rQuery="1006";
		
		
		DAOCachedRowSet theDAOCachedRowSet = null;
		String exeQuery = "select COUNT(1) from INT_STATION_SERVICE_MAP where STATION_NAME='"
				+ station + "' and SERVICENAME='"+service+"' and active='A'";
		
		LOGGER.debug("*************exeQuery***" + exeQuery);
		try {
			theDAOCachedRowSet = OracleDAOFactory.executeQuery(exeQuery);

			while (theDAOCachedRowSet.next()) {
				int i=theDAOCachedRowSet.getInt(1);
				if(i>0)
				{
					rQuery="0000";
					
				}
			}

		} catch (SQLException e) {
			LOGGER.error("SQL EXCEPTION IN CommonFunctionsDAO");
			e.printStackTrace();
		} catch (NamingException e) {
			LOGGER.error("NamingException EXCEPTION IN CommonFunctionsDAO");
			e.printStackTrace();
		} catch (Exception e) {
			LOGGER.error("Exception EXCEPTION IN CommonFunctionsDAO");
			e.printStackTrace();
		}
		finally {
			try{
				
				if(theDAOCachedRowSet!=null){
					theDAOCachedRowSet.release();
					theDAOCachedRowSet.close();
				}

	}catch(Exception se){
	 			se.printStackTrace();
	 		}

		
		}
		
		return rQuery;
	}
	
	public String getTokenFlag(String service){
		String rQuery="N";
		
		
		DAOCachedRowSet theDAOCachedRowSet = null;
		String exeQuery = "select Token from int_service_dtl where service_name='"
				+ service + "' and active='A'";
		LOGGER.debug("*************service***" + service);
		LOGGER.debug("*************exeQuery***" + exeQuery);
		try {
			theDAOCachedRowSet = OracleDAOFactory.executeQuery(exeQuery);

			while (theDAOCachedRowSet.next()) {
				rQuery=theDAOCachedRowSet.getString(1);
			}

		} catch (SQLException e) {
			LOGGER.error("SQL EXCEPTION IN CommonFunctionsDAO");
			e.printStackTrace();
		} catch (NamingException e) {
			LOGGER.error("NamingException EXCEPTION IN CommonFunctionsDAO");
			e.printStackTrace();
		} catch (Exception e) {
			LOGGER.error("Exception EXCEPTION IN CommonFunctionsDAO");
			e.printStackTrace();
		}
		finally {
			try{
				
				if(theDAOCachedRowSet!=null){
					theDAOCachedRowSet.release();
					theDAOCachedRowSet.close();
				}

	}catch(Exception se){
	 			se.printStackTrace();
	 		}

		
		}
		
		return rQuery;
	}
	
	public String captureRequest(RequestCaptureDomainObject requestCaptureDomainObject){
		ArrayList<PreparedStatementDomainObject> alPreparedStatementDomainObject;
		PreparedStatementDomainObject thePreparedStatementDomainObject;
		DAOCachedRowSet theDAOCachedRowSet=null;
		String rtString="F";
		try {

			int paramCount = 1;
			alPreparedStatementDomainObject = new ArrayList<PreparedStatementDomainObject>();
			// DBQUERY =new ICommonFunctionsDAO();
			 
			String query="insert into INT_REQUEST_DTL(station_name,servicename,userid,msgid)values(?,?,?,?)";
			LOGGER.debug("validateAgreementActive-->>query-->>"+query);
			
			thePreparedStatementDomainObject = new PreparedStatementDomainObject();
			
			
			thePreparedStatementDomainObject = new PreparedStatementDomainObject();
			thePreparedStatementDomainObject.setTypeAt(paramCount++);
			thePreparedStatementDomainObject.setType(PreparedStatementDomainObject.DATA_TYPE_STRING);
			thePreparedStatementDomainObject.setStringValue(requestCaptureDomainObject.getStation_name());
			alPreparedStatementDomainObject.add(thePreparedStatementDomainObject);
			
			
			thePreparedStatementDomainObject = new PreparedStatementDomainObject();
			thePreparedStatementDomainObject.setTypeAt(paramCount++);
			thePreparedStatementDomainObject.setType(PreparedStatementDomainObject.DATA_TYPE_STRING);
			thePreparedStatementDomainObject.setStringValue(requestCaptureDomainObject.getServicename());
			alPreparedStatementDomainObject.add(thePreparedStatementDomainObject);
			
			
			thePreparedStatementDomainObject = new PreparedStatementDomainObject();
			thePreparedStatementDomainObject.setTypeAt(paramCount++);
			thePreparedStatementDomainObject.setType(PreparedStatementDomainObject.DATA_TYPE_STRING);
			thePreparedStatementDomainObject.setStringValue(requestCaptureDomainObject.getUserid());
			alPreparedStatementDomainObject.add(thePreparedStatementDomainObject);
			
			
			thePreparedStatementDomainObject = new PreparedStatementDomainObject();
			thePreparedStatementDomainObject.setTypeAt(paramCount++);
			thePreparedStatementDomainObject.setType(PreparedStatementDomainObject.DATA_TYPE_STRING);
			thePreparedStatementDomainObject.setStringValue(requestCaptureDomainObject.getMsgid());
			alPreparedStatementDomainObject.add(thePreparedStatementDomainObject);
			
			

			LOGGER.debug(alPreparedStatementDomainObject);
			
			 OracleDAOFactory.executePreparedUpdate(query, alPreparedStatementDomainObject);
	
		} catch (SQLException e) {
			LOGGER.error(this.getClass().getName()
					+ " validateAgreementActive() " + e);
			
		} catch (NamingException e) {
			LOGGER.error(this.getClass().getName()
					+ " validateAgreementActive() " + e);
			
		} catch (Exception e) {
			LOGGER.error(this.getClass().getName()
					+ " validateAgreementActive() " + e);
			
		} finally {
			try{
				
				if(theDAOCachedRowSet!=null){
					theDAOCachedRowSet.release();
					theDAOCachedRowSet.close();
				}
				alPreparedStatementDomainObject=null;
				thePreparedStatementDomainObject = null;
	 		}catch(Exception se){
	 			LOGGER.error(this.getClass().getName()+" agreementvalidate finally() "+se);
	 		}

		}
		return rtString;
		
	}
	public String validateToken(String msgid,String Token){
		
String rQuery="1007";
		
		
		DAOCachedRowSet theDAOCachedRowSet = null;
		String exeQuery = "select count(1) from INT_REQUEST_DTL where msgid='"
				+ msgid + "' and token_enc='"+Token+"' and nvl(token_used,'N')='N'";
		
		LOGGER.debug("*************exeQuery***" + exeQuery);
		try {
			theDAOCachedRowSet = OracleDAOFactory.executeQuery(exeQuery);

			while (theDAOCachedRowSet.next()) {
				int i=theDAOCachedRowSet.getInt(1);
				if(i>0)
				{
					rQuery="0000";
					
				}
			}

		} catch (SQLException e) {
			LOGGER.error("SQL EXCEPTION IN CommonFunctionsDAO");
			e.printStackTrace();
		} catch (NamingException e) {
			LOGGER.error("NamingException EXCEPTION IN CommonFunctionsDAO");
			e.printStackTrace();
		} catch (Exception e) {
			LOGGER.error("Exception EXCEPTION IN CommonFunctionsDAO");
			e.printStackTrace();
		}
		finally {
			try{
				
				if(theDAOCachedRowSet!=null){
					theDAOCachedRowSet.release();
					theDAOCachedRowSet.close();
				}

	}catch(Exception se){
	 			se.printStackTrace();
	 		}

		
		}
		
		return dynaErrMSG(rQuery);
		
	}
	
	
	public String tokenUpdate(String msgid,String Token,String Tokenenc){
		
		String rQuery="0000";
				
				

String exeQuery = "update int_request_dtl set token_used='N',token='"
						+ Token + "' ,TOKEN_ENC='"+Tokenenc+"' where msgid='"+msgid+"'";
				
				LOGGER.debug("*************exeQuery***" + exeQuery);
				try {
					OracleDAOFactory.executeQuery(exeQuery);

				} catch (SQLException e) {
					LOGGER.error("SQL EXCEPTION IN CommonFunctionsDAO");
					e.printStackTrace();
				} catch (NamingException e) {
					LOGGER.error("NamingException EXCEPTION IN CommonFunctionsDAO");
					e.printStackTrace();
				} catch (Exception e) {
					LOGGER.error("Exception EXCEPTION IN CommonFunctionsDAO");
					e.printStackTrace();
				}
				
				return rQuery;
				
			}
	
	
	public String UpdateSecondReq(String msgid){
		
		String rQuery="0000";
		
		

String exeQuery = "update int_request_dtl set token_used='Y',SECOND_REQ_DATE=sysdate where msgid='"+msgid+"'";
		
		LOGGER.debug("*************exeQuery***" + exeQuery);
		try {
			OracleDAOFactory.executeQuery(exeQuery);

		} catch (SQLException e) {
			LOGGER.error("SQL EXCEPTION IN CommonFunctionsDAO");
			e.printStackTrace();
		} catch (NamingException e) {
			LOGGER.error("NamingException EXCEPTION IN CommonFunctionsDAO");
			e.printStackTrace();
		} catch (Exception e) {
			LOGGER.error("Exception EXCEPTION IN CommonFunctionsDAO");
			e.printStackTrace();
		}
		return rQuery;
	}

		public String validateMsgid(String msgid,String system,String service){
		String rQuery="1011";
		
		DAOCachedRowSet theDAOCachedRowSet = null;
		String exeQuery = "select COUNT(1) from INT_REQUEST_DTL where MSGID='"
				+ msgid + "' and STATION_NAME='"+system+"' and SERVICENAME='"+service+"'";
	
		try {
			theDAOCachedRowSet = OracleDAOFactory.executeQuery(exeQuery);

			while (theDAOCachedRowSet.next()) {
				int i=theDAOCachedRowSet.getInt(1);
				if(i==0)
				{
					rQuery="0000";
					
				}
			}

		} catch (SQLException e) {
			LOGGER.error("SQL EXCEPTION IN CommonFunctionsDAO");
			e.printStackTrace();
		} catch (NamingException e) {
			LOGGER.error("NamingException EXCEPTION IN CommonFunctionsDAO");
			e.printStackTrace();
		} catch (Exception e) {
			LOGGER.error("Exception EXCEPTION IN CommonFunctionsDAO");
			e.printStackTrace();
		}

		finally {
			try{
				
				if(theDAOCachedRowSet!=null){
					theDAOCachedRowSet.release();
					theDAOCachedRowSet.close();
				}

	}catch(Exception se){
	 			se.printStackTrace();
	 		}

		
		}
		return rQuery;
	}

		public String UpdateRequest(String RESPONSE_CODE,String RESPONSE_STATUS,String MSGID ,String SERVICENAME ,String STATION_NAME){
			ArrayList<PreparedStatementDomainObject> alPreparedStatementDomainObject;
			PreparedStatementDomainObject thePreparedStatementDomainObject;
			DAOCachedRowSet theDAOCachedRowSet=null;
			String rtString="F";
			try {

				int paramCount = 1;
				alPreparedStatementDomainObject = new ArrayList<PreparedStatementDomainObject>();
				// DBQUERY =new ICommonFunctionsDAO();
				 
				String query="update INT_REQUEST_DTL set RESPONSE_CODE=?,RESPONSE_STATUS=? where MSGID=? and SERVICENAME=? and STATION_NAME=?";
				LOGGER.debug("validateAgreementActive-->>query-->>"+query);
				
				thePreparedStatementDomainObject = new PreparedStatementDomainObject();
				
				
				thePreparedStatementDomainObject = new PreparedStatementDomainObject();
				thePreparedStatementDomainObject.setTypeAt(paramCount++);
				thePreparedStatementDomainObject.setType(PreparedStatementDomainObject.DATA_TYPE_STRING);
				thePreparedStatementDomainObject.setStringValue(RESPONSE_CODE);
				alPreparedStatementDomainObject.add(thePreparedStatementDomainObject);
				
				
				thePreparedStatementDomainObject = new PreparedStatementDomainObject();
				thePreparedStatementDomainObject.setTypeAt(paramCount++);
				thePreparedStatementDomainObject.setType(PreparedStatementDomainObject.DATA_TYPE_STRING);
				thePreparedStatementDomainObject.setStringValue(RESPONSE_STATUS);
				alPreparedStatementDomainObject.add(thePreparedStatementDomainObject);
				
				
				thePreparedStatementDomainObject = new PreparedStatementDomainObject();
				thePreparedStatementDomainObject.setTypeAt(paramCount++);
				thePreparedStatementDomainObject.setType(PreparedStatementDomainObject.DATA_TYPE_STRING);
				thePreparedStatementDomainObject.setStringValue(MSGID);
				alPreparedStatementDomainObject.add(thePreparedStatementDomainObject);
				
				
				thePreparedStatementDomainObject = new PreparedStatementDomainObject();
				thePreparedStatementDomainObject.setTypeAt(paramCount++);
				thePreparedStatementDomainObject.setType(PreparedStatementDomainObject.DATA_TYPE_STRING);
				thePreparedStatementDomainObject.setStringValue(SERVICENAME);
				alPreparedStatementDomainObject.add(thePreparedStatementDomainObject);
				
				
				thePreparedStatementDomainObject = new PreparedStatementDomainObject();
				thePreparedStatementDomainObject.setTypeAt(paramCount++);
				thePreparedStatementDomainObject.setType(PreparedStatementDomainObject.DATA_TYPE_STRING);
				thePreparedStatementDomainObject.setStringValue(STATION_NAME);
				alPreparedStatementDomainObject.add(thePreparedStatementDomainObject);
				

				LOGGER.debug(alPreparedStatementDomainObject);
				
				 OracleDAOFactory.executePreparedUpdate(query, alPreparedStatementDomainObject);
		
			} catch (SQLException e) {
				LOGGER.error(this.getClass().getName()
						+ " validateAgreementActive() " + e);
				
			} catch (NamingException e) {
				LOGGER.error(this.getClass().getName()
						+ " validateAgreementActive() " + e);
				
			} catch (Exception e) {
				LOGGER.error(this.getClass().getName()
						+ " validateAgreementActive() " + e);
				
			} finally {
				try{
					
					if(theDAOCachedRowSet!=null){
						theDAOCachedRowSet.release();
						theDAOCachedRowSet.close();
					}
					alPreparedStatementDomainObject=null;
					thePreparedStatementDomainObject = null;
		 		}catch(Exception se){
		 			LOGGER.error(this.getClass().getName()+" agreementvalidate finally() "+se);
		 		}

			}
			return rtString;
			
		}

		
		@Override
		public String getAgreementno(String query){
			String rQuery="";
			
			
			DAOCachedRowSet theDAOCachedRowSet = null;
			String exeQuery = "select agreementno from lea_agreement_dtl where agreementid="
					+ query;
			LOGGER.debug("*************ERR_CODE***" + query);
			LOGGER.debug("*************exeQuery***" + exeQuery);
			try {
				theDAOCachedRowSet = OracleDAOFactory.executeQuery(exeQuery);

				while (theDAOCachedRowSet.next()) {
					rQuery=theDAOCachedRowSet.getString(1);
				}

			} catch (SQLException e) {
				LOGGER.error("SQL EXCEPTION IN CommonFunctionsDAO");
				e.printStackTrace();
			} catch (NamingException e) {
				LOGGER.error("NamingException EXCEPTION IN CommonFunctionsDAO");
				e.printStackTrace();
			} catch (Exception e) {
				LOGGER.error("Exception EXCEPTION IN CommonFunctionsDAO");
				e.printStackTrace();
			}

			finally {
				try{
					
					if(theDAOCachedRowSet!=null){
						theDAOCachedRowSet.release();
						theDAOCachedRowSet.close();
					}

		}catch(Exception se){
		 			se.printStackTrace();
		 		}

			
			}	
			return rQuery;
		}
		
		
		
		@Override
		public String validateAgreementno(String query){
			String rQuery="1001";
			
			
			DAOCachedRowSet theDAOCachedRowSet = null;
			String exeQuery = "select count(1) from lea_agreement_dtl where agreementno='"+query+"'";
			LOGGER.debug("*************ERR_CODE***" + query);
			LOGGER.debug("*************exeQuery***" + exeQuery);
			try {
				theDAOCachedRowSet = OracleDAOFactory.executeQuery(exeQuery);

				while (theDAOCachedRowSet.next()) {
					int i=theDAOCachedRowSet.getInt(1);
					if(i>0)
					{
						rQuery="0000";
						
					}
				}

			} catch (SQLException e) {
				LOGGER.error("SQL EXCEPTION IN CommonFunctionsDAO");
				e.printStackTrace();
			} catch (NamingException e) {
				LOGGER.error("NamingException EXCEPTION IN CommonFunctionsDAO");
				e.printStackTrace();
			} catch (Exception e) {
				LOGGER.error("Exception EXCEPTION IN CommonFunctionsDAO");
				e.printStackTrace();
			}

			finally {
				try{
					
					if(theDAOCachedRowSet!=null){
						theDAOCachedRowSet.release();
						theDAOCachedRowSet.close();
					}

		}catch(Exception se){
		 			se.printStackTrace();
		 		}

			
			}
			return rQuery;
		}
		@Override
		public String validateAgreementID(String query){
			String rQuery="1001";
			
			
			DAOCachedRowSet theDAOCachedRowSet = null;
			String exeQuery = "select count(1) from lea_agreement_dtl where agreementid="
					+ query;
			LOGGER.debug("*************ERR_CODE***" + query);
			LOGGER.debug("*************exeQuery***" + exeQuery);
			try {
				theDAOCachedRowSet = OracleDAOFactory.executeQuery(exeQuery);

				while (theDAOCachedRowSet.next()) {
					int i=theDAOCachedRowSet.getInt(1);
					if(i>0)
					{
						rQuery="0000";
						
					}
				}

			} catch (SQLException e) {
				LOGGER.error("SQL EXCEPTION IN CommonFunctionsDAO");
				e.printStackTrace();
			} catch (NamingException e) {
				LOGGER.error("NamingException EXCEPTION IN CommonFunctionsDAO");
				e.printStackTrace();
			} catch (Exception e) {
				LOGGER.error("Exception EXCEPTION IN CommonFunctionsDAO");
				e.printStackTrace();
			}

			finally {
				try{
					
					if(theDAOCachedRowSet!=null){
						theDAOCachedRowSet.release();
						theDAOCachedRowSet.close();
					}

		}catch(Exception se){
		 			se.printStackTrace();
		 		}

			
			}
			return rQuery;
		}

		@Override
		public HashMap<String, String> grtReqparameter() {
			HashMap<String, String> hmreturn =new HashMap<String, String>();
			
			DAOCachedRowSet theDAOCachedRowSet = null;
			String exeQuery = "select SERVICENAME, PARAMETER, VLENGTH, SPL_CHAR_ALLOWED, SPL_CHAR_FLAG, DATATYPE from request_tag_validation";
					
			
			LOGGER.debug("*************exeQuery***" + exeQuery);
			try {
				theDAOCachedRowSet = OracleDAOFactory.executeQuery(exeQuery);
				
//datatype hm
				String parameter;
				String value;
				
				
				
				while (theDAOCachedRowSet.next()) {
					parameter="";
					value="";
					parameter=theDAOCachedRowSet.getString("SERVICENAME")+theDAOCachedRowSet.getString("PARAMETER")+"DATATYPE";
					value=theDAOCachedRowSet.getString("DATATYPE");
					hmreturn.put(parameter,value);
					
					parameter=theDAOCachedRowSet.getString("SERVICENAME")+theDAOCachedRowSet.getString("PARAMETER")+"VLENGTH";
					value=theDAOCachedRowSet.getString("VLENGTH");
					hmreturn.put(parameter,value);
					
					parameter=theDAOCachedRowSet.getString("SERVICENAME")+theDAOCachedRowSet.getString("PARAMETER")+"SPL_CHAR_FLAG";
					value=theDAOCachedRowSet.getString("SPL_CHAR_FLAG");
					hmreturn.put(parameter,value);
					
					parameter=theDAOCachedRowSet.getString("SERVICENAME")+theDAOCachedRowSet.getString("PARAMETER")+"SPL_CHAR_ALLOWED";
					value=theDAOCachedRowSet.getString("SPL_CHAR_ALLOWED");
					hmreturn.put(parameter,value);
					
					
				}

			} catch (SQLException e) {
				LOGGER.error("SQL EXCEPTION IN CommonFunctionsDAO");
				e.printStackTrace();
			} catch (NamingException e) {
				LOGGER.error("NamingException EXCEPTION IN CommonFunctionsDAO");
				e.printStackTrace();
			} catch (Exception e) {
				LOGGER.error("Exception EXCEPTION IN CommonFunctionsDAO");
				e.printStackTrace();
			}

			finally {
				try{
					
					if(theDAOCachedRowSet!=null){
						theDAOCachedRowSet.release();
						theDAOCachedRowSet.close();
					}

		}catch(Exception se){
		 			se.printStackTrace();
		 		}

			
			}
			
			return hmreturn;
		}
		
		
		public String getRegEx(String service,String tag) {
			String regex="";
			DAOCachedRowSet theDAOCachedRowSet = null;
			String exeQuery = "select SPL_CHAR_ALLOWED from REQUEST_TAG_VALIDATION where service='Y' and SERVICENAME='"
					+ service+"' and upper(PARAMETER)=upper('"+tag+"')";

			try {
				theDAOCachedRowSet = OracleDAOFactory.executeQuery(exeQuery);

				while (theDAOCachedRowSet.next()) {
					regex=theDAOCachedRowSet.getString(1);
					
				}

			} catch (SQLException e) {
				LOGGER.error("SQL EXCEPTION IN CommonFunctionsDAO");
				e.printStackTrace();
			} catch (NamingException e) {
				LOGGER.error("NamingException EXCEPTION IN CommonFunctionsDAO");
				e.printStackTrace();
			} catch (Exception e) {
				LOGGER.error("Exception EXCEPTION IN CommonFunctionsDAO");
				e.printStackTrace();
			}

			finally {
				try{
					
					if(theDAOCachedRowSet!=null){
						theDAOCachedRowSet.release();
						theDAOCachedRowSet.close();
					}

		}catch(Exception se){
		 			se.printStackTrace();
		 		}

			
			}
		LOGGER.debug("manish--regex>>"+regex);
		
			return regex;
		}
		
		public String fnValidateProductKey(String productKey, String mapping, String ip,String entd) {
			
			String Query=dynaQuery("PRODUCTKEY");
String Rstring="FAIL";

			ArrayList<PreparedStatementDomainObject> alPreparedStatementDomainObject;
			PreparedStatementDomainObject thePreparedStatementDomainObject;
			
			int paramCount = 1;
			alPreparedStatementDomainObject = new ArrayList<PreparedStatementDomainObject>();
			
			
			thePreparedStatementDomainObject = new PreparedStatementDomainObject();
			DAOCachedRowSet theDAOCachedRowSet=null;

			try {
			
			thePreparedStatementDomainObject = new PreparedStatementDomainObject();
			thePreparedStatementDomainObject.setTypeAt(paramCount++);
			thePreparedStatementDomainObject.setType(PreparedStatementDomainObject.DATA_TYPE_STRING);
			thePreparedStatementDomainObject.setStringValue(entd);
			alPreparedStatementDomainObject.add(thePreparedStatementDomainObject);
			
			thePreparedStatementDomainObject = new PreparedStatementDomainObject();
			thePreparedStatementDomainObject.setTypeAt(paramCount++);
			thePreparedStatementDomainObject.setType(PreparedStatementDomainObject.DATA_TYPE_STRING);
			thePreparedStatementDomainObject.setStringValue(productKey);
			alPreparedStatementDomainObject.add(thePreparedStatementDomainObject);

			thePreparedStatementDomainObject = new PreparedStatementDomainObject();
			thePreparedStatementDomainObject.setTypeAt(paramCount++);
			thePreparedStatementDomainObject.setType(PreparedStatementDomainObject.DATA_TYPE_STRING);
			thePreparedStatementDomainObject.setStringValue(ip);
			alPreparedStatementDomainObject.add(thePreparedStatementDomainObject);

			thePreparedStatementDomainObject = new PreparedStatementDomainObject();
			thePreparedStatementDomainObject.setTypeAt(paramCount++);
			thePreparedStatementDomainObject.setType(PreparedStatementDomainObject.DATA_TYPE_STRING);
			thePreparedStatementDomainObject.setStringValue(mapping);
			alPreparedStatementDomainObject.add(thePreparedStatementDomainObject);

			theDAOCachedRowSet = OracleDAOFactory.executePreparedQuery(Query, alPreparedStatementDomainObject);
				
			
			while (theDAOCachedRowSet.next()) {
				
				if(theDAOCachedRowSet.getString(1).equalsIgnoreCase("1"));
				{
					Rstring="SUCCESS";
				}
				
			

			}
			
			
			}  catch (Exception e) {
				LOGGER.error("Exception EXCEPTION IN RepaymentADomainObject");
				e.printStackTrace();
			}
			
		
			
			return Rstring;
		}
		
		
}