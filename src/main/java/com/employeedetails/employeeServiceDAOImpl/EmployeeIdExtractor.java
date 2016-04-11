package com.employeedetails.employeeServiceDAOImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.employeedetails.user.Employee;

public class EmployeeIdExtractor implements ResultSetExtractor<Object> {

	@Override
	public Employee extractData(ResultSet rs) throws SQLException, DataAccessException {
		Employee employee = new Employee();
		if (rs.next()) {
			employee.setEmployeeId(rs.getString("employeeid"));
			employee.setDesignation(rs.getString("designation"));
			employee.setFirstName(rs.getString("firstname"));
			employee.setLastName(rs.getString("lastname"));
			employee.setMobileNo(rs.getString("mobileno"));
		}
		return employee;
	}

}
