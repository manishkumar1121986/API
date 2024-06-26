package com.api.util;

public interface ConfigurationMappingConstants {

	/** 
	 * FETCHING LABELS FROM DATABASE BASED ON BELOW KEYS
	 * TABLE NAME : CONFIGURATION_MAPPING 
	 * COLUMN NAME :  KEY 
	 * FEW CONSTANTS DEFINED IN SignInDAOConstants.java
	 **/
	String ADDRESS_DTLS_COUNT_KEY = "ADDRESS_DTLS_COUNT";
	String ADDITIONAL_ADDRESS_DTLS_COUNT_KEY = "ADDITIONAL_ADDRESS_DTLS_COUNT";
	String IMPLEMENTATION_NAME_KEY = "IMPLEMENTATION_NAME";
	String VOID_RECEIPT_COUNT_KEY = "VOID_RECEIPT_COUNT";
	String RECORDED_RECEIPT_COUNT_KEY = "RECORDED_RECEIPT_COUNT";
	String MAIL_PORT_KEY = "MAIL_PORT";
	String MAIL_HOST_KEY = "MAIL_HOST";
	String MAIL_FROM_KEY = "MAIL_FROM";
	String USER_PASSWORD_SMTP_FLAG_KEY = "USER_PASSWORD_SMTP_FLAG";
	String MAIL_USERNAME_KEY = "MAIL_USERNAME";
	String MAIL_PASSWORD_KEY = "MAIL_PASSWORD";
	String CASE_DOWNLOAD_KEY = "CASE_DOWNLOAD";
	String RECEIPT_DOWNLOAD_KEY = "RECEIPT_DOWNLOAD";
	String SOA_TIMEOUT_KEY = "SOA_TIMEOUT";
	String DUPLICATE_PRINT_KEY = "DUPLICATE_PRINT";
	String CURRENCY_LEFT_KEY = "CURRENCY_LEFT";
	String CURRENCY_RIGHT_KEY = "CURRENCY_RIGHT";
	String NO_OF_LOANS_FOR_PAGE_SEARCH_KEY = "NO_OF_LOANS_FOR_PAGE_SEARCH";
	String SEND_SMS_TYPE_KEY = "SEND_SMS_TYPE";
	String SESSION_CHECK_KEY = "SESSION_CHECK";
	String KEYSTORE_KEY_KEY = "KEYSTORE_KEY";
	String ANDROID_VERSION_KEY = "ASSET_ANDROID_VERSION";
	String ASSET_EXPIRY_DATE_FLAG_KEY = "ASSET_EXPIRY_DATE_FLAG";
	String ASSET_USER_COUNT_FLAG_KEY = "ASSET_USER_COUNT_FLAG";
	String SMS_URL_KEY = "SMS_URL";
	String SERVER_PROXY_HOST_KEY = "SERVER_PROXY_HOST";
	String SERVER_PROXY_PORT_KEY = "SERVER_PROXY_PORT";
	String DEPT_KEY = "DEPT";
	String APPID_KEY = "APPID";
	String HTTPMODE_KEY = "HTTPMODE";
	String DUPLICATE_CHECK_KEY = "DUPLICATE_CHECK";
	String SERVER1_KEY = "SERVER1";
	String SERVER2_KEY = "SERVER2";
	String SERVER3_KEY = "SERVER3";
	String SERVER4_KEY = "SERVER4";
	String PORT1_KEY = "PORT1";
	String PORT2_KEY = "PORT2";
	String PORT3_KEY = "PORT3";
	String PORT4_KEY = "PORT4";
	String TIMEOUTVAL_KEY = "TIMEOUTVAL";
	String SMS_DELIVERY_TO_KEY = "SMS_DELIVERY_TO";
	String SMS_DELIVERY_FROM_KEY = "SMS_DELIVERY_FROM";
	String MOBILE_NUMBER_INITIALS_KEY = "MOBILE_NUMBER_INITIALS";
	String BOUNCE_DTLS_COUNT_KEY = "BOUNCE_DTLS_COUNT";
	String PAYMENT_DTLS_COUNT_KEY = "PAYMENT_DTLS_COUNT";
	String CONTACT_HST_COUNT_KEY = "CONTACT_HST_COUNT";
	String UNLOCK_MAIL_CONTENT_KEY = "UNLOCK_MAIL_CONTENT";
	String UNLOCK_MAIL_SUBJECT_KEY = "UNLOCK_MAIL_SUBJECT";
	String RESET_MAIL_CONTENT_KEY = "RESET_MAIL_CONTENT";
	String RESET_MAIL_SUBJECT_KEY = "RESET_MAIL_SUBJECT";
	String SERVER_SIDE_VALIDATON_KEY = "SERVER_SIDE_VALIDATON";
	String GUARANTOR_ADDRESS_DTLS_COUNT = "GUARANTOR_ADDRESS_DTLS_COUNT";
	String UPI_AMOUNT_LIMIT = "UPI_AMOUNT_LIMIT";
	String NUMBER_OF_BUFFER_DAYS_FOR_UPI = "NUMBER_OF_BUFFER_DAYS_FOR_UPI";
	String AADHAR_PAYMENT_ONUS_CODE = "AADHAR_PAYMENT_ONUS_CODE";
	String AADHAR_SERVER_IP = "AADHAR_SERVER_IP";
	String AADHAR_SERVER_PORT = "AADHAR_SERVER_PORT";
	String AADHAR_SERVER_TIMEOUT = "AADHAR_SERVER_TIMEOUT";
	String LDAP_ENABLED = "LDAP_ENABLED";
	String LDAP_HOST = "LDAP_HOST";
	String LDAP_PORT = "LDAP_PORT";
	String LDAP_DC_PART1 = "LDAP_DC_PART1";
	String LDAP_DC_PART2 = "LDAP_DC_PART2";
	String LDAP_DC_PART3 = "LDAP_DC_PART3";
	String LDAP_DOMAIN = "LDAP_DOMAIN";
	String LDAP_UID_ATTR = "LDAP_UID_ATTR";
	String LDAP_UNAME_ATTR = "LDAP_UNAME_ATTR";
	String LDAP_KEYSTORE = "LDAP_KEYSTORE";
	String LDAP_TRUSTSTORE = "LDAP_TRUSTSTORE";
	String LDAP_TRUSTSTORE_PASSWORD = "LDAP_TRUSTSTORE_PASSWORD";
	String INTERNAL_EXTERNAL_BOTH_FLAG = "INTERNAL_EXTERNAL_BOTH_FLAG";
	String OTP_SMS_SEND_FLAG = "OTP_SMS_SEND_FLAG";
	String OTP_SMS_CONTENT = "OTP_SMS_CONTENT";
	String OTP_SMS_URL = "OTP_SMS_URL";
	String OTP_LENGTH = "OTP_LENGTH";
	// Images Upload Functionality
	String IMAGE_UPLOAD_PATH = "IMAGE_UPLOAD_PATH";
	String IMAGE_UPLOAD_TYPE = "IMAGE_UPLOAD_TYPE";
	String DELETE_IMAGE_UPLOADED_FLAG = "DELETE_IMAGE_UPLOADED_FLAG";
	String SAME_IMAGE_UPLOADED_FLAG = "SAME_IMAGE_UPLOADED_FLAG";
	
