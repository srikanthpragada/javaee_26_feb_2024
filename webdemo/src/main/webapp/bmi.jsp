<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BMI</title>
</head>
<body>

	<h1>BMI Calculator</h1>
	<form action="bmi.jsp">
		Height <br /> <input type="number" step="0.01" required 
		       value="${param.height}"   name="height"> (In Meters)
		<p></p>
		Weight <br /> <input type="number" required value="${param.weight}" name="weight"> (In Killos)
		<p></p>
		<input type="submit" value="Calculate">
		<input type="reset" value="Clear" />
	</form>
	
	<%
	  
	   String sheight = request.getParameter("height");
	   if(sheight == null)  // first request 
	      return;           // terminate JSP 
   
   	   double height = Double.parseDouble(sheight);
	   double weight = Double.parseDouble(request.getParameter("weight"));
	   
	   double bmi = weight / (height * height);
	      
       String category = "Obese";
	   if (bmi < 18.5) 
           category = "Underweigth";		    
       else if (bmi < 25) 
		   category = "Normal";
       else if (bmi < 30) 
		   category =  "Overweight";

	%>
	
	<h2>
	   BMI =  <%=String.format("%5.2f",bmi) %>
	   <p></p>
	   Category = <%= category %>
	</h2>
</body>
</html>