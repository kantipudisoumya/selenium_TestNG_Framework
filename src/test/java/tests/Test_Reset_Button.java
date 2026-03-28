package tests;

import base.base;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PracticePage;

public class Test_Reset_Button extends base {
   PracticePage practice;

   @Test
   public void test_reset_button() {
      this.practice = new PracticePage(this.driver);
      this.practice.navigate_To_Test_Table_Page();
      Assert.assertFalse(this.practice.is_reset_Visble());
      this.practice.unselect_All_Level_CheckBoxes();
      Assert.assertTrue(this.practice.is_reset_Visble());
      Assert.assertNotNull(this.practice.get_noData_Error());
      this.practice.select_All_Level_CheckBoxes();
      Assert.assertFalse(this.practice.is_get_noData_Error_Displayed());
   }
}
