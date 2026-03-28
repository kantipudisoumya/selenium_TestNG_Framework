package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
   public static WebDriver initBrowser(String browserType) {
	  WebDriver driver=null;
      if (browserType == null || browserType.trim().isEmpty()) {
    	  browserType="chrome";
    	  driver=new ChromeDriver();
      }
      else
      {
         switch(browserType.toLowerCase()) {
         case "chrome":
               driver=new ChromeDriver();
               break;
         case "firefox":
               driver=new FirefoxDriver();
               break;
         case "edge":
            driver=new EdgeDriver();
            break;
         case "default":
            driver=new ChromeDriver();
            break;
         }
      }
      return driver;
   }
}
