package base;
import org.openqa.selenium.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import factory.BrowserFactory;

public class base {
	protected WebDriver driver;
	
	@Parameters("browser")
	@BeforeClass
	public void init_Driver(@Optional("chrome") String browser)
	{
		driver=BrowserFactory.initBrowser(browser);
		
		if(driver==null)
		{
			throw new RuntimeException("Browser is null even after initialization");
		}
		driver.manage().window().maximize();
		
	}
	
	@AfterClass
	public void tearDown()
	{
		if(driver!=null)
		{
			driver.quit();
		}
	}

}
