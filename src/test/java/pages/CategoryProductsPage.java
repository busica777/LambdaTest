package pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseClass;

import java.util.List;

@Getter
public class CategoryProductsPage extends BaseClass {
	@FindBy(xpath = "//*[contains(@class,'product-layout')]")
	private List<WebElement> listOfProducts;
	@FindBy(xpath = "//a[normalize-space()='>']")
	private WebElement nextProductListPage;
	
	public CategoryProductsPage(){
		PageFactory.initElements(driver , this);
	}
}
