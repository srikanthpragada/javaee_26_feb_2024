<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Wish</title>
<style>
    .right { text-align: right}
</style>
</head>
<body>
	<h1>Interest Calculation</h1>
	<table border="1" cellpadding="5px">
		<tr>
			<td>Amount</td>
			<td class="right">${amount}</td>
		</tr>
		<tr>
			<td>Interest Rate</td>
			<td class="right">${rate}</td>
		</tr>
		<tr>
			<td>Interest</td>
			<td class="right">${interest}</td>
		</tr>
	</table>
</body>
</html>