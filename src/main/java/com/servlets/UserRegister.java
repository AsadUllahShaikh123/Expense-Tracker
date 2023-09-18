package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.RegisterDao;
import com.db.HibernateUtils;
import com.entity.User;

@WebServlet("/userRegister")
public class UserRegister extends HttpServlet {
	

	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("fullName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String about = request.getParameter("about");
		
		User user = new User(name,email,password,about);
		RegisterDao dao = new RegisterDao(HibernateUtils.getSessionFactory());
		
		HttpSession session = request.getSession();
		boolean registered = dao.registerUser(user);
		if(registered) {
			session.setAttribute("succMsg", "User Registered Successfully");
			response.sendRedirect("register.jsp");
		}else {
			session.setAttribute("errorMsg", "Something wrong on server");
			response.sendRedirect("register.jsp");
		}
	}

}
