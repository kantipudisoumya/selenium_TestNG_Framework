package utilities;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
   protected WebDriver driver;
   private WebDriverWait wait;

   public WaitUtils(WebDriver driver) {
      this.driver = driver;
      this.wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
   }

   public WebElement waitForVisibility(WebElement element) {
      return (WebElement)this.wait.until(ExpectedConditions.visibilityOf(element));
   }

   public WebElement waitUntilClickable(WebElement element) {
      return (WebElement)this.wait.until(ExpectedConditions.elementToBeClickable(element));
   }

   public boolean wait_Until_Url_Contains(String input) {
      return (Boolean)this.wait.until(ExpectedConditions.urlContains(input));
   }
}
