package com.royal.controller;

import java.io.IOException;
import java.sql.Date;

import com.royal.bean.EmployeeBean;
import com.royal.dao.EmployeeDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
public class AddEmployeeServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// Get parameters from the form submission
        String empName = request.getParameter("emp_name");
        int deptId = Integer.parseInt(request.getParameter("dept_id"));
        String dobStr = request.getParameter("dob");
        double salary = Double.parseDouble(request.getParameter("salary"));

        Date dob = Date.valueOf(dobStr);
        // Create an Employee object using the form data
        EmployeeBean newEmployee = new EmployeeBean(empName, deptId, dob, salary);

        // Call the DAO to insert the new employee into the database
        EmployeeDao employeeDao = new EmployeeDao();
        boolean isSuccess = employeeDao.addEmployee(newEmployee);

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
}
