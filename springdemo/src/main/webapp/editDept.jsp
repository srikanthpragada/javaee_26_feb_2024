<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Department</title>
<%@include file="bootstrap.jsp"%>
</head>
<body>
	<div class="container">
	    <%@include file="menu.jsp" %>
		<h1>Edit Department</h1>
		<sf:form method="post" modelAttribute="dept">
		Id <br />
			<sf:input type="number" readonly="true" required="true" path="id" />
			<p></p>
		Name <br />
			<sf:input type="text" required="true" path="name" />
			<p></p>
			<button>Update</button>
		</sf:form>
	</div>
</body>
</html>