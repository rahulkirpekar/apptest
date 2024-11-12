package com.royal.controller;

import java.io.IOException;

import com.royal.bean.EmployeeBean;
import com.royal.dao.EmployeeDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EditEmployeeServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int id = Integer.parseInt(request.getParameter("id"));
		
		System.out.println("EditEmployeeServlet id : " + id);
		EmployeeDao dao = new EmployeeDao();
		
		EmployeeBean ebean = dao.getEmployeeById(id);
		
		System.out.println("EditEmployeeServlet : " + ebean);
		request.setAttribute("ebean", ebean);
		
		RequestDispatcher rd = null;
		if (ebean != null) 
		{
			rd = request.getRequestDispatcher("viewEmployees.jsp");
		} else 
		{
			rd = request.getRequestDispatcher("welcome.jsp");
		}
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
