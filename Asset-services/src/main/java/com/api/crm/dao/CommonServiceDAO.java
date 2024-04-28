package com.api.crm.dao;

import java.sql.*;
import java.util.ArrayList;


import javax.inject.Named;



import com.api.common.dao.daofactory.MsAccessConnection;
import com.api.util.MBaseLogger;

import net.ucanaccess.jdbc.UcanaccessSQLException;

import com.api.crm.domainobject.*;
@Named("commonServiceDAO")
public class CommonServiceDAO implements ICommonServiceDAO{

	
	private static final MBaseLogger LOGGER = new MBaseLogger();
	

	
	public ArrayList<CountryDomainObject> country() {
		
		
		CountryDomainObject countryDomainObject =new CountryDomainObject();
		String query="";
		ArrayList<CountryDomainObject> countryDomainObjectAL = new ArrayList<CountryDomainObject>();
		MsAccessConnection msaccess = new MsAccessConnection();
		Connection conn = msaccess.getConnection();
		try {
			
			query = "select * from COUNTRY";
			LOGGER.debug("*************query***" + query);
			Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(query);
             
            while (result.next()) {
            	LOGGER.debug("Inside result--->");
            	countryDomainObject.setKey(result.getString("KEY"));
            	countryDomainObject.setValue(result.getString("VALUE"));
            	countryDomainObject.setStatus("S");
                 
            	countryDomainObjectAL.add(countryDomainObject);
            }
			
			

		} catch (Exception e) {
			LOGGER.error("Exception EXCEPTION IN countryDomainObject");
			e.printStackTrace();
		}
		finally {
			  if (conn != null)
				    try {
				      conn.close();
				    } catch (SQLException e) {
				      e.printStackTrace();
				    }}
		
		
		
		return countryDomainObjectAL;
	}
	@Override
	public ArrayList<ProductDomainObject> product() {
		//ProductDomainObject productDomainObject =new ProductDomainObject();
		//DAOCachedRowSet theDAOCachedRowSet = null;
		String query="";
		
		  ArrayList<ProductDomainObject> productDomainObjectAL = new ArrayList<ProductDomainObject>();
		  MsAccessConnection msaccess = new MsAccessConnection();
			Connection conn = msaccess.getConnection();
		try {
			
			query = "select * from PRODUCT";
			LOGGER.debug("*************query***" + query);
			Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(query);
             
            while (result.next()) {
            	LOGGER.debug("Inside result--->");
            	ProductDomainObject productDomainObject =new ProductDomainObject();
            	productDomainObject.setKey(result.getString("KEY"));
            	productDomainObject.setDescription(result.getString("DESCRIPTION"));
            	productDomainObject.setCost(result.getString("VALUE"));
            	productDomainObject.setStatus("S");
            	productDomainObjectAL.add(productDomainObject);
               
            }
			
			

		} catch (Exception e) {
			LOGGER.error("Exception EXCEPTION IN ProductDomainObject");
			e.printStackTrace();
		}finally {
			  if (conn != null)
				    try {
				      conn.close();
				    } catch (SQLException e) {
				      e.printStackTrace();
				    }}
		
		
		
		
		return productDomainObjectAL;
	}
	@Override
	public CustomerDomainObject customer(CustomerDomainObject customerDomainObject) {
		CustomerDomainObject croductDomainObject1 =new CustomerDomainObject();
		//DAOCachedRowSet theDAOCachedRowSet = null;
		String query="";
		MsAccessConnection msaccess = new MsAccessConnection();
		Connection conn = msaccess.getConnection();
		try {
			
			
			Statement statement = conn.createStatement();
			//insert
			if("I".equalsIgnoreCase(customerDomainObject.getAction()))
			{
				
				PreparedStatement pst = conn.prepareStatement("Insert into CUSTOMER (ACTIVITY1,ACTIVITY2,ACTIVITY3,ACTIVITY4,ACTIVITY5,ACTIVITY6,ACTIVITY7,ACTIVITY8,ACTIVITY9,ACTIVITY10,ACTIVESTATUS,EMAIL,PHONE,MOBILE,ADDRESS,COMPANY1,COMPANY2,COMPANY3,COSTOFFER,COSTPAID,COMPANYNAMECREATE,COUNTRY,DOB,FNAME,LNAME,ISSUEDATE,PASSPORT,TRADELICNO,NEXTREVIEWDATE,CUSTOMERID,CLOSINGDATE) "
				           
				           + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				
				//"Insert into customer (ACTIVITY1,ACTIVITY2,ACTIVITY3,ACTIVITY4,ACTIVITY5,ACTIVITY6,ACTIVITY7,ACTIVITY8,ACTIVITY9,ACTIVITY10,ACTIVESTATUS,EMAIL,PHONE,MOBILE,ADDRESS,COMPANY1,COMPANY2,COMPANY3,COSTOFFER,COSTPAID,COMPANYNAMECREATE,COUNTRY,DOB,FNAME,LNAME,ISSUEDATE,PASSPORT,TRADELICNO,NEXTREVIEWDATE,CUSTOMERID) values ()";
						

				  pst.setString(1, customerDomainObject.getActivity1());
				  pst.setString(2, customerDomainObject.getActivity2());
				  pst.setString(3, customerDomainObject.getActivity3());
				  pst.setString(4, customerDomainObject.getActivity4());
				  pst.setString(5, customerDomainObject.getActivity5());
				  pst.setString(6, customerDomainObject.getActivity6());
				  pst.setString(7, customerDomainObject.getActivity7());
				  pst.setString(8, customerDomainObject.getActivity8());
				  pst.setString(9, customerDomainObject.getActivity9());
				  pst.setString(10, customerDomainObject.getActivity10());
				  pst.setString(11, customerDomainObject.getActiveStatus());
				  pst.setString(12, customerDomainObject.getEmail());
				  pst.setString(13, customerDomainObject.getPhone());
				  pst.setString(14, customerDomainObject.getMobile());
				  pst.setString(15, customerDomainObject.getAddress());
				  pst.setString(16, customerDomainObject.getCompany1());
				  pst.setString(17, customerDomainObject.getCompany2());
				  pst.setString(18, customerDomainObject.getCompany3());
				  pst.setString(19, customerDomainObject.getCostOffer());
				  pst.setString(20, customerDomainObject.getCostPaid());
				  pst.setString(21, customerDomainObject.getCompanyNameCreated());
				  pst.setString(22, customerDomainObject.getCountry());
				  pst.setString(23, customerDomainObject.getDob());
				  pst.setString(24, customerDomainObject.getFname());
				  pst.setString(25, customerDomainObject.getLname());
				  pst.setString(26, customerDomainObject.getIssueDate());
				  pst.setString(27, customerDomainObject.getPassportNo());
				  pst.setString(28, customerDomainObject.getTradeLicNo());
				  pst.setString(29, customerDomainObject.getNextRenewDate());
				  pst.setString(30, customerDomainObject.getCustomerId());
				  pst.setString(31, customerDomainObject.getClosingDate());
				  
				  LOGGER.debug("*************MANISH Insert 1***");

				  try {
					pst.executeUpdate();
				} catch (UcanaccessSQLException e) {
					// TODO Auto-generated catch block
					String msg="";
					msg=e.getMessage();
					LOGGER.debug("*************Insert msg***" + msg);
					
				}
				  LOGGER.debug("*************MANISH Insert 2***");
//				query = "Insert into customer (ACTIVITY1,ACTIVITY2,ACTIVITY3,ACTIVITY4,ACTIVITY5,ACTIVITY6,ACTIVITY7,ACTIVITY8,ACTIVITY9,ACTIVITY10,"
//						+ "ACTIVESTATUS,EMAIL,PHONE,MOBILE,ADDRESS,COMPANY1,COMPANY2,COMPANY3,COSTOFFER,COSTPAID"
//						+ ",COMPANYNAMECREATE,COUNTRY,DOB,FNAME,LNAME,ISSUEDATE,PASSPORT,TRADELICNO,NEXTREVIEWDATE,CUSTOMERID) values ('"
//						+customerDomainObject.getActivity1()+"','"
//						+customerDomainObject.getActivity2()+"','"
//						+customerDomainObject.getActivity3()+"','"
//						+customerDomainObject.getActivity4()+"','"
//						+customerDomainObject.getActivity5()+"','"
//						+customerDomainObject.getActivity6()+"','"
//						+customerDomainObject.getActivity7()+"','"
//						+customerDomainObject.getActivity8()+"','"
//						+customerDomainObject.getActivity9()+"','"
//						+customerDomainObject.getActivity10()+"','"
//						+customerDomainObject.getActiveStatus()+"','"
//						+customerDomainObject.getEmail()+"','"
//						+customerDomainObject.getPhone()+"','"
//						+customerDomainObject.getMobile()+"','"
//						+customerDomainObject.getAddress()+"','"
//						+customerDomainObject.getCompany1()+"','"
//						+customerDomainObject.getCompany2()+"','"
//						+customerDomainObject.getCompany3()+"','"
//						+customerDomainObject.getCostOffer()+"','"
//						+customerDomainObject.getCostPaid()+"','"
//						+customerDomainObject.getCompanyNameCreated()+"','"
//						+customerDomainObject.getCountry()+"','"
//						+customerDomainObject.getDob()+"','"
//						+customerDomainObject.getFname()+"','"
//						+customerDomainObject.getLname()+"','"
//						+customerDomainObject.getIssueDate()+"','"
//						+customerDomainObject.getPassportNo()+"','"
//						+customerDomainObject.getTradeLicNo()+"','"
//						+customerDomainObject.getNextRenewDate()+"','"
//						+customerDomainObject.getCustomerId()+"')";
				//LOGGER.debug("*************query***" + query);
			//	int count=statement.executeUpdate(query);
			//	LOGGER.debug("*************count***" + count);
				
			}
			
			if("U".equalsIgnoreCase(customerDomainObject.getAction()))
			{
			//update
			query = "insert into CUSTOMER_HST select * from customer where customerid='"+customerDomainObject.getCustomerId()+"'";
			LOGGER.debug("*************query***" + query);
			statement.executeUpdate(query);
			
			query = "update CUSTOMER set "
					+"ACTIVITY1 = '"+customerDomainObject.getActivity1()+"',"
					+"ACTIVITY2 = '"+customerDomainObject.getActivity2()+"',"					
					+"ACTIVITY3 = '"+customerDomainObject.getActivity3()+"',"
					+"ACTIVITY4 = '"+customerDomainObject.getActivity4()+"',"
					+"ACTIVITY5 = '"+customerDomainObject.getActivity5()+"',"
					+"ACTIVITY6 = '"+customerDomainObject.getActivity6()+"',"
					+"ACTIVITY7 = '"+customerDomainObject.getActivity7()+"',"
					+"ACTIVITY8 = '"+customerDomainObject.getActivity8()+"',"
					+"ACTIVITY9 = '"+customerDomainObject.getActivity9()+"',"
					+"ACTIVITY10 = '"+customerDomainObject.getActivity10()+"',"
					
					+"ACTIVESTATUS = '"+customerDomainObject.getActiveStatus()+"',"
					+"EMAIL = '"+customerDomainObject.getEmail()+"',"
					+"PHONE = '"+customerDomainObject.getPhone()+"',"
					+"MOBILE = '"+customerDomainObject.getMobile()+"',"
					+"ADDRESS = '"+customerDomainObject.getAddress()+"',"
					+"COMPANY1 = '"+customerDomainObject.getCompany1()+"',"
					+"COMPANY2 = '"+customerDomainObject.getCompany2()+"',"
					+"COMPANY3 = '"+customerDomainObject.getCompany3()+"',"
					+"COSTOFFER = '"+customerDomainObject.getCostOffer()+"',"
					+"COSTPAID = '"+customerDomainObject.getCostPaid()+"',"
					+"COMPANYNAMECREATE = '"+customerDomainObject.getCompanyNameCreated()+"',"
					
					+"COUNTRY = '"+customerDomainObject.getCountry()+"',"
					+"DOB = '"+customerDomainObject.getDob()+"',"
					+"FNAME = '"+customerDomainObject.getFname()+"',"
					+"LNAME = '"+customerDomainObject.getLname()+"',"
					+"ISSUEDATE = '"+customerDomainObject.getIssueDate()+"',"
					+"PASSPORT = '"+customerDomainObject.getPassportNo()+"',"
					+"TRADELICNO = '"+customerDomainObject.getTradeLicNo()+"',"
					+"NEXTREVIEWDATE = '"+customerDomainObject.getNextRenewDate()
					+"' where customerid='"+customerDomainObject.getCustomerId()+"'";
			LOGGER.debug("*************query***" + query);
			statement.executeUpdate(query);
			}
			//common
			 LOGGER.debug("*************MANISH Select 1--->***"+customerDomainObject.getCustomerId());
			query = "select * from CUSTOMER where customerid='"+customerDomainObject.getCustomerId()+"'";
			//statement.executeUpdate(query);
			LOGGER.debug("*************query***" + query);
			 LOGGER.debug("*************MANISH Select 2--->***");
            ResultSet result = statement.executeQuery(query);
             
            while (result.next()) {
            	LOGGER.debug("Inside result--->");
            	
            	croductDomainObject1.setActiveStatus(result.getString("ACTIVESTATUS"));
            	croductDomainObject1.setActivity1(result.getString("ACTIVITY1"));
            	croductDomainObject1.setActivity10(result.getString("ACTIVITY10"));
            	croductDomainObject1.setActivity2(result.getString("ACTIVITY2"));
            	croductDomainObject1.setActivity3(result.getString("ACTIVITY3"));
            	croductDomainObject1.setActivity4(result.getString("ACTIVITY4"));
            	croductDomainObject1.setActivity5(result.getString("ACTIVITY5"));
            	croductDomainObject1.setActivity6(result.getString("ACTIVITY6"));
            	croductDomainObject1.setActivity7(result.getString("ACTIVITY7"));
            	croductDomainObject1.setActivity8(result.getString("ACTIVITY8"));
            	croductDomainObject1.setActivity9(result.getString("ACTIVITY9"));
            	croductDomainObject1.setAddress(result.getString("ADDRESS"));
            	croductDomainObject1.setClosingDate(result.getString("CLOSINGDATE"));
            	croductDomainObject1.setCompany1(result.getString("COMPANY1"));
            	croductDomainObject1.setCompany2(result.getString("COMPANY2"));
            	croductDomainObject1.setCompany3(result.getString("COMPANY3"));
            	croductDomainObject1.setCompanyNameCreated(result.getString("COMPANYNAMECREATE"));
            	croductDomainObject1.setCostOffer(result.getString("COSTOFFER"));
            	croductDomainObject1.setCostPaid(result.getString("COSTPAID"));
            	croductDomainObject1.setCountry(result.getString("COUNTRY"));
            	croductDomainObject1.setCustomerId(result.getString("CUSTOMERID"));
            	croductDomainObject1.setDob(result.getString("DOB"));
            	croductDomainObject1.setEmail(result.getString("EMAIL"));
            	croductDomainObject1.setFname(result.getString("FNAME"));
            	croductDomainObject1.setIssueDate(result.getString("ISSUEDATE"));
            	croductDomainObject1.setLname(result.getString("LNAME"));
            	croductDomainObject1.setMobile(result.getString("MOBILE"));
            	croductDomainObject1.setNextRenewDate(result.getString("NEXTREVIEWDATE"));
            	croductDomainObject1.setPassportNo(result.getString("PASSPORT"));
            	croductDomainObject1.setPhone(result.getString("PHONE"));
            	croductDomainObject1.setTradeLicNo(result.getString("TRADELICNO"));
            	croductDomainObject1.setStatus("S");
                 
               
            }
			
            LOGGER.debug("*************MANISH Select 3--->***");

		} catch (Exception e) {
			LOGGER.error("Exception EXCEPTION IN Customer Insert");
			e.printStackTrace();
		} finally {
			  if (conn != null)
				    try {
				      conn.close();
				    } catch (SQLException e) {
				      e.printStackTrace();
				    }}
		
		
		
		return croductDomainObject1;
	}
	@Override
	public ListCustomerDomainObject getCoustomerList() {
		
		//DAOCachedRowSet theDAOCachedRowSet = null;
		String query="";
		ListCustomerDomainObject listCustomerDomainObject=new ListCustomerDomainObject();
		MsAccessConnection msaccess = new MsAccessConnection();
		Connection conn = msaccess.getConnection();
		try {
			
			query = "select * from CUSTOMER";
			LOGGER.debug("*************query***" + query);
			Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(query);
            
            ArrayList<CustomerDomainObject> customerDomainObjectAL = new ArrayList<CustomerDomainObject>();
             
            while (result.next()) {
            	LOGGER.debug("Inside result--->");
            	CustomerDomainObject croductDomainObject1 =new CustomerDomainObject();
            	croductDomainObject1.setActiveStatus(result.getString("ACTIVESTATUS"));
            	croductDomainObject1.setActivity1(result.getString("ACTIVITY1"));
            	croductDomainObject1.setActivity10(result.getString("ACTIVITY10"));
            	croductDomainObject1.setActivity2(result.getString("ACTIVITY2"));
            	croductDomainObject1.setActivity3(result.getString("ACTIVITY3"));
            	croductDomainObject1.setActivity4(result.getString("ACTIVITY4"));
            	croductDomainObject1.setActivity5(result.getString("ACTIVITY5"));
            	croductDomainObject1.setActivity6(result.getString("ACTIVITY6"));
            	croductDomainObject1.setActivity7(result.getString("ACTIVITY7"));
            	croductDomainObject1.setActivity8(result.getString("ACTIVITY8"));
            	croductDomainObject1.setActivity9(result.getString("ACTIVITY9"));
            	croductDomainObject1.setAddress(result.getString("ADDRESS"));
            	croductDomainObject1.setClosingDate(result.getString("CLOSINGDATE"));
            	croductDomainObject1.setCompany1(result.getString("COMPANY1"));
            	croductDomainObject1.setCompany2(result.getString("COMPANY2"));
            	croductDomainObject1.setCompany3(result.getString("COMPANY3"));
            	croductDomainObject1.setCompanyNameCreated(result.getString("COMPANYNAMECREATE"));
            	croductDomainObject1.setCostOffer(result.getString("COSTOFFER"));
            	croductDomainObject1.setCostPaid(result.getString("COSTPAID"));
            	croductDomainObject1.setCountry(result.getString("COUNTRY"));
            	croductDomainObject1.setCustomerId(result.getString("CUSTOMERID"));
            	croductDomainObject1.setDob(result.getString("DOB"));
            	croductDomainObject1.setEmail(result.getString("EMAIL"));
            	croductDomainObject1.setFname(result.getString("FNAME"));
            	croductDomainObject1.setIssueDate(result.getString("ISSUEDATE"));
            	croductDomainObject1.setLname(result.getString("LNAME"));
            	croductDomainObject1.setMobile(result.getString("MOBILE"));
            	croductDomainObject1.setNextRenewDate(result.getString("NEXTREVIEWDATE"));
            	croductDomainObject1.setPassportNo(result.getString("PASSPORT"));
            	croductDomainObject1.setPhone(result.getString("PHONE"));
            	croductDomainObject1.setTradeLicNo(result.getString("TRADELICNO"));
            	croductDomainObject1.setStatus("S");
            	
            	customerDomainObjectAL.add(croductDomainObject1);
            	
            }
            listCustomerDomainObject.setListCustomerDomainObject(customerDomainObjectAL);
            listCustomerDomainObject.setStatus("S");
			

		} catch (Exception e) {
			LOGGER.error("Exception EXCEPTION IN countryDomainObject");
			e.printStackTrace();
		}finally {
			  if (conn != null)
				    try {
				      conn.close();
				    } catch (SQLException e) {
				      e.printStackTrace();
				    }}
		
		
		
		return listCustomerDomainObject;
	}



	



}
