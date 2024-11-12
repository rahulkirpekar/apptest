<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<%
    if (session == null || session.getAttribute("user") == null) 
    {
        response.sendRedirect("login.jsp");
    }
%>

<head>
    <meta charset="UTF-8">
    <title>Welcome - Employee Management System</title>
    <style>
    
       /* Styling for the logout button */
	.btn-logout {
	    background-color: #f44336; /* Red color for logout */
	    color: white;
	    padding: 10px 20px;
	    text-align: center;
	    text-decoration: none;
	    border-radius: 5px;
	    display: inline-block;
	    margin: 10px 0;
	    font-size: 16px;
	}
	
	.btn-logout:hover {
	    background-color: #e53935;
	}
	
	
        /* General styling */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: Arial, sans-serif;
        }

        body {
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            background-color: #f8f9fa;
        }

        .container {
            max-width: 800px;
            width: 100%;
            padding: 2rem;
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0px 4px 12px rgba(0, 0, 0, 0.1);
        }

        h1 {
            color: #333;
            margin-bottom: 1.5rem;
            text-align: center;
        }

        .button-container {
            display: flex;
            flex-direction: row;
            justify-content: space-around;
            margin-top: 2rem;
        }

        .btn {
            display: inline-block;
            padding: 0.8rem 1.5rem;
            background-color: #0d6efd;
            color: #ffffff;
            border: none;
            border-radius: 4px;
            font-size: 1rem;
            cursor: pointer;
            text-align: center;
            text-decoration: none;
            transition: background-color 0.3s ease;
        }

        .btn:hover {
            background-color: #0b5ed7;
        }

        .logout {
            text-align: center;
            margin-top: 3rem;
        }

        .logout a {
            color: "white";
            text-decoration: none;
            font-size: 0.9rem;
        }

        .logout a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome to Employee Management System</h1>
        
        <!-- Action buttons for CRUD operations -->
        <div class="button-container">
            <a href="addEmployee.jsp" class="btn">Add Employee</a>
            <a href="employeeList.jsp" class="btn">List of All Employees</a>
        </div>
        
        <!-- Logout option -->
        <div class="logout">
            <p><a href="LogoutServlet"  class="btn-logout">Logout</a></p>
        </div>
        
        
        
        
    </div>
</body>
</html>