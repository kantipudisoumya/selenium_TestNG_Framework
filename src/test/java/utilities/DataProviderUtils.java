package utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtils {
   @DataProvider(
      name = "invalid_login"
   )
   public Object[][] invalid_loginData() {
      return new Object[][]{{"incorrectUser", "Password123", "Your username is invalid!"}, {"student", "incorrectPassword", "Your password is invalid!"}};
   }

   @DataProvider(
      name = "valid_login"
   )
   public Object[][] valid_loginData() {
      return new Object[][]{{"student", "Password123", "Congratulations"}};
   }
}
