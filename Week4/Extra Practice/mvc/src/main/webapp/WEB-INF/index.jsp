<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- My own local CSS -->
<link rel="stylesheet" href="/css/style.css" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Library</title>
</head>
<body>

	<h1>Book Library</h1>

	<table class="table table-dark">
		<thead>
			<tr>
				<th>Title</th>
				<th>Description</th>
				<th>Number of Pages</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${allBooks}" var="book">
				<tr>
					<td><a href="/books/${book.id}"><c:out
								value="${book.title}"></c:out></a></td>
					<td><c:out value="${book.description}"></c:out></td>
					<td><c:out value="${book.numberOfPages}"></c:out></td>
				</tr>

			</c:forEach>
		</tbody>
	</table>

	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>