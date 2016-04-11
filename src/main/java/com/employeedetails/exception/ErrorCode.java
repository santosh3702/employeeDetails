package com.employeedetails.exception;

import java.io.Serializable;



public enum ErrorCode implements Serializable{



    EC_1057("Null Point Exception was occured due to some of the fields are null, so plz fill all the fields correctly"),
    EC_1027("Employee Id is already exits"),
    EC_1058("Employee Id is invalied"),
    EC_1059("Employee Id is invalied"),
    EC_1062("moblile no invalied"),
    
;

    
    private String property = null;

   
    ErrorCode(String property) {
        this.property = property;
    }

   
    public static ErrorCode fromValue(String value) {
        return valueOf(value);
    }

  
    public String getValue() {
        return property;
    }


}
