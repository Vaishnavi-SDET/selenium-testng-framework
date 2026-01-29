package tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.TestListener;

@Listeners(TestListener.class)

public class LoginTest extends BaseTest{
	
	
	
	@Test (priority = 1)
	
	public void OpenLoginPage()
	{
		driver.get("https://opensource-demo.orangehrmlive.com/");

		LoginPage login = new LoginPage(driver);

		login.OpenLoginPage("Admin", "admin123");

		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "User was not redirected to Dashboard after login");
		}
	@Test (priority = 2)

	public void invalidLogin()
	{
		driver.get("https://opensource-demo.orangehrmlive.com/");
		LoginPage login = new LoginPage(driver);
		login.OpenLoginPage("Abc", "1234");
		Assert.assertTrue(login.getErrorMessage().contains("Invalid"),"Invalid error message not displayed");
		
	}

}
