package pages;

import org.openqa.selenium.WebDriver;

public class CoursesPage {
   WebDriver driver;

   public CoursesPage(WebDriver driver) {
      this.driver = driver;
   }

   public void navigate_Courses_Page() {
      this.driver.get("https://practicetestautomation.com/courses/");
   }
}
