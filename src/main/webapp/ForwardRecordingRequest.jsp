<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.net.HttpURLConnection" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.io.InputStreamReader" %>
<%@ page import="java.io.OutputStream" %>
<%@ page import="java.net.MalformedURLException" %>
<%@ page import="java.net.URL" %>

<?xml version="1.0" encoding="utf-8" ?> 
<XML>
<SMSAWAY>Dear Customer,Thank you for using services shared for offline message tracking.</SMSAWAY> 
<%
try{
String l_method=request.getParameter("protocol");
String l_ip=request.getParameter("ip");	
String l_port=request.getParameter("port");
	
URL url = new URL(l_method+"://"+l_ip+":"+l_port+"/Asset-api/rest/receiptData/insert");
HttpURLConnection conn = (HttpURLConnection) url.openConnection();
conn.setDoOutput(true);
conn.setRequestMethod("POST");
conn.setRequestProperty("Content-Type", "application/json");
conn.setRequestProperty("operation-flag", "C");


String l_a = "{\"payAmount\":"+"\""+request.getParameter("payamount")+"\",";
String l_b = "\"userId\":"+"\""+request.getParameter("userid")+"\",";
String l_c = "\"payMode\":"+"\""+request.getParameter("paymode")+"\",";
String l_d = "\"applId\":"+"\""+request.getParameter("applid")+"\",";
String l_e = "\"receiptNumber\":"+"\""+request.getParameter("receiptnumber")+"\",";
String l_f = "\"source\":"+"\""+request.getParameter("source")+"\",";
String l_g = "\"mobileNumber\":"+"\""+request.getParameter("mobilenumber")+"\",";
String l_h = "\"paymentFor\":"+"\""+request.getParameter("paymentfor")+"\",";
String l_i = "\"tempMobileNo\":"+"\""+request.getParameter("tempmobile")+"\",";
String l_j = "\"tempEmail\":"+"\""+request.getParameter("tempemail")+"\",";
String l_k = "\"instrumentNo\":"+"\""+request.getParameter("instrumentno")+"\"}";

String input	=	l_a + l_b + l_c + l_d + l_e + l_f + l_g + l_h + l_i + l_j + l_k;
OutputStream os = conn.getOutputStream();
os.write(input.getBytes());
os.flush();

if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {}


BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
String output;
while ((output = br.readLine()) != null) {}
conn.disconnect();
} catch (MalformedURLException e) {
} catch (IOException e) {
}
%>

</XML>