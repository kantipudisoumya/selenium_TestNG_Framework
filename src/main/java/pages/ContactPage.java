package pages;

import org.openqa.selenium.WebDriver;


public class ContactPage{
	WebDriver driver;
   
	public ContactPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void navigate_Contact_Page() {
      this.driver.get("https://practicetestautomation.com/contact/");
   }
}
