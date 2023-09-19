package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ExpenseDao;
import com.db.HibernateUtils;
import com.entity.Expense;
import com.entity.User;

/**
 * Servlet implementation class AddExpense
 */
@WebServlet("/add_expense")
public class AddExpense extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String description = request.getParameter("description");
		String price = request.getParameter("price");

		HttpSession session = request.getSession();
		User user =(User) session.getAttribute("loginUser");
		Expense expense = new Expense(title,date,time,description,price,user);
		
		ExpenseDao dao = new ExpenseDao(HibernateUtils.getSessionFactory());
		boolean saved = dao.saveExpense(expense);
		
		if(saved) {
			response.sendRedirect("user/add_expense.jsp");
			session.setAttribute("succMsg", "Expense Added Successfully");
		}else {
			response.sendRedirect("user/add_expense.jsp");
			session.setAttribute("errorMsg", "something wrong on server");
		}
	}

}
