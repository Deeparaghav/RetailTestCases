package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class RTTC_080_UserOrder_AdminChangeStatus {
	private WebDriver driver;
	private String baseUrl1;
	private String baseURL;
	private LoginPOM loginPOM;
	private OrdersPOM ordersPOM;
	private UserPagePOM userPagePOM;
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
		userPagePOM = new UserPagePOM(driver);
		baseUrl1 = properties.getProperty("baseURL1");
		screenShot = new ScreenShot(driver); 
		driver.get(baseUrl1);
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
//		driver.quit();
	}
	
	/*This function is for users to order a new item and checkout, also logging as admin and changing the status of the order*/
	 
	@Test(priority=1)
	public void userOrder() 
	{
		userPagePOM.searchTxtFn();
		userPagePOM.filterTxtFn();
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='col col-xs-fill']//h4//a)[1]")));
		userPagePOM.prodLinFn();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-cart")));
		userPagePOM.addToCartFn();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='tb_icon ico-linea-ecommerce-bag']")));
		userPagePOM.shoppingBagFn();
		userPagePOM.viewCartFn();
		userPagePOM.checkOutFn();
		userPagePOM.email();
		userPagePOM.pwdFn();
		userPagePOM.loginFn();
		userPagePOM.continuePaymentFn();
		userPagePOM.continueShippingFn();
		userPagePOM.commentsFn();
		userPagePOM.contFn();
		userPagePOM.agreeFn();
		userPagePOM.lastFn();
		userPagePOM.ConfirmFn();
		baseURL = properties.getProperty("baseURL");
		driver.navigate().to(baseURL);
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		customersPOM.MenuTabfn();
		ordersPOM.salestabFn();
		ordersPOM.OrderSubtabfn();
		ordersPOM.custNameFn();
		ordersPOM.filterFn();
		ordersPOM.viewBtnFn();
		ordersPOM.statusDropDown();
		ordersPOM.addHistoryFn();
		String ExpectedMsg="Success: You have modified orders!";
		System.out.println("Expected Message is- "+ ExpectedMsg);
		String ActualMsg=ordersPOM.successMsgFn();
		System.out.println("Actual Message is-  "+ ActualMsg);
		Assert.assertTrue(ActualMsg.contains(ExpectedMsg));
		driver.navigate().to(baseUrl1);
		userPagePOM.acctountFn();
		userPagePOM.email();
		userPagePOM.pwdFn();
		userPagePOM.loginFn();
		userPagePOM.viewHistoryFn();
		String ExpectedMsg1="Completed";
		System.out.println("Expected Message is- "+ ExpectedMsg1);
		String ActualMsg1=userPagePOM.statusFn();
		System.out.println("Actual Message is-  "+ ActualMsg1);
		Assert.assertTrue(ActualMsg1.contains(ExpectedMsg1));
	}
	}
