package auto;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class PetClinic2 {

	String url = "http://localhost:8080";
	WebDriver driver = null;
	@Test
	public void verifyAddOwner() {
		WebElement element = driver.findElement(By.xpath("//a[@title='find owners']"));
		element.click();
		
		driver.findElement(By.xpath("//a[@href='/owners/new']")).click();
		createOwner("asd","asda","aaa","aaa","1231231212");
		
	}
	
	public void createOwner(String firstName,String lastName,String address,String city,String telephone) {
		driver.findElement(By.id("firstName")).sendKeys(firstName);
		driver.findElement(By.id("lastName")).sendKeys(lastName);
		driver.findElement(By.id("address")).sendKeys(address);
		driver.findElement(By.id("city")).sendKeys(city);
		driver.findElement(By.id("telephone")).sendKeys(telephone);
		driver.findElement(By.xpath("//button[text()='Add Owner']")).click();
	}
	
	@Before
	public void init() {
		launchBrowser("chrome");
	}
	
	@After
	public void tearDown() {
		driver.close();
	}
	
	@Test
	public void verifyErrorMessageForAddOwner() {
		driver.findElement(By.xpath("//a[@title='find owners']")).click();
		driver.findElement(By.xpath("//a[@href='/owners/new']")).click();
		createOwner("","asda","aaa","aaa","1231231212");
		String message = driver.findElement(By.xpath("//span[@class='help-inline']")).getText();
		System.out.println(message);
		
		String expected = "must not be empty";
		
		if(message.equals(expected)) {
			System.out.println("PASS");
		}else {
			System.out.println("FAIL");
		}
	}
	
	public void findOwners(String owner) {
		driver.findElement(By.xpath("//a[@title='find owners']")).click();
		By by = By.xpath("//input[@id='lastName']");
		driver.findElement(by).sendKeys(owner);;
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	@Test
	public void addPetToOwner() {
		findOwners("K");
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
	
	@Test
	public void testPetType() {
		findOwners("Black");
		editPet();
		String value = getDefaultPetType();
		String expected = "bird";
		Assert.assertEquals(expected, value);
	}
	
	public void editPet() {
		driver.findElement(By.xpath("//a[ contains(text(),'Edit') and contains(text(),'Pet') ]")).click();
	}
	
	public String getDefaultPetType() {
		WebElement element = driver.findElement(By.id("type"));
		Select select = new Select(element);
		WebElement selectedOption = select.getFirstSelectedOption();
		String optionText = selectedOption.getText();
		System.out.println(optionText);
		return optionText;
	}
	
	
	
	
	
	
	
	
}
