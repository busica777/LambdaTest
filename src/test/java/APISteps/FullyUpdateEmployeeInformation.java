package APISteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import org.junit.Assert;
import utils.APIConstants;
import utils.APIPayload;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

import static APISteps.CreateNewEmployee.request;
import static APISteps.CreateNewEmployee.response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class FullyUpdateEmployeeInformation {
	@Given("request is made to update full employee information")
	public void request_is_made_to_update_full_employee_information(io.cucumber.datatable.DataTable dataTable) {
		request = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.auth().oauth2(GenerateTokenStep.token)
				.body(APIPayload.updateEmployeeInformation(dataTable));
		
	}
	
	@When("put call is prepared")
	public void put_call_is_prepared() {
		response = request.when()
				.put(APIConstants.PUT_UPDATE_EMPLOYEE_INFORMATION);
	}
	
	@Then("expected {string} contains value {string}")
	public void expected_contains_value(String MSG, String MSGValue) {
		response.then()
				.log()
				.ifValidationFails()
				.body(MSG, equalTo(MSGValue))
				.log()
				.body();
	}
	
	@Then("updated fields match with provided information")
	public void updated_fields_match_with_provided_information(io.cucumber.datatable.DataTable dataTable) {
		Map<String, String> actualData = response.body().jsonPath().get("Employee");
		List<Map<String, String>> expectedData = dataTable.asMaps();
		BiConsumer<String, String> matcher = Assert::assertEquals;
		expectedData.forEach(map -> map.forEach((k, v) -> matcher.accept(v, actualData.get(k))));
	}
	
}
