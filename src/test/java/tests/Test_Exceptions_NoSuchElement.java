package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Base;
import pages.PracticePage;

public class Test_Exceptions_NoSuchElement extends Base{

	PracticePage practice;
	
	@Test
	public void test_add_row()
	{
		practice=new PracticePage(driver);
		practice.navigate_To_Practice_Page();
		practice.navigate_To_Test_Exceptions_Page();
		practice.add_Row();
		Assert.assertTrue(practice.is_row2_Displayed());
	}
}
