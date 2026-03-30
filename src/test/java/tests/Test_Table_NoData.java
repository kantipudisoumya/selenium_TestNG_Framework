package tests;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PracticeTestTablePage;

public class Test_Table_NoData extends Base {
   PracticeTestTablePage practice;

   @Test
   public void test_noData() throws InterruptedException {
      this.practice = new PracticeTestTablePage(this.driver);
      this.practice.navigate_To_Test_Table_Page();
      this.practice.select_Language_Option("Python");
      this.practice.select_Min_Enrollments("50000");
      Assert.assertEquals(this.practice.get_noData_Error(), "No matching courses.");
   }
}
