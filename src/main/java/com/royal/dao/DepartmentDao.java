package com.royal.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.royal.util.DBConnection;

// Department class to hold department details
// DepartmentDAO class to handle department database operations
public class DepartmentDao
{
    private int deptId;
    private String deptName;
    
    public DepartmentDao() 
    {
	}
    public DepartmentDao(int deptId, String deptName) 
    {
        this.deptId = deptId;
        this.deptName = deptName;
    }

    public int getDeptId() {
        return deptId;
    }

    public String getDeptName() {
        return deptName;
    }
    
    // Method to retrieve all departments from the Department table
    public List<DepartmentDao> getAllDepartments() 
    {
        List<DepartmentDao> departments = new ArrayList<DepartmentDao>();
        
        String query = "SELECT Dept_id, Dept_name FROM Department";
        
		Connection conn = DBConnection.getConnection();
		
		try 
		{
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) 
			{
				int deptId = rs.getInt("Dept_id");
				String deptName = rs.getString("Dept_name");
				departments.add(new DepartmentDao(deptId, deptName));
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
		} 
        return departments;
    }
    public static void main(String[] args) 
    {
    	System.out.println(new DepartmentDao(0, "").getAllDepartments().size());
	}
}


