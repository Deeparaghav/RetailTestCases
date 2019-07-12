package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdminHomePOM;
import com.training.pom.CustomersPOM;
import com.training.pom.LoginPOM;
import com.training.pom.OrdersPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_053_GenrateInvoiceAndChangeOrderStatus {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private OrdersPOM ordersPOM;
	private CustomersPOM customersPOM;
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
	/*This function generates invoice as an admin for those cusotmers whose order
	 * is placed and also changes the order status to Complete */
	 
	
	@Test
	public void generateInvoiceChangeOrderStatus() throws InterruptedException
	{
		customersPOM.MenuTabfn();
		ordersPOM.salestabFn();
		ordersPOM.OrderSubtabfn();
		ordersPOM.custNameFn();
		ordersPOM.viewBtnFn();
		ordersPOM.invoiceBtnFn();
		driver.switchTo().defaultContent();
		ordersPOM.statusDropDown();
		ordersPOM.addHistoryFn();
		String ExpectedMsg="Success: You have modified orders!";
		System.out.println("Expected Message is- "+ ExpectedMsg);
		String ActualMsg=ordersPOM.successMsgFn();
		System.out.println("Actual Message is-  "+ ActualMsg);
		Assert.assertTrue(ActualMsg.contains(ExpectedMsg));
		
	}
}
