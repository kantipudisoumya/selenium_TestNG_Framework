package pages;

import org.openqa.selenium.WebDriver;

public class HomePage {
   WebDriver driver;

   public HomePage(WebDriver driver) {
      this.driver = driver;
   }

   public void navigate_To_Home_Page(WebDriver driver) {
      driver.get("https://practicetestautomation.com/");
   }
}
