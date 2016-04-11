package com.employeedetails.validation;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.employeedetails.exception.EmployeeValidateException;
import com.employeedetails.exception.ErrorCode;
import com.employeedetails.user.Employee;

@Component
public class EmployeeValidation {
	
	Employee user = null;
	
	@Value("${EMPLOYEE_ID_LENGTH}")
	public int employeeIdLength;

	private static final Logger LOG = Logger.getLogger(EmployeeValidation.class);
	public Employee validateEmployeeDetails(Employee user) throws EmployeeValidateException  {
		if((StringUtils.isEmpty(user.getEmployeeId())&&user.getEmployeeId().length()!= employeeIdLength) || (StringUtils.isEmpty(user.getFirstName())) ||  (StringUtils.isEmpty(user.getLastName()))
				||  (StringUtils.isEmpty(user.getMobileNo())&& StringUtils.isBlank(user.getMobileNo())) ||  (StringUtils.isEmpty(user.getDesignation())&&StringUtils.isBlank(user.getDesignation()))){
			
			LOG.debug("Null Point Exception was occured due to some of the fields are null, so plz fill all the fields correctly");
			throw new EmployeeValidateException("401",ErrorCode.EC_1057.getValue());
		}
		
		return user;
		
	}
	
}