<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Department</title>
<%@include file="bootstrap.jsp"%>
</head>
<body>
	<div class="container">
		<h1>Add Department</h1>
		<sf:form method="post" modelAttribute="dept">
		Id <br />
			<sf:input type="number" required="true" path="id" />
			<p></p>
		Name <br />
			<sf:input type="text" required="true" path="name" />
			<p></p>
			<button>Add</button>
		</sf:form>
	</div>
</body>
</html>