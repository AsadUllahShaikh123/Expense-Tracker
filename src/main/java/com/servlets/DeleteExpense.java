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

/**
 * Servlet implementation class DeleteExpense
 */
@WebServlet("/delete_expense")
public class DeleteExpense extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		ExpenseDao dao = new ExpenseDao(HibernateUtils.getSessionFactory());
		boolean deleted = dao.deleteExpense(id);
		HttpSession session = request.getSession();
		if(deleted) {
			session.setAttribute("succMsg", "Expense Deleted Successfully");
			response.sendRedirect("user/view_expense.jsp");
		}else {
			session.setAttribute("errorMsg", "something wrong on server");
			response.sendRedirect("user/view_expense.jsp");
		}
		
		
		
		
		
	}
	
	
	

}
