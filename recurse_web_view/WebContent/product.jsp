<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.base.businessa.logica.*" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product Offerings</title>
</head>
<body>
<% ProductOfferings prod=(ProductOfferings)request.getAttribute("product"); 
	out.println(prod.toString());
%>
</body>
</html>