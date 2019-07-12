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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_050_EditCustDetail_AddRewardPoints {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private AdminHomePOM adminhomePOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private CustomersPOM customersPOM;


	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		customersPOM = new CustomersPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		driver.get(baseUrl);
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		
	}
	@Test	
	public void LoginTest() throws InterruptedException {
		Thread.sleep(6000);
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("First");
		}
	
	/* Function to edit customers with their First name and 
	 * last name and add reward points to the same customer */
	 
	
	@Test
	public void editCustDetails() throws InterruptedException
	{
		customersPOM.MenuTabfn();
		customersPOM.custtabfn();
		customersPOM.custsubtabfn();
		customersPOM.custnamefn();
		customersPOM.filterBtnfn();
		customersPOM.editBtnfn();
		customersPOM.firstNamefn();
		customersPOM.addressTabFn();
		customersPOM.postalCodeFn();
		customersPOM.RewardPointsTabfn();
		customersPOM.descriptionFn();
		customersPOM.pointsFn();
		customersPOM.submitRewardsPointsFn();
		customersPOM.saveBtnFn();
		String ExpectedMsg1="Success: You have modified customers!";
		System.out.println("Expected Message for adding Reward Points- "+ ExpectedMsg1);
		String ActualMsg1=customersPOM.successmsgfn1();
		System.out.println("Actual Message for adding Reward Points-  "+ ActualMsg1);
		Assert.assertTrue(ActualMsg1.contains(ExpectedMsg1));
	}
}
