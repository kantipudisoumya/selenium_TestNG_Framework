package pages;

import org.openqa.selenium.WebDriver;

import utilities.ConfigReader;

public class CoursesPage {
   WebDriver driver;

   public CoursesPage(WebDriver driver) {
      this.driver = driver;
   }

   public void navigate_Courses_Page() {
      this.driver.get(ConfigReader.getProperty("baseUrl")+"/courses/");
   }
}
