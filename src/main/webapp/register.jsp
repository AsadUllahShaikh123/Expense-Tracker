<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="components/allCss.jsp"%>
<style>
.shadow {
	box-shadow: rgba(0, 0, 0, 0.35) 0px 5px 15px;
}
</style>
</head>
<body class="bg-light">
	<%@include file="components/navbar.jsp"%>
	<div class="container p-5">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card shadow">
					<div class="card-header">
						<p class="text-center fs-3 fw-bold">Register Page</p>
					</div>
					<div class="card-body">
						<form action="userRegister" method="post">
							<div class="mb-3">
								<label class="fw-bold">Enter Full Name</label><input type="text" name="fullName"
									class="form-control" required/>
							</div>
							<div class="mb-3">
								<label class="fw-bold">Email</label><input type="email" name="email"
									class="form-control" required/>
							</div>
							<div class="mb-3">
								<label class="fw-bold">Password</label><input type="password" name="password"
									class="form-control" required/>
							</div>
							<div class="mb-3">
								<label class="fw-bold">About</label><input type="text" name="about"
									class="form-control" required/>
							</div>

							<button class="btn btn-success col-md-12 mt-5 mb-3">Register</button>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>