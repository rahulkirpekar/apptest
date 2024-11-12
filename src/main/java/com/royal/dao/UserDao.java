package com.royal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.royal.bean.UserBean;
import com.royal.util.DBConnection;

public class UserDao 
{
	 public boolean authenticateUser(String username, String password) 
	 {
		 String LOGIN_QUERY="SELECT * FROM User WHERE Username = ? AND Password = ?";
	        // Connect to the database and check credentials
	        try 
	        {
	    		Connection conn = DBConnection.getConnection();
	    		PreparedStatement stmt = conn.prepareStatement(LOGIN_QUERY);
	        
	            // Set username and password parameters
	            stmt.setString(1, username);
	            stmt.setString(2, password);
	            
	            ResultSet resultSet = stmt.executeQuery();
	            
	            // Return true if credentials are valid, false otherwise
	            return resultSet.next();
	            
	        } catch (Exception e) 
	        {
	            e.printStackTrace();
	        }
	        return false;
	    }

	public UserBean getUserInfo(String username) 
	{
		UserBean userBean =null;
		String selectQuery = "SELECT Username,Password from user WHERE username=?";
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try 
		{
			pstmt = conn.prepareStatement(selectQuery);
			
			pstmt.setString(1, username);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			
			userBean = new UserBean(rs.getString(1), rs.getString(2));
			
			System.out.println(userBean.getUserName()+" " + userBean.getPassword());
			
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return userBean;
	}
}
