package tests;

import base.Base;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PracticePage;

public class Test_Table_LevelFilter extends Base {
   PracticePage practice;

   @Test
   public void test_Table_Filter() {
      this.practice = new PracticePage(this.driver);
      this.practice.navigate_To_Test_Table_Page();
      this.practice.unselect_All_Level_CheckBoxes();
      this.practice.select_Level_CheckBox("Beginner");
      this.verify_All_Table_Level_Entries("Beginner", "level");
   }

   public void verify_All_Table_Level_Entries(String level_Value, String level) {
      List<WebElement> list = this.practice.get_All_Table_Column_Entries(level);
      for(WebElement element:list)
      {
         Assert.assertEquals(element.getText(), level_Value);
         System.out.println("Level is " + element.getText());
      }

   }
}
