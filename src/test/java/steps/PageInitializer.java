package steps;

import pages.HomePage;
import pages.LogInPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;

public class PageInitializer {
	
	public static HomePage homePage;
	public static LogInPage logInPage;
	public static UserRegistrationPage userRegistration;
	public static MyAccountPage myAccountPage;
	
	public static void initializePages() {
		homePage = new HomePage();
		logInPage = new LogInPage();
		userRegistration = new UserRegistrationPage();
		myAccountPage = new MyAccountPage();
		
	}
}
