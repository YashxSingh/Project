<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Yash's Product Page</title>
</head>

<body
	style="text-align: center; color: background-color: rgb(135, 135, 255color: background-color: rgb(135, 135, 255));">
	<h1>
		Welcome to my Product World,
		<%=request.getAttribute("username")%>
		!!!
	</h1>
	<br>
	<br>
	<br>
	<hr>
	<p>
		<a href="<%=request.getContextPath()%>//all-products">Go to the
			Products Page</a>
	</p>

</body>

</html>