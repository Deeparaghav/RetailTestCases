package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdminHomePOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_019_DeleteReturnedProduct {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private AdminHomePOM adminhomePOM;
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
	
	@Test
	public void returnDeletedProducts() throws InterruptedException
	{
		Thread.sleep(6000);
		adminhomePOM.salestab();
		Thread.sleep(3000);
		adminhomePOM.returnsclick();
		Thread.sleep(3000);
		adminhomePOM.returncheckbox();
		Thread.sleep(3000);
		adminhomePOM.deletefn();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		String ExpectedMsg="Success: You have modified returns!";
		String ActualMsg=adminhomePOM.successmsgfn();
		Assert.assertTrue(ActualMsg.contains(ExpectedMsg));
	}
}
