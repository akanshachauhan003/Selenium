package auto;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.annotations.Test;

public class WriteFile {

	@Test
	public void write() {
		
		File file = new File("Desktop\\Logback.txt");
		try {
			FileOutputStream fos = new FileOutputStream(file);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			String st = new String("I am Akansha");
			byte[] by = st.getBytes();
			bos.write(by);
			bos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void write2() {
		
		File file = new File("Desktop\\Logback.txt");
		try {
			FileWriter fos = new FileWriter(file);
			BufferedWriter bos = new BufferedWriter(fos);
			String st = new String("I am Akansha 2");
			bos.write(st);
			bos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}