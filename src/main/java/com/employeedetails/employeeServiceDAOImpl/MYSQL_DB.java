package com.employeedetails.employeeServiceDAOImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.employeedetails.employeeServiceDAO.EmployeeServiceDAO;
import com.employeedetails.user.Employee;

@Repository
public class MYSQL_DB implements EmployeeServiceDAO {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public String addEmployeeDetails(Employee employee) {
		// insert into employee (firstname , lastname, mobileno, employeeid,
		// designation) values (?,?,?,?,?)
		String employe = null;
		employe = addemployee(employee);
		return employe;
	}

	private String addemployee(Employee employee) {
		// TODO Auto-generated method stub
		if (findByemployeeId(employee.getEmployeeId())) {

		}

		return null;
	}

	private boolean findByemployeeId(String employeeId) {
		String query = "Select * from employee where employeeid = ?";
		
		
		jdbcTemplate.query(query, new EmployeeIdExtractor() );
		
		return false;
	}

	@Override
	public String updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> listEmployeeDetails() {
		// TODO Auto-generated method stub
		return null;
	}

}
