package com.employeedetails.exception;

import org.springframework.stereotype.Component;

@Component
public class EmployeeValidateException extends Exception {

	private static final long serialVersionUID = 1L;
	
	String message;
	String code ;
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}
	
	public EmployeeValidateException(){
		
	}
	public EmployeeValidateException(String code,String message){
	
		this.code=code;
		this.message= message;
	}

	
}
