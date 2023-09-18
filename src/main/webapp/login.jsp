<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- By Default Expression Language is ignored in JSP  --%>
<%@ page isELIgnored="false"%>
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
						<p class="text-center fs-3 fw-bold">Login</p>
					</div>
					<c:if test="${ not empty msg }">
						<p class="text-center fs-3 fw-bold text-success">${ msg }</p>
						<c:remove var="msg" scope="session"/>
					</c:if>
					<c:if test="${ not empty errorMsg }">
						<p class="text-center fs-3 text-danger">${ errorMsg }</p>
						<c:remove var="errorMsg" scope="session"/>
					</c:if>
					<div class="card-body">
						<form action="login" method="post">

							<div class="mb-3">
								<label class="fw-bold">Email</label><input type="email"
									name="email" class="form-control" />
							</div>
							<div class="mb-3">
								<label class="fw-bold">Password</label><input type="password"
									name="password" class="form-control" />
							</div>
							<button class="btn btn-success col-md-12 mt-5 mb-3">Register</button>
							<div class="text-center">
								Don't have an account <a href="register.jsp "
									class="text-decoration-none">create one</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>