package com.employeedetails.app;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.employeedetails.employeeServiceDAO.EmployeeServiceDAO;
import com.employeedetails.employeeServiceDAOImpl.MYSQL_DB;

@Configuration
@PropertySource("classpath:application.properties")
public class DB_Config {
	
	@Value("${DB_ON}") 
	private String dbName;
	
	@Value("${DB_DRIVER}") 
	private String driverclass;
	
	@Value("${URL}") 
	private String url;
	
	@Value("${USERNAME}") 
	private String userName;
	
	@Value("${PASSWORD}") 
	private String password;
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverclass);
		dataSource.setUrl(url);
		dataSource.setUsername(userName);
		dataSource.setPassword(password);
		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}
	
	
	public EmployeeServiceDAO employeeServiceDAO(){
		if((!dbName.isEmpty()) && dbName == "MYSQL"){
			MYSQL_DB mYSQL_DB = new MYSQL_DB();
			mYSQL_DB.setJdbcTemplate(jdbcTemplate());
			return mYSQL_DB;
		}
		
		
		else{
		return null;
		}
	}
	
}
