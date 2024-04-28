package com.api.common.dao.daofactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceUtils;

import com.api.common.domainobject.PreparedStatementDomainObject;
import com.api.util.GenericUtilityMProductService;
import com.api.util.MBaseLogger;


public final class OracleDAOFactory extends DAOFactory
{
	
	private static DataSource dataSource;
	
	private static String queryExecuted = "";
	
	public static void setDataSource(DataSource dataSource) {
		OracleDAOFactory.dataSource = dataSource;
	}

	/**
	* Private static variable for holding the reference to DAXLogger.
	*/
	private static MBaseLogger LOGGER = new MBaseLogger();
	/**
	* Private static variable for holding the reference to OracleDaoFactory.
	*/
	private static OracleDAOFactory objOracleDAOFactory;

	/**
	* Private constructor to make this class Singleton.
	*/
	private OracleDAOFactory() {

	}


	/**
	* This static method is called to get the reference of this class.
	* @return OracleDaoFactory instance of this class.
	*/
	public static OracleDAOFactory getInstance()
	{
		return objOracleDAOFactory;
	}

	public Object getDAOObject(String pClassName) throws SQLException{
		try{
			return Class.forName(pClassName).newInstance();
		}catch(Exception ee){
			throw new SQLException(ee);
		}
	}


    /** Get the Connection from Data source
     * @return Data Base Connection
     * @throws Exception Generic Exception
     */
    public static java.sql.Connection getConnection() throws Exception {
    	Connection conn=null;
    	conn = DataSourceUtils.getConnection(dataSource);
    	LOGGER.debug("DB USERNAME::"+conn.getMetaData().getUserName());
    	return conn;

    }

