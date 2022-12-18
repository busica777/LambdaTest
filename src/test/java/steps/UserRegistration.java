package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.BaseClass;

import static steps.PageInitializer.*;
import static utils.ConfigReader.getPropertyValue;

public class UserRegistration extends BaseClass {
	@When("user click on My account button")
	public void user_click_on_my_account_button() {
		click.accept(homePage.getMyAccountButton());
	}
	
	@When("user click on Continue button under New Customer option")
	public void user_click_on_continue_button_under_new_customer_option() {
		click.accept(logInPage.getNewCustomerContinueButton());
	}
	
	@When("user enters personal information")
	public void user_enters_personal_information() {
		sendText.accept(userRegistration
				.getNewUserFirstName(), getPropertyValue.apply("firstName"));
		sendText.accept(userRegistration
				.getNewUserLastName(), getPropertyValue.apply("lastName"));
		sendText.accept(userRegistration
				.getNewUserEmail(), getPropertyValue.apply("email"));
		sendText.accept(userRegistration
				.getNewUserPhoneNumber(), getPropertyValue.apply("telephone"));
		sendText.accept(userRegistration
				.getNewUserPassword(), getPropertyValue.apply("password"));
		sendText.accept(userRegistration
				.getNewUserConfirmPassword(), getPropertyValue.apply("confirmPassword"));
		
		click.accept(userRegistration.getNewsLetterSubscribtion_NO());
		click.accept(userRegistration.getAgreePrivatePolicyButton());
	}
	
	@When("user clicks on Continue button")
	public void user_clicks_on_continue_button() {
		click.accept(userRegistration.getContinueButton());
	}
	
	@Then("user see registration success message")
	public void user_see_registration_success_message() {
		assertThatText.accept(userRegistration.getUserCreatedSuccessfullymMSG().getText(),
				getPropertyValue.apply("successUserRegistrationMSG"));
	}
}
