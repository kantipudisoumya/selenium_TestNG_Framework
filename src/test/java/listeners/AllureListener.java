package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import factory.BrowserFactory;
import io.qameta.allure.Attachment;
import utilities.ScreenshotUtil;

public class AllureListener implements ITestListener{
	
	@Override
	public void onTestFailure(ITestResult result)
	{
		if(BrowserFactory.getDriver()!=null)
		{
		attachScreenshot();
		}
	}
	
    @Attachment(value="Screenshot on failure", type="image/png")
	public byte[] attachScreenshot()
	{
		return ScreenshotUtil.capture();
	}

}
