<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="java.util.*" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Languages</title>
</head>
<body>
	<%
    String name = request.getParameter("lang");
	Object value = session.getAttribute("langs");
	ArrayList<String> langs = null;
	if (value == null)  // attribute not found 
		langs = new ArrayList<String>();   // Empty List 
	else
		langs = (ArrayList<String>) value;

	langs.add(name);
	session.setAttribute("langs", langs);
	%>

	<h2>Languages</h2>
	<%
	   // List langs 
	   for (String lang : langs)
		 out.println(lang + "<br/>");
	%>
</body>
</html>