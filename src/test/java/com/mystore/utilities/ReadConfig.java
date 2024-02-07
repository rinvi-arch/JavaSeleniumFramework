package com.mystore.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig {
	Properties prop;
	String path = "C:\\Java\\eclipse-workspace\\MyStoreV1\\Configuration\\config.properties";
	
	public ReadConfig() {
		prop = new Properties();
		try {
			FileInputStream in = new FileInputStream(path);
			prop.load(in);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getBaseURL() {
		String value = prop.getProperty("baseurl");
		if(value != null) 
			return value;
		else 
			throw new RuntimeException("URL not specified in config file");
	}
	
	public String getBrowser() {
		String value = prop.getProperty("browser");
		if(value != null)
			return value;
		else 
			throw new RuntimeException("Browser not specified in config file");
	}
	
}
