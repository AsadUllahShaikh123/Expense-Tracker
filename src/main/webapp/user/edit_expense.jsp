<%@page import="com.entity.Expense"%>
<%@page import="com.db.HibernateUtils"%>
<%@page import="com.dao.ExpenseDao"%>
<%@page import="com.entity.User"%>
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
<style>
.shadow {
	box-shadow: rgba(0, 0, 0, 0.35) 0px 5px 15px;
}
</style>
<%@include file="../components/allCss.jsp"%>
</head>
<body class="bg-light">
	<%@include file="../components/navbar.jsp"%>
	<div class="conatiner p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card shadow">
					<div class="card-header fs-4 fw-bold text-center">Edit Expense
					</div>
					<c:if test="${ not empty succMsg }">
						<p class="text-center fs-3 text-success">${ succMsg }</p>
						<c:remove var="succMsg" scope="session" />
					</c:if>
					<c:if test="${ not empty errorMsg }">
						<p class="text-center fs-3 text-danger">${ errorMsg }</p>
						<c:remove var="errorMsg" scope="session" />
					</c:if>
					<%
						int id = Integer.parseInt(request.getParameter("id"));
						ExpenseDao dao = new ExpenseDao(HibernateUtils.getSessionFactory());
						Expense expense = dao.getExpenseById(id);
					%>
					<div class="card-body">
						<form action="../edit_expense" method="post">
							<input type="hidden" name="id" value="<%= id%>"/>
							<div class="mb-3">
								<label>Title</label> <input type="text" name="title"
									class="form-control" value="<%= expense.getTitle()%>"/>
							</div>
							<div class="mb-3">
								<label>Date</label> <input type="date" name="date"
									class="form-control" value="<%= expense.getDate() %>" />
							</div>
							<div class="mb-3">
								<label>Time</label> <input type="time" name="time" value="<%=expense.getTime() %>" class="form-control" />
							</div>
							<div class="mb-3">
								<label>Description</label> <input type="text" name="description"
									class="form-control" value="<%= expense.getDescription() %>" />
							</div>
							<div class="mb-3">
								<label>Price</label> <input type="text" name="price"
									class="form-control" value="<%= expense.getPrice()%>"/>
							</div>
							<button class="btn btn-success col-md-12">Update</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>