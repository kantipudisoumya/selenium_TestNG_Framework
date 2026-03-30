package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ConfigReader;
import utilities.WaitUtils;

public class PracticeTestExceptionsPage {
	
	WebDriver driver;
	WaitUtils wait;

	   @FindBy(id = "add_btn")
	   WebElement add_btn_exceptions;
	
	   private By getRowInputField(int rowNumber)
	   {
		   return By.xpath(("//div[@id='row"+rowNumber+"']/input[@type='text']"));
	   }
	   
	   private WebElement getRowEditButton(int rowNumber)
	   {
		   return driver.findElement(By.xpath("//div[@id='row"+rowNumber+"']/button[@id='edit_btn']"));
	   }
	   
	   private WebElement getRowSaveButton(int rowNumber)
	   {
		   return driver.findElement(By.xpath("//div[@id='row"+rowNumber+"']/button[@name='Save']"));
	   }
	   
	   private WebElement getRowSaveConfirmation(int rowNumber)
	   {
		   wait.waitForVisibility(By.xpath("//div[@id='confirmation' and text()='Row "+rowNumber+" was saved' and not(contains(@style,'display: none;'))]"));
		   WebElement element = driver.findElement(By.xpath("//div[@id='confirmation' and text()='Row "+rowNumber+" was saved' and not(contains(@style,'display: none;'))]"));
	       System.out.println(element.getText());
		   return element;
	   }
	   
	   public boolean isRowSaveSuccessful(int rowNumber)
	   {
		   return getRowSaveConfirmation(rowNumber).isDisplayed();
	   }
	   
	   
	   public PracticeTestExceptionsPage(WebDriver driver)
	   {
	      this.driver = driver;
	      PageFactory.initElements(driver, this);
	      wait = new WaitUtils(driver);
	   }
	   
	   public void navigate_To_Test_Exceptions_Page()
	   {
		   driver.get(ConfigReader.getProperty("baseUrl")+"/practice-test-exceptions/");
	   }
	public void add_Row() {
  	  WebElement element=add_btn_exceptions;
  	  element.click();
  }
    
    public boolean is_row_Displayed(int rowNumber)
    {
  	  
  	      WebElement element_found;
  	      By element=getRowInputField(rowNumber);
  		  element_found=wait.waitForVisibility(element);
  		  return element_found.isDisplayed();
    }
    
    public void set_Text_And_Save(String text, int rowNumber)
    {
  	  if(is_row_Displayed(rowNumber))
  	  {
  		  if(!driver.findElement(getRowInputField(rowNumber)).isEnabled())
  		  {
  		     getRowEditButton(rowNumber).click();
  		  }
  		  driver.findElement(getRowInputField(rowNumber)).clear();
  		  driver.findElement(getRowInputField(rowNumber)).sendKeys(text);
  		     getRowSaveButton(rowNumber).click();
  	  }
    }
}
