package APISteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import org.junit.Assert;
import utils.APIConstants;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static APISteps.CreateNewEmployee.employeeID;
import static APISteps.CreateNewEmployee.request;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class RetrieveCreatedEmployee {
	
	
	@Given("request is prepared")
	public void request_is_prepared() {
		System.out.println(employeeID);
		request = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.queryParam("employee_id", employeeID)
				.auth().oauth2(GenerateTokenStep.token);
		
	}
	
	@When("get call is made for retrieving employee")
	public void get_call_is_made_for_retrieving_employee() {
		CreateNewEmployee.response = request.when()
				.get(APIConstants.RETRIEVE_CREATED_EMPLOYEE);
	}
	
	@Then("{string} is match with global employee id value")
	public void is_match_with_global_employee_id_value(String empId) {
		CreateNewEmployee.response.then()
				.log()
				.ifValidationFails()
				.body(empId, equalTo(employeeID));
	}
	
	@Then("{string} object data match with created employee information")
	public void object_data_match_with_created_employee_information(String empObject,
																	io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> expectedData = dataTable.asMaps();
		//to get all the keys and values of employee object, we use jsonPath.get method
		Map<String, String> actualData = CreateNewEmployee.response.body().jsonPath().get(empObject);
		
		for (Map<String, String> map : expectedData) {
			//it returns all the keys
			Set<String> keys = map.keySet();
			for (String key : keys) {
				String expectedValue = map.get(key);
				String actualValue = actualData.get(key);
				Assert.assertEquals(expectedValue, actualValue);
			}
		}
		
	}
}
