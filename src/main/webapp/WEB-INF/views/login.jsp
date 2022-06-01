<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>first web Application</title>
</head>
<body>
<h1>Hello this is my first web application</h1>
<form method="post">
	
	Name : <input type="text" name="name">
	<br>
	Password : <input type="password" name="password">
	<br>
	<input type="submit" value="clck me">
	
	<h3>
	<font color="red">${message}</font>
	</h3>
</form>
</body>
</html>