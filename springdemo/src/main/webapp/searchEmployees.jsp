<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Employees</title>
<%@include file="bootstrap.jsp"%>
</head>
<body>
	<div class="container">
		<%@include file="menu.jsp"%>
		<h1>Search Employee</h1>
		<form action="doSearch">
			Name <input type="text" required="true" name="empName"
				value="${empName}" />
			<p></p>
			<button>Search</button>
		</form>
		<p></p>

		<c:if test="${!empty employees}">
			<table class="table table-bordered">
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Job</th>
					<th>Salary</th>
				</tr>

				<c:forEach var="emp" items="${employees}">
					<tr>
						<td>${emp.id}</td>
						<td>${emp.name}</td>
						<td>${emp.jobId}</td>
						<td>${emp.salary}</td>
					</tr>
				</c:forEach>

			</table>
		</c:if>

		<c:if test="${empty employees}">
			<h3>Sorry! No Employees Found!</h3>
		</c:if>

	</div>
</body>
</html>