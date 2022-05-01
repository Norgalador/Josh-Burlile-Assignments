<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- My own local CSS -->
<link rel="stylesheet" href="/css/style.css" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit an Expense</title>
</head>
<body>
	<div class="col-6 offset-md-3">
		<h3>Edit an expense:</h3>
		<form:form action="/update/${editExpense.id}" method="put"
			modelAttribute="editExpense">
			<div class=mt-3 class="form-group">
				<form:label path="expense">Expense Name:</form:label>
				<form:errors class="text-danger" path="expense" />
				<form:input type="text" class="form-control" path="expense"
					placeholder="sunglasses" />
			</div>
			<div class="mt-3 form-group">
				<form:label path="vendor">Vendor:</form:label>
				<form:errors path="vendor" />
				<form:input type="text" class="form-control" path="vendor" />
			</div>
			<div class="mt-3 form-group">
				<form:label path="amount">Amount:</form:label>
				<form:errors path="amount" />
				<form:input type="text" class="form-control" path="amount" />
			</div>
			<div class="mt-3 form-group">
				<form:label path="description">Description:</form:label>
				<form:errors path="description" />
				<form:textarea class="form-control" path="description" rows="3"></form:textarea>
			</div>
			<button type="submit" class="mt-3 btn btn-primary">Update</button>
		</form:form>
	</div>



	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></sc
</body>
</html>