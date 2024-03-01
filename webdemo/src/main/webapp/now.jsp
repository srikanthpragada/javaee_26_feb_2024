<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Now</title>
</head>
<body>
	<h1>
		<%=new java.util.Date().toString()%>
		<hr />
		<%
		String now = new java.util.Date().toString();
		out.println(now);
		%>
	</h1>
</body>
</html>