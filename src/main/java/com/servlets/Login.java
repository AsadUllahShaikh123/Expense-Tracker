package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.db.HibernateUtils;
import com.entity.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserDao dao = new UserDao(HibernateUtils.getSessionFactory());
		
		User user = dao.userLogin(email, password);
		HttpSession session = request.getSession();
		if(user == null) {
			session.setAttribute("errorMsg","Incorrect email or password" );
			response.sendRedirect("login.jsp");
		}else {
			response.sendRedirect("user/home.jsp");
		}
		
	}

}
