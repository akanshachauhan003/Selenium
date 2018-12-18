package com.slokam.opencart.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.slokam.opencart.commons.listeners.CustomListeners;

@Listeners(CustomListeners.class)
public class BaseTestCase {

	String url = "https://demo.opencart.com/admin/";
	static WebDriver driver = null;
	
	public static WebDriver getDriver() {
		return driver;
	}

	public void launchBrowser(String browser) {

		if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver-v0.23.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@BeforeMethod
	public void init() {
		launchBrowser("chrome");
	}

	@AfterMethod
	public void tearDown() {
		 driver.close();
	}

}
