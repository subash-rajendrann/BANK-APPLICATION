<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>loan history</title>
</head>
<body>
<%@page import="com.abc.model.*,java.util.*" %>

<% 
  // session=request.getSession();
//List<?> list=(List<?>)session.getAttribute("accno");
session=request.getSession();
out.println("account no:"+session.getAttribute("lacc"));
%><br><%out.println("email:"+session.getAttribute("lemail"));

%><br><%out.println("loan amount:"+session.getAttribute("lamt")); %>



<br/><br/>
<a href="home.html">click here to go to homepage</a>





</body>
</html>