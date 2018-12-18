package com.slokam.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminProfilePage {

	WebDriver driver;

	public AdminProfilePage(WebDriver driver) {
		this.driver = driver;
	}

	public String getAdminEmail() {
		String email = driver.findElement(By.id("input-email")).getAttribute("value");
		return email;
	}
}
