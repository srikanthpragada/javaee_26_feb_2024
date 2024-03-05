<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="java.sql.*, javax.sql.rowset.*" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Job</title>
</head>
<%
// Take job id
String id = request.getParameter("id");
// Retrieve row based on job_id
CachedRowSet rowSet = RowSetProvider.newFactory().createCachedRowSet();
rowSet.setUrl("jdbc:mysql://localhost:3306/feb26");
rowSet.setUsername("root");
rowSet.setPassword("mysql");
rowSet.setCommand("select * from jobs  where job_id = ?");
rowSet.setString(1, id);
rowSet.execute();

rowSet.next(); // move to first row in the rowset

String title = rowSet.getString("job_title");
int minsal = rowSet.getInt("min_salary");
%>


<body>

	<h1>Edit Job</h1>
	<a href="list_jobs.jsp">List Jobs</a>
	<p></p>
	<form action="update_job.jsp">
		<input type="hidden" name="id" required value="<%=id%>" />
		<p></p>
		Title <br /> <input type="text" name="title" required
			value="<%=title%>" />
		<p></p>
		Min. Salary <br /> <input type="number" name="minsal" required
			value="<%=minsal%>" />
		<p></p>
		<input type="submit" value="Update Employee" />
	</form>
	 

</body>
</html>