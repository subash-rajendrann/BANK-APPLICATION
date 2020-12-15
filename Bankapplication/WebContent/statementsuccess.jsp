<%@page import="org.eclipse.jdt.internal.compiler.ast.ForeachStatement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% session=request.getSession();

   out.println("sender accno:"+session.getAttribute("sal"));
   out.println("receiver accno:"+session.getAttribute("ral"));
   out.println("amount send:"+session.getAttribute("al"));
%>
</body>
</html>