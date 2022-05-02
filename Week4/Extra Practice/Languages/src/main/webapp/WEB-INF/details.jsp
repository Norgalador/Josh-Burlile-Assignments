<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- My own local CSS -->
<link rel="stylesheet" href="/css/style.css" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${language.name}</title>
</head>
<body>
	<h1>Computer Programming Languages</h1>

	<div class="card card-info card-header">
		<h2>${language.name}</h2>
	</div>
	<div class="card-body">
		<p>Creator: ${language.creator}</p>
		<p>Current Version: ${language.currentVersion}</p>
		<a href="/languages/${language.id}/edit">Edit</a>
		<form:form action="/languages/${language.id}/delete" method="delete">
			<button class="btn btn-link">Delete</button>
		</form:form>
	</div>

	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>