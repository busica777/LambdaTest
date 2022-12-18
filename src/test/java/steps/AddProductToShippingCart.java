package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.BaseClass;

import static steps.PageInitializer.homePage;
import static steps.PageInitializer.myAccountPage;

public class AddProductToShippingCart extends BaseClass {
	@When("User clicks on Shop by Category option")
	public void user_clicks_on_shop_by_category_option() {
		click.accept(myAccountPage.getCategoryButton());
	}
	
	@When("User select category for selecting product to purchase")
	public void user_select_category_for_selecting_product_to_purchase() {
		click.accept(iterateListElements
				(homePage.getShopByCategorywebElements(),"wishedCategory"));
	}
	
	@When("User from Product Page select any item")
	public void user_from_product_page_select_any_item() {
	
	}
	
	@When("User clicks on Add to Cart button from Category Page")
	public void user_clicks_on_add_to_cart_button_from_category_page() {
	
	}
	
	@Then("User should see success message that item was added")
	public void user_should_see_success_message_that_item_was_added() {
	
	}
	
}
