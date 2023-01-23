package utils;

import io.restassured.RestAssured;

public interface APIConstants {
	String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
	String GENERATE_TOKEN = baseURI + "/generateToken.php";
	String CREATE_NEW_EMPLOYEE = baseURI + "/createEmployee.php";
	String RETRIEVE_CREATED_EMPLOYEE = baseURI + "/getOneEmployee.php";
	
}
