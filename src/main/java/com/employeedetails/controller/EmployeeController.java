package com.employeedetails.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.employeedetails.employeeservice.EmployeeService;
import com.employeedetails.exception.EmployeeDetailException;
import com.employeedetails.exception.EmployeeValidateException;
import com.employeedetails.user.Employee;
import com.employeedetails.validation.EmployeeValidation;

@RestController
public class EmployeeController {


	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private EmployeeValidation employeeValidation;

	@ExceptionHandler(EmployeeDetailException.class)
	@ResponseBody
	public ResponseEntity<EmployeeDetailException> myexception(@RequestBody EmployeeDetailException e){
		return new ResponseEntity<EmployeeDetailException>(e,HttpStatus.CREATED);
	}
	
	
	@RequestMapping("/")
	public String welcomeEmployeeSystem() {
		return "Welcome To Employee management System";
	}
	
	@ExceptionHandler(EmployeeValidateException.class)
	@RequestMapping(value = "/add" , method=RequestMethod.POST , consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addEmployeeDetails(@RequestBody Employee userrequest) throws EmployeeValidateException{
		employeeValidation.validateEmployeeDetails(userrequest);
		String status = employeeService.addEmployeeDetails(userrequest);
		System.out.println(status);
		return new ResponseEntity<String>(status, HttpStatus.CREATED);	
	}
	
	@RequestMapping(value = "/update" , method = RequestMethod.POST, produces={"application/json","application/xml"},consumes={"application/json","application/xml"} )
	public ResponseEntity<String> updateEmployeeDetails(@RequestBody Employee userrequest) throws EmployeeValidateException{
		employeeValidation.validateEmployeeDetails(userrequest);
		String employeeUpdated = employeeService.updateEmployeeDetails(userrequest);
		return new ResponseEntity<String>(employeeUpdated, HttpStatus.CREATED);
	}
	
	@RequestMapping(value ="/list" , method = RequestMethod.GET)
	public List<Employee> listEmployeeDetails(){ 	
		List<Employee> employees = employeeService.listEmployeeDetails();
		return employees;
		
	}
	
	
	@RequestMapping(value ="/delete" , method = RequestMethod.DELETE)
	public String deleteEmployeeById(@RequestBody Employee userrequest){ 	
		
		String employees = employeeService.deleteEmployee(userrequest.getEmployeeId());
		return employees;
		
	}
	
	
	
	 
	

}
