package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrdersPOM {
private WebDriver driver;
	
	public OrdersPOM (WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//li[@id='menu-sale']//a[@class='parent'])[1]")
	private WebElement salesTab;
	
	@FindBy(xpath="//li[@id=\"menu-sale\"]/ul/li[1]/a")
	private WebElement ordersSubtab;
	
	@FindBy(id="input-customer")
	private WebElement custName;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover']//tbody//tr//td[contains(text(),'Pending')]//..//a[@class='btn btn-info']")
	private WebElement viewBtn;
	
	@FindBy(xpath="//a[@class='btn btn-info']")
	private WebElement invoiceBtn;

	@FindBy(id="input-order-status")
	private WebElement statusdd;
	
	@FindBy(id="button-history")
	private WebElement addHistoryBtn;
	
	@FindBy(xpath="(//div[@id='tab-history']//following-sibling::div)[1]")
	private WebElement successMsg;
	
	@FindBy(id="button-filter")
	private WebElement filter;
	
//	@FindBy(xpath="(//i[@class='fa fa-eye'])[1]")
//	private WebElement view;
	
	@FindBy(id="input-order-id")
	private WebElement Orderid;
	
	@FindBy(id="input-firstname")
	private WebElement FName;
	
	@FindBy(id="input-lastname")
	private WebElement LName;
	
	@FindBy(id="input-email")
	private WebElement Email;
	
	@FindBy(id="input-telephone")
	private WebElement phnumber;	
	
	@FindBy(id="input-product")
	private WebElement prod;
	
	@FindBy(id="input-model")
	private WebElement model;
			
	@FindBy(id="input-customer")
	private WebElement customer;
	
	@FindBy(xpath="//i[@class='fa fa-save']")
	private WebElement save;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement success;
	
	@FindBy(xpath="//tr[1]//td[contains(text(),'90')]//..//td[@class='text-center']//input")
	private WebElement checkbx;
	
	@FindBy(xpath="//button[@data-original-title='Delete']")
	private WebElement delete;
	
	public void deleteFn1()
	{
		this.delete.click();
	}
	
	public void chbxFn1()
	{
		this.checkbx.click();
	}
	
	public String successMsgFn1()
	{
		return this.success.getText();
	}
	
	public void saveFn()
	{
		this.save.click();
	}
	
	public void customerFn(String cust)
	{
		this.customer.sendKeys(cust);
	}	
	
	public void modelFn(String model) 
	{
		this.model.sendKeys(model);
	}
	
	public void productrFn(String product) 
	{
		this.prod.sendKeys(product);
	}
	
	public void phNumberFn(String phno) 
	{
		this.phnumber.sendKeys(phno);
	}
	
	public void emailFn(String email) 
	{
		this.Email.sendKeys(email);
	}
	public void LsNameFn(String lastname)
	{
		this.LName.sendKeys(lastname);
	}
	
	public void OrderSubtabfn()
	{
		this.ordersSubtab.click();
	}
	
	public void custNameFn()
	{
		this.custName.sendKeys("Deepashree");
	}
	
	public void viewBtnFn()
	{
		this.viewBtn.click();
	}
	
	public void invoiceBtnFn()
	{
		this.invoiceBtn.click();
	}
	
	public void statusDropDown()
	{
		Select dd= new Select(statusdd);
		dd.selectByVisibleText("Complete");
	}
	
	public void addHistoryFn()
	{
		this.addHistoryBtn.click();
	}
	
	public void salestabFn()
	{
		this.salesTab.click();
	}
	
	public String successMsgFn()
	{
		return this.successMsg.getText();
	}
	
	public void filterFn()
	{
		this.filter.click();
	}
	
	public void orderIdFn(int orderId2)
	{
		this.Orderid.sendKeys(Integer.toString(orderId2));
	}
	
	public void FnameFn(String frname)
	{
		this.FName.sendKeys(frname);
	}
}
