package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ConfigReader;
import utilities.WaitUtils;

public class LoginPage{
   WebDriver driver;
   WaitUtils wait;
   @FindBy(
      id = "username"
   )
   WebElement username;
   @FindBy(
      id = "password"
   )
   WebElement password;
   @FindBy(
      id = "submit"
   )
   WebElement submit;
   @FindBy(
      id = "error"
   )
   WebElement error;
   @FindBy(
      xpath = "//strong[contains(text(),'Congratulations')]"
   )
   WebElement success;
   @FindBy(
      xpath = "//a[contains(text(),'Log out')]"
   )
   WebElement logout_btn;

   public LoginPage(WebDriver driver) {
      this.driver = driver;
      PageFactory.initElements(driver, this);
      WaitUtils wait = new WaitUtils(driver);
      this.wait = wait;
   }

   public void navigate_To_Login_Page() {
      driver.get(ConfigReader.getProperty("baseUrl")+"/practice-test-login/");
   }

   public void login(String user, String pass) {
      username.sendKeys(user);
      password.sendKeys(pass);
      submit.click();
   }

   public String get_Login_Error() {
      wait.waitForVisibility(error);
      return error.getText();
   }

   public boolean is_Login_Successful() {
      wait.wait_Until_Url_Contains("practicetestautomation.com/logged-in-successfully/");
      wait.waitForVisibility(this.success);
      wait.waitForVisibility(this.logout_btn);
      return true;
   }

   public void logout() {
      wait.waitUntilClickable(logout_btn);
      logout_btn.click();
   }
}
