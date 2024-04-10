<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="header.jsp"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<title>Todos</title>
</head>
<body>
	<h1>Todos</h1>
	<jsp:include page="list_todos.jsp" />
</body>
</html>