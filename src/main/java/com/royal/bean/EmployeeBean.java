package com.royal.bean;

import java.sql.Date;

public class EmployeeBean 
{
    private int empId;
	private String empName;
    private int deptId;
	private String deptName;
    private Date dob;
    private double salary;
    
    public EmployeeBean() 
    {
	}
    //(empId, empName, deptName, dob, salary);
    public EmployeeBean(int empId, String empName, String deptName, Date dob, double salary) 
   	{
   		this.empId = empId;
   		this.empName = empName;
   		this.deptName=deptName;
   		this.dob = dob;
   		this.salary = salary;
   	}
    
    public EmployeeBean(String empName, int deptId, Date dob, double salary) 
	{
		this.empName = empName;
		this.deptId = deptId;
		this.dob = dob;
		this.salary = salary;
	}
    public EmployeeBean(int empId, String empName, int deptId,String deptName, Date dob, double salary) 
	{
		this.empId = empId;
		this.empName = empName;
		this.deptId = deptId;
		this.deptName=deptName;
		this.dob = dob;
		this.salary = salary;
	}
	public EmployeeBean(int empId, String empName, int deptId, Date dob, double salary) 
	{
		this.empId = empId;
		this.empName = empName;
		this.deptId = deptId;
		this.dob = dob;
		this.salary = salary;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	@Override
	public String toString() 
	{
		return deptId+" " + deptName+" " + empName;
	}
	
}
