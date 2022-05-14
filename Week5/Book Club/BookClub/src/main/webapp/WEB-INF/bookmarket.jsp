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
		<h1>
			Welcome to the Book Market,
			<c:out value="${loggedInUser.name}" />
		</h1>
		<nav class="navbar navbar-expand-lg p-2 mb-3">
			<a class="navbar-brand" href="#">Book Club</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
				<div class="navbar-nav">
					<a class="nav-item nav-link active" href="/dashboard">Home</a> <a
						class="nav-item nav-link" href="/new">Add a Book</a> <a
						class="nav-item nav-link" href="/logout">Logout</a>
				</div>
			</div>
		</nav>

		<table class="table">
			<thead>
				<tr>
					<th>Title</th>
					<th>Author</th>
					<th>Owner</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${books}" var="book">
					<tr>
						<td><a href="/books/bookDetails/${book.id}">${book.title}
						</a></td>
						<td>${book.author}</td>
						<td>${book.user.name}</td>
						<c:if test = "${book.user.id==user.id}">
						<td><a href="/edit/${book.id}">edit</a> <a href="/delete/${book.id}">delete</a></td>
						</c:if>
						<c:if test = "${book.user.id!=user.id}">
			       <td><a href="/bookmarket/${book.id}">borrow</a></td>
			    		</c:if>
			    	</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<p>Books I've borrowed:</p>
		<table>
	<thead>
		<tr>
			<td>Title</td>
			<td>Author Name</td>
			<td>Owner</td>
			<td>Actions</td>
		</tr>
	</thead>
    <tbody>
		<c:forEach var="book" items="${myBooks}">
			<tr>
				<td><a href="/books/bookDetails/${book.id}"><c:out value="${book.title}"></c:out></a></td>
				<td><c:out value="${book.author}"></c:out></td>
				<td><c:out value="${book.user.userName}"></c:out></td>
				<td><a href="/bookmarket/return/${book.id}">Return</a></td>
			</tr>	
		</c:forEach>
    </tbody>
</table>

	</div>


	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>