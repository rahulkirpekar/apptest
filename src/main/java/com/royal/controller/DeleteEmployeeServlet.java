package com.royal.controller;

import java.io.IOException;

import com.royal.dao.EmployeeDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteEmployeeServlet
 */
public class DeleteEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DeleteEmployeeServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int id = Integer.parseInt(request.getParameter("id"));
		
		System.out.println("DeleteEmployeeServlet id : " + id);
		EmployeeDao dao = new EmployeeDao();
		
		int rowsAffected = dao.deleteEmployee(id);
		
		RequestDispatcher rd = null;
		if (rowsAffected > 0) 
		{
			rd = request.getRequestDispatcher("employeeList.jsp");
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
