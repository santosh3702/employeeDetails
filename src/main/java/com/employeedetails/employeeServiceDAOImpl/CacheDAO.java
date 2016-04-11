package com.employeedetails.employeeServiceDAOImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.employeedetails.employeeServiceDAO.EmployeeServiceDAO;
import com.employeedetails.exception.EmployeeDetailException;
import com.employeedetails.exception.ErrorCode;
import com.employeedetails.user.Employee;

public class CacheDAO implements EmployeeServiceDAO    {

	public static Map<String, Employee> map = new HashMap<>();
	
	@Override
	public String addEmployeeDetails(Employee employee) {
		String employe = null;
		try {
			employe = addemployee(employee);
		} catch (EmployeeDetailException e) {
			employe = e.getMessage();
		}
		return employe;
	} 
	
	
	public String addemployee(Employee employee) throws EmployeeDetailException{
		
		if(map.containsKey(employee.getEmployeeId()))
		{
			throw new EmployeeDetailException("402",ErrorCode.EC_1027.getValue());
		}
		
		map.put(employee.getEmployeeId(), employee);
		return "Employee is Added";	
	}


	@Override
	public String updateEmployee(Employee employee) {
		String message = null;
		if(map.containsKey(employee.getEmployeeId())){
			map.put(employee.getEmployeeId(), employee);
			message ="";
		}
		else{
			try {
				throw new EmployeeDetailException("403", ErrorCode.EC_1058.getValue());
			} catch (EmployeeDetailException error) {
				message = error.getMessage();
				System.out.println(message);
			}
		}
		return message;
	}


	@Override
	public List<Employee> listEmployeeDetails() {
		List<Employee> employeeslist = new ArrayList<>(map.values());
		return employeeslist;
	}

	

}
