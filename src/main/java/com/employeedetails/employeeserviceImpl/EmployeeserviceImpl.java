package com.employeedetails.employeeserviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employeedetails.databaseholderfactory.DataBaseHolderFactory;
import com.employeedetails.employeeServiceDAO.EmployeeServiceDAO;
import com.employeedetails.employeeservice.EmployeeService;
import com.employeedetails.user.Employee;


@Component
public class EmployeeserviceImpl implements EmployeeService {

	@Autowired
	private DataBaseHolderFactory dataBaseHolderFactory;
	

	@Override
	public String addEmployeeDetails(Employee employee) {
		EmployeeServiceDAO employeeServiceDAO = dataBaseHolderFactory.getDataBaseDetails();
		String status = employeeServiceDAO.addEmployeeDetails(employee);
		return status;
	}

	@Override
	public String updateEmployeeDetails(Employee employee) {
		EmployeeServiceDAO employeeServiceDAO = dataBaseHolderFactory.getDataBaseDetails();
		String employeeUpdate = employeeServiceDAO.updateEmployee(employee);
		return employeeUpdate;
	}

	@Override
	public List<Employee> listEmployeeDetails() {
		EmployeeServiceDAO employeeServiceDAO = dataBaseHolderFactory.getDataBaseDetails();
		List<Employee> employees = employeeServiceDAO.listEmployeeDetails();
		return employees;
	}


	
	


	

}