	String SAME_VOICE_UPLOADED_FLAG = "SAME_VOICE_UPLOADED_FLAG";
	String VOICE_UPLOADED_PATH = "VOICE_UPLOADED_PATH";
	// Token Query Signin
	String SIGNIN_TOKEN_FLAG = "SIGNIN_TOKEN_FLAG";
	String SSOVERSION = "SSOVERSION";
	String SIGN_IN_JS_PATH = "SIGN_IN_JS_PATH";
	String PRODUCTION_FLAG = "PRODUCTION_FLAG";
	String NUMBER_OF_BUFFER_DAYS_FOR_RPL = "NUMBER_OF_BUFFER_DAYS_FOR_RPL";
	String RPL_RESEND_FLAG = "RPL_RESEND_FLAG";
	String RPL_FORWARD_FLAG = "RPL_FORWARD_FLAG";
	String RPL_RECALL_FLAG = "RPL_RECALL_FLAG";

	/** 
	 * FETCHING LABELS FROM DATABASE BASED ON BELOW KEYS
	 * TABLE NAME : MOB_LISTVIEW_HEADER 
	 * COLUMN NAME :  MOB_LV_CODE 
	 **/
	String ADDRESS_DETAILS_LABELS = "ADDRESS_DETAILS";
	String ADDED_ADDRESS_DETAILS_LABELS = "ADDED_ADDRESS_DETAILS";
	String PAYMENT_DETAILS_LABELS = "PAYMENT_DETAILS";
	String BOUNCE_DETAILS_LABELS = "BOUNCE_DETAILS";
	String CONTACT_HISTORY_LABELS = "CONTACT_HISTORY";
	String ACCOUNT_SUMMARY_LABELS = "ACCOUNT_SUMMARY";
	String GUARANTOR_ADDRESS_DETAILS_LABELS = "GUARANTOR_ADDRESS_DETAILS";
	String ASSET_DETAILS_LABELS = "ASSET_DETAILS";

