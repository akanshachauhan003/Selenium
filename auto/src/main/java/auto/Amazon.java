package auto;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {
	
	public void login() {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		WebElement ele = driver.findElementByXPath("//*[@id=\"twotabsearchtextbox\"]");
		ele.sendKeys("iphone 7");
		
		WebElement abc = driver.findElementByXPath("//*[@id=\"nav-search\"]/form/div[2]/div/input");
		abc.click();
		
		WebElement asd = driver.findElementByXPath("//*[@id=\"result_0\"]/div/div/div/div[2]/div[2]/div[1]/a/h2");
		asd.click();
		
	}

	public static void main(String[] args) {
		Amazon xyz = new Amazon();
		xyz.login();



	}

}
