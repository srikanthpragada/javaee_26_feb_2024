<%@ page language="java" contentType="text/html; charset=UTF-8"
         import="javax.sql.rowset.*"
         pageEncoding="UTF-8"%>
 
 <%
        Class.forName("com.mysql.cj.jdbc.Driver"); // Load JDBC Driver

		CachedRowSet rowSet = RowSetProvider.newFactory().createCachedRowSet();
		rowSet.setUrl("jdbc:mysql://localhost:3306/feb26");
		rowSet.setUsername("root");
		rowSet.setPassword("mysql");
		rowSet.setCommand("select concat(first_name, concat(' ',last_name)) from employees where employee_id = ?");
		rowSet.setString(1, request.getParameter("id"));
		rowSet.execute();
		
		if (rowSet.next())
			out.println(rowSet.getString(1));
		else
			out.println("");  // Id not found 
		
%>
		