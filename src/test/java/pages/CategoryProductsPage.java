package pages;

import lombok.Getter;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseClass;



@Getter
public class CategoryProductsPage extends BaseClass {
	@FindBy(xpath = "//a[normalize-space()='>']")
	private WebElement nextProductListPage;
	@FindBy(xpath = "//span[normalize-space()='Software']")
	private WebElement shopByCategorySoftware;
	@FindBy(xpath = "//*[contains(@id,'grid-image-42-212408')]")
	private WebElement product_AppleCinema30;
	@FindBy(xpath = "//*[contains(@class,'cart cart-42')]")
	private WebElement addToCartAppleCinema30Icon;
	@FindBy(xpath = "(//*[contains(@class,'cart-42')])[2]")
	private WebElement addToCartFromModalContentButtonAppleCinema30;
	@FindBy(xpath = "//*[contains(@id,'input-option')]")
	private WebElement selectSizeFromMedalContentAppleCinema30;
	@FindBy(xpath = "//p[contains(text(),'Success: You have added')]")
	private WebElement MSGitemWasAddedToShoppingCart;
	
	
	public CategoryProductsPage(){
		PageFactory.initElements(driver , this);
	}
}
