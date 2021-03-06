package com.employeedetails.databaseholderfactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.employeedetails.employeeServiceDAO.EmployeeServiceDAO;
import com.employeedetails.employeeServiceDAOImpl.CacheDAO;
import com.employeedetails.employeeServiceDAOImpl.MYSQL_DB;
import com.employeedetails.employeeServiceDAOImpl.OracleDAO;

@Component
@PropertySource("classpath:application.properties")
public class DataBaseHolderFactory {
	
	@Value("${DB_ON}") 
	private String dbName;
	
	@Autowired
	private MYSQL_DB db;

	public EmployeeServiceDAO getDataBaseDetails() {
		
		if(dbName.equals("CACHE"))
		{
		return new CacheDAO();	
		}
		if(dbName.equals("MYSQL")){
		return	db;
		}
		else {
			return new OracleDAO();
		}
		
		
	}

}
