package tests;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.DataProviderUtils;

public class Test_Invalid_Login extends Base {
   @Test(
      dataProvider = "invalid_login",
      dataProviderClass = DataProviderUtils.class
   )
   public void test_invalid_login(String username, String password, String expected) throws InterruptedException {
      LoginPage login = new LoginPage(this.driver);
      login.navigate_To_Login_Page();
      login.login(username, password);
      String errorMessage = login.get_Login_Error();
      System.out.println(errorMessage);
      Assert.assertEquals(errorMessage, expected);
   }
}
