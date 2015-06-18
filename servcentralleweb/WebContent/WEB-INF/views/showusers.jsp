<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.Set"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ShowUsers</title>
<link href="./resources/css/showusers.css" rel="stylesheet">
<script type="text/javascript" src="./resources/js/elemental.js"></script>
</head>
<body onload="showDate()">
	<div class="header">
		
	</div>

	<%
		Map<Integer, List> m = (Map) request.getAttribute("datamems");
		Set<Integer> s = m.keySet();
	%>
	<table class="mytable">
		<thead>
			<td>Id          </td>
			<td>Name        </td>
			<td>location    </td>
			<td>address     </td>
			<td>pin         </td>
			<td>services    </td>
		</thead>
		<% for(Integer e:s){%>
			<tr>
				<td><% out.print(e);%></td>
				<%
					List li = m.get(e);
					for(int p=0;p<li.size();p++){ %>
					<td><% out.print(li.get(p)); %></td>
					<%} %>
			</tr>
		<% } %> 
	</table>

</body>
</html>