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

	<div class="col-6 offset-md-3">
		<h3>${language.name}</h3>
		<form:form action="/languages/${language.id}" method="put"
			modelAttribute="language">
			<div class=mt-3 class="form-group">
				<form:label path="name">Language Name:</form:label>
				<form:errors class="text-danger" path="name" />
				<form:input type="text" class="form-control" path="name"
					placeholder="Java" />
			</div>
			<div class="mt-3 form-group">
				<form:label path="creator">Creator:</form:label>
				<form:errors class="text-danger" path="creator" />
				<form:input type="text" class="form-control" path="creator" />
			</div>
			<div class="mt-3 form-group">
				<form:label path="currentVersion">Current Version:</form:label>
				<form:errors class="text-danger" path="currentVersion" />
				<form:input type="text" class="form-control" path="currentVersion" />
			</div>
			<button type="submit" class="mt-3 btn btn-primary">Submit</button>
		</form:form>
	</div>




	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>