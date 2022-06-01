<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Todo's for ${name }</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<h1>Your Todo's</h1>
		<table class="table">
			<caption>Todo's</caption>
			<thead>
				<tr>
					<td>Description</td>
					<td>Target Date</td>
					<td>is it done?</td>
					<td></td>
					<td>Delete</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todos}" var="todo">
					<tr>

						<td>${todo.desc }</td>
						<td><fmt:formatDate value="${todo.targetDate}" pattern="dd/MM/yyyy"/></td>
						<td>${todo.done }</td>
						<td><a type="button" class="btn btn-success"
							href="/update-todo?id=${todo.id}">UPDATE</a></td>
						<td><a type="button" class="btn btn-warning"
							href="/delete-todo?id=${todo.id}">DELETE</a></td>

					</tr>

				</c:forEach>


			</tbody>

		</table>

		<br> <br>
		<div>
			<a class="button" href="/add-todo">Add a Todo</a>
		</div>
	</div>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>