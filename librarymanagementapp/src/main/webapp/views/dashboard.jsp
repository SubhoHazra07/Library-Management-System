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
	<nav class="navbar navbar-dark bg-dark shadow">
		<h5>
			<span class="text-white">Welcome, ${ username }</span>&nbsp;
			<button class='btn btn-primary'><a href="/login" class="text-white">Log out</a></button>
		</h5>
	</nav>
	<div class="container mt-5">
		<div class="row">
			<div class="col-md-10 text-center">
				<h3 class="text-dark">Book Listing</h3>
			</div>
			<div class="col-md-2 text-center">
				<button class="btn btn-outline-primary shadow"><a href="/addnewbook/" >Add a Book</a></button>
			</div>
		</div>
	</div>
	<div class="container mt-5">
		<div class="row">
			<table class="table table-bordered shadow text-center">
				<thead>
					<tr>
						<td>Book Code</td>
						<td>Book Name</td>
						<td>Author</td>
						<td>Data Added</td>
						<td>Actions</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ books }" var="p">
						<tr>
							<td>${p.book_code }</td>
							<td>${p.book_name }</td>
							<td>${p.author_name }</td>
							<td>${p.added_date }</td>
							<td>
								<button class="btn btn-success"><a href="/editbook/${p.id }" class="text-white">Edit</a></button>
								<button class="btn btn-danger"><a href="/deletebook/${p.id }" class="text-white">Delete</a></button>
							</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>