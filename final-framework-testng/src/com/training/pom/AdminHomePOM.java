package com.training.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePOM {
	private WebDriver driver;
	
	public AdminHomePOM (WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="button-menu")
	private WebElement MenuTab;
	
	@FindBy(xpath="//i[@class='fa fa-shopping-cart fw']")
	private WebElement salestab;
		
	@FindBy(xpath="//i[@class='fa fa-shopping-cart fw']//ancestor::li//li[3]")
	private WebElement returns;
	
	@FindBy(xpath="//form[@id='form-return']//div//table//tbody//tr//td[3]//..//..//..//input[@name='selected[]']")
	private WebElement returnchbox;
		
	@FindBy(xpath="//button[@class='btn btn-danger']")
	private WebElement deleteitem;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement successmsg;
	
	@FindBy(xpath="//i[@class='fa fa-user fw']")
	private WebElement customerstab;
	
	@FindBy(xpath="(//a[text()='Customers'])[1]")
	private WebElement custSubtab;
	
	@FindBy(id="input-name")
	private WebElement custNameTextbx;
	
	@FindBy(id="button-filter")
	private WebElement filterbtn;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover']//tbody//tr[1]//td[2]")
	private WebElement resultCust;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover']//tbody//tr//td[contains(text(),'manzoor979@gmail.com')]//preceding-sibling::td//input")
	private WebElement custBasedOnEmail;
	
	@FindBy(id="input-email")
	private WebElement emailtxt;
	
	public void MenuTabfn()
	{
		this.MenuTab.click();
	}
	
	public void salestab()
	{
		Actions act = new Actions(driver);
		act.moveToElement(salestab).build().perform();
	}
	
	public void returnsclick()
	{
		Actions act = new Actions(driver);
		act.moveToElement(returns).click().build().perform();
	}
	
	public void returncheckbox()
	{
		this.returnchbox.click();
	}
	
	public void deletefn()
	{
		this.deleteitem.click();
	}
	
	public String successmsgfn()
	{
		return this.successmsg.getText();
	}
	
	public void custtabfn()
	{
		this.customerstab.click();
	}
	
	public void custsubtabfn()
	{
		this.custSubtab.click();
	}
	
	public void custnamefn()
	{
		this.custNameTextbx.sendKeys("Manzoor");
	}
	public void filterBtnfn()
	{
		this.filterbtn.click();
	}
	
	public String resultCustNamefn()
	{
		return this.resultCust.getText();
	}
	
	public void emailtxtfn()
	{
		this.emailtxt.sendKeys("manzoor@gmail.com");
	}
	
	public void custchkboxbasedonemailfn()
	{
		this.custBasedOnEmail.click();
	}
}
