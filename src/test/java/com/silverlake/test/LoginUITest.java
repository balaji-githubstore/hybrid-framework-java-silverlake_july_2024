package com.silverlake.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.silverlake.base.AutomationWrapper;

public class LoginUITest extends AutomationWrapper
{
	@Test	
	public void titleTest() {
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, "OpenEMR Login");
	}

	@Test
	public void applicationDescriptionTest() {
		String actualDesc = driver.findElement(By.xpath("//p[contains(text(),'most')]")).getText();
		Assert.assertEquals(actualDesc,
				"The most popular open-source Electronic Health Record and Medical Practice Management solution.");
	}

}
