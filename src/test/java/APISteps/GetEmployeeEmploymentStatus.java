package APISteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import utils.APIConstants;

import static APISteps.CreateNewEmployee.request;
import static APISteps.CreateNewEmployee.response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.number.OrderingComparison.greaterThanOrEqualTo;


public class GetEmployeeEmploymentStatus {
	@Given("request is prepared to get employment status")
	public void request_is_prepared_to_get_employment_status() {
		request = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.auth().oauth2(GenerateTokenStep.token);
	}
	
	@When("get call is prepared")
	public void get_call_is_prepared() {
		response = request.when()
				.get(APIConstants.GET_EMPLOYEE_EMPLOYMENT_STATUS);
	}
	
	@Then("response time is no exceed {int} ms")
	public void response_time_is_no_exceed_ms(Integer responseTime) {
		response.then()
				.log()
				.ifValidationFails()
				.time(not(greaterThanOrEqualTo(Long.valueOf(responseTime))))
				.log()
				.body();
	}
}
