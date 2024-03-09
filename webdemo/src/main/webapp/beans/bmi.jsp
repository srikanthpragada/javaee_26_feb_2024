<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BMI</title>
</head>
<body>

	<h1>BMI Calculator with JavaBean</h1>
	<form action="bmi.jsp">
		Height <br /> <input type="number" step="0.01" required
			value="${param.height}" name="height"> (In Meters)
		<p></p>
		Weight <br /> <input type="number" required value="${param.weight}"
			name="weight"> (In Killos)
		<p></p>
		<input type="submit" value="Calculate"> <input type="reset"
			value="Clear" />
	</form>

	<%
	String sheight = request.getParameter("height");
	if (sheight == null) // first request 
		return; // terminate JSP
	%>

	<jsp:useBean id="bmiBean" class="beans.BMIBean" scope="page" />
	<jsp:setProperty property="*" name="bmiBean" />

	<h1>BMI  = ${bmiBean.BMI}, Remarks = ${bmiBean.type}</h1>




</body>
</html>