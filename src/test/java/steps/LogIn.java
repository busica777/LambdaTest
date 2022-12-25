package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.NoSuchElementException;
import utils.BaseClass;
import utils.ConfigReader;

import static steps.PageInitializer.homePage;
import static steps.PageInitializer.logInPage;


public class LogIn extends BaseClass {
	@When("user enters valid email address and password")
	public void user_enters_valid_and() {
			click.accept(homePage.getMyAccountButton());
			sendText.accept(logInPage.getEmailAddress(), ConfigReader
					.getPropertyValue.apply("validLogInEmail"));
			sendText.accept(logInPage.getPassword(), ConfigReader
					.getPropertyValue.apply("validLogInPassword"));
	}
	
	
	@When("user click on Login button")
	public void user_click_on_login_button() {
		click.accept(logInPage.getLogInButton());
	}
	
	
	@Then("user navigate to My account page")
	public void user_navigate_to_my_account_page() {
		assertThatText.accept(ConfigReader.getPropertyValue
				.apply("myAccountURL"), driver.getCurrentUrl());
		
		
	}
	
}
