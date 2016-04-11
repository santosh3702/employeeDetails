package com.employeedetails.exception;

public class EmployeeDetailException extends Exception{

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
	
	public EmployeeDetailException(){
		
	}
	public EmployeeDetailException(String code,String message){
	
		this.code=code;
		this.message= message;
	}

}
