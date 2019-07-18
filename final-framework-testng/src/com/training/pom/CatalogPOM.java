package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CatalogPOM {
	private WebDriver driver;
	
	public CatalogPOM (WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//div[@id='content']//div[1]//div//div//a[1]//i[1])[1]")
	private WebElement addNewCategory;
	
	@FindBy(id="input-name1")
	private WebElement categoryNametxt;
	
	@FindBy(xpath="(//textarea[@class='note-codable']//..//div[2])[2]")
	private WebElement categoryDesc;
	
	@FindBy(id="input-meta-title1")
	private WebElement metaTitle;
	
	@FindBy(id="input-meta-description1")
	private WebElement metaDesc;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElement SaveCategory;
	
	@FindBy(xpath="//button[@class='btn btn-primary']//i[@class='fa fa-save']")
	private WebElement Savebtn;
		
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement successMsg;
	
	@FindBy(xpath="(//li[@class='active open']//a)[3]")
	private WebElement productsTab;
	
	@FindBy(xpath="//a[@class='btn btn-primary']//i[@class='fa fa-plus']")
	private WebElement addNewbtn;
	
	@FindBy(id="input-name1")
	private WebElement prodName;
	
	@FindBy(id="input-meta-title1")
	private WebElement metaTitleProd;
	
	@FindBy(xpath="//ul[@class='nav nav-tabs']//li[3]")
	private WebElement linksTab;
	
	@FindBy(id="input-category")
	private WebElement linkCategory;
	
	@FindBy(xpath="//div[@id='product-category']")
	private WebElement categoryOption;
	
	@FindBy(xpath="//a[@href='#tab-data']")
	private WebElement dataTab;
	
	@FindBy(id="input-model")
	private WebElement model;
	
	@FindBy(xpath="//div[@class='container-fluid']//div[@class='alert alert-success']")
	private WebElement FinalSuccessMsg;
	
	public void addNewCategoryFn()
	{
		this.addNewCategory.click();
	}
	
	public void categoryNameFn(String categoryName)
	{
		this.categoryNametxt.sendKeys(categoryName);
	}
	
	public void categoryDescFn(String categoryDesc)
	{
		this.categoryDesc.sendKeys(categoryDesc);
	}
	
	public void metaTitleFn(String metaTitle)
	{
		this.metaTitle.sendKeys(metaTitle);
	}
	
	public void metaDescFn(String metaDescptn)
	{
		this.metaDesc.sendKeys(metaDescptn);
	}
	
	public void saveCatFn()
	{
		this.SaveCategory.click();
	}
	
	public String successMsgFn()
	{
		return this.successMsg.getText();
	}
	
	public void saveBtnFn()
	{
		this.Savebtn.click();
	}
	
	public void productTabFn()
	{
		this.productsTab.click();
	}
	
	public void addnewProd()
	{
		this.addNewbtn.click();
	}
	
	public void prodNameFn(String prodName)
	{
		this.prodName.sendKeys(prodName);
	}
	
	public void metaTitleProd(String metaProdTitle)
	{
		this.metaTitleProd.sendKeys(metaProdTitle);
	}

	public void linksTabFn()
	{
		this.linksTab.click();
	}


	public void linkCatFn(String linkCategoryarg)
	{
	
		this.linkCategory.sendKeys(linkCategoryarg);
		String xpathbefore="//ul[@class='dropdown-menu']//li//a[text()='";
		String xpathafter="']";
		String elementxpath=xpathbefore+linkCategoryarg+xpathafter;
		WebElement categoryOptions1 = driver.findElement(By.xpath(elementxpath));
		
		Actions act = new Actions(driver);
		act.moveToElement(categoryOptions1).click().build().perform();
	}
	
	public void dataTabFn()
	{
		this.dataTab.click();
	}
	
	public void modelTxt()
	{
		this.model.sendKeys("New");
	}
	
	public String finalSuccessMsg()
	{
		return this.FinalSuccessMsg.getText();
	}
}

