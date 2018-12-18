package auto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class PropExample {

	@Test
	public void test1() {
		
		File file = new File(".\\src\\test\\resources\\application.properties");
		try {
			FileInputStream fis  = new FileInputStream(file);
			Properties prop  = new Properties();
			prop.load(fis);
			
			String appUrl = prop.getProperty("url");
			System.out.println(appUrl);
			String browser = prop.getProperty("browser", "firefox");
			System.out.println(browser);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}