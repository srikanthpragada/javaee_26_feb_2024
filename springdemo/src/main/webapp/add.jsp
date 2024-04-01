<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add</title>
</head>
<body>
	<h1>Add</h1>
	<form method="post">
		First Number <br /> <input type="number" required name="first" 
		                       value=${addModel.first} />
		<p></p>
		Second Number <br /> <input type="number" required name="second" 
		                       value=${addModel.second} />
		<p></p>
		<button>Add</button>
	</form>
	
	<h1>${addModel.result > 0 ? addModel.result : ''}</h1>
</body>
</html>