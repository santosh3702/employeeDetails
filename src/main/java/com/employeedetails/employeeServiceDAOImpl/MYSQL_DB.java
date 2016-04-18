package com.employeedetails.employeeServiceDAOImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.employeedetails.employeeServiceDAO.EmployeeServiceDAO;
import com.employeedetails.exception.EmployeeDetailException;
import com.employeedetails.exception.ErrorCode;
import com.employeedetails.user.Employee;

@Component/*(value ="mysql_DB")*/
public class MYSQL_DB implements EmployeeServiceDAO {
	
    @Autowired
	private JdbcTemplate jdbcTemplate;

	
	public MYSQL_DB(){
		
	}
	/*public void setDataSource(DataSource ds) {
	    jdbcTemplate = new JdbcTemplate(ds);
	}*/

	@Override
	public String addEmployeeDetails(Employee employee) {
		String employe = null;
		employe = addemployee(employee);
		return employe;
	}

	private String addemployee(Employee employee) {
		// TODO Auto-generated method stub
		if (findByemployeeId(employee.getEmployeeId())) {
			String query = "insert into employee (firstname , lastname, mobileno, employeeid, designation) values (?,?,?,?,?)";
			jdbcTemplate.update(query, new Object[] { employee.getFirstName(), employee.getLastName(),
					employee.getMobileNo(), employee.getEmployeeId(), employee.getDesignation() });
			return "employee is added";
		}

		else {

			try {
				throw new EmployeeDetailException("402", ErrorCode.EC_1027.getValue());
			} catch (EmployeeDetailException e) {
				// TODO Auto-generated catch block
				return "employee is alredy exits";
			}
		}
	}

	private boolean findByemployeeId(String employeeId) {
		String query = "Select * from employee where employeeid = ?";
		List<String> args = new ArrayList<>();
		args.add(employeeId);
	/*	String sql = "tee D:\\rahul"+"\\mysql.txt";
		System.out.println(sql);
		jdbcTemplate.update(sql);*/
		Employee employee = (Employee) jdbcTemplate.query(query, args.toArray() ,new EmployeeIdExtractor());
		if (employee.getEmployeeId() == null) {
			return true;
		}

		return false;
	}
	
	private boolean findByemployeeIdExist(String employeeId) {
		String query = "Select * from employee where employeeid = ?";
		List<String> args = new ArrayList<>();
		args.add(employeeId);
		Employee employee = (Employee) jdbcTemplate.query(query, args.toArray() ,new EmployeeIdExtractor());
		if (employee.getEmployeeId() != null) {
			return true;
		}

		return false;
	}

	@Override
	public String updateEmployee(Employee employee) {
		String update = null;
		if(findByemployeeIdExist(employee.getEmployeeId())){
		 update = upDate(employee);
		}
		else{
			update = "employeeId not exist";
		}
		return update;
	}

	private String upDate(Employee employee) {
		String query = "update employee set firstname = ?, lastname = ?, mobileno = ?, designation = ? where employeeid = ?";
		jdbcTemplate.update(query, new Object[] { employee.getFirstName(), employee.getLastName(),
				employee.getMobileNo(), employee.getDesignation(), employee.getEmployeeId()});
		return "employee is updated";
	}

	@Override
	public List<Employee> listEmployeeDetails() {
		List<Employee> listMarketCouch = new ArrayList<Employee>();
		String query = "Select * from employee";
		listMarketCouch = jdbcTemplate.query(query, new EmployeeListExtractor());
		return listMarketCouch;
	}

	@Override
	public String deleteEmployee(String employeeId) {
		String query = "delete from employee where employeeid = ?";
		List<String> args = new ArrayList<>();
		args.add(employeeId);
		jdbcTemplate.update(query,  args.toArray());
		return "employee is deleted";
	}

}
