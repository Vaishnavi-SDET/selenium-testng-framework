package utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener
{
	
	public void onTestFailure (ITestResult result)
	{
		WebDriver driver = ((base.BaseTest) result.getInstance()).driver;
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File destDir = new File("Screenshots");
		if (!destDir.exists())
		{
			destDir.mkdirs();
		}
		
		try {
			FileUtils.copyFile(src, new File("Screenshots/" + result.getName() + ".png"));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
