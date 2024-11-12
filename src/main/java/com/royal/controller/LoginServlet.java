package com.royal.controller;

import java.io.IOException;

import com.royal.bean.UserBean;
import com.royal.dao.UserDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// Retrieve username and password from login.jsp form
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        boolean isAuthenticated = new UserDao().authenticateUser(username, password);
        
        if (isAuthenticated) 
        {
        	System.out.println("---in if---isAuthenticated--->"+isAuthenticated);
        	UserBean userBean = new UserDao().getUserInfo(username);
        	System.out.println(userBean.getUserName()+"---"+userBean.getPassword());
        	HttpSession session = request.getSession();
        	session.setAttribute("user", userBean); 
            // Redirect to a success page
            response.sendRedirect("welcome.jsp");
        } else 
        {
            // Set an error message and forward back to login page
            request.setAttribute("errorMessage", "Invalid username or password");
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
}
