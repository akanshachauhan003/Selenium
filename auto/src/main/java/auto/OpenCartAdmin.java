package auto;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpenCartAdmin {

	String url = "https://demo.opencart.com/admin/";
	WebDriver driver = null;
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
		//driver.close();
	}
	
	@Test
	public void testSupportFourm() {
		login("admin","admin");
		clickOnDemoDropdown();
		clickOnSupportForum();
		
		String mainHandle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		String childHandle = "";
		for (String handle : handles) {
			if(!handle.equals(mainHandle)) {
				childHandle = handle;
			}
		}
		
		driver.switchTo().window(childHandle);
		String st = driver.findElement(By.xpath("//a[@data-navbar-reference='index']")).getText();
		System.out.println(st);
		driver.close();
	}
	
	public void login(String user,String pass) {
		driver.findElement(By.id("input-username")).sendKeys(user);
		driver.findElement(By.id("input-password")).sendKeys(pass);
		driver.findElement(By.cssSelector("button[class='btn btn-primary']")).click();
	}
	
	public void clickOnDemoDropdown() {
		driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
	}
	
	public void clickOnSupportForum() {
		driver.findElement(By.xpath("//a[contains(text(),'Support Forum')]")).click();
	}
	
	
	
}
