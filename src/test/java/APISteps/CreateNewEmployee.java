package APISteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.APIConstants;
import utils.APIPayload;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


public class CreateNewEmployee {
	public static Response response;
	public static RequestSpecification request;
	public static String employeeID;
	
	@Given("request is prepared and body  contains {string}, {string}, {string}, {string}, {string}, {string}, {string}")
	public void request_is_prepared_and_body_contains(String firstName, String lastName,
													  String middleName, String gender,
													  String DOB, String empStatus, String jobTitle) {
		request = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.auth().oauth2(GenerateTokenStep.token)
				.body(APIPayload.createNewEmloyee(firstName, lastName, middleName,
						gender, DOB, empStatus, jobTitle));
		
	}
	
	@When("post call is made to create employee")
	public void post_call_is_made_to_create_employee() {
		response = request.when()
				.post(APIConstants.CREATE_NEW_EMPLOYEE);
	}
	
	@Then("status code is {int}")
	public void status_code_is(Integer statusCode) {
		response.then()
				.log()
				.ifValidationFails()
				.statusCode(statusCode);
	}
	
	@Then("expected message is {string}")
	public void expected_message_is_employee_created(String expectedMSG) {
		response.then()
				.log()
				.ifValidationFails()
				.body("Message", equalTo(expectedMSG));
	}
	
	@Then("{string} is stored in global variables")
	public void is_stored_in_global_variables(String empID) {
		employeeID = response.then()
				.extract()
				.body()
				.jsonPath()
				.getString(empID);
		System.out.println(employeeID);
		
	}
	
}
