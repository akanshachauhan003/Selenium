package auto;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class PetClinic {

	String url = "http://localhost:8080";
	@Test
	public void verifyAddOwner() {
		//System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
		//ChromeDriver driver = new ChromeDriver();
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		FirefoxDriver driver = new FirefoxDriver();
		driver.get(url);
		
		WebElement element = driver.findElementByXPath("//a[@title='find owners']");
		element.click();
		
		driver.findElementByXPath("//a[@href='/owners/new']").click();
		
		driver.findElementById("firstName").sendKeys("ABC");
		driver.findElementById("lastName").sendKeys("K");
		driver.findElementById("address").sendKeys("ADDRESS1");
		driver.findElementById("city").sendKeys("Kent");
		driver.findElementById("telephone").sendKeys("1231231231");
		
		driver.findElementByXPath("//button[text()='Add Owner']").click();
	}
	@Test
	public void addPetToOwner() {
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		FirefoxDriver driver = new FirefoxDriver();
		driver.get(url);
		WebElement ele = driver.findElementByXPath("//a[@title='find owners']");
		driver.findElementByXPath("//a[@title='find owners']").click();
		
		By by = By.xpath("//input[@id='lastName']");
		driver.findElement(by).sendKeys("K");;
		
		//driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'New')]")).click();
		
		driver.findElement(By.id("name")).sendKeys("Pet1");
		driver.findElement(By.id("birthDate")).sendKeys("2018-10-20");
		
		//Select an option from dropdown
		
		WebElement petTypeEle = driver.findElement(By.id("type"));
		Select select = new Select(petTypeEle);
		select.selectByVisibleText("cat");
		driver.findElement(By.xpath("//button[text()='Add Pet']")).click();
	}
	
	@Test
	public void verifyErrorMessageForAddOwner() {
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		FirefoxDriver driver = new FirefoxDriver();
		driver.get(url);
		driver.findElementByXPath("//a[@title='find owners']").click();
		driver.findElementByXPath("//a[@href='/owners/new']").click();
		driver.findElementById("firstName").sendKeys("");
		driver.findElementById("lastName").sendKeys("K");
		driver.findElementById("address").sendKeys("ADDRESS1");
		driver.findElementById("city").sendKeys("Kent");
		driver.findElementById("telephone").sendKeys("1231231231");
		
		driver.findElementByXPath("//button[text()='Add Owner']").click();
		
		String message = driver.findElement(By.xpath("//span[@class='help-inline']")).getText();
		System.out.println(message);
		
		String expected = "must not be empty";
		
		if(message.equals(expected)) {
			System.out.println("PASS");
		}else {
			System.out.println("FAIL");
		}
		/*String title = driver.getTitle();
		System.out.println(title);
		
		String st = driver.getPageSource();
		System.out.println(st);
		
		String current= driver.getCurrentUrl();
		System.out.println(current);*/
		driver.close();
		//driver.quit();
	}
	
	
}