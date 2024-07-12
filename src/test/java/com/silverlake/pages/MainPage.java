package com.silverlake.pages;

import org.openqa.selenium.WebDriver;

import com.silverlake.base.WebDriverKeywords;

public class MainPage extends WebDriverKeywords {
	
	private WebDriver driver;

	public MainPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getMainPageTitle() {
		return driver.getTitle();
	}

	public void clickOnPaitentMenu() {

	}
}
