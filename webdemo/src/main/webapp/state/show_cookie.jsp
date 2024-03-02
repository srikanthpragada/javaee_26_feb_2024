<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Cookie</title>
</head>
<body>
City = ${cookie.city.value}
<p></p>
<%
    Cookie [] cl = request.getCookies();
    for(Cookie c : cl)
    	out.println(c.getName() + "<br/>");
%>

</body>
</html>