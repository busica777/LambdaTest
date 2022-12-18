package pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseClass;

import java.util.List;


@Getter
public class HomePage extends BaseClass {
	@FindBy(xpath = "(//a[@data-toggle='dropdown'])[3]")
	private  WebElement myAccountButton;
	@FindBy(xpath = "//div[@class='icon svg-icon']/parent::a")
	private List<WebElement> shopByCategorywebElements;
	
	public HomePage(){
		PageFactory.initElements(driver,this);
	}
	
}
