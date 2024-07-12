package com.silverlake.pages;

import org.openqa.selenium.WebDriver;

public class MainPage {
	private WebDriver driver;

	public MainPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getMainPageTitle() {
		return driver.getTitle();
	}

	public void clickOnPaitentMenu() {

	}
}
