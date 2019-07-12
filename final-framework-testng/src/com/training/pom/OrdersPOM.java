package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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
}
