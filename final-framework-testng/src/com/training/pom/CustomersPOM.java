package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CustomersPOM {
private WebDriver driver;
	
	public CustomersPOM (WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="button-menu")
	private WebElement MenuTab;
	
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
	
	@FindBy(xpath="(//a[@class='btn btn-primary'])[2]")
	private WebElement editBtn;

	@FindBy(id="input-firstname")
	private WebElement firstname;
	
	@FindBy(id="input-lastname")
	private WebElement lastName;
	
	@FindBy(id="input-firstname1")
	private WebElement firstname1;
	
	@FindBy(id="input-lastname1")
	private WebElement lastName1;
	
	@FindBy(id="input-email")
	private WebElement email;
	
	@FindBy(xpath="//div[@class='pull-right']//button")
	private WebElement savebtn;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement ActualMsg;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement ActualMsg1;
	
	@FindBy(xpath="//a[@href='#tab-reward']")
	private WebElement rewardPointstab;
	
	@FindBy(id="input-reward-description")
	private WebElement descriptiontxt;
	
	@FindBy(id="input-points")
	private WebElement pointstxt;
	
	@FindBy(id="button-reward")
	private WebElement submitRewardPoints;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement successmsg1;
	
	@FindBy(xpath="//li[@id=\"menu-customer\"]/ul/li[2]/a")
	private WebElement customerGroupsSubTab;
	
	@FindBy(xpath="//div[@class='pull-right']//a//i")
	private WebElement addGroup;
	
	@FindBy(xpath="//input[@name='customer_group_description[1][name]']")
	private WebElement custGroupName;
	
	@FindBy(id="input-description1")
	private WebElement custGroupDescription;
	
	@FindBy(xpath="(//input[@name='approval'])[1]")
	private WebElement approveCust;
	
	@FindBy(xpath="(//div[@class=\"pull-right\"]//i)[1]")
	private WebElement saveCustGroup;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement successmsgGroup;
	
	@FindBy(xpath="//td[contains(text(),'Platinum')]//..//a[@class='btn btn-primary']")
	private WebElement AddCustToGroup;
	
	@FindBy(xpath="//*[@id=\"address-add\"]/a")
	private WebElement addressTab;
	
	@FindBy(id="input-postcode1")
	private WebElement postaclCode;
	
	@FindBy(xpath="//i[@class='fa fa-plus']")
	private WebElement addUser;
	
	@FindBy(id="input-customer-group")
	private WebElement groupDD;
	
	@FindBy(id="input-telephone")
	private WebElement phonenumber;
	
	@FindBy(id="input-password")
	private WebElement passwd;
	
	@FindBy(id="input-confirm")
	private WebElement confirmpwd;
	
	@FindBy(xpath="//li[@id=\"address-add\"]/a")
	private WebElement addAddress;
	
	@FindBy(id="input-address-11")
	private WebElement address1;
	
	@FindBy(id="input-address-21")
	private WebElement address2;
	
	@FindBy(id="input-city1")
	private WebElement city;
	
	@FindBy(id="input-country1")
	private WebElement country;
	
	@FindBy(id="input-zone1")
	private WebElement zone;
	
	public void MenuTabfn()
	{
		this.MenuTab.click();
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
	
	public void editBtnfn()
	{
		this.editBtn.click();
	}

	public void firstNamefn()
	{
		this.firstname.clear();
		this.firstname.sendKeys("manzoorfn");
	}
	
	public void lastNamefn()
	{
		this.lastName.clear();
		this.lastName.sendKeys("mehadiln");
	}
	
	public void firstNamefn1()
	{
		this.firstname1.clear();
		this.firstname1.sendKeys("manzoorfn1");
	}
	
	public void lastNamefn1()
	{
		this.lastName1.clear();
		this.lastName1.sendKeys("mehadiln1");
	}
	
	public void emailFn()
	{
		this.email.clear();
		this.email.sendKeys("deepashree13456789@gmail.com");
	}
	
	public void phoneNumberFn()
	{
		this.phonenumber.sendKeys("9896111910");
	}
	
	public void passwdFn()
	{
		this.passwd.sendKeys("manzoor1");
	}
	
	public void confirmpwdFn()
	{
		this.confirmpwd.sendKeys("manzoor1");
	}
	
	public void addAddressFn()
	{
		this.addAddress.click();
	}
	
	
	public void saveBtnFn()
	{
		this.savebtn.click();
	}

	public String successmsgfn()
	{
		return this.ActualMsg.getText();
	}
	
	public String successMsgAddUserFn()
	{
		return this.ActualMsg1.getText();
	}
	public void RewardPointsTabfn()
	{
		this.rewardPointstab.click();
	}
	
	public void descriptionFn()
	{
		this.descriptiontxt.sendKeys("review");
	}
	
	public void pointsFn()
	{
		this.pointstxt.sendKeys("50");
	}
	
	public void submitRewardsPointsFn()
	{
		this.submitRewardPoints.click();
	}
	
	public String successmsgfn1()
	{
		return this.successmsg1.getText();
	}
	
	public void customerGroupsSubbtabfn()
	{
		this.customerGroupsSubTab.click();
	}

	public void addNewCustGroupFn()
	{
		this.addGroup.click();
	}
	
	public void custGourpNameFn()
	{
		this.custGroupName.sendKeys("deepa privilege customer");
	}
	
	public void custGroupDescFn()
	{
		this.custGroupDescription.sendKeys("Testing1234");
	}
	
	public void approveCustomerFn()
	{
		this.approveCust.click();
	}
	
	public void savecustGroupFn()
	{
		this.saveCustGroup.click();
	}
	
	public String successMsgGroupCreationFn()
	{
		return this.successmsgGroup.getText();
	}
	
	public void addCustomerForGroup()
	{
		this.AddCustToGroup.click();
	}
	
	public void addressTabFn()
	{
		this.addressTab.click();
	}
	
	public void postalCodeFn()
	{
		this.postaclCode.sendKeys("8796545");
	}
	
	public void addUserFn()
	{
		this.addUser.click();
	}
	
	public void selectGroupDropDownFn()
	{
		Select dd = new Select(groupDD);
		dd.selectByVisibleText("deepa privilege customer");
	}
	
	public void addresstxtFn()
	{
		this.address1.sendKeys("yeshwanthapur");
	}
	
	public void areatxtfn()
	{
		this.address2.sendKeys("Bangalore");
	}
	
	public void cityFn()
	{
		this.city.sendKeys("Bangalore");
	}
	
	public void country()
	{
		Select dd1 = new Select(country);
		dd1.selectByVisibleText("India");	
	}
	
	public void zone()
	{
		Select dd2 = new Select(zone);
		dd2.selectByVisibleText("Karnataka");
	}
}

