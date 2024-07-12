package com.silverlake.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.silverlake.base.AutomationWrapper;
import com.silverlake.utilities.DataSource;

public class LoginTest extends AutomationWrapper {
	
	@Test(dataProvider = "commonDataProvider",dataProviderClass = DataSource.class)
	public void validLoginTest(String username,String password,String expectedTitle) {
		driver.findElement(By.id("authUser")).sendKeys(username);
		driver.findElement(By.cssSelector("#clearPass")).sendKeys(password);
		driver.findElement(By.cssSelector("#login-button")).click();
		
		Assert.assertEquals(driver.getTitle(), expectedTitle);
	}
	
	@Test(dataProvider = "commonDataProvider",dataProviderClass = DataSource.class)
	public void invalidLoginTest(String username,String password,String expectedError)
	{
		driver.findElement(By.id("authUser")).sendKeys(username);
		driver.findElement(By.cssSelector("#clearPass")).sendKeys(password);
		driver.findElement(By.cssSelector("#login-button")).click();
		
		String actualError = driver.findElement(By.xpath("//p[contains(text(),'Invalid')]")).getText();
		
		Assert.assertTrue(actualError.contains(expectedError)); //expect true 
	}

}
