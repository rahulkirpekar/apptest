<%@page import="jakarta.servlet.http.HttpSession"%>
<%@page import="com.royal.dao.DepartmentDao"%>
<%@page import="com.royal.bean.EmployeeBean"%>
<%@ page import="java.util.List" %>
<%@ page import="com.royal.dao.EmployeeDao" %>

<%
    if (session == null || session.getAttribute("user") == null) 
    {
        response.sendRedirect("login.jsp");
    }
%>

<%
    // Instantiate the DAO and retrieve the employee details by ID
    EmployeeBean employee = (EmployeeBean)request.getAttribute("ebean");
    // Instantiate the DAO and retrieve the list of departments
    DepartmentDao departmentDAO = new DepartmentDao();
    List<DepartmentDao> departments = departmentDAO.getAllDepartments();
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Employee</title>
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
    
    
        /* General reset and styling */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f7f7f7;
        }

        .container {
            width: 50%;
            margin: 50px auto;
            background-color: white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0px 4px 12px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            color: #333;
            font-size: 2rem;
            margin-bottom: 30px;
        }

        .form-group {
            margin-bottom: 20px;
        }

        .form-group label {
            font-size: 1.1rem;
            font-weight: bold;
            margin-bottom: 10px;
            display: block;
            color: #555;
        }

        .form-group input,
        .form-group select {
            width: 100%;
            padding: 12px;
            font-size: 1rem;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            transition: border-color 0.3s ease;
        }

        .form-group input:focus,
        .form-group select:focus {
            border-color: #007bff;
            outline: none;
        }

        .btn-submit {
            width: 100%;
            padding: 12px;
            background-color: #007bff;
            color: white;
            font-size: 1.1rem;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .btn-submit:hover {
            background-color: #0056b3;
        }

        .form-group input[type="number"] {
            -moz-appearance: textfield;
            -webkit-appearance: none;
            appearance: none;
        }

        .form-group input[type="number"]::-webkit-outer-spin-button,
        .form-group input[type="number"]::-webkit-inner-spin-button {
            -webkit-appearance: none;
            margin: 0;
        }

        /* Responsive Design */
        @media screen and (max-width: 768px) {
            .container {
                width: 80%;
            }

            h1 {
                font-size: 1.5rem;
            }

            .form-group input,
            .form-group select {
                font-size: 0.9rem;
            }

            .btn-submit {
                font-size: 1rem;
            }
        }
    </style>
</head>
<body>
	<a href="LogoutServlet" class="btn-logout">Logout</a>

    <div class="container">
        <h1>Edit Employee</h1>
        <form action="updateEmployeeServlet" method="post">
        
        	<!-- Employee Id-->
                <input type="text" id="emp_id" name="emp_id" value="<%=employee.getEmpId()%>" hidden="">
        
            <!-- Employee Name -->
            <div class="form-group">
                <label for="emp_name">Employee Name</label>
                <input type="text" id="emp_name" name="emp_name" value="<%=employee.getEmpName()%>" required>
            </div>

            <!-- Department (Dropdown) -->
            <div class="form-group">
                <label for="dept_id">Department</label>
                <select id="dept_id" name="dept_id" required>
                    <% for (DepartmentDao dept : departments) 
                       { 
 							if(dept.getDeptId()==employee.getDeptId())
 							{                   	
                    %>
                       	 <option value="<%= employee.getDeptId() %>" selected><%= employee.getDeptName() %></option>
                    <% 
                    		}else
                    		{
                    %>			
                        <option value="<%= dept.getDeptId() %>" ><%= dept.getDeptName() %></option>
                    <% 			
                    		}
                       }	
 						%>
                </select>
            </div>

            <!-- Date of Birth -->
            <div class="form-group">
                <label for="dob">Date of Birth</label>
                <input type="date" id="dob" name="dob" value="<%=employee.getDob()%>" required>
            </div>

            <!-- Salary -->
            <div class="form-group">
                <label for="salary">Salary</label>
                <input type="number" id="salary" name="salary" value="<%=employee.getSalary()%>" required>
            </div>

            <!-- Submit Button -->
            <button type="submit" class="btn-submit">Update Employee</button>
        </form>
    </div>
</body>
</html>
