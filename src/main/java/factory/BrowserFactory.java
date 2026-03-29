package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ConfigReader;

public class BrowserFactory {
   public static WebDriver initBrowser(String browserType) {
	  boolean headless=Boolean.valueOf(ConfigReader.getProperty("headless"));
	  WebDriver driver=null;
      if (browserType == null || browserType.trim().isEmpty()) {
    	  browserType=ConfigReader.getProperty("defaultBrowser");
      }
         switch(browserType.toLowerCase()) {
         case "chrome":
        	   WebDriverManager.chromedriver().setup();
        	   ChromeOptions options=new ChromeOptions();
        	   if(headless)
        	   {
        	   options.addArguments("--headless=new");
        	   options.addArguments("--no-sandbox");
        	   options.addArguments("--disable-dev-shm-usage");
        	   options.addArguments("--disable-gpu");
        	   options.addArguments("--window-size=1920,1080");
        	   }
               driver=new ChromeDriver(options);
               break;
         case "firefox":
        	   WebDriverManager.edgedriver().setup();
               FirefoxOptions options_ff=new FirefoxOptions();
               if(headless)
               {
        	   options_ff.addArguments("--headless=new");
        	   options_ff.addArguments("--width=1920");
        	   options_ff.addArguments("--height=1080");
               }
        	   driver=new FirefoxDriver(options_ff);
               break;
         case "edge":
        	WebDriverManager.edgedriver().setup();
        	EdgeOptions options_edge=new EdgeOptions();
        	if(headless)
        	{
        	options_edge.addArguments("--headless=new");
     	    options_edge.addArguments("--no-sandbox");
     	    options_edge.addArguments("--disable-dev-shm-usage");
     	    options_edge.addArguments("--window-size=1920,1080");
        	}
            driver=new EdgeDriver(options_edge);
            break;
         case "default":
        	 ChromeOptions options_c=new ChromeOptions();
        	 if(headless)
        	 {
      	     options_c.addArguments("--headless=new");
      	     options_c.addArguments("--no-sandbox");
      	     options_c.addArguments("--disable-dev-shm-usage");
      	     options_c.addArguments("--disable-gpu");
      	     options_c.addArguments("--window-size=1920,1080");
        	 }
             driver=new ChromeDriver(options_c);
             break;
         }
      return driver;
   }
}
