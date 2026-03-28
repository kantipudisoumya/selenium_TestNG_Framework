package tests;

import base.base;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.DataProviderUtils;

public class Test_Valid_Login extends base {
   @Test(
      dataProvider = "valid_login",
      dataProviderClass = DataProviderUtils.class
   )
   public void test_valid_login(String username, String password, String expected) throws InterruptedException {
      LoginPage login = new LoginPage(this.driver);
      login.navigate_To_Login_Page();
      login.login(username, password);
      Assert.assertTrue(login.is_Login_Successful(), "Congratulations message, URL and Logout buttons are displayed!");
      System.out.println("success");
      login.logout();
   }
}
