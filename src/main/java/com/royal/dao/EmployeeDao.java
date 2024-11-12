package com.royal.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.royal.bean.EmployeeBean;
import com.royal.util.DBConnection;

public class EmployeeDao 
{
	// Method to add employee to the database
    public boolean addEmployee(EmployeeBean employee) 
    {
        Connection conn = DBConnection.getConnection();
        boolean isSuccess = false;

        String sql = "INSERT INTO Employee (emp_name, dept_id, dob, salary) VALUES (?, ?, ?, ?)";

        try 
        {
        	PreparedStatement pstmt = conn.prepareStatement(sql);
        	pstmt.setString(1, employee.getEmpName());
        	pstmt.setInt(2, employee.getDeptId());
        	
        	// Convert String dob to java.sql.Date
        	pstmt.setDate(3, new Date(employee.getDob().getTime())); // Using java.sql.Date
        	pstmt.setDouble(4, employee.getSalary());
        	
        	int rowsAffected = pstmt.executeUpdate();
        	
        	if (rowsAffected > 0) 
        	{
        		isSuccess = true;
        	}
		} catch (Exception e) 
        {
			e.printStackTrace();
		}

        return isSuccess;
    }
    
 // Method to add employee to the database
    public boolean updateEmployee(EmployeeBean employee) 
    {
        Connection conn = DBConnection.getConnection();
        boolean isSuccess = false;

        String sql = "UPDATE employee SET emp_name = ?, dept_id = ?, dob = ?, salary = ? WHERE emp_id = ?";
        
        try 
        {
        	PreparedStatement pstmt = conn.prepareStatement(sql);
        	pstmt.setString(1, employee.getEmpName());
        	pstmt.setInt(2, employee.getDeptId());
        	
        	// Convert String dob to java.sql.Date
        	pstmt.setDate(3, new Date(employee.getDob().getTime())); // Using java.sql.Date
        	pstmt.setDouble(4, employee.getSalary());
        	pstmt.setInt(5, employee.getEmpId());
        	
        	int rowsAffected = pstmt.executeUpdate();
        	
        	if (rowsAffected > 0) 
        	{
        		isSuccess = true;
        	}
		} catch (Exception e) 
        {
			e.printStackTrace();
		}

        return isSuccess;
    }
	public int deleteEmployee(int id) 
	{
		String deleteQuery = "DELETE FROM employee WHERE Emp_id=?";
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null; 
		int rowsAffected = 0 ;
		if (conn!=null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(deleteQuery);
				pstmt.setInt(1, id);
				
				rowsAffected = pstmt.executeUpdate();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else 
		{
			System.out.println("Db not connected");
		}
		return rowsAffected;
	}
	public EmployeeBean getEmployeeById(int empId) 
	{
	    EmployeeBean employee = null;
	    String sql = "SELECT e.emp_id, e.emp_name, e.dept_id, e.dob, e.salary, d.dept_name "
	               + "FROM Employee e JOIN Department d ON e.dept_id = d.dept_id WHERE e.emp_id = ?";
	    
	    System.out.println("sql : " + sql);
	    try 
	    {
	    	Connection conn = DBConnection.getConnection(); 
	    	
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        
	        pstmt.setInt(1, empId);
	        ResultSet rs = pstmt.executeQuery();
	        
	        if (rs.next()) 
	        {
	            int empId1 = rs.getInt("emp_id");
	            String empName = rs.getString("emp_name");
	            int deptId = Integer.parseInt(rs.getString("dept_id"));
	            String deptName = rs.getString("dept_name");
	            Date dob = rs.getDate("dob");
	            double salary = rs.getDouble("salary");
	            employee = new EmployeeBean(empId1, empName, deptId, deptName, dob, salary);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return employee;
	}
	public List<EmployeeBean> getAllEmployees() 
	{
	    List<EmployeeBean> employees = new ArrayList<EmployeeBean>();
	    String sql = "SELECT e.emp_id, e.emp_name, e.dept_id, e.dob, e.salary, d.dept_name "
	               + "FROM Employee e JOIN Department d ON e.dept_id = d.dept_id";
	    try 
	    {
	    	Connection conn = DBConnection.getConnection(); 
	         
	    	PreparedStatement pstmt = conn.prepareStatement(sql);
	        
	    	ResultSet rs = pstmt.executeQuery();
	         
	        while (rs.next()) 
	        {
	            int empId = rs.getInt("emp_id");
	            String empName = rs.getString("emp_name");
	            int deptId = rs.getInt("dept_id");
	            String deptName = rs.getString("dept_name");
	            Date dob = rs.getDate("dob");
	            double salary = rs.getDouble("salary");

	            //   									(int empId, String empName, int deptId, Date dob, double salary)
	            EmployeeBean employee = new EmployeeBean(empId, empName, deptId, deptName, dob, salary);
	            employees.add(employee);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return employees;
	}
}
