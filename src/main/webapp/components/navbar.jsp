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
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-success">
		<div class="container-fluid">
			<c:if test="${ not empty loginUser }">
				<a class="navbar-brand" href="index.jsp"><i
				class="fa-solid fa-money-check"></i> Expense Tracker</a>
			</c:if>
			<c:if test="${ empty loginUser }">
				<a class="navbar-brand" href="index.jsp"><i
				class="fa-solid fa-money-check"></i> Expense Tracker</a>
			</c:if>
			
			
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<c:if test="${ not empty loginUser }">
						<li class="nav-item"><a class="nav-link active" href="add_expense.jsp">
								<i class="fa-solid fa-plus"></i> Add Expense
						</a></li>
						<li class="nav-item"><a class="nav-link active"
							href="view_expense.jsp"><i class="fa-solid fa-list-ul"></i>
								View Expense</a></li>
					</c:if>
				</ul>
				<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
					<c:if test="${ not empty loginUser }">
						<li class="nav-item"><a class="nav-link active" href="#">
								<i class="fa-solid fa-circle-user"></i> ${ loginUser.name }
						</a></li>
						<li class="nav-item"><a class="nav-link active"
							href="../logout"><i class="fa-solid fa-right-to-bracket "></i>
								Logout</a></li>
					</c:if>
					<c:if test="${ empty loginUser }">

						<li class="nav-item"><a class="nav-link active"
							href="login.jsp"><i class="fa-solid fa-right-to-bracket "></i>
								Login</a></li>
						<li class="nav-item"><a class="nav-link active"
							href="register.jsp"><i class="fa-solid fa-user-plus fa-fade"></i>
								Register</a></li>
					</c:if>
				</ul>

			</div>
		</div>
	</nav>
</body>
</html>