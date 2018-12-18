package com.slokam.opencart.commons.listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.slokam.opencart.testcases.BaseTestCase;

public class CustomListeners extends TestListenerAdapter{

	
	public void onTestFailure(ITestResult result) {
		String name = result.getMethod().getMethodName();
		WebDriver driver = BaseTestCase.getDriver();
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\wilmu\\screen_"+name+"_"+System.currentTimeMillis()+".jpeg");
		try {
			FileUtils.copyFile(source, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
