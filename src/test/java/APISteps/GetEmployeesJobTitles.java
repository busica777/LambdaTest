package APISteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapper;
import org.json.simple.JSONArray;
import utils.APIConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static APISteps.CreateNewEmployee.request;
import static APISteps.CreateNewEmployee.response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.collection.IsMapContaining.hasKey;

public class GetEmployeesJobTitles {
	@Given("request is prepared to get job titles")
	public void request_is_prepared_to_get_job_titles() {
		request = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.auth().oauth2(GenerateTokenStep.token);
	}
	@When("get call is made")
	public void get_call_is_made() {
				response = request.when()
				.get(APIConstants.GET_EMPLOYEE_JOB_TITLES);
		
	}
	
	@Then("object body contains {string}")
	public void object_body_contains(String objectName) {
		response.then()
				.log()
				.ifValidationFails()
				.body("", hasKey(objectName))
				.extract()
				.body();
	}
	
	@Then("content type is present")
	public void content_type_is_present() {
		response.then()
				.log()
				.ifValidationFails()
				.header("Content-Type", equalTo("application/json"))
				.log()
				.body();
	}
	
}
