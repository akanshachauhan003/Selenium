package auto;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class JQueryUI {
	String url = "http://jqueryui.com";
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
	public void test1() {
		driver.findElement(By.xpath("//a[text()='Droppable']")).click();
		WebElement ele = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(ele);
		
		WebElement drag=  driver.findElement(By.id("draggable"));
		System.out.println(drag.getText());
		
		WebElement drop = driver.findElement(By.id("droppable"));
		System.out.println(drag.getText());
		
		Actions actions = new Actions(driver);
		actions.dragAndDrop(drag, drop).build().perform();
		
		String actual = driver.findElement(By.id("droppable")).getText();
		String expected= "Dropped!";
		
		Assert.assertEquals(expected, actual);
		
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[text()='Resizable']")).click();
		
	}
	
	
	
	
	
}