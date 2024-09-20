<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<title>Search for results!</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body class="bg-light">
	<nav class="navbar navbar-dark bg-dark">
		<h5>
			<span class="text-white">Welcome, User</span>&nbsp;
			<button class='btn btn-primary'><a href="/login" class="text-white">Log out</a></button>
		<!--	<button class='btn btn-primary'>Log out</button>    -->
		</h5>
	</nav>
	<div class="container mt-5">
		<div class="row">
			<div class="col-md-6 mx-auto">
				<form action="/addnewbook" method="post">
				<input type="hidden" id="id" value="${book.id}"/>
					<div class="form-group">
						<label for="book_code">BookCode</label> <input class="form-control"
							id="book_code" type="text" name="book_code" value="${ book.book_code }" required />
					</div>
					<div class="form-group">
						<label for="book_name">Book Name</label> <input
							class="form-control" id="book_name" type="text" name="book_name"
							value="${ book.book_name }" required />
					</div>
					<div class="form-group">
						<label for="author">Author</label> <select class="form-control"
						id="author_name" name="author_name">
							<option selected value="${ book.author_name }"></option>
							
						</select>
					</div>
					<div class="form-group">
						<label for="date">Date: </label> <input class="form-control"
							id="added_date" type="text" name="added_date"
							value="${book.added_date}" readonly required />
					</div>
					<div class="form-group mt-3">
						<div class="row">
							<div class="col-md-6">
								
								<button class="btn btn-primary">Edit</button>
								<button type="button" class="btn btn-danger"><a href="/dashboard/" class="text-white">Cancel</button>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>