package com.slokam.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLoginPagePF {

	WebDriver driver;

	@FindBy(id="input-username")
	WebElement userName;
	
	@FindBy(id="input-password")
	WebElement password;
	
	@FindBy(css="button[class='btn btn-primary']")
	WebElement login;
	
	public AdminLoginPagePF(WebDriver driver) {
		this.driver = driver;
	}

	public void login(String user, String pass) {
		userName.sendKeys(user);
		password.sendKeys(pass);
		login.click();
	}
}
