<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Net Price</title>
</head>
<body>
	<%
	// read input from HTML form
	String sprice = request.getParameter("price");
	try {
		int price = Integer.parseInt(sprice);

		// Calculate discount 
		int discount;

		if (price > 5000)
			discount = price * 20 / 100;
		else
			discount = price * 10 / 100;

		int netprice = price - discount;

		out.println("<h2>Net Price :" + netprice + "</h2>");
	} catch (Exception ex) {
		System.out.println(ex);
		out.println("<h3>Sorry!! Invalid Input </h3>");
	}
	%>

</body>
</html>