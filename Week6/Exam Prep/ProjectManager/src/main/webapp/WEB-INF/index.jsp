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
		<h1 class="text-center">Project Manager</h1>
		<p class="text-center">A place for teams to manage projects.</p>

		<div class="row">
			<div class="col-5 mx-auto card">
				<h3 class="card-header p-3">Register</h3>
				<form:form class="card-body" action="/register" method="post"
					modelAttribute="newUser">
					<div class="form-floating mb-3">
						<form:input type="text" class="form-control" path="firstName"
							placeholder="First Name" />
						<form:label path="firstName">First Name</form:label>
						<form:errors class="text-danger" path="firstName" />
					</div>
					<div class="form-floating mb-3">
						<form:input type="text" class="form-control" path="lastName"
							placeholder="Last Name" />
						<form:label path="lastName">Last Name</form:label>
						<form:errors class="text-danger" path="lastName" />
					</div>
					<div class="form-floating mb-3">
						<form:input type="email" class="form-control" path="email"
							placeholder="email@example.com" />
						<form:label path="email">Email</form:label>
						<form:errors class="text-danger" path="email" />
					</div>
					<div class="form-floating mb-3">
						<form:input type="password" class="form-control" path="password"
							placeholder="Password" />
						<form:label path="password">Password</form:label>
						<form:errors class="text-danger" path="password" />
					</div>
					<div class="form-floating mb-3">
						<form:input type="password" class="form-control" path="confirm"
							placeholder="Confirm Password" />
						<form:label path="confirm">Confirm Password</form:label>
						<form:errors class="text-danger" path="confirm" />
					</div>
					<button type="submit" class="btn btn-primary mx-auto">Submit</button>
				</form:form>
			</div>

			<div class="col-5 mx-auto card">
				<h3 class="card-header p-3">Login</h3>
				<form:form class="card-body" action="/login" method="post"
					modelAttribute="newLogin">
					<div class="form-floating mb-3">
						<form:input type="email" class="form-control" path="email"
							placeholder="email@example.com" />
						<form:label path="email">Email</form:label>
						<form:errors class="text-danger" path="email" />
					</div>
					<div class="form-floating mb-3">
						<form:input type="password" class="form-control" path="password"
							placeholder="Password" />
						<form:label path="password">Password</form:label>
						<form:errors class="text-danger" path="password" />
					</div>
					<button type="submit" class="btn btn-primary mx-auto">Submit</button>
				</form:form>
			</div>
		</div>
	</div>





	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>