	/** 
	 * FETCHING QUERY FROM DATABASE BASED ON BELOW KEYS
	 * TABLE NAME : MOB_LISTVIEW_DEF_M 
	 * COLUMN NAME :  LV_CODE 
	 **/
	String MOB_ACCOUNT_DETAILS_QRY = "MOB_ACCOUNT_DETAILS";
	String MOB_ADDRESS_DETAILS_QRY = "MOB_ADDRESS_DETAILS";
	String MOB_ADDED_ADDRES_DETAILS_QRY = "MOB_ADDED_ADDRES_DETAILS";
	String MOB_SIGNIN_RECEIPT_QRY = "MOB_SIGNIN_RECEIPT_QRY";
	String MOB_CASE_DETAILS_ELSE_QRY = "MOB_CASE_DETAILS_ELSE";
	String MOB_CASE_DETAILS_A_QRY = "MOB_CASE_DETAILS_A";
	String MOB_CASE_DETAILS_B_QRY = "MOB_CASE_DETAILS_B";
	String MOB_CASE_DETAILS_ALLOCATED_QRY = "MOB_CASE_DETAILS_ALLOCATED";
	String MOB_CASE_DETAILS_NAM_QRY = "MOB_CASE_DETAILS_NAM";
	String MOB_BOUNCE_DETAILS_QRY = "MOB_BOUNCE_DETAILS";
	String MOB_PAYMENT_DETAILS_QRY = "MOB_PAYMENT_DETAILS";
	String MOB_CONTACT_DETAILS_QRY = "MOB_CONTACT_DETAILS";
	String MOB_GUARANTOR_ADDRES_DETAILS_QRY = "MOB_GUARANTOR_DTLS_QRY";
	String MOB_UNIT_ID_QRY = "MOB_UNIT_ID";
	String MOB_GET_ALL_UNIT_ID_FOR_SAME_REPORTING = "MOB_GET_ALL_UNIT_ID_FOR_SAME_REPORTING";
	// Images Upload Functionality
	String MOB_GET_IMAGE_NAME_QRY = "MOB_GET_IMAGE_NAME_QRY";
	String MOB_INSERT_IMAGE_QRY = "MOB_INSERT_IMAGE_QRY";
	String MOB_GET_ALL_IMAGE_QRY = "MOB_GET_ALL_IMAGE_QRY";
	String MOB_GET_SINGLE_IMAGE_QRY = "MOB_GET_SINGLE_IMAGE_QRY";
	// Token Query Signin
	String MOB_SIGNIN_TOKEN_QRY = "MOB_SIGNIN_TOKEN_QRY";
	String MOB_SESSION_ID_QRY = "MOB_SESSION_ID_QRY";
	// ATM BRANCH LOCATOR
	String MOB_GET_ATM_BRANCH_QRY = "MOB_GET_ATM_BRANCH_QRY";
	String MOB_DB_PASSWORD_QRY = "MOB_DB_PASSWORD_QRY";
	// ASSET DETAILS FUNCTIONALITY
	String MOB_ASSET_DETAILS_QRY = "MOB_ASSET_DETAILS";
	
	/** 
	 * SEQUENCE NAME USED IN APPLICATION
	 **/
	String IMAGE_UPLOAD_SEQ = "IMAGE_UPLOAD_SEQ";
	String AADHAR_PAYMENT_SEQ = "AADHAR_PAYMENT_SEQ";
	
	/** 
	 * MAIL CONTENT KEY FOR MOB_MAIL_SMS_CONTENT
	 **/
	String ONLINE_FC = "ONLINE_FC";
	String ONLINE_SOA = "ONLINE_SOA";
}