    public static DAOCachedRowSet executePreparedQuery(String strQuery, ArrayList<PreparedStatementDomainObject> alPreparedStatementDTO)
            throws java.sql.SQLException, NamingException, Exception
        {
    		StringBuffer queryAtExceutionTimeOut=new StringBuffer(strQuery);
    		int indexOfQuestionMark=0;

    		Connection conn = null;
            PreparedStatement stmt = null;
            DAOCachedRowSet crs = null;
            ResultSet rs = null;
            try
            {
                conn = getConnection();

                queryExecuted = strQuery;
                
                stmt = conn.prepareStatement(queryExecuted);
                
    			for(int arrCount=0; arrCount<alPreparedStatementDTO.size(); arrCount++)
    			{
    				try
    				{
    					indexOfQuestionMark = queryAtExceutionTimeOut.toString().indexOf("?");

    				}catch(Exception e)
    				{
    				}

    				PreparedStatementDomainObject objPreparedStatementDomainObject = (PreparedStatementDomainObject) alPreparedStatementDTO.get(arrCount);
    				switch(objPreparedStatementDomainObject.getType())
    				{
    					case PreparedStatementDomainObject.DATA_TYPE_INT:
    						if(objPreparedStatementDomainObject.getNullFlag())
    						{
    							stmt.setNull(objPreparedStatementDomainObject.getTypeAt(),Types.INTEGER);
    							queryAtExceutionTimeOut = queryAtExceutionTimeOut.replace(indexOfQuestionMark,indexOfQuestionMark+1, "''");
    						}
    						else
    						{
    							stmt.setInt(objPreparedStatementDomainObject.getTypeAt(),objPreparedStatementDomainObject.getIntValue());
    							queryAtExceutionTimeOut = queryAtExceutionTimeOut.replace(indexOfQuestionMark,indexOfQuestionMark+1, objPreparedStatementDomainObject.getIntValue()+"");

    						}

    						break;
    					case PreparedStatementDomainObject.DATA_TYPE_LONG:
    						if(objPreparedStatementDomainObject.getNullFlag())
    						{
    							stmt.setNull(objPreparedStatementDomainObject.getTypeAt(),Types.LONGVARCHAR);
    							queryAtExceutionTimeOut = queryAtExceutionTimeOut.replace(indexOfQuestionMark,indexOfQuestionMark+1, "''");
    						}
    						else
    						{
    							stmt.setLong(objPreparedStatementDomainObject.getTypeAt(),objPreparedStatementDomainObject.getLongValue());
    							queryAtExceutionTimeOut = queryAtExceutionTimeOut.replace(indexOfQuestionMark,indexOfQuestionMark+1, objPreparedStatementDomainObject.getLongValue()+"");
    						}
    						break;
    					case PreparedStatementDomainObject.DATA_TYPE_DATE:
    						if(objPreparedStatementDomainObject.getNullFlag())
    						{
    							stmt.setNull(objPreparedStatementDomainObject.getTypeAt(),Types.DATE);
    							queryAtExceutionTimeOut = queryAtExceutionTimeOut.replace(indexOfQuestionMark,indexOfQuestionMark+1, "''");
    						}
    						else
    						{
    							stmt.setDate(objPreparedStatementDomainObject.getTypeAt(),objPreparedStatementDomainObject.getDateValue());
    							queryAtExceutionTimeOut = queryAtExceutionTimeOut.replace(indexOfQuestionMark,indexOfQuestionMark+1, objPreparedStatementDomainObject.getDateValue()+"");
    						}
    						break;
    					case PreparedStatementDomainObject.DATA_TYPE_DOUBLE:
    						if(objPreparedStatementDomainObject.getNullFlag())
    						{
    							stmt.setNull(objPreparedStatementDomainObject.getTypeAt(),Types.DOUBLE);
    							queryAtExceutionTimeOut = queryAtExceutionTimeOut.replace(indexOfQuestionMark,indexOfQuestionMark+1, "''");
    						}
    						else
    						{
    							stmt.setDouble(objPreparedStatementDomainObject.getTypeAt(),objPreparedStatementDomainObject.getDoubleValue());
    							queryAtExceutionTimeOut = queryAtExceutionTimeOut.replace(indexOfQuestionMark,indexOfQuestionMark+1, objPreparedStatementDomainObject.getDoubleValue()+"");
    						}
    						break;
    					case PreparedStatementDomainObject.DATA_TYPE_FLOAT:
    						if(objPreparedStatementDomainObject.getNullFlag())
    						{
    							stmt.setNull(objPreparedStatementDomainObject.getTypeAt(),Types.FLOAT);
    							queryAtExceutionTimeOut = queryAtExceutionTimeOut.replace(indexOfQuestionMark,indexOfQuestionMark+1, "''");
    						}
    						else
    						{
    							stmt.setFloat(objPreparedStatementDomainObject.getTypeAt(),objPreparedStatementDomainObject.getFloatValue());
    							queryAtExceutionTimeOut = queryAtExceutionTimeOut.replace(indexOfQuestionMark,indexOfQuestionMark+1, objPreparedStatementDomainObject.getFloatValue()+"");
    						}
    						break;
    					case PreparedStatementDomainObject.DATA_TYPE_STRING:
    						if(objPreparedStatementDomainObject.getNullFlag())
    						{
    							stmt.setNull(objPreparedStatementDomainObject.getTypeAt(),Types.VARCHAR);
    							queryAtExceutionTimeOut = queryAtExceutionTimeOut.replace(indexOfQuestionMark,indexOfQuestionMark+1, "''");
    						}
    						else
    						{
    							stmt.setString(objPreparedStatementDomainObject.getTypeAt(),objPreparedStatementDomainObject.getStringValue());
    							queryAtExceutionTimeOut = queryAtExceutionTimeOut.replace(indexOfQuestionMark,indexOfQuestionMark+1, "'" + objPreparedStatementDomainObject.getStringValue()+"'");
    						}
    						break;
    					case PreparedStatementDomainObject.DATA_TYPE_TIME_STAMP:
    						if(objPreparedStatementDomainObject.getNullFlag())
    						{
    							stmt.setNull(objPreparedStatementDomainObject.getTypeAt(),Types.TIMESTAMP);
    							queryAtExceutionTimeOut = queryAtExceutionTimeOut.replace(indexOfQuestionMark,indexOfQuestionMark+1, "''");
    						}
    						else
    						{
    							stmt.setTimestamp(objPreparedStatementDomainObject.getTypeAt(),objPreparedStatementDomainObject.getTimestampValue());
    							queryAtExceutionTimeOut = queryAtExceutionTimeOut.replace(indexOfQuestionMark,indexOfQuestionMark+1, objPreparedStatementDomainObject.getTimestampValue().toString());
    						}
    						break;
    					default:
    						LOGGER.debug(new StringBuffer("ERROR IN PREPARED QUERY EXECUTION - ").append(strQuery).toString());
    						break;
    				}
    				objPreparedStatementDomainObject = null;
    			}
    			LOGGER.debug("Query------------ " + queryAtExceutionTimeOut);
                rs = stmt.executeQuery();
    			crs = new DAOCachedRowSet();
    			crs.populate(rs);

            }
            catch(SQLException se)
            {
    			LOGGER.error(new StringBuffer(strQuery).append(" -- ").append(se).append(" --- " ).append(alPreparedStatementDTO).toString() );
                throw se;
            }
            catch(NamingException se)
            {
    			LOGGER.error(new StringBuffer(strQuery).append(" -- ").append(se).append(" --- " ).append(alPreparedStatementDTO).toString() );
                throw se;
            }
            catch(Exception se)
            {
    			LOGGER.error(new StringBuffer(strQuery).append(" -- ").append(se).append(" --- " ).append(alPreparedStatementDTO).toString() );
                throw se;
            }
            finally
            {
				if(stmt != null)
				{
					try{
				    stmt.close();
					stmt = null;
					}catch(Exception se){
						
					}
				}
				if(conn != null)
				{
					try{
				    conn.close();
					conn = null;
					}catch(Exception se){
						
					}
				}
				if(rs != null)
				{
				    try {
						rs.close();
						rs = null;
					} catch (Exception e) {
						
					}
				}
            }
            return crs;
        }

