package tests;

import base.base;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PracticePage;

public class Test_Combined_Filter extends base {
   PracticePage practice;

   public void verify_Combined_Filter(String language, String level, String enrollments) throws InterruptedException {
      HashMap<Integer, List<String>>map = new HashMap<Integer, List<String>>();
      map = this.practice.get_Table_Rows_With_Filter();
      int size = map.size();

      for(int i = 0; i < size; ++i) 
      {
         List<String> list=new ArrayList<String>();
         list = map.get(i);
         Assert.assertTrue(((String)list.get(0)).equals(language) && ((String)list.get(1)).equals(level) && Integer.valueOf((String)list.get(2)) > Integer.valueOf(enrollments));
      }

   }

   @Test
   public void test_Combined_Filter() throws InterruptedException 
   {
      practice = new PracticePage(this.driver);
      practice.navigate_To_Test_Table_Page();
      practice.select_Language_Option("Python");
      practice.unselect_All_Level_CheckBoxes();
      practice.select_Level_CheckBox("Beginner");
      practice.select_Min_Enrollments("10000");
      verify_Combined_Filter("Python", "Beginner", "10000");
   }
}
