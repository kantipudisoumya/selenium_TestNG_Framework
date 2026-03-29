package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;

import factory.BrowserFactory;

public class ScreenshotUtil{
	
	public static byte[] capture()
	{
		WebDriver driver=BrowserFactory.getDriver();
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	}

}
