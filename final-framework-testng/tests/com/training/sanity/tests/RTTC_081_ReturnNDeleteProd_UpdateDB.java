package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.AdminHomePOM;
import com.training.pom.CatalogPOM;
import com.training.pom.CustomersPOM;
import com.training.pom.LoginPOM;
import com.training.pom.OrdersPOM;
import com.training.pom.UserPagePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_081_ReturnNDeleteProd_UpdateDB {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private AdminHomePOM adminhomePOM;
	private OrdersPOM ordersPOM;
	private static Properties properties;
	private ScreenShot screenShot;


	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		adminhomePOM = new AdminHomePOM(driver);
		ordersPOM = new OrdersPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		driver.get(baseUrl);
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
//		driver.quit();
	}
	@Test	
	public void LoginTest() throws InterruptedException {
		Thread.sleep(6000);
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("First");
		}
	
	/* Function to return product of customer & delete from return list & same get displayed in database*/
	
	@Test(dataProvider="db-inputs", dataProviderClass= LoginDataProviders.class)
	public void returnNDeleteProd(int OrderId, String CustName, String FirstName, String LastName, String Email, String PhoneNumber, String Product, String Model) throws InterruptedException
	{
		adminhomePOM.salestab();
		adminhomePOM.returnsclick();
		adminhomePOM.addReturnProd();
		ordersPOM.orderIdFn(OrderId);
		ordersPOM.customerFn(CustName);
		ordersPOM.FnameFn(FirstName);
		ordersPOM.LsNameFn(LastName);
		ordersPOM.emailFn(Email);
		ordersPOM.phNumberFn(PhoneNumber);
		ordersPOM.productrFn(Product);
		ordersPOM.modelFn(Model);
		ordersPOM.saveFn();
		String ExpectedMsg="Success: You have modified returns!";
		System.out.println("Expected Message is- "+ ExpectedMsg);
		String ActualMsg=ordersPOM.successMsgFn1();
		System.out.println("Actual Message is-  "+ ActualMsg);
		Assert.assertTrue(ActualMsg.contains(ExpectedMsg));
		ordersPOM.chbxFn1();
		ordersPOM.deleteFn1();
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		System.out.println("Deleted values are: " + OrderId + "\t" +CustName+ "\t" +FirstName+ "\t" +LastName+ "\t" +Email );
		System.out.println("\n" +PhoneNumber+ "\t" +Product+ "\t" +Model);
		
	}
}
