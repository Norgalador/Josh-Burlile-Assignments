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
<title>Category Page</title>
</head>
<body>

	<div class="container">

		<h1 class="">${category.name}</h1>
		<a href="/">Home</a>

		<h3>Products:</h3>
		<c:forEach var="product" items="${addedProducts}">
			<c:out value="${product.name}" />
		</c:forEach>

		<hr>
		<form:form action="/category/{id}/addProduct" method="post"
			modelAttribute="unaddedProducts">
			<div class="form-group">
				<form:label path="product">Add Product:</form:label>
				<form:errors class="text-danger" path="product" />
				<form:select class="form-control" path="product" />
				<c:forEach var="product" items="${unaddedProducts}">
					<form:option value="${product.id}">${product.name}</form:option>
				</c:forEach>
			</div>
			<!-- Hidden Input for userId -->
			<%-- <form:input type="hidden" value="${loggedInUser.id}" path="user" /> --%>


			<input type="submit" class="btn btn-primary" value="Add" />
		</form:form>

	</div>


	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>