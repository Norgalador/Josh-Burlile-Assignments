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
<title>New Category</title>
</head>
<body>

<div class="container">
<a href="/">Home</a>

<h1 class="">New Category</h1>
<form:form action="/category/create" method="post"
			modelAttribute="newCategory">
			<div class="form-group">
				<form:label path="name">Name:</form:label>
				<form:errors class="text-danger" path="name" />
				<form:input class="form-control" path="name" />
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