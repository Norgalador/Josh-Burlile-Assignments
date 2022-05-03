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
<title>New Ninja</title>
</head>
<body>

	<div class="col-6 offset-md-3">
		<h3>Add a Ninja:</h3>
		<form:form action="/ninjas" method="post" modelAttribute="ninja">
			<div class=mt-3 class="form-group">
				<form:label path="dojo">Dojo:</form:label>
				<form:errors class="text-danger" path="dojo"/>
				<form:select class="form-control" path="dojo">
					<c:forEach var="eachDojo" items="${dojos}">
						<option value="${eachDojo.id}"><c:out value="${eachDojo.name}"/></option>
					</c:forEach>
				</form:select>
			</div>
			<div class=mt-3 class="form-group">
				<form:label path="firstName">First Name:</form:label>
				<form:errors class="text-danger" path="firstName" />
				<form:input type="text" class="form-control" path="firstName"/>
			</div>
			<div class=mt-3 class="form-group">
				<form:label path="lastName">Last Name:</form:label>
				<form:errors class="text-danger" path="lastName" />
				<form:input type="text" class="form-control" path="lastName"/>
			</div>
			<div class=mt-3 class="form-group">
				<form:label path="age">Age:</form:label>
				<form:errors class="text-danger" path="age" />
				<form:input type="text" class="form-control" path="age"/>
			</div>
			<button type="submit" class="mt-3 btn btn-primary">Create</button>
		</form:form>
	</div>



<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>