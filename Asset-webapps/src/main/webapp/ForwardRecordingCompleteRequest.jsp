<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.net.HttpURLConnection" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.io.InputStreamReader" %>
<%@ page import="java.io.OutputStream" %>
<%@ page import="java.net.MalformedURLException" %>
<%@ page import="java.net.URL" %>
<%@ page import="java.util.*" %>

<?xml version="1.0" encoding="utf-8" ?> 
<XML>

<%
try{
String l_method=request.getParameter("protocol");
String l_ip=request.getParameter("ip");	
String l_port=request.getParameter("port");
	
URL url = new URL(l_method+"://"+l_ip+":"+l_port+"/Asset-api/rest/receiptData/completeinsert");
HttpURLConnection conn = (HttpURLConnection) url.openConnection();
conn.setDoOutput(true);
conn.setRequestMethod("POST");
conn.setRequestProperty("Content-Type", "application/json");
conn.setRequestProperty("operation-flag", "C");


String l_a = "{\"mobileNumber\":"+"\""+request.getParameter("mobileNumber")+"\",";
String l_b = "\"sourceKeyword\":"+"\""+request.getParameter("sourceKeyword")+"\",";
String l_c = "\"sourceNumber\":"+"\""+request.getParameter("sourceNumber")+"\",";
String l_d = "\"smsContent\":"+"\""+request.getParameter("smsContent")+"\",";
String l_e = "\"smsDate\":"+"\""+request.getParameter("smsDate")+"\",";
String l_f = "\"smsTime\":"+"\""+request.getParameter("smsTime")+"\",";
String l_g = "\"smsCircle\":"+"\""+request.getParameter("smsCircle")+"\"}";

String input	=	l_a + l_b + l_c + l_d + l_e + l_f + l_g;
OutputStream os = conn.getOutputStream();
os.write(input.getBytes());
os.flush();

if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {}

String response_code = conn.getHeaderField("response-code");
out.println("response code "+response_code + "\n");

StringBuilder sb = new StringBuilder();
BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
String output;
while ((output = br.readLine()) != null) {
	sb.append(output+"\n");
}
//out.println(sb.toString());
conn.disconnect();
} catch (MalformedURLException e) {
} catch (IOException e) {
}
%>
<SMSAWAY>Dear Customer,Thank you for using services shared for offline message tracking.</SMSAWAY> 
</XML>