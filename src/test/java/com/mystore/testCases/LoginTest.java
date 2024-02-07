package com.mystore.testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.mystore.pageObject.LoginPage;

import jdk.internal.org.jline.utils.Log;

public class LoginTest extends BaseTest{
	
	LoginPage loginPage;
	
	@Test
	public void Verifylogin() {
		//step 1. lanuch browser which we're doing in the base test
		//step 2. open url - getting it from the config 
		driver.get(url);
		log.info("open url");
		// step 2. enter username and password
		loginPage = new LoginPage(driver);
		loginPage.enterUsernameAndPassword("standard_user", "secret_sauce");
		log.info("entered username and password");
		loginPage.clickOnLogin();
		log.info("clicked on login");
		String title = driver.getTitle();
		Assert.assertEquals(title, "Swag Labs");
		System.out.println(title);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
