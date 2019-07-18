package com.training.bean;

/**
 * 
 * @author Deepa
 * @see this class shall get the bean data 
 */
public class DBBean {
 

	private String url;
	private String driver;
	private String userName;
	private String password;
	
	public DBBean() {}
	
	public DBBean(String url, String driver, String userName, String password){
		super();
		this.url = url;
		this.driver = driver;
		this.userName = userName;
		this.password = password;
	}

	public String geturl() {
		return url;
	}

	public void seturl(String url) {
		this.url = url;
	}

	public String getdriver() {
		return driver;
	}

	public void setdriver(String driver) {
		this.driver = driver;
	}

	public String getuserName() {
		return userName;
	}

	public void setuserName(String userName) {
		this.userName = userName;
	}

	public String getpassword() {
		return password;
	}

	public void setpassword(String password) {
		this.password = password;
	}
	
}
