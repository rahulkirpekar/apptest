package com.royal.controller;

import java.io.IOException;
import java.sql.Date;

import com.royal.bean.EmployeeBean;
import com.royal.dao.EmployeeDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateEmployeeServlet
 */
public class UpdateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UpdateEmployeeServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// Get parameters from the form submission
        int emp_id = Integer.parseInt(request.getParameter("emp_id"));
        String empName = request.getParameter("emp_name");
        int deptId = Integer.parseInt(request.getParameter("dept_id"));
        String dobStr = request.getParameter("dob");
        double salary = Double.parseDouble(request.getParameter("salary"));

        Date dob = Date.valueOf(dobStr);
        // Create an Employee object using the form data
        EmployeeBean updateEmployee = new EmployeeBean(emp_id, empName, deptId, dob, salary);

        // Call the DAO to insert the new employee into the database
        EmployeeDao employeeDao = new EmployeeDao();
        boolean isSuccess = employeeDao.updateEmployee(updateEmployee);

        // Redirect based on success or failure
        if (isSuccess) 
        {
            // Redirect to the employee list or a success page
            response.sendRedirect("employeeList.jsp"); // Assuming you have a list of employees page
        } else {
            // Redirect to an error page or back to the form with a message
            request.setAttribute("errorMessage", "Failed to add employee. Please try again.");
            request.getRequestDispatcher("addEmployee.jsp").forward(request, response);
        }
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
