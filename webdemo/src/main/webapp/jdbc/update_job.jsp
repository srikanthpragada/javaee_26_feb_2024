<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.sql.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Job</title>
</head>
<body>
	<h2>Update Job</h2>
	<%
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/feb26", "root", "mysql");
	PreparedStatement ps = con.prepareStatement("update jobs set job_title = ?, min_salary = ? where job_id = ?");

	ps.setString(1, request.getParameter("title"));
	ps.setString(2, request.getParameter("minsal"));
	ps.setString(3, request.getParameter("id"));

	try {
		ps.executeUpdate();
		response.sendRedirect("list_jobs.jsp");
	} catch (Exception ex) {
		out.println("Sorry! Error ->" + ex.getMessage());
	} finally {
		ps.close();
		con.close();
	}
	%>

</body>
</html>