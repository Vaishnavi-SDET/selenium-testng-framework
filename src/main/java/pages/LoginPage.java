package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	private WebDriver driver;
	
	By username = By.xpath("//input[@placeholder='Username']");
	By password = By.xpath("//input[@placeholder='Password']");
	By loginbtn = By.xpath("//button[@type='submit']");
	By invalidCreds = By.className(".oxd-alert-content-text");
	
	public LoginPage (WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void OpenLoginPage (String user, String pass)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement userField = wait.until(ExpectedConditions.visibilityOfElementLocated(username));
		userField.sendKeys(user);
		
		
		driver.findElement(password).sendKeys(pass);
		driver.findElement(loginbtn).click();
	}
	
	public String getErrorMessage()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		return wait.until(ExpectedConditions.visibilityOfElementLocated(invalidCreds)).getText();
	}

}
