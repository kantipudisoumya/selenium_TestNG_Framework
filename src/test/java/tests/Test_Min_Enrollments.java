package tests;

import base.base;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PracticePage;

public class Test_Min_Enrollments extends base {
   PracticePage practice;

   public void verify_Min_Enrollments(int min_enrollments) {
      List<WebElement> list = this.practice.get_All_Table_Column_Entries("enrollments");
      for(WebElement element:list)
      {
         if (Integer.valueOf(element.getText()) < min_enrollments) {
            Assert.assertFalse(true);
         }
      }

   }

   @Test
   public void test_Min_Enrollments() throws InterruptedException {
      this.practice = new PracticePage(this.driver);
      this.practice.navigate_To_Test_Table_Page();
      String enroll_str = this.practice.select_Min_Enrollments("10000");
      int enrollments = Integer.valueOf(enroll_str);
      this.verify_Min_Enrollments(enrollments);
   }
}
