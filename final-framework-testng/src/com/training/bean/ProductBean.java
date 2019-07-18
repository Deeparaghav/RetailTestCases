package com.training.bean;

public class ProductBean {
	private int OrderId;
	private String CustName;
	private String FirstName;
	private String LastName;
	private String Email;
	private String phonenumber;
	private String product;
	private String model;
	

	public ProductBean() {
	}

	public ProductBean(int OrderId, String CustName, String FirstName,String LastName, String Email, String phonenumber, String product, String model) {
		super();
		this.OrderId = OrderId;
		this.CustName = CustName;
		this.FirstName = FirstName;
		this.CustName = CustName;
		this.LastName = LastName;
		this.Email = Email;
		this.phonenumber = phonenumber;
		this.product = product;
		this.model = model;
	}

	public int getOrderId() {
		return OrderId;
	}

	public void setOrderId(int OrderId) {
		this.OrderId = OrderId;
	}

	public String getCustName() {
		return CustName;
	}
	
	public void setCustName(String CustName) {
		this.CustName = CustName;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String LastName) {
		this.LastName = LastName;
	}
	
	public String getEmail() {
		return Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}
	
	public String getphonenumber() {
		return phonenumber;
	}

	public void setphonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	public String getproduct() {
		return product;
	}

	public void setproduct(String product) {
		this.product = product;
	}
	
	public String getmodel() {
		return model;
	}

	public void setmodel(String model) {
		this.model = model;
	}
	
	
	@Override
	public String toString() {
		return "LoginBean [Order Id=" + OrderId + ", Customer Name=" + CustName + "]";
	}

	

}
