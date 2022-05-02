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
<title>Languages</title>
</head>
<body>
	<h1>Computer Programming Languages</h1>

	<div>
		<table class="table table-info table-striped">
			<thead>
				<tr>
					<th>Name</th>
					<th>Creator</th>
					<th>Version</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${languages}" var="language">
					<tr>
						<td><a href="/languages/${language.id}"><c:out
									value="${language.name}"></c:out></a></td>
						<td><c:out value="${language.creator}"></c:out></td>
						<td><c:out value="${language.currentVersion}"></c:out></td>
						<td class="d-inline-block"><a href="/languages/${language.id}/edit">Edit</a>
							<form:form action="/languages/${language.id}/delete" method="delete">
								<button class="btn btn-link">Delete</button>
							</form:form></td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="col-6 offset-md-3">
		<h3>Add a Language:</h3>
		<form:form action="/languages" method="post"
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