<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="sql" uri="jakarta.tags.sql"%>

<h1>Employees</h1>

<sql:setDataSource var="mysql" driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/feb26" user="root" password="mysql" />

<sql:query var="emplist" dataSource="${mysql}">
      select * from employees
</sql:query>

<ul>
	<c:forEach var="emp" items="${emplist.rows}">
		<li>${emp.employee_id},${emp.first_name},${emp.salary} </li>
	</c:forEach>
</ul>




