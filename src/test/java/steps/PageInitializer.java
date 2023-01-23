package steps;

import pages.*;

public class PageInitializer {
	
	public static HomePage homePage;
	public static LogInPage logInPage;
	public static UserRegistrationPage userRegistration;
	public static MyAccountPage myAccountPage;
	public static CategoryProductsPage categoryProductsPage;
	
	public static void initializePages() {
		homePage = new HomePage();
		logInPage = new LogInPage();
		userRegistration = new UserRegistrationPage();
		myAccountPage = new MyAccountPage();
		categoryProductsPage = new CategoryProductsPage();
		
		
	}
}
