package pages;

import org.openqa.selenium.WebDriver;


public class BlogPage{
	WebDriver driver;
	
	public BlogPage(WebDriver driver)
	{
		this.driver=driver;
	}
   public void navigate_Blog_Page() {
      this.driver.get("https://practicetestautomation.com/blog/");
   }
}
