<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- My own local CSS -->
<link rel="stylesheet" href="/css/style.css" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Club</title>
</head>
<body>

	<div class="container">
		<h1>Edit a book</h1>
		<nav class="navbar navbar-expand-lg p-2 mb-3">
			<a class="navbar-brand" href="#">Book Club</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
				<div class="navbar-nav">
					<a class="nav-item nav-link active" href="#">Home</a> <a
						class="nav-item nav-link" href="/new">Add a Book</a> 
						<a class="nav-item nav-link" href="/bookmarket">Book Market</a>
						<a class="nav-item nav-link" href="/logout">Logout</a>
				</div>
			</div>
		</nav>
		<form:form action="/update/${editBook.id}" method="put"
			modelAttribute="editBook">
			<div class="form-group">
				<form:label path="title">Book Title</form:label>
				<form:errors class="text-danger" path="title" />
				<form:input class="form-control" path="title" />
			</div>
			<div class="form-group">
				<form:label path="author">Author</form:label>
				<form:errors class="text-danger" path="author" />
				<form:input class="form-control" path="author" />
			</div>
			<div class="form-group">
				<form:label path="thoughts">My Thoughts</form:label>
				<form:errors class="text-danger" path="thoughts" />
				<form:input class="form-control" path="thoughts" />
			</div>
				<!-- Hidden Input for userId -->
				<form:input type="hidden" value="${loggedInUser.id}" path="user" />
			
			
			<input type="submit" class="btn btn-primary" value="Submit" />
		</form:form>

	</div>


	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>