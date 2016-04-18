package com.employeedetails.employeeservice;

import java.util.List;

import com.employeedetails.user.Employee;

public interface EmployeeService {
	
	public String addEmployeeDetails(Employee employee);

	public String updateEmployeeDetails(Employee employee);
	
	public List<Employee> listEmployeeDetails();

	public String deleteEmployee(String employeeId);
}
