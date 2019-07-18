package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPOM {
private WebDriver driver;
	
	public ProductsPOM (WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//i[@class='fa fa-plus']")
	private WebElement addNewReturn;
	
	public void addReturnFn()
	{
		this.addNewReturn.click();
	}
}
