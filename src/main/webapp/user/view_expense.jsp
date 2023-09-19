<%@page import="com.entity.Expense"%>
<%@page import="java.util.List"%>
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
<body>
	<c:if test="${ empty loginUser }">
		<c:redirect url="../login.jsp"></c:redirect>
	</c:if>
	<%@include file="../components/navbar.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="card shadow mt-3">
					<div class="card-header text-center">
						<p class="fs-3 fw-bold">Add Expenses</p>
					</div>
					<div class="card-body">
					
						<table class="table">
							<thead>
								<tr>
									<th scope="col">Title</th>
									<th scope="col">Description</th>
									<th scope="col">Date</th>
									<th scope="col">Time</th>
									<th scope="col">Price</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>
								<%
									User user = (User)session.getAttribute("loginUser");
									ExpenseDao dao = new ExpenseDao(HibernateUtils.getSessionFactory());
									
									List<Expense> expenses = dao.getAllExpensesByUser(user);
									
									for(Expense expense : expenses){
										
								%>
									<tr>
										<th scope="row"><%= expense.getTitle() %></th>
										<td><%=expense.getDescription() %></td>
										<td scope="col"><%= expense.getDate() %></td>
										<td><%=expense.getTime() %></td>
										<td><%=expense.getPrice() %></td>
										<td>
											<a href="edit.jsp?id=<%= expense.getId() %>" class="btn btn-primary btn-sm me-1">Edit</a>
											<a href="delete.jsp?id=<%=expense.getId() %>" class="btn btn-danger btn-sm me-1">Delete</a>
										</td>
									</tr>
								<% } %>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>