package APISteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import utils.APIConstants;

import static APISteps.CreateNewEmployee.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class DeleteEmployee {
	@Given("request is made to delete employee")
	public void request_is_made_to_delete_employee() {
		request = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.auth().oauth2(GenerateTokenStep.token)
				.queryParam("employee_id", employeeID);
	}
	
	@When("delete call is prepared")
	public void delete_call_is_prepared() {
		response = request.when()
				.delete(APIConstants.DELETE_EMPLOYEE);
	}
	
	@Then("{string} match with employee id in globals")
	public void match_with_employee_id_in_globals(String employeeId) {
		response.then()
				.log()
				.ifValidationFails()
				.body(employeeId, equalTo(CreateNewEmployee.employeeID))
				.log()
				.body();
	}
}
