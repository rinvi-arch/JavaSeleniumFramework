package com.mystore.pageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	// create object of webdriver 
	WebDriver ldriver;

	public LoginPage(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this); // driver to search for context, object of this class (LoginPage.class)
	}

	// identify the webelement 
	@FindBy(id="user-name") WebElement username;
	@FindBy(id="password") WebElement password;
	@FindBy(id="login-button") WebElement loginBtn;
	
	
	//identify action on webelement 
	public void enterUsernameAndPassword(String user, String pass) {
		username.clear();
		username.sendKeys(user); //"standard_user"
		password.clear();
		password.sendKeys(pass); //"secret_sauce"
	}
	public void clickOnLogin() {
		loginBtn.click();
	}
}
