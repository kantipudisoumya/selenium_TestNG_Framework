package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Attachment;
import utilities.ScreenshotUtil;

public class AllureListener implements ITestListener{
	
	@Override
	public void onTestFailure(ITestResult result)
	{
		attachScreenshot();
	}
	
    @Attachment(value="Screenshot on failure", type="image/png")
	public byte[] attachScreenshot()
	{
		return ScreenshotUtil.capture();
	}

}
