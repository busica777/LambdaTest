package pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseClass;



@Getter
public class MyAccountPage extends BaseClass {
	@FindBy(xpath = "(//*[@aria-label='Shop by Category'])[2]")
	private WebElement CategoryButton;
	
	public MyAccountPage() {
		PageFactory.initElements(driver, this);
	}
}
