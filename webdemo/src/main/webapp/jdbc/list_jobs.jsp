<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="javax.sql.rowset.*" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Jobs</title>
</head>
<body>
    <%@include file="common.html" %>
	<h1>List of Jobs</h1>
    <a href="add_job.jsp">Add New Job</a>
    <p></p>
	<table border="1" width="100%" cellpadding="5pt">
		<tr style="background-color:blue;color:white;font-weight:bold"> 
			<th>Job Title</th>
			<th>Min Salary</th>
			<th></th>
		</tr>

		<%
		//Class.forName("com.mysql.cj.jdbc.Driver"); // Load JDBC Driver 
		
		CachedRowSet rowSet = RowSetProvider.newFactory().createCachedRowSet();
		rowSet.setUrl("jdbc:mysql://localhost:3306/feb26");
		rowSet.setUsername("root");
		rowSet.setPassword("mysql");
		rowSet.setCommand("select * from jobs");
		rowSet.execute();

		while (rowSet.next()) {
			String id = rowSet.getString("job_id");
		%>
		
		<tr>
		  <td><%=rowSet.getString("job_title") %> </td>
		  <td style='text-align:right'><%= rowSet.getInt("min_salary") %> </td>
		  <td style='text-align:center'>
		     <a href='edit_job.jsp?id=<%=id%>'>Edit</a>
		     &nbsp;
		     <a href='delete_job.jsp?id=<%=id%>'>Delete</a>
		     &nbsp;
		     <a href='list_employees.jsp?id=<%=id%>'>Employees</a>
		  </td>
		</tr>
		
		<% 
		 }
		%>
	</table>
</body>
</html>