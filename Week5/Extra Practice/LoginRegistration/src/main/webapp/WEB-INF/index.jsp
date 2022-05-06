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
<title>Login & Registration</title>
</head>
<body class="container">


	<h1>Welcome!</h1>
	<p>Join our growing community!</p>

	<div class="row">
		<div class="col-8 offset-2 card">
			<h3 class="card-header p-3">Register</h3>
			<form:form class="card-body" action="/register" method="post" modelAttribute="newUser">
				<div class="form-group p-3">
					<form:label path="userName">User Name</form:label>
					<form:errors class="text-danger" path="userName" />
					<form:input type="text" class="form-control" path="userName"
						placeholder="Enter username" />
				</div>
				<div class="form-group p-3">
					<form:label path="email">Email address</form:label>
					<form:errors class="text-danger" path="email" />
					<form:input type="email" class="form-control" path="email"
						placeholder="Enter email" />
				</div>
				<div class="form-group p-3">
					<form:label path="password">Password</form:label>
					<form:errors class="text-danger" path="password" />
					<form:input type="password" class="form-control" path="password"
						placeholder="Password" />
				</div>
				<div class="form-group p-3">
					<form:label path="confirm">Confirm Password</form:label>
					<form:errors class="text-danger" path="confirm" />
					<form:input type="password" class="form-control" path="confirm"
						placeholder="Confirm Password" />
				</div>
				<button type="submit" class="btn btn-primary m-2">Submit</button>
			</form:form>
		</div>
	</div>

	<div class="row">
		<div class="col-8 offset-2 card">
			<h3 class="card-header p-3">Login</h3>
			<form:form class="card-body" action="/login" method="post" modelAttribute="newLogin">
				<div class="form-group p-3">
					<form:label path="email">Email address</form:label>
					<form:errors class="text-danger" path="email" />
					<form:input type="email" class="form-control" path="email"
						placeholder="Enter email" />
				</div>
				<div class="form-group p-3">
					<form:label path="password">Password</form:label>
					<form:errors class="text-danger" path="password" />
					<form:input type="password" class="form-control" path="password"
						placeholder="Password" />
				</div>
				<button type="submit" class="btn btn-primary m-2">Submit</button>
			</form:form>
		</div>
	</div>

	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>