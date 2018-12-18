package com.slokam.opencart.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestProfile extends BaseTestCase{

	
	@Test
	public void testSupportFourm() {
		login("admin","admin");
		clickOnDemoDropdown();
		clickOnYourProfile();
		String email = driver.findElement(By.id("input-email")).getAttribute("value");
		System.out.println(email);
		Assert.assertEquals(email, "bharath.kristipati@fsds.com");
	}
	
	public void screenshot() {
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("D:\\screen.jpeg");
		try {
			FileUtils.copyFile(source, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void login(String user,String pass) {
		driver.findElement(By.id("input-username")).sendKeys(user);
		driver.findElement(By.id("input-password")).sendKeys(pass);
		driver.findElement(By.cssSelector("button[class='btn btn-primary']")).click();
	}
	
	public void clickOnDemoDropdown() {
		driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
	}
	public void clickOnYourProfile() {
		driver.findElement(By.xpath("//a[contains(text(),'Your Profile')]")).click();
	}
	 
	public void clickOnSupportForum() {
		driver.findElement(By.xpath("//a[contains(text(),'Support Forum')]")).click();
	}
}
