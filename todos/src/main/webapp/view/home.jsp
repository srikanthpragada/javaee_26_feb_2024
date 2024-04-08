<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="header.jsp"%>
<title>Home</title>
</head>
<body>
	<h1>Recently Added</h1>
    <jsp:include page="list_todos.jsp" />
</body>
</html>