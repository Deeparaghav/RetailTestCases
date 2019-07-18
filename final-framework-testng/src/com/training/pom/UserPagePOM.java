package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserPagePOM {
private WebDriver driver;
public JavascriptExecutor js;
	
	public UserPagePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="search_button")
	private WebElement searchButton;
	
	@FindBy(id="filter_keyword")
	private WebElement filterTxt;
	
	@FindBy(xpath="//div[@class='image_hover tb_back']//a//img")
	private WebElement itemselected;
	
	@FindBy(id="button-cart")
	private WebElement addToCart;
	
	@FindBy(xpath="(//div[@class='col col-xs-fill']//h4//a)[1]")
	private WebElement prodLink;
	
	@FindBy(xpath="//i[@class='tb_icon ico-linea-ecommerce-bag']")
	private WebElement shoppingBag;
	
	@FindBy(xpath="//a[text()='View Cart']")
	private WebElement viewCart;
	
	@FindBy(xpath="//div[@class='pull-right']//a[text()='Checkout']")
	private WebElement checkOutbtn;
	
	@FindBy(id="input-email")
	private WebElement login;
	
	@FindBy(id="input-password")
	private WebElement pwd;
	
	@FindBy(id="button-login")
	private WebElement loginbtn;
	
	@FindBy(id="button-payment-address")
	private WebElement continue_payment;
	
	@FindBy(id="button-shipping-address")
	private WebElement continue_shipping;
	
	@FindBy(name="comment")
	private WebElement comments;
	
	@FindBy(id="button-shipping-method")
	private WebElement cont;
	
	@FindBy(name="agree")
	private WebElement agree;
	
	@FindBy(id="button-payment-method")
	private WebElement lastCont;
	
	@FindBy(id="button-confirm")
	private WebElement confirm;
	
	@FindBy(xpath="//i[@class='fa fa-user-o']")
	private WebElement account;
	
	@FindBy(xpath="//a[text()='View your order history']")
	private WebElement viewHistory;
	
	@FindBy(xpath="//table[@class='table table-hover']//tbody//tr//td[4]")
	private WebElement status;
	
	public void searchTxtFn()
	{
		this.searchButton.click();
	}
	
	public void filterTxtFn()
	{
		this.filterTxt.sendKeys("dolor sit");
		this.searchButton.click();
		
	}

	public void itemSelectedFn()
	{
		this.itemselected.click();
	}
	
	public void addToCartFn()
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-cart")));
		this.addToCart.click();
	}
	
	public void prodLinFn()
	{
		this.prodLink.click();
	}
	
	public void shoppingBagFn()
	{
		Actions ac = new Actions(driver);
		ac.moveToElement(shoppingBag).perform();
		
	}
	
	public void viewCartFn()
	{
		this.viewCart.click();
	}

	public void checkOutFn()
	{
		this.checkOutbtn.click();
	}
	
	public void email()
	{
		this.login.sendKeys("msdeepashree@gmail.com");
	}

	public void pwdFn()
	{
		this.pwd.sendKeys("shilpa@123");
	}

	public void loginFn()
	{
		this.loginbtn.click();
	}
	
	
	public void continuePaymentFn()
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-payment-address")));
		System.out.println("continue");
		this.continue_payment.click();
	}
	
	public void continueShippingFn()
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-shipping-address")));
		JavascriptExecutor js= (JavascriptExecutor)driver;
//		WebElement continueShipping = driver.findElement(By.id("button-shipping-address"));
		js.executeScript("window.scrollBy(0,-500)");
		this.continue_shipping.click();
	}
	
	public void commentsFn()
	{	
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("comment")));
		js= (JavascriptExecutor)driver;
		WebElement comment1 = driver.findElement(By.name("comment"));
		js.executeScript("arguments[0].scrollIntoView()", comment1);
		this.comments.sendKeys("This product is nice");
	}

	public void contFn()
	{
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-shipping-method")));
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("window.scrollBy(0, -1000)");
//		WebElement cont1 = driver.findElement(By.id("button-shipping-method"));
//		js.executeScript("arguments[0].scrollIntoView()", cont1);
		this.cont.click();
	}
	
	public void agreeFn()
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("agree")));
		JavascriptExecutor js= (JavascriptExecutor)driver;
		WebElement agree1 = driver.findElement(By.name("agree"));
		js.executeScript("arguments[0].scrollIntoView()", agree1);
		this.agree.click();
	}
	
	public void lastFn()
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-payment-method")));
		JavascriptExecutor js= (JavascriptExecutor)driver;
		WebElement continu = driver.findElement(By.id("button-payment-method"));
		js.executeScript("arguments[0].scrollIntoView()", continu);
		this.lastCont.click();
	}
	
	public void ConfirmFn()
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-confirm")));	
		JavascriptExecutor js= (JavascriptExecutor)driver;
		WebElement confirm1 = driver.findElement(By.id("button-confirm"));
		js.executeScript("arguments[0].scrollIntoView()", confirm1);
		this.confirm.click();
	}
	
	public void acctountFn()
	{
		this.account.click();
	}
	
	public void viewHistoryFn()
	{
		this.viewHistory.click();
	}
	
	public String statusFn()
	{
		return this.status.getText();
	}
}


