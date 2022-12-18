package pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseClass;


@Getter
public class UserRegistrationPage extends BaseClass {
	@FindBy(name = "firstname")
	private WebElement newUserFirstName;
	@FindBy(name = "lastname")
	private WebElement newUserLastName;
	@FindBy(name = "email")
	private WebElement newUserEmail;
	@FindBy(name = "telephone")
	private WebElement newUserPhoneNumber;
	@FindBy(name = "password")
	private WebElement newUserPassword;
	@FindBy(name = "confirm")
	private WebElement newUserConfirmPassword;
	@FindBy(xpath = "//label[@for='input-newsletter-yes']")
	private WebElement newUserNewsLetterSubscribtion_YES;
	@FindBy(xpath = "//label[@for='input-newsletter-no']")
	private WebElement newsLetterSubscribtion_NO;
	@FindBy(xpath = "//label[@for='input-agree']")
	private WebElement agreePrivatePolicyButton;
	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;
	@FindBy(xpath = "(//div[contains(@class,'col-md-9')]/p)[2]")
	private WebElement userCreatedSuccessfullymMSG;
	
	public UserRegistrationPage() {
		PageFactory.initElements(driver, this);
	}
}
