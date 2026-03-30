package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class WaitUtils {
   protected WebDriver driver;
   private Wait<WebDriver> wait;

   //Using Fluent Wait
   public WaitUtils(WebDriver driver) {
      this.driver = driver;
      this.wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(5));
   }

   public WebElement waitForVisibility(WebElement element) {
      return (WebElement)this.wait.until(ExpectedConditions.visibilityOf(element));
   }
   
   public WebElement waitForVisibility(By locator) {
	      return (WebElement)this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	   }

   public WebElement waitUntilClickable(WebElement element) {
      return (WebElement)this.wait.until(ExpectedConditions.elementToBeClickable(element));
   }
   

   public boolean wait_Until_Url_Contains(String input) {
      return (Boolean)this.wait.until(ExpectedConditions.urlContains(input));
   }
}
