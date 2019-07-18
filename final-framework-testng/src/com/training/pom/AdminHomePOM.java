package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	@FindBy(xpath="//li[@id=\"menu-catalog\"]//a//span")
	private WebElement CatalogTab;
	
	@FindBy(xpath="(//li[@id=\"menu-catalog\"]//ul//li[1]/a)[1]")
	private WebElement categoriesSubtab;
	
	@FindBy(xpath="//div[@id='content']//div[1]//div//div//a//i")
	private WebElement addReturn;
	
	public void addReturnProd() 
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='content']//div[1]//div//div//a//i")));
		this.addReturn.click();
	}
	
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
	
	public void catalogTabFn()
	{
		this.CatalogTab.click();
	}
	
	public void categoriesSubTabFn()
	{
		this.categoriesSubtab.click();
	}
}
