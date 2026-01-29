package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstClass {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		driver = new ChromeDriver();
	}
	
	@Test
	public void openGoogle()
	{
	
	driver.get("https://www.google.com");
	}
	
	@AfterMethod
	
	public void quit()
	{
	
	driver.quit();
	}
	
}
