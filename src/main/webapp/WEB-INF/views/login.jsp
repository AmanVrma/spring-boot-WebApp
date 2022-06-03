<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>first web Application</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>
<div class="container-sm">
<h1 class="text-center">Hello To The TODO-List</h1>
<h3 class="text-center">Log In</h3>
<form method="post">
	<div class="row mb-3 col-md-4 container-sm " >
	<label class="form-label col-sm-2 col-form-label">Name:</label>
	<input type="text" name="name" class="form-control">
	</div>
	<div class="row mb-3 col-md-4 container-sm">
	<label class="form-label">Password</label>
	<input type="password" name="password" class="form-control">
	</div>
	<button type="submit" class="btn btn-primary" value="clck me">Login</button>
	
	<h3>
	<font color="red">${message}</font>
	</h3>
</form>
</div>
</body>
</html>
