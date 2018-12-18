package auto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelRead {

	@Test
	public void test1() {

		File file = new File("D:\\git\\akaAuto\\src\\test\\resources\\Login.xlsx");
		FileInputStream fis = null;
		XSSFWorkbook workbook = null;
		XSSFSheet sheet = null;
		try {
			fis = new FileInputStream(file);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet("Sheet1");

			XSSFRow row = sheet.getRow(2);
			XSSFCell cell = row.getCell(2);
			String username = getValue(cell);
			System.out.println(username);
			String sr = getValue(row.getCell(1));
			System.out.println(sr);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getValue(Cell cell ) {
		String value= "";
		if (cell.getCellType() == CellType.STRING) {
			value = cell.getStringCellValue();
		} else if (cell.getCellType() == CellType.NUMERIC) {
			int a = (int) cell.getNumericCellValue();
			value = String.valueOf(a);
		}
		
		return value;
	}
	
	
	
	@Test
	public void test2() {

		File file = new File("D:\\git\\akaAuto\\src\\test\\resources\\Login.xls");
		FileInputStream fis = null;
		HSSFWorkbook workbook = null;
		HSSFSheet sheet = null;
		try {
			fis = new FileInputStream(file);
			workbook = new HSSFWorkbook(fis);
			sheet = workbook.getSheet("Sheet1");

			HSSFRow row = sheet.getRow(2);
			HSSFCell cell = row.getCell(2);
			String username = getValue(cell);
			System.out.println(username);
			String sr = getValue(row.getCell(1));
			System.out.println(sr);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void test3() {
		String filepath = "D:\\git\\akaAuto\\src\\test\\resources\\Login.xls";
		File file = new File(filepath);
		FileInputStream fis = null;
		Workbook workbook = null;
		Sheet sheet = null;
		if(filepath.endsWith(".xlsx")) {
			
			try {
				fis = new FileInputStream(file);
				workbook = new XSSFWorkbook(fis);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			try {
				fis = new FileInputStream(file);
				workbook = new HSSFWorkbook(fis);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		sheet = workbook.getSheet("Sheet1");
		Row row = sheet.getRow(2);
		Cell cell = row.getCell(2);
		String username = getValue(cell);
		System.out.println(username);
		String sr = getValue(row.getCell(1));
		System.out.println(sr);
		
		
		
	}
	
}
