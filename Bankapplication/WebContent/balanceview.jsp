<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>balance</title>
</head>
<body>
<% 
   session=request.getSession();
    
    out.println("ACCOUNT BALANCE ="+session.getAttribute("balance"));
%>
</body>
</html>