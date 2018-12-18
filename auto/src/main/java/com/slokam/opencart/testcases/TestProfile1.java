package com.slokam.opencart.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.slokam.opencart.pages.AdminLoginPage;
import com.slokam.opencart.pages.AdminProfilePage;
import com.slokam.opencart.pages.DashboardPage;
import com.slokam.opencart.pages.StatisticsPage;

public class TestProfile1  extends BaseTestCase{

		
	@Test
	public void testSupportFourm() {
		AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
		adminLoginPage.login("admin","admin");
		DashboardPage dashBoardPage = new DashboardPage(driver);
		dashBoardPage.clickOnDemoDropdown();
		dashBoardPage.clickOnYourProfile();
		AdminProfilePage adminProfilePage = new AdminProfilePage(driver);
		String email = adminProfilePage.getAdminEmail();
		System.out.println(email);
		
	}
	
	@Test
	public void verifyStatistics() {
		AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
		adminLoginPage.login("admin","admin");
		DashboardPage dashBoardPage = new DashboardPage(driver);
		dashBoardPage.clickOnStatistics();
		StatisticsPage statisticsPage = new StatisticsPage(driver);
		String orders = statisticsPage.getTotalOrderSales();
		System.out.println(orders);
		Assert.fail();
	}
	
	
}