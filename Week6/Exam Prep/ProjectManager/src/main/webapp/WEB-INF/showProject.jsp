<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- My own local CSS -->
<link rel="stylesheet" href="/css/style.css" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${book.title}</title>
</head>
<body>

	<div class="container">
		<nav class="navbar mx-auto">
			<h1 class="">Project Details</h1>
			<a class="nav-link" href="/dashboard">Back to Dashboard</a>
		</nav>
		<div class="card col-md-6 mx-auto">
			<h4 class="card-header">Project: ${project.title}</h4>
			<div class="card-body">
				<p class="card-text">Description: ${project.description}</p>
				<p class="card-text">
					Due Date:
					<fmt:formatDate type="date" value="${project.dueDate}"
						dateStyle="medium" />
				</p>
				<div class="btn-group">
				<c:if test="${project.lead.id==loggedInUser.id}">
				 <a class="btn btn-primary m-2" role="button" href="/editProject/${project.id}">Edit Project</a>
				<form:form method="delete" action="/deleteProject/${project.id}">
				<button class="btn btn-primary m-2">Delete Project</button>
				</form:form>
				</c:if>
				</div>
				
			</div>
		</div>
	</div>

</body>
</html>