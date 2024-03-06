<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="jakarta.tags.core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Core Tags Demo</title>
</head>
<body>
	<c:set var="a" value="10" scope="page" />

	Value of a =
	<c:out value="${a}" />

	<p></p>

	<c:out value="<h1>Heading1!</h1>" escapeXml="true" />

	<p></p>

	<c:forEach var="i" begin="1" end="10" step="2">
          ${i}
          <br />
	</c:forEach>


	<ul>
		<c:forEach var="name" items="james,anders,roberts,micheal,hunter">
			<li>${name}</li>
		</c:forEach>
	</ul>

	<ul>
		<c:forTokens var="name" items="james:roberts,micheal:hunter"
			delims=":,">
			<li>${name}</li>
		</c:forTokens>
	</ul>


</body>
</html>