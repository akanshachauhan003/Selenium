package com.slokam.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminLoginPage {

	WebDriver driver;
	
	public AdminLoginPage(WebDriver driver) {
		this.driver = driver;
	}
	public void login(String user,String pass) {
		driver.findElement(By.id("input-username")).sendKeys(user);
		driver.findElement(By.id("input-password")).sendKeys(pass);
		driver.findElement(By.cssSelector("button[class='btn btn-primary']")).click();
	}
}
