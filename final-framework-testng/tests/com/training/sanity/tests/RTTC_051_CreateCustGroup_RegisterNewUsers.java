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

public class RTTC_051_CreateCustGroup_RegisterNewUsers {
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
		/* Steps to create a customer group */
		customersPOM.MenuTabfn();
		customersPOM.custtabfn();
		customersPOM.customerGroupsSubbtabfn();
		customersPOM.addNewCustGroupFn();
		customersPOM.custGourpNameFn();
		customersPOM.custGroupDescFn();
		customersPOM.approveCustomerFn();
		customersPOM.savecustGroupFn();
		String ExpectedMsg="Success: You have modified customer groups!";
		System.out.println("Expected Message is- "+ ExpectedMsg);
		String ActualMsg=customersPOM.successMsgGroupCreationFn();
		System.out.println("Actual Message is-  "+ ActualMsg);
		Assert.assertTrue(ActualMsg.contains(ExpectedMsg));
		/* Function to add user to group */
		customersPOM.custtabfn();
		customersPOM.custsubtabfn();
		customersPOM.addUserFn();
		Thread.sleep(2000);
		customersPOM.selectGroupDropDownFn();
		customersPOM.firstNamefn();
		customersPOM.lastNamefn();
		customersPOM.emailFn();
		customersPOM.phoneNumberFn();
		customersPOM.passwdFn();
		customersPOM.confirmpwdFn();
		customersPOM.addressTabFn();
		customersPOM.addresstxtFn();
		customersPOM.firstNamefn1();
		customersPOM.lastNamefn1();
		customersPOM.areatxtfn();
		customersPOM.cityFn();
		customersPOM.postalCodeFn();
		customersPOM.country();
		customersPOM.zone();
		customersPOM.saveBtnFn();
		String ExpectedMsg1="Success: You have modified customers!";
		System.out.println("Expected Message is- "+ ExpectedMsg1);
		String ActualMsg1=customersPOM.successMsgAddUserFn();
		System.out.println("Actual Message is-  "+ ActualMsg1);
		Assert.assertTrue(ActualMsg1.contains(ExpectedMsg1));
		
	}
}
