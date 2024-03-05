<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="java.sql.*" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Job</title>
</head>
<body>
    <%@include file="common.html" %>

	<h1>Add Job</h1>
	<a href="list_jobs.jsp">List Jobs</a>
	<p></p>
	<form action="add_job.jsp">
		Id <br /> <input type="text" name="id" required value="${param.id}" />
		<p></p>
		Title <br /> <input type="text" name="title" required
			value="${param.title}" />
		<p></p>
		Min. Salary <br /> <input type="number" name="minsal" required
			value="${param.minsal}" />
		<p></p>
		<input type="submit" value="Add Employee" />
	</form>
	<p></p>
	<h3>
		<%
		// Get input from HTML form 
		String id = request.getParameter("id");
		if (id == null) // first request so stop here
			return;

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/feb26", "root", "mysql");
		PreparedStatement ps = con.prepareStatement("insert into jobs(job_id, job_title, min_salary) values(?,?,?)");

		ps.setString(1, id);
		ps.setString(2, request.getParameter("title"));
		ps.setString(3, request.getParameter("minsal"));

		try {
			ps.executeUpdate();
			out.println("Added Successfully!");
		} catch (Exception ex) {
			out.println("Sorry! Error ->" + ex.getMessage());
		}

		ps.close();
		con.close();
		%>

	</h3>

</body>
</html>