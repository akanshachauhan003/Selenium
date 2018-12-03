package auto;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Amazon1 {

	WebDriver driver = null;
	String url = "https://www.amazon.in/";
	
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
	public void verifyCat() {
		WebElement ele = driver.findElement(By.xpath("//a[@id='nav-link-shopall']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(ele).build().perform();
		WebElement tvEle = driver.findElement(By.xpath("//span[text()='TV, Appliances, Electronics']"));
		actions.moveToElement(tvEle).build().perform();
		driver.findElement(By.xpath("//span[text()='Televisions']")).click();
	}
}
