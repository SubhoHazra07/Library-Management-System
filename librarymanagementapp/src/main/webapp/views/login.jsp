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
</head>
<body class="bg-light">
	<nav class="navbar navbar-dark bg-dark shadow">
		<div class="container">
			<div class="row mx-auto text-white">
				<h5>Login Page</h5>
			</div>
		</div>
	</nav>

	<div class="container mt-5">

		<div class="col-md-6 mx-auto">
			<div class="row">
				<div class="row">
					<h6>Enter login details: </h6>
				</div>
			</div>
			
			<form action="login" method="post">
				
				<div class="form-group">
					<label for="username">Username</label> <input class="form-control"
						id="username" type="text" name="username" required />
				</div>
				<div class="form-group">
					<label for="password">Password</label> <input class="form-control"
						id="password" type="password" name="password" required />
				</div>
				<div class="form-group mt-3">
					<h6 class="text-danger">${ errormsg }</h6>
					<button class="btn btn-outline-primary">Login</button>
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