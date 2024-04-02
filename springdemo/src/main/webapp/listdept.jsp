<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="sql" uri="jakarta.tags.sql"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Departments</title>
</head>
<body>
	<h1>Departments</h1>
	<table>
		<tr>
			<th>Department Id</th>
			<th>Department Name</th>
			<th></th>
		</tr>

		<c:forEach var="dept" items="${depts}">
			<tr>
				<td>${dept.id}</td>
				<td>${dept.name}</td>
				<td></td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>