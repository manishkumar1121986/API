package com.api.common.dao.constants;

public interface CommonFunctionsDAOConstants {

	String GET_DATE_DIFF_USING_SYSDATE = " SELECT trunc(sysdate)-to_date(?,'DD-MM-YYYY') DATE_DIFF from dual ";
	
	String GET_SCREEN_LABEL = " select MOB_LV_HD_HDRLABEL, MOB_LV_HDR_VISIBLE " +
							  " from MOB_LISTVIEW_HEADER_VIEW " +
							  " WHERE MOB_LV_CODE = ? " +
							  " order by MOB_LV_HDR_SEQ ";
	
	String GET_RECEIPT_NUMBER =  " SELECT COLUMN_VALUE RECEIPT_NUMBER "+
									" FROM TABLE(GET_MOBILE_RECEIPTS4_RECORDING('A', "+
									" '1', "+
									" ?, "+
									" 'ST', ? ))";
	
	String GET_LIST_RECEIPT_NUMBER = " SELECT COLUMN_VALUE RECEIPT_NUMBER  FROM TABLE" +
			  					 " (GET_MOBILE_RECEIPTS4_RECORDING('A' ,? ,?, ?, ? ))";
	
	String GET_DOWNLOADED_RECEIPTS = " SELECT RECEIPT_NUMBER FROM MOBILE_RECEIPTS WHERE USERID = ? AND MOB_IMEI_NO = ? ";
	
	String GET_FINANCIER_TYPE = " SELECT GET_LOAN_FINANCIER(?) LOAN_TYPE FROM DUAL ";
	
	String GET_MOB_LOAN_TYPE = " SELECT GET_MOB_LOAN_TYPE(?) LOAN_TYPE FROM DUAL ";
	
	String GET_SCREEN_LABEL_WITH_Y = " select MOB_LV_HD_HDRLABEL " +
			  							" from MOB_LISTVIEW_HEADER_VIEW " +
			  							" WHERE MOB_LV_CODE = ? AND MOB_LV_HDR_VISIBLE = 'Y' " +
			  							" order by MOB_LV_HDR_SEQ ";
	
}