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
<title>Home Page</title>
</head>
<body>
<div class="container">
<h1 class="text-center">Home Page</h1>

<a href="/new/product">New Product</a>
<br>
<a href="/new/category">New Category</a>

<table class="table col-6">
			<thead>
				<tr>
					<th>Products</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${products}" var="product">
					<tr>
						<td><a href="/product/productDetails/${product.id}">${product.name}</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

<table class="table col-6">
			<thead>
				<tr>
					<th>Categories</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${categories}" var="category">
					<tr>
						<td><a href="/category/categoryDetails/${category.id}">${category.name}</a></td>
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