package auto;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenCart2 {
	String url = "https://demo.opencart.com/";
	WebDriver driver = null;
	
	@Test
	public void register() {
		WebElement element = driver.findElement(By.xpath("//a[@title=\"My Account\"]"));
		element.click();
		
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")).click();
		personalDetails("akansha","chauhan","akansha001@gmail.com","1231231212");
		password("1234","3456");
		}
	
	 public void personalDetails(String firstName, String LastName, String email, String telephone ) {
		 driver.findElement(By.xpath("//*[@id=\"input-firstname\"]")).sendKeys(firstName);
		 driver.findElement(By.xpath("//*[@id=\"input-lastname\"]")).sendKeys(LastName);
		 driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys(email);
		 driver.findElement(By.xpath("//*[@id=\"input-telephone\"]")).sendKeys(telephone);
		 
	 }
	 public void password(String password, String passwordConfirm) {
		 
		 driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys(password);
		 driver.findElement(By.xpath("//*[@id=\"input-confirm\"]")).sendKeys(passwordConfirm);
		 
		 driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]")).click();
		 driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
	 }
	 
	 @Before
		public void init() {
			launchBrowser("chrome");
		}
	 
	 public void launchBrowser(String browser) {
			
			if(browser.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver-v0.23.0-win64\\geckodriver.exe");
				driver = new FirefoxDriver();
			}else {
				System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
			}
			driver.get(url);
		}
}
