package com.silverlake.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void EnterUsername(String username) {
		driver.findElement(By.id("authUser")).sendKeys(username);
	}

	public void EnterPassword(String password) {
		driver.findElement(By.cssSelector("#clearPass")).sendKeys(password);
	}

	public void ClickOnLogin() {
		driver.findElement(By.cssSelector("#login-button")).click();
	}

	public String getInvalidErrorMessage() {
		return driver.findElement(By.xpath("//p[contains(text(),'Invalid')]")).getText();
	}
}
