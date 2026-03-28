package tests;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PracticePage;

public class Test_Reset_Button extends Base {
   PracticePage practice;

   @Test
   public void test_reset_button() {
      practice = new PracticePage(this.driver);
      practice.navigate_To_Test_Table_Page();
      Assert.assertFalse(practice.is_reset_Visble());
      practice.unselect_All_Level_CheckBoxes();
      Assert.assertTrue(practice.is_reset_Visble());
      Assert.assertNotNull(practice.get_noData_Error());
      this.practice.select_All_Level_CheckBoxes();
      Assert.assertFalse(practice.is_get_noData_Error_Displayed());
   }
}
