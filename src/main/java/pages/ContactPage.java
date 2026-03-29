package pages;

import org.openqa.selenium.WebDriver;

import utilities.ConfigReader;


public class ContactPage{
	WebDriver driver;
   
	public ContactPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void navigate_Contact_Page() {
      this.driver.get(ConfigReader.getProperty("baseUrl")+"/contact");
   }
}
