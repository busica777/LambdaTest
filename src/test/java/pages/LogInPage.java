package pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseClass;
import com.sun.tools.javac.*;


@Getter
public class LogInPage extends BaseClass {
	@FindBy(xpath = "//a[text()='Continue']")
	private WebElement newCustomerContinueButton;
	
	@FindBy(name ="email")
	private WebElement emailAddress;
	@FindBy(name = "password")
	private WebElement password;
	@FindBy(xpath = "//*[@value='Login']")
	private WebElement logInButton;
	public LogInPage(){
		PageFactory.initElements(driver,this);
	}
}
