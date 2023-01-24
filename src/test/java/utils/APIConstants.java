package utils;

import io.restassured.RestAssured;

public interface APIConstants {
	String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
	String GENERATE_TOKEN = baseURI + "/generateToken.php";
	String CREATE_NEW_EMPLOYEE = baseURI + "/createEmployee.php";
	String RETRIEVE_CREATED_EMPLOYEE = baseURI + "/getOneEmployee.php";
	String PARTIAL_EMPLOYEE_UPDATING = baseURI + "/updatePartialEmplyeesDetails.php";
	String GET_EMPLOYEE_JOB_TITLES = baseURI + "/jobTitle.php";
	String GET_EMPLOYEE_EMPLOYMENT_STATUS = baseURI + "/employeementStatus.php";
	String PUT_UPDATE_EMPLOYEE_INFORMATION = baseURI + "/updateEmployee.php";
	String DELETE_EMPLOYEE = baseURI + "/deleteEmployee.php";
	
}
