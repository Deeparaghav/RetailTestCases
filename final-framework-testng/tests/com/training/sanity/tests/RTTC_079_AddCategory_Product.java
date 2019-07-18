package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.AdminHomePOM;
import com.training.pom.CatalogPOM;
import com.training.pom.CustomersPOM;
import com.training.pom.CatalogPOM;
import com.training.pom.LoginPOM;
import com.training.pom.OrdersPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_079_AddCategory_Product {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private OrdersPOM ordersPOM;
	private AdminHomePOM adminhomePOM;
	private CustomersPOM customersPOM;
	private CatalogPOM catalogPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		ordersPOM = new OrdersPOM(driver);
		customersPOM = new CustomersPOM(driver);
		adminhomePOM = new AdminHomePOM(driver);
		catalogPOM = new CatalogPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		driver.get(baseUrl);
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
//		driver.quit();
	}
	@Test(priority=0)
	public void LoginTest() throws InterruptedException {
		Thread.sleep(6000);
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("First");
		}
	
	/*This function creates category mentioned in the excel and also add new product */
	 
	@Test(priority=1, dataProvider ="excel-inputs", dataProviderClass = LoginDataProviders.class)
	public void AddCategoryNProduct(String CatName, String CatDescription, String MetaTag, String MetaDescription, String product, String MetaTitle, String category) 
	{
		customersPOM.MenuTabfn();
		adminhomePOM.catalogTabFn();
		adminhomePOM.categoriesSubTabFn();
		catalogPOM.addNewCategoryFn();
		catalogPOM.categoryNameFn(CatName);
		catalogPOM.categoryDescFn(CatDescription);
		catalogPOM.metaTitleFn(MetaTag);
		catalogPOM.metaDescFn(MetaDescription);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, -250);");
		catalogPOM.saveCatFn();
		String ExpectedMsg1="Success: You have modified categories!";
		System.out.println("Expected Message is- "+ ExpectedMsg1);
		String ActualMsg1=catalogPOM.successMsgFn();
		System.out.println("Actual Message is-  "+ ActualMsg1);
		Assert.assertTrue(ActualMsg1.contains(ExpectedMsg1));
		catalogPOM.productTabFn();
		catalogPOM.addnewProd();
		catalogPOM.prodNameFn(product);
		catalogPOM.metaTitleProd(MetaTitle);
		catalogPOM.linksTabFn();
		catalogPOM.linkCatFn(category);
		jse.executeScript("scroll(0, -250);");
		catalogPOM.dataTabFn();
		catalogPOM.modelTxt();		
		catalogPOM.saveBtnFn();
		String ExpectedMsg="Success: You have modified products!";
		System.out.println("Expected Message is- "+ ExpectedMsg);
		String ActualMsg=catalogPOM.finalSuccessMsg();
		System.out.println("Actual Message is-  "+ ActualMsg);
		Assert.assertTrue(ActualMsg.contains(ExpectedMsg));
	}
}
