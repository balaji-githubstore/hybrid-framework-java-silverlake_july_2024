package com.silverlake.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.silverlake.base.AutomationWrapper;
import com.silverlake.pages.LoginPage;
import com.silverlake.pages.MainPage;
import com.silverlake.utilities.DataSource;

public class LoginTest extends AutomationWrapper {
	
	@Test(dataProvider = "commonDataProvider",dataProviderClass = DataSource.class)
	public void validLoginTest(String username,String password,String expectedTitle) {
		LoginPage login=new LoginPage(driver);
		login.EnterUsername(username);
		login.EnterPassword(password);
		login.ClickOnLogin();
		
		MainPage main=new MainPage(driver);
		Assert.assertEquals(main.getMainPageTitle(), expectedTitle);
	}
	
	@Test(dataProvider = "commonDataProvider",dataProviderClass = DataSource.class)
	public void invalidLoginTest(String username,String password,String expectedError)
	{
		LoginPage login=new LoginPage(driver);
		login.EnterUsername(username);
		login.EnterPassword(password);
		login.ClickOnLogin();
		
		String actualError = login.getInvalidErrorMessage();
		
		Assert.assertTrue(actualError.contains(expectedError)); //expect true 
	}

}
