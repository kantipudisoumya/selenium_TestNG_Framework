package pages;

import org.openqa.selenium.WebDriver;

import utilities.ConfigReader;


public class BlogPage{
	WebDriver driver;
	
	public BlogPage(WebDriver driver)
	{
		this.driver=driver;
	}
   public void navigate_Blog_Page() {
      this.driver.get(ConfigReader.getProperty("baseUrl")+"/blog/");
   }
}
