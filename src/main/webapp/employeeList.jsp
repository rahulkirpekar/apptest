<%@ page import="com.royal.bean.EmployeeBean"%>
<%@ page import="java.util.List" %>
<%@ page import="com.royal.dao.EmployeeDao" %>


<%
    if (session == null || session.getAttribute("user") == null) 
    {
        response.sendRedirect("login.jsp");
    }
%>

<%
    // Instantiate the DAO and retrieve the list of employees
    EmployeeDao employeeDAO = new EmployeeDao();
    List<EmployeeBean> employees = employeeDAO.getAllEmployees();
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee List</title>
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
	
        /* General Page Styling */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 90%;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            color: #333;
        }

        /* Table Styling */
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        tr:hover {
            background-color: #f5f5f5;
        }

        /* Button Styling for Action Links */
        .btn-edit, .btn-delete {
            color: white;
            padding: 6px 12px;
            text-align: center;
            text-decoration: none;
            border-radius: 5px;
            margin-right: 5px;
            font-weight: bold;
        }

        .btn-edit {
            background-color: #4CAF50; /* Green for Edit */
        }

        .btn-edit:hover {
            background-color: #45a049;
        }

        .btn-delete {
            background-color: #f44336; /* Red for Delete */
        }

        .btn-delete:hover {
            background-color: #e53935;
        }

        /* Add New Employee Button */
        .btn-add {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            border-radius: 5px;
            display: inline-block;
            margin: 20px 0;
        }

        .btn-add:hover {
            background-color: #45a049;
        }

        /* Responsive Table */
        @media screen and (max-width: 600px) {
            table {
                width: 100%;
                font-size: 14px;
            }

            th, td {
                padding: 8px;
            }

            .btn-add {
                width: 100%;
                padding: 12px;
            }
        }
    </style>
</head>
<body>
<a href="LogoutServlet" class="btn-logout">Logout</a>

    <div class="container">
        <h1>Employee List</h1>

        <!-- Add Employee Button -->
        <a href="addEmployee.jsp" class="btn-add">Add New Employee</a>
        <a href="welcome.jsp" class="btn-add">Welcome Page</a>

        <!-- Employee Table -->
        <table>
            <thead>
                <tr>
                    <th>Employee ID</th>
                    <th>Employee Name</th>
                    <th>Department</th>
                    <th>Date of Birth</th>
                    <th>Salary</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    for (EmployeeBean employee : employees) {
                %>
                    <tr>
                        <td><%= employee.getEmpId() %></td>
                        <td><%= employee.getEmpName() %></td>
                        <td><%= employee.getDeptName() %></td>
                        <td><%= employee.getDob() %></td>
                        <td><%= employee.getSalary() %></td>
                        <td>
                            <!-- Edit and Delete Buttons -->
                            <a href="EditEmployeeServlet?id=<%= employee.getEmpId() %>" class="btn-edit">EDIT</a> 
                            <a href="DeleteEmployeeServlet?id=<%= employee.getEmpId() %>" class="btn-delete" onclick="return confirm('Are you sure you want to delete this employee?')">DELETE</a>
                        </td>
                    </tr>
                <% 
                    }
                %>
            </tbody>
        </table>
    </div>

</body>
</html>