    public static int executePreparedUpdate(String strQuery, ArrayList<PreparedStatementDomainObject> alPreparedStatementDTO)
        throws java.sql.SQLException, NamingException, Exception
    {
		LOGGER.debug(new StringBuffer("execute executePreparedUpdate - ").append(strQuery).toString());
        Connection conn = null;
        PreparedStatement stmt = null;
		StringBuffer queryAtExceutionTimeOut=new StringBuffer(strQuery);

		int indexOfQuestionMark=0;
		int recordUpdated = 0;
        try
        {

			conn = getConnection();
			
			queryExecuted = strQuery;
			
            stmt = conn.prepareStatement(queryExecuted);
			for(int arrCount=0; arrCount<alPreparedStatementDTO.size(); arrCount++)
			{
				try
				{
					indexOfQuestionMark = queryAtExceutionTimeOut.toString().indexOf("?");

				}catch(Exception e)
					{
						indexOfQuestionMark=queryAtExceutionTimeOut.length()-2;
					}

				PreparedStatementDomainObject objPreparedStatementDomainObject = (PreparedStatementDomainObject) alPreparedStatementDTO.get(arrCount);
				switch(objPreparedStatementDomainObject.getType())
				{
					case PreparedStatementDomainObject.DATA_TYPE_INT:
						queryAtExceutionTimeOut = queryAtExceutionTimeOut.replace(indexOfQuestionMark,indexOfQuestionMark+1, objPreparedStatementDomainObject.getIntValue()+"");
						stmt.setInt(objPreparedStatementDomainObject.getTypeAt(),objPreparedStatementDomainObject.getIntValue());
						break;
					case PreparedStatementDomainObject.DATA_TYPE_LONG:
						queryAtExceutionTimeOut = queryAtExceutionTimeOut.replace(indexOfQuestionMark,indexOfQuestionMark+1, objPreparedStatementDomainObject.getLongValue()+"");
						stmt.setLong(objPreparedStatementDomainObject.getTypeAt(),objPreparedStatementDomainObject.getLongValue());
						break;
					case PreparedStatementDomainObject.DATA_TYPE_DATE:
						queryAtExceutionTimeOut = queryAtExceutionTimeOut.replace(indexOfQuestionMark,indexOfQuestionMark+1, objPreparedStatementDomainObject.getDateValue()+"");
						stmt.setDate(objPreparedStatementDomainObject.getTypeAt(),objPreparedStatementDomainObject.getDateValue());
						break;
					case PreparedStatementDomainObject.DATA_TYPE_DOUBLE:
						queryAtExceutionTimeOut = queryAtExceutionTimeOut.replace(indexOfQuestionMark,indexOfQuestionMark+1, objPreparedStatementDomainObject.getDoubleValue()+"");
						stmt.setDouble(objPreparedStatementDomainObject.getTypeAt(),objPreparedStatementDomainObject.getDoubleValue());
						break;
					case PreparedStatementDomainObject.DATA_TYPE_FLOAT:
						queryAtExceutionTimeOut = queryAtExceutionTimeOut.replace(indexOfQuestionMark,indexOfQuestionMark+1, objPreparedStatementDomainObject.getFloatValue()+"");
						stmt.setFloat(objPreparedStatementDomainObject.getTypeAt(),objPreparedStatementDomainObject.getFloatValue());
						break;
					case PreparedStatementDomainObject.DATA_TYPE_STRING:
						queryAtExceutionTimeOut = queryAtExceutionTimeOut.replace(indexOfQuestionMark,indexOfQuestionMark+1, "'"+ objPreparedStatementDomainObject.getStringValue()+"'");
						stmt.setString(objPreparedStatementDomainObject.getTypeAt(),objPreparedStatementDomainObject.getStringValue());
						break;
					case PreparedStatementDomainObject.DATA_TYPE_TIME_STAMP:
						queryAtExceutionTimeOut = queryAtExceutionTimeOut.replace(indexOfQuestionMark,indexOfQuestionMark+1, objPreparedStatementDomainObject.getTimestampValue().toString());
						stmt.setTimestamp(objPreparedStatementDomainObject.getTypeAt(),objPreparedStatementDomainObject.getTimestampValue());
						break;
					default:
						LOGGER.debug(new StringBuffer("ERROR IN PREPARED QUERY EXECUTION - ").append(strQuery).toString());
						break;
				}
				objPreparedStatementDomainObject = null;
			}
			LOGGER.debug("Query--------" +queryAtExceutionTimeOut.toString());
            recordUpdated = stmt.executeUpdate();

        }
        catch(SQLException se)
        {
			LOGGER.error(se);
			LOGGER.error(new StringBuffer(strQuery).append(" -- ").append(se).append(" --- " ).append(alPreparedStatementDTO).toString() );
            throw se;
        }
        catch(Exception se)
        {
			LOGGER.error(se);
			LOGGER.error(new StringBuffer(strQuery).append(" -- ").append(se).append(" --- " ).append(alPreparedStatementDTO).toString() );
            throw se;
        }
        finally
        {
			if(stmt != null)
			{
			    try {
					stmt.close();
					stmt = null;
				} catch (Exception e) {
					LOGGER.error(e);
				}
			}
			if(conn != null)
			{
			    try {
					conn.close();
					conn = null;
				} catch (Exception e) {
					LOGGER.error(e);
				}
			}
        }
        return recordUpdated;
    }
    

