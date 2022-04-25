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
<title>Omikuji Form</title>
</head>
<body>
	<div class="card col-6 offset-3">
		<h1 class="card-header text-center">Send an Omikuji!</h1>
		<form class="card-body" action="/processForm" method="post">
			<label class="form-label p-2">Pick any number from 5 to 25</label>
			<input class="form-control p-2" type="number" name="number" min="5" max="25">
	        <label class="form-label p-2">Enter the name of any city:</label>
	        <input class="form-control p-2" type="text" name="city">
	         <label class="form-label p-2">Enter the name of any real person:</label>
	        <input class="form-control p-2" type="text" name="person">
	        <label class="form-label p-2">Enter professional endeavor or hobby:</label>
	        <input class="form-control p-2" type="text" name="activity">
	        <label class="form-label p-2">Enter any type of living thing:</label>
	        <input class="form-control p-2" type="text" name="livingThing">
	        <label class="form-label p-2">Say something nice to someone:</label>
	        <textarea class="form-control p-2" name="geniality" rows="5" cols="10"></textarea>
	        <p class="p-2">Send and show a friend.</p>
	        <input class="btn btn-primary" type="submit" value="Send">
	    </form>
    </div>

<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>