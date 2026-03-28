package tests;

import base.base;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PracticePage;

public class Test_Table_Sort_Filter extends base {
   PracticePage practice;

   @Test
   public void test_sort_enrollments() {
      this.practice = new PracticePage(this.driver);
      this.practice.navigate_To_Test_Table_Page();
      this.practice.select_sort_dropDown("Enrollments");
      Assert.assertTrue(this.practice.is_Column_Sorted("enrollments"));
   }

   @Test
   public void test_sort_CourseName() {
      this.practice = new PracticePage(this.driver);
      this.practice.navigate_To_Test_Table_Page();
      this.practice.select_sort_dropDown("Course Name");
      Assert.assertTrue(this.practice.is_string_Column_Sorted("course"));
   }
}
