package auto;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstClass {
	
	public void verifyLogin() {
	
	
		
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		WebElement emailElement = driver.findElementById("email");
		emailElement.sendKeys("naveennegi06");
		
		WebElement passElement = driver.findElementById("pass");
		passElement.sendKeys("mednipur");
		
		WebElement loginElement = driver.findElementById("u_0_2");
		loginElement.click();
		
	}
	
	
	public static void main(String[] arg) {
		FirstClass fb = new FirstClass();
		fb.verifyLogin();
		
		
	}

}