	public static DAOCachedRowSet executeQuery(String sqlQuery) throws SQLException, NamingException, Exception
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		DAOCachedRowSet crs = null;
		try
		{
			conn = getConnection();
			queryExecuted = sqlQuery;
			stmt=conn.prepareStatement(queryExecuted);
			rs = stmt.executeQuery(queryExecuted);
			crs = new DAOCachedRowSet();
			crs.populate(rs);

			LOGGER.debug("Query------------ " + sqlQuery);
		}
		catch(SQLException se)
		{
			LOGGER.error(new StringBuffer(sqlQuery).append(" -- ").append(se).append(" --- " ).toString() );
			throw se;
		}
		catch(NamingException se)
		{
			LOGGER.error(new StringBuffer(sqlQuery).append(" -- ").append(se).append(" --- " ).toString() );
			throw se;
		}
		catch(Exception se)
		{
			LOGGER.error(new StringBuffer(sqlQuery).append(" -- ").append(se).append(" --- " ).toString() );
			throw se;
		}
		finally
		{
			if(rs != null)
			{
				try {
					rs.close();
					rs = null;
				} catch (Exception e) {
					
				}
			}
			if(stmt != null)
			{
				try {
					stmt.close();
					stmt = null;
				} catch (Exception e) {
					
				}
			}
			if(conn != null)
			{
				try {
					conn.close();
					conn = null;
				} catch (Exception e) {
					
				}
			}

		}

