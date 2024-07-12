package com.silverlake.base;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

public class WebDriverKeywords {

	private WebDriver driver;
	private FluentWait<WebDriver> wait;

	public WebDriverKeywords(WebDriver driver) {
		this.driver = driver;

		wait = new FluentWait<WebDriver>(driver);
		wait.ignoring(Exception.class);
		wait.withTimeout(Duration.ofSeconds(30));
//		 wait.pollingEvery(Duration.ofSeconds(1));
	}

	public void clickElement(By locator) {
		// driver.findElement(locator).click();
		wait.until(x -> x.findElement(locator)).click();
	}

	public void typeOnElement(By locator, String text) {
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(text);
	}

	public String getElementText(By locator) {
		return driver.findElement(locator).getText();
	}
	
	public void SwitchToTabUsingTitle(String title)
	{
		ArrayList<String> windows=new ArrayList<String>(driver.getWindowHandles());
		
		for(String window : windows)
		{
			driver.switchTo().window(window);
			if(driver.getTitle().equals(title))
			{
				break;
			}
		}
		
		//currently driver will point to the matching title
	}
}








