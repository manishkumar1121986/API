package com.api.controlparameters.dao.constants;

public interface ControlParameterDAOConstants {

	String GET_CONFIGURATION_DATA="SELECT KEY,VALUE FROM CONFIGURATION_MAPPING WHERE KEY = ? ";
	String GET_QUERY_LISTVIEW_DATA=" SELECT LV_DATA_QRY FROM MOB_LISTVIEW_DEF_VIEW WHERE LV_CODE=? ";
	String GET_QUERY_SERVICE_FLAG =" select MOB_SESSION_CHECK from MOB_SERVICES_REQUEST_DTL where MOB_SERVICES = ? ";
	String GET_FOLLOW_VALI_DATA =" select MFV_KEY from MOB_FOLLOWUP_VALIDATIONS where MFV_VALUE = ? ";
}