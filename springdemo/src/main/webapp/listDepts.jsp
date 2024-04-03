<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Departments</title>
<%@include file="bootstrap.jsp" %>
</head>
<body>
<div class="container">
	<h1>Departments</h1>
	<a href="/addDept">Add Department</a>
	<p></p>
	<table class="table table-bordered">
		<tr>
			<th>Department Id</th>
			<th>Department Name</th>
			<th></th>
		</tr>

		<c:forEach var="dept" items="${depts}">
			<tr>
				<td>${dept.id}</td>
				<td>${dept.name}</td>
				<td class="text-center">
				   <a href="/edit?id=${dept.id}">Edit</a>
				   &nbsp;
				   <a onclick="return confirm('Do you want to delete?')"
				      href="/delete?id=${dept.id}">Delete</a>
				   &nbsp;
				   <a href="/employees?dept=${dept.id}">Employees</a>
				   
				</td>
			</tr>
		</c:forEach>

	</table>
	</div>
</body>
</html>