		return crs;
	}

	public static String getSequenceKey(String sequenceName) throws SQLException, NamingException, Exception
	{
		DAOCachedRowSet rs = null;
		String sequenceKey = null;
		StringBuffer sBuffer =null;
		try
		{
			sBuffer = new StringBuffer("SELECT ").append(sequenceName).append(".nextval from dual");
			rs = executePreparedQuery(sBuffer.toString(), new ArrayList<PreparedStatementDomainObject>());
			if(rs.next())
			{
				sequenceKey = rs.getString(1);
			}
		}
		catch(SQLException se)
		{
			LOGGER.error(new StringBuffer(sequenceName).append(" -- ").append(se).append(" --- " ).toString() );
			throw se;
		}
		catch(NamingException se)
		{
			LOGGER.error(new StringBuffer(sequenceName).append(" -- ").append(se).append(" --- " ).toString() );
			throw se;
		}
		catch(Exception se)
		{
			LOGGER.error(new StringBuffer(sequenceName).append(" -- ").append(se).append(" --- " ).toString() );
			throw se;
		}
		finally
		{
			try
			{
				if(rs != null)
				{
					rs.release();
					rs.close();
					rs = null;
				}
				sBuffer = null;
			}
			catch(SQLException se)
			{
				LOGGER.error(new StringBuffer(sequenceName).append(" -- ").append(se).append(" --- " ).toString() );
				throw se;
			}
		}
		return sequenceKey;
	}




	public static Object[] executeSP(String spName,Object[] inParameters,int[] inTypes,int[] outTypes) throws SQLException , NamingException , Exception
	{
    	LOGGER.debug(new StringBuffer("executeSP - ").append(spName).toString());
    	LOGGER.debug(new StringBuffer("executeSP - In Parameter - ").append(Arrays.toString(inParameters)));
		int icol = 0;
		int iTypes = 0;
		Object[] outParameters = null;
		Connection conn = null;
    	java.sql.CallableStatement cstmt  =null;
		try
		{
			conn = getConnection();
			StringBuffer  parameterString = new StringBuffer();
			int iInParameterslength = ((inParameters == null)?0:inParameters.length);
			LOGGER.debug("Length of the input parameters"+iInParameterslength);
			int iOutParameterslength = ((outTypes == null) ? 0:outTypes.length);
			LOGGER.debug("Length of OUTPUt parameters"+iInParameterslength);
			if(iOutParameterslength  > 0)
			{
				outParameters = new Object[iOutParameterslength];
			}

			int iTotalparameters = iInParameterslength + iOutParameterslength;
			LOGGER.debug("Lenght of input + output params="+iTotalparameters);
			for( icol = 0;icol < iTotalparameters ;icol++)
			{
				parameterString.append("?,");
			}
			if (iTotalparameters >  0){
				parameterString = new StringBuffer(parameterString.substring(0,parameterString.lastIndexOf(",")));
			}
				

			LOGGER.debug(" ...input..parameter ..."+parameterString);
		    cstmt =  conn.prepareCall(new StringBuffer("{ CALL ").append(spName).append("(").append(parameterString).append(" ) }").toString());

			for(icol =1;icol <= iInParameterslength;icol++)
			{
				switch (inTypes[icol -1])
				{
					case Types.LONGVARCHAR:
					case Types.VARCHAR:
					{

						if (inParameters[icol -1] != null && !inParameters[icol -1].equals("")){
							cstmt.setString(icol,inParameters[icol -1].toString());
						}
						else
						{
							cstmt.setString(icol,null);
						}
						break;
					}
					case Types.DATE:
					{
						cstmt.setDate(icol,(java.sql.Date)inParameters[icol -1]);
						break;
					}
					case Types.BLOB:
					{
						cstmt.setBlob(icol,(java.sql.Blob)inParameters[icol -1]);
						break;
					}

					case Types.SMALLINT:
					case Types.INTEGER:
					{
						cstmt.setInt(icol, GenericUtilityMProductService.setInt(inParameters[icol -1].toString()));
						break;
					}
					case Types.DOUBLE:
					{
						cstmt.setDouble(icol, GenericUtilityMProductService.setDbl(inParameters[icol -1].toString()));
						break;
					}
					default:
					{
						cstmt.setString(icol,inParameters[icol -1].toString());
					}
				}
			}

			for(icol = iInParameterslength + 1,iTypes = 0;icol <=iTotalparameters;icol++,iTypes++)
			{
				LOGGER.debug("VALUE OF ICOL"+icol+" outTypes[iTypes]   "+outTypes[iTypes]);
				cstmt.registerOutParameter(icol,outTypes[iTypes]);
			}

			cstmt.execute();
			for(icol = iInParameterslength + 1,iTypes = 0;icol <=iTotalparameters;icol++,iTypes++)
			{
				outParameters[iTypes]  = cstmt.getObject(icol);
			}

		}
		catch(SQLException se)
		{
			LOGGER.error("ODF EXP "+se);
			throw se;
		}
		catch(NamingException se)
		{
			LOGGER.error("ODF EXP "+se);
			throw se;
		}
		catch(Exception se)
		{
			LOGGER.error("ODF EXP "+se);
			throw se;
		}
		finally
		{
			if(conn != null)
			{
				try {
					conn.close();
					conn = null;
				} catch (Exception e) {
					
				}
			}

			if(cstmt != null)
			{
			try {
				cstmt.close();
				cstmt=null;
			} catch (Exception e) {
				
			}
			}
		}
		return outParameters;
	}

}