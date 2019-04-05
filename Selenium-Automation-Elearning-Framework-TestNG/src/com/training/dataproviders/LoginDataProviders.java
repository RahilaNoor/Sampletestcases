package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class LoginDataProviders {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<LoginBean> list = new ELearningDAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(LoginBean temp : list){
			Object[]  obj = new Object[6]; 
			//obj[0] = temp.getUserName(); 
			//obj[1] = temp.getPassword();
			obj[0] = temp.getproductname(); 
			obj[1] = temp.getMetatagtitle(); 
			obj[2] = temp.getModel(); 
			obj[3] = temp.getprice(); 
			obj[4] = temp.getQuantity(); 
			obj[5] = temp.getCategories(); 
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName ="C:/Retail poject/Testdata.xlsx"; 
		String SheetName="Sheet1";
		return new ApachePOIExcelRead().getExcelContent(fileName,SheetName); 
	}
	@DataProvider(name = "excel-inputs1")
	public Object[][] getExcelData1(){
		String fileName ="C:/Retail poject/Testdata.xlsx"; 
		String SheetName="Sheet2";
		return new ApachePOIExcelRead().getExcelContent(fileName,SheetName); 
	}
	@DataProvider(name = "excel-inputs2")
	public Object[][] getExcelData2(){
		String fileName ="C:/Retail poject/Testdata.xlsx"; 
		String SheetName="Sheet3";
		return new ApachePOIExcelRead().getExcelContent(fileName,SheetName); 
	}
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:/Retail poject/Testdata.xlsx", "Sheet1"); 
	}
}
