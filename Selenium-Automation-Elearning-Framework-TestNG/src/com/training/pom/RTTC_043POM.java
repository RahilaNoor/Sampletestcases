package com.training.pom;

import java.nio.channels.SelectableChannel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RTTC_043POM {

	private WebDriver driver;

	public RTTC_043POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// catalog-findelement by id
	@FindBy(id = "menu-catalog")
	private WebElement catalog;

	// products-findelement by xpath
	@FindBy(xpath = "/html[1]/body[1]/div[1]/nav[1]/ul[1]/li[3]/ul[1]/li[2]/a[1]")
	public WebElement products;
	
	//Add Edit button
	@FindBy(xpath="//tr[1]//td[8]//a[1]")
	public WebElement Edit;
	
	//Data link
	@FindBy(xpath="//a[contains(text(),'Data')]")
	public WebElement Datalink;
	
	//Quantity
	@FindBy(xpath="//input[@id='input-quantity']")
	public WebElement Quantity;
	
	//SEO URL
	@FindBy(xpath="//input[@id='input-keyword']")
	public WebElement SEOURL;
	
	//Save
	@FindBy(xpath="//button[@type='submit']")
	public WebElement Save;
	
	

	// defining catalog method to navigate to catalog
	public void catalog() {
		this.catalog.click();
	}

	// defining products method to navigate to products
	public void products() {
		this.products.click();
	}

	//defining EditPoduct method
	public void editproduct() {
		Edit.click();
	}
	
	//Navigate to Data tab
	public void data() {
		Datalink.click();
		
		}
}
	