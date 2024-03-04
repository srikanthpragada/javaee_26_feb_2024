<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="java.sql.*" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Salary</title>
</head>
<body>

	<%
	// Get input from HTML form 
	String id = request.getParameter("id");
	String salary = request.getParameter("salary");
	
    // Update Database 
	Class.forName("com.mysql.cj.jdbc.Driver"); // Load JDBC Driver 
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/feb26", "root", "mysql");
	PreparedStatement ps = con.prepareStatement("update employees set salary = ? where employee_id = ?");
	ps.setInt(1, Integer.parseInt(salary)); // salary 
	ps.setInt(2, Integer.parseInt(id)); // id

	int count = ps.executeUpdate();
	ps.close();
	con.close();
  
	// Send message to client 
	if (count == 1)
		out.println("<h2>Updated salary successfully!</h2>");
	else
		out.println("<h2>Employee ID not found</h2>");
	%>

</body>
</html>