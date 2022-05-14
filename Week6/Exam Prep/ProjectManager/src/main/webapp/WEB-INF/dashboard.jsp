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
<title>Project Manager</title>
</head>
<body>

	<div class="container">
		<h1>
			Welcome,
			<c:out value="${loggedInUser.firstName}" />
		</h1>
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark p-2 mb-3">
			<a class="navbar-brand" href="#">Project Manager</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
				<div class="navbar-nav">
					<a class="nav-item nav-link active" href="/dashboard">Home</a> <a
						class="nav-item nav-link" href="/newProject">New Project</a> <a
						class="nav-item nav-link" href="/logout">Logout</a>
				</div>
			</div>
		</nav>

		<div class="row">

			<h3>All Projects</h3>
			<table class="table">
				<thead>
					<tr>
						<th>Project</th>
						<th>Team Lead</th>
						<th>Due Date</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${unassignedProjects}" var="project">
						<tr>
							<!-- if tag to see if user is a project lead -->
							<c:if test="${project.lead.id!=loggedInUser.id}">
								<td><a href="/projectDetails/${project.id}">${project.title}
								</a></td>
								<td><c:out value="${project.lead.firstName}" /></td>
								<td><fmt:formatDate type="date" value="${project.dueDate}"
										dateStyle="medium" /></td>

								<td><a href="/joinProject/${project.id}">Join Team</a></td>
							</c:if>
					</c:forEach>

				</tbody>
			</table>


			<h3>Your Projects</h3>
			<table class="table">
				<thead>
					<tr>
						<th>Project</th>
						<th>Team Lead</th>
						<th>Due Date</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${assignedProjects}" var="project">
						<tr>
							<td><a href="/projectDetails/${project.id}">${project.title}
							</a></td>
							<td>${project.lead.firstName}</td>
							<td><fmt:formatDate type="date" value="${project.dueDate}"
									dateStyle="medium" /></td>
							<c:if test="${project.lead.id==loggedInUser.id}">
								<td><a href="/editProject/${project.id}">Edit Project</a></td>
							</c:if>
							<c:if test="${project.lead.id!=loggedInUser.id}">
								<td><a href="/leaveProject/${project.id}">Leave team</a></td>
							</c:if>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>


	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>