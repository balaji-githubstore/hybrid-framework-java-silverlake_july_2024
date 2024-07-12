package com.silverlake.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class AutomationWrapper {

	protected WebDriver driver;

	@BeforeMethod
	@Parameters({ "browser", "node" })
	public void setup(@Optional("ch") String browserName, @Optional("NA") String node) throws MalformedURLException {

		if (node.equalsIgnoreCase("NA")) {
			if (browserName.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			} else if (browserName.equalsIgnoreCase("ff")) {
				driver = new FirefoxDriver();
			} else {
				driver = new ChromeDriver();
			}
		} else {
			DesiredCapabilities cap = new DesiredCapabilities();
			if (browserName.equalsIgnoreCase("edge")) {
				cap.setBrowserName("edge");
			} else if (browserName.equalsIgnoreCase("ff")) {
				cap.setBrowserName("chrome");
			} else {
				cap.setBrowserName("chrome");
			}

			driver = new RemoteWebDriver(new URL(node), cap);
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demo.openemr.io/b/openemr");
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
