package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Base;
import pages.PracticeTestExceptionsPage;

public class Test_Exceptions extends Base{

	PracticeTestExceptionsPage practice;
	
	@Test
	public void test_add_row()
	{
		practice=new PracticeTestExceptionsPage(driver);
		practice.navigate_To_Test_Exceptions_Page();
		practice.add_Row();
		Assert.assertTrue(practice.is_row_Displayed(2));
	}
	
	@Test
	public void test_save_row2() throws InterruptedException
	{
		practice=new PracticeTestExceptionsPage(driver);
		practice.navigate_To_Test_Exceptions_Page();
		practice.add_Row();
		practice.set_Text_And_Save("pizza1223",2);
		Assert.assertTrue(practice.isRowSaveSuccessful(2));
	}
	
	@Test
	public void test_Invalid_Element_StateException() throws InterruptedException
	{
		practice = new PracticeTestExceptionsPage(driver);
		practice.navigate_To_Test_Exceptions_Page();
		practice.set_Text_And_Save("Donut", 1);
		Assert.assertTrue(practice.isRowSaveSuccessful(1));
	}
	
	@Test
	public void test_Instructions_Display()
	{
    	practice = new PracticeTestExceptionsPage(driver);
    	practice.navigate_To_Test_Exceptions_Page();
    	Assert.assertTrue(practice.is_Instructions_Displayed());
    	practice.add_Row();
    	practice.is_row_Displayed(2);
    	Assert.assertFalse(practice.is_Instructions_Displayed());
    }
	
}
