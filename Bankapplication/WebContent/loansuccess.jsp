<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>loan success</title>
</head>
<body>
<%
session=  request.getSession();
out.println("dear"+session.getAttribute("accno")+"your loan application "+session.getAttribute("amt")+"is recorded");
out.println("<br>");
out.println("our executive will contact you on the mailid "+session.getAttribute("email"));
out.println("<br>");
out.println("THANKOYU");


%>
</body>
</html>