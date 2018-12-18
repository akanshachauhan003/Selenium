package t1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataExample {
	
	@Test(dataProvider= "excel")
	public void validateLogin(String user, String pass) {
		System.out.println("username: " + user + "password: " + pass);
		
	}
	
	@DataProvider(name = "login")
	public Object[][] datap(){
		
		Object[][] obj = {   {"akansha ", "akansha123"}, {"chauhan ", "chauhan123"}, {"asd ", "qwe"}, {"fdfe ", "rff"}    };
		
		return obj;
	}
	
	@DataProvider(name = "login1")
	public Object[][] datap1(){
		
		Object[][] obj = new Object[6][2];
		
		for(int i = 0; i <obj.length; i++) {
			obj[i][0] = "akansha" + i;
			obj[i][1] = "password" + i;
		}
		return obj;
	}
	
	@DataProvider(name= "excel")
	public Object[][] datap2(){
		
		ExcelHandler hdata = new ExcelHandler();
		hdata.init();
		int totalrows = hdata.getTotalRows();
		Object[][] obj = new Object[totalrows][2];
		for(int i = 0; i <obj.length; i++) {
			obj[i][0] = hdata.getRowData(2+i,2);
			obj[i][1] = hdata.getRowData(2+i,3);
		}
		
		return obj;
		
	}

}
