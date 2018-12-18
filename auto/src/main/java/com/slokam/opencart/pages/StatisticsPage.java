package com.slokam.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StatisticsPage {
	WebDriver driver;

	public StatisticsPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getTotalOrderSales() {
		String order = driver.findElement(By.xpath("//td[text()='Order Sales']/following-sibling::td")).getText();
		return order;
	}
}
