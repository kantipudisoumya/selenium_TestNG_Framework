package pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.ConfigReader;
import utilities.WaitUtils;

public class PracticePage{
   WebDriver driver;
   WaitUtils wait;
   @FindBy(
      xpath = "//a[contains(@href,'practice-test-login')]"
   )
   WebElement test_Login_Link;
   @FindBy(
      xpath = "//a[contains(@href,'practice-test-exceptions')]"
      
   )
   WebElement test_Exceptions_Link;
   
   @FindBy(
      xpath = "//a[contains(@href,'practice-test-table')]"
   )
   WebElement test_Table_Link;
   @FindBy(
      xpath = "//input[@name='lang']"
   )
   List<WebElement> lang_option;
   
   @FindBy(
      name = "level"
   )
   List<WebElement> level_checkBox;
   @FindBy(
      xpath = "//table[@id='courses_table']/tbody/tr[not(@style='display: none;')]"
   )
   List<WebElement> table_rows;
   
   @FindBy(
      id = "sortBy"
   )
   WebElement sort_dropDown;
   @FindBy(
      id = "enrollDropdown"
   )
   WebElement dropDown_Min_Enrollments;
   @FindBy(
      xpath = "//ul[@class='dropdown-menu']"
   )
   WebElement dropDown_List;
   @FindBy(
      xpath = "//ul[@class='dropdown-menu']/li"
   )
   List<WebElement> dropDown_List_Items;
   @FindBy(
      id = "noData"
   )
   WebElement noData;
   
   @FindBy(id = "add_btn")
   WebElement add_btn_exceptions;
   
   @FindBy(id = "row2")
   WebElement row2_exceptions;
   
   @FindBy(
      id = "resetFilters"
   )
   WebElement reset_button;
 
   

   public PracticePage(WebDriver driver) {
      this.driver = driver;
      PageFactory.initElements(driver, this);
      WaitUtils wait = new WaitUtils(driver);
      this.wait = wait;
   }

   public void navigate_To_Practice_Page() {
      this.driver.get(ConfigReader.getProperty("baseUrl")+"/practice/");
   }

   public void navigate_To_Test_Table_Page() {
      this.navigate_To_Practice_Page();
      this.test_Table_Link.click();
   }

   public void navigate_To_Test_Login_Page() {
      this.navigate_To_Practice_Page();
      this.test_Table_Link.click();
   }

   public void navigate_To_Test_Exceptions_Page() {
      this.navigate_To_Practice_Page();
      this.test_Exceptions_Link.click();
   }
   

   public WebElement select_Language_Option(String language) {
      List<WebElement> list = this.lang_option;
      for(WebElement element:list)
      {
         if (element.getAttribute("value").equals(language)) {
            if (!element.isSelected()) {
               element.click();
            }

            return element;
         }
      }

      return null;
   }

   public WebElement select_Level_CheckBox(String level) {
      List<WebElement> list = this.level_checkBox;
      for(WebElement element:list)
      {
         if (element.getAttribute("value").equals(level)) {
            if (!element.isSelected()) {
               element.click();
            }

            return element;
         }
      }

      return null;
   }

   public void select_All_Level_CheckBoxes() {
      List<WebElement> list = this.level_checkBox;

      for(WebElement element:list) 
      {
         if (!element.isSelected()) {
            element.click();
         }
      }

   }

   public void unselect_All_Level_CheckBoxes() {
      List<WebElement> list = this.level_checkBox;

      for(WebElement element:list)
         {
            if (element.isSelected()) 
            {
              element.click();
            }
        }
   }

   public List<WebElement> get_All_Table_Column_Entries(String columnName) 
   {
      List<WebElement> rows = this.driver.findElements(By.xpath("//table[@id='courses_table']/tbody/tr[not(contains(translate(@style,' ',''),'display:none;'))]/td[@data-col='" + columnName + "']"));
      for(WebElement row:rows)
      {
         wait.waitForVisibility(row);
      }
      return rows;
   }

   public boolean is_Column_Sorted(String columnName) {
      List<WebElement> list = new ArrayList<WebElement>();
      list = get_All_Table_Column_Entries(columnName);
      int value = 0;
      
      for(WebElement item:list)
      {
         System.out.println("List item = " + item.getText());
         if (Integer.valueOf(item.getText()) < value) {
            return false;
         }
      }

      return true;
   }

   public boolean is_string_Column_Sorted(String columnName) {
      List<WebElement> list = new ArrayList<WebElement>();
      list = get_All_Table_Column_Entries(columnName);
      char value = 'a';
      
      for(WebElement item: list)   	  
      {
         System.out.println("List item = " + item.getText());
         if (item.getText().toLowerCase().charAt(0) < value) {
            return false;
         }
         value = item.getText().toLowerCase().charAt(0);
      }

      return true;
   }

   public String select_Min_Enrollments(String input) {
      this.dropDown_Min_Enrollments.click();
      String temp = "";
      List<WebElement> list=dropDown_List_Items;
      for(WebElement element:list)
      {
         if (element.getAttribute("data-value").toString().contains(input)) {
            temp = element.getAttribute("data-value").toString();
            element.click();
         }
      }

      return temp;
   }

   public HashMap<Integer, List<String>> get_Table_Rows_With_Filter() {
      HashMap<Integer, List<String>> map = new HashMap<Integer, List<String>>();
      int i = 0;
      List<WebElement> rows = this.table_rows;

      for(WebElement element:rows)
      {
         String language = element.findElement(By.xpath(".//td[@data-col='language']")).getText();
         String level = element.findElement(By.xpath(".//td[@data-col='level']")).getText();
         String enrollments = element.findElement(By.xpath(".//td[@data-col='enrollments']")).getText();
         List<String> list = new ArrayList<String>();
         list.add(0, language);
         list.add(1, level);
         list.add(2, enrollments);
         map.put(i, list);
      }

      return map;
   }

   public String get_noData_Error() {
       return this.noData.getText();
   }

   public void select_sort_dropDown(String option) {
      Select sort_drop_Down = new Select(this.sort_dropDown);
      sort_drop_Down.selectByVisibleText(option);
   }

   public boolean is_reset_Visble() {
      boolean status = this.reset_button.isDisplayed();
      return status;
   }

   public boolean is_get_noData_Error_Displayed() {
      return this.noData.isDisplayed();
   }
   
      public void add_Row() {
    	  WebElement element=add_btn_exceptions;
    	  System.out.println(element.getText());
    	  element.click();
    }
      
      public boolean is_row2_Displayed()
      {
    	  
    	      WebElement element_found;
    		  By element=By.xpath("//div[@id='row2']/input[@type='text']");
    		  element_found=wait.waitForVisibility(element);
    		  return element_found.isDisplayed();
      }
}
