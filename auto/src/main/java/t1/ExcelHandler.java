package t1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

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

public class ExcelHandler {
	
	        Workbook workbook = null;
	        Sheet sheet = null;
	        public void init() {
			String filepath = ".\\src\\test\\resources\\Login.xls";
			File file = new File(filepath);
			FileInputStream fis = null;
			
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
			
			}
	        
	        public int getTotalRows() {
	        	int total = sheet.getPhysicalNumberOfRows();
	        	return total-1;
	        }
	        
	        public String getRowData(int rowNumber, int columnNumber) {
	        	Row row = sheet.getRow(rowNumber);
	        	Cell cell = row.getCell(columnNumber);
	        	return getValue(cell);
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
	        
	        
	        
	        
	        
		
	}