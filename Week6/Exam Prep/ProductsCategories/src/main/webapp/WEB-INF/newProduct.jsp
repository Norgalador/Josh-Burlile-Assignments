<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- My own local CSS -->
<link rel="stylesheet" href="/css/style.css"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Product</title>
</head>
<body>

<div class="container">
<a href="/">Home</a>

<h1 class="">New Product</h1>
<form:form action="/product/create" method="post"
			modelAttribute="newProduct">
			<div class="form-group">
				<form:label path="name">Name:</form:label>
				<form:errors class="text-danger" path="name" />
				<form:input class="form-control" path="name" />
			</div>
			<div class="form-group">
				<form:label path="description">Description:</form:label>
				<form:errors class="text-danger" path="description" />
				<form:input class="form-control" path="description" />
			</div>
			<div class="form-group">
				<form:label path="price">Price:</form:label>
				<form:errors class="text-danger" path="price" />
				<form:input class="form-control" path="price" />
			</div>
				<!-- Hidden Input for userId -->
				<%-- <form:input type="hidden" value="${loggedInUser.id}" path="user" /> --%>
			
			
			<input type="submit" class="btn btn-primary" value="Submit" />
		</form:form>
		
</div>


<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>