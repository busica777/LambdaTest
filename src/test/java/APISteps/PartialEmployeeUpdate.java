package APISteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import utils.APIConstants;
import utils.APIPayload;

import java.util.List;
import java.util.Map;

import static APISteps.CreateNewEmployee.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class PartialEmployeeUpdate {
	@Given("request to update employee is prepared and body contains information for updating")
	public void request_to_update_employee_is_prepared_and_body_contains_information_for_updating(io.cucumber.datatable.DataTable dataTable) {
		request = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.auth().oauth2(GenerateTokenStep.token)
				.body(APIPayload.partialEmployeeUpdating(dataTable));
	}
	
	@When("put call is made for updating employee")
	public void put_call_is_made_for_updating_employee() {
		response = request.when()
				.patch(APIConstants.PARTIAL_EMPLOYEE_UPDATING);
	}
	
	@Then("expected {string} is {string}")
	public void expected_is(String MSG, String MSGValue) {
		response.then()
				.log()
				.ifValidationFails()
				.body(MSG, equalTo(MSGValue));
	}
	
}
