package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.ProductBean;
import com.training.dao.ELearningDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class LoginDataProviders {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<ProductBean> list = new ELearningDAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(ProductBean temp : list){
			Object[]  obj = new Object[8]; 
			obj[0] = temp.getOrderId(); 
			obj[1] = temp.getCustName(); 
			obj[2] = temp.getFirstName();
			obj[3] = temp.getLastName();
			obj[4] = temp.getEmail();
			obj[5] = temp.getphonenumber();
			obj[6] = temp.getproduct();
			obj[7] = temp.getmodel();			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName ="C:\\Users\\DeepashreeSuryakumar\\Documents\\Retails_Comples_TestData.xlsx"; 
		return new ApachePOIExcelRead().getExcelContent(fileName); 
	}
	
//	@DataProvider(name = "xls-inputs")
//	public Object[][] getXLSData(){
//		// ensure you will have the title as first line in the file 
//		return new ReadExcel().getExcelData("C:/Retail_Complex.xlsx", "Test Data"); 
//	}
}
