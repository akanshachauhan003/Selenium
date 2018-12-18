package com.slokam.opencart.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.slokam.opencart.pages.AdminLoginPagePF;
import com.slokam.opencart.pages.AdminProfilePage;
import com.slokam.opencart.pages.DashboardPage;

public class TestProfile2 extends BaseTestCase{

	
	@Test
	public void testSupportFourm() {
		AdminLoginPagePF adminLoginPage = new AdminLoginPagePF(driver);
		PageFactory.initElements(driver, adminLoginPage);
		adminLoginPage.login("admin","admin");
		
	}
	
	
	
	
}