package tests;

import base.base;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PracticePage;

public class Test_Table_LanguageFilter extends base {
   PracticePage practice;

   public boolean verify_All_Table_Language_Entries(String input, String language) {
      List<WebElement> rows = this.practice.get_All_Table_Column_Entries(language);
      for(WebElement row: rows)
      {
         Assert.assertEquals(row.getText(), input);
      }

      return true;
   }

   @Test
   public void test_LanguageFilter() {
      this.practice = new PracticePage(this.driver);
      this.practice.navigate_To_Test_Table_Page();
      this.practice.select_Language_Option("Java");
      this.verify_All_Table_Language_Entries("Java", "language");
   }
}
