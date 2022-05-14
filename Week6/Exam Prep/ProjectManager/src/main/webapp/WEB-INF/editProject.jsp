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
<title>Edit a Task</title>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="card">
				<div class="card-body">
					<h1 class="card-title">Edit a Project</h1>
					<form:form action="/updateProject/${updateProject.id}" method="put"
						modelAttribute="updateProject">
						<div class="form-floating mb-3">
							<form:input type="text" class="form-control" path="title"
								placeholder="Project Title" />
							<form:label path="title">Project Title</form:label>
							<form:errors class="text-danger" path="title" />
						</div>
						<div class="form-floating mb-3">
							<form:textarea type="text" class="form-control"
								path="description" placeholder="write a description" />
							<form:label path="description">Project Description</form:label>
							<form:errors class="text-danger" path="description" />
						</div>
						<div class="form-floating mb-3">
							<form:input type="date" class="form-control" path="dueDate"
								placeholder="Due Date" />
							<form:label path="dueDate">Due Date</form:label>
							<form:errors class="text-danger" path="dueDate" />
						</div>
						<!-- Hidden Input for userId -->
						<form:input type="hidden" value="${loggedInUser.id}" path="lead" />

						<a href="/dashboard" role="button" class="btn btn-primary">Cancel</a>
						<input type="submit" class="btn btn-primary" value="Submit" />
					</form:form>
				</div>
			</div>
		</div>
	</div>


	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>