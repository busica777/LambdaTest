package pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseClass;




@Getter
public class HomePage extends BaseClass {
	@FindBy(xpath = "(//a[@data-toggle='dropdown'])[3]")
	private  WebElement myAccountButton;
	
	public HomePage(){
		PageFactory.initElements(driver,this);
	}
	
}
