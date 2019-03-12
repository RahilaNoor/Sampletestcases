package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RTTC_011POM {
	private WebDriver driver; 
	
	public RTTC_011POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	//user name-findelement by name
	@FindBy(name="username")
	private WebElement userName; 
	
	//password - find element by id
	@FindBy(id="input-password")
	private WebElement password;
	
	//loginbutton- find element by xpath
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginBtn; 
	
	//defining sendusername method to send username
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	//defining password method to send password
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	//defining loginbtn method to login
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
}
