package APISteps;

import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;



import static io.restassured.RestAssured.given;
import static utils.APIConstants.GENERATE_TOKEN;
import static utils.APIPayload.adminLogIn;

public class GenerateTokenStep {
	public static String token;
	@Given("JWT is generated")
	public void jwt_is_generated() {
		token = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(adminLogIn())
				.when()
				.post(GENERATE_TOKEN)
				.then()
						.log().body()
				.extract().jsonPath().getString("token");
		
	}
}
