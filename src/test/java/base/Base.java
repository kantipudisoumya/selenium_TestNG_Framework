package base;
import org.openqa.selenium.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import factory.BrowserFactory;
import listeners.AllureListener;

@Listeners(AllureListener.class)
public class Base {
	protected WebDriver driver;
	
	@Parameters("browser")
	@BeforeClass
	public void init_Driver(@Optional String browser)
	{
		driver=BrowserFactory.initBrowser(browser);
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
