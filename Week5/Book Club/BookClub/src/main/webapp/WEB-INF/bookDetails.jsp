<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- My own local CSS -->
<link rel="stylesheet" href="/css/style.css" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${book.title}</title>
</head>
<body>

	<div class="container">
		<a href="/dashboard">Home</a> <a href="/new">Add a Book</a> <a href="/logout">Logout</a>

		<h1>Book Details</h1>
		<p>Title: ${book.title}</p>
		<p>Author: ${book.author}</p>
		<p>Reader Thoughts: ${book.thoughts}</p>
		<h4>Created by:</h4>
		<p>${book.user.name}</p>

	<c:if test="${book.user.id==loggedInUser.id}">
	<form:form action="delete">
	<button><a href="/edit/${book.id}">Edit</a></button>
	<button><a href="/delete/${book.id}">Delete</a></button>
	</form:form>
	</c:if>
	
		
	</div>

</body>
</html>