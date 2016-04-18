package com.employeedetails.employeeServiceDAOImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.employeedetails.user.Employee;

public class EmployeeListExtractor implements ResultSetExtractor<List<Employee>> {

	@Override
	public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Employee> listMarketCouch = new ArrayList<Employee>();
		while (rs.next()) {
			Employee employee = new Employee();
			employee.setEmployeeId(rs.getString("employeeid"));
			employee.setDesignation(rs.getString("designation"));
			employee.setFirstName(rs.getString("firstname"));
			employee.setLastName(rs.getString("lastname"));
			employee.setMobileNo(rs.getString("mobileno"));
			listMarketCouch.add(employee);
		}
		
		return listMarketCouch;
	}

}
