package com.employeedetails.employeeServiceDAO;

import java.util.List;

import com.employeedetails.user.Employee;

public interface EmployeeServiceDAO {

	public String addEmployeeDetails(Employee employee);

	public String updateEmployee(Employee employee);

	public List<Employee> listEmployeeDetails();
	
	

}
