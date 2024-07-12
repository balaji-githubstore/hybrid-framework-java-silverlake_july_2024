package com.silverlake.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.silverlake.base.WebDriverKeywords;

public class LoginPage extends WebDriverKeywords {

	private By usernameLocator = By.id("authUser");
	private By passwordLocator = By.cssSelector("#clearPass");
	private By invalidLocator = By.xpath("//p[contains(text(),'Invalid')]");
	private By loginLocator = By.cssSelector("#login-button");

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void EnterUsername(String username) {
		//driver.findElement(usernameLocator).sendKeys(username);
		super.typeOnElement(usernameLocator, username);
	}

	public void EnterPassword(String password) {
		//driver.findElement(passwordLocator).sendKeys(password);
			typeOnElement(passwordLocator, password);
	}

	public void ClickOnLogin() {
		//driver.findElement(loginLocator).click();
		clickElement(loginLocator);
	}

	public String getInvalidErrorMessage() {
		//return driver.findElement(invalidLocator).getText();
		return super.getElementText(invalidLocator);
	}

	public String getUsernamePlaceholder() {
		return driver.findElement(usernameLocator).getAttribute("placeholder");
	}
}
