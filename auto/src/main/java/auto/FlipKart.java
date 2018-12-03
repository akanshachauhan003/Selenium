package auto;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FlipKart {

	
	WebDriver driver = null;
	String url = "https://www.flipkart.com/";
	
	@Before
	public void gsd() {
		lan("chrome");
	}
	
	public void lan(String browser) {

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
	
	@Test
	public void test1() {
		driver.findElement(By.xpath("//button[text()='✕']")).click();
	}
	
	
	
}
