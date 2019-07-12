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
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_021_DeleteCustViaAdmin {
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
		driver.quit();
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
	public void deleteCustViaEmail() throws InterruptedException
	{
		adminhomePOM.MenuTabfn();
		adminhomePOM.custtabfn();
		adminhomePOM.custsubtabfn();
		adminhomePOM.custnamefn();
		adminhomePOM.filterBtnfn();
		adminhomePOM.custchkboxbasedonemailfn();
		adminhomePOM.deletefn();
		driver.switchTo().alert().accept();
		String ExpectedMsg="Success: You have modified customers!";
		String ActualMsg=adminhomePOM.successmsgfn();
		Assert.assertTrue(ActualMsg.contains(ExpectedMsg));
	}
}
