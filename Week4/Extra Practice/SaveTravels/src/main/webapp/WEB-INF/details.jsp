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
<title>Expense Details</title>
</head>
<body>
	<div class="col-6 p-2 offset-md-3 card">
		<h1 class="card-title">Expense Details</h1>
		<div class="card-body">
			<h2>${expense.expense}</h2>
			<p>Vendor: ${expense.vendor}</p>
			<p>Amount: ${expense.amount}</p>
			<p>Description: ${expense.description}</p>
			<a href="/edit/${expense.id}" class="card-link">Edit</a>
			<a href="/" class="card-link">Dashboard</a>
			
		</div>
	</div>



	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></sc
</body>
</html>