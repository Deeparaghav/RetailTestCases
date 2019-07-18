package com.training.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.training.bean.DBBean;

/**
 * 
 * @author Naveen
 * @see will load the db details and shall be used in connection class
 */
public class LoadDBDetails {
	public static DBBean getDBDetails() {

		try {
			Properties properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/db.properties");
			properties.load(inStream);

			DBBean dbBean = new DBBean(); 
			
			dbBean.seturl(properties.getProperty("url"));
			dbBean.setdriver(properties.getProperty("driver"));
			// getting the user name if not present (by default - root ) 
			dbBean.setuserName(properties.getProperty("username", "root"));
			dbBean.setpassword(properties.getProperty("password"));
			
			return dbBean; 
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}


}
