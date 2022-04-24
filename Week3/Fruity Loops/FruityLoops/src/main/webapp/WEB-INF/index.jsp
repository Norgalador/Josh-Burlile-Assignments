<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- My own local CSS -->
<link rel="stylesheet" href="/css/style.css"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Josh's Exotic Fruity Loops Store</title>
</head>
<body>
	<div class="col-4 offset-4 p-2">
		<h2 class="bg-success bg-opacity-25 text-white text-center p-3">Fun Tropical Fruit Store</h2>
		<table class="table table-success table-striped table-bordered table-hover">
			<tbody>
				<tr class="thead-light">
					<th>Name</th>
					<th>Price</th>
				</tr>
				<c:forEach var="fruit" items="${fruitsFromMyController}">
					<tr>
						<td><c:out value="${fruit.name}"/></td>
						<td>$<c:out value="${fruit.price}"/></td>
					</tr>	
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>