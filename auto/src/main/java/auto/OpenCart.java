package auto;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class OpenCart {
	
	String url = "https://demo.opencart.com/";
	WebDriver driver = null;
	
	@Before
	public void gsd() {
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
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

     @Test
    public void components() {
    	WebElement ele = driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[3]/a"));
    	Actions actions = new Actions(driver);
		actions.moveToElement(ele).build().perform();
		driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[3]/div/div/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"input-sort\"]")).click();
     
		WebElement SortTypeEle = driver.findElement(By.id("input-sort"));
		Select select = new Select(SortTypeEle);
		select.selectByVisibleText("Name (Z - A)");
		actions.moveToElement(ele).build().perform();
		driver.findElement(By.xpath("//*[@id=\"input-sort\"]")).click();
     }
		
		public void samsung() {
		
	    driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[1]/div/div[2]/div[1]/h4/a")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/h1"));
		
     }
		
		
		
		
		
    }
		
		
    


