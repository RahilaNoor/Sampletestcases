package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RTTC_014POM {

	private WebDriver driver;

	public RTTC_014POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// catalog-findelement by id
	@FindBy(id = "menu-catalog")
	private WebElement catalog;
	
	// products-findelement by xpath
	@FindBy(xpath = "/html[1]/body[1]/div[1]/nav[1]/ul[1]/li[3]/ul[1]/li[2]/a[1]")
	public WebElement products;
	
	// productname-findelement by id
	@FindBy(id = "input-name")
	private WebElement productname;
	
	// productpice-findelement by id
	@FindBy(id = "input-price")
	private WebElement productprice;
	
	// filterbutton-findelement by id
	@FindBy(xpath = "//button[contains(text(),'Filter')]")
	private WebElement filterbutton;

	// defining catalog method to navigate to catalog
	public void catalog() {
		this.catalog.click();
	}

	// defining products method to navigate to products
	public void products() {
		this.products.click();
	}

	// defining productnamesearch method to input productname
	public void productnamesearch(String productname) {
		this.productname.clear();
		this.productname.sendKeys(productname);
	}

	// defining productpricesearch method to input productprice
	public void productpricesearch(String productprice) {
		this.productprice.clear();
		this.productprice.sendKeys(productprice);
	}

	// defining clickFilter method to filter te search
	public void clickFilter() {
		this.filterbutton.click();

	}

	// defining cleartext method to clear the texts from search textboxes
	public void cleartext() {
		this.productname.clear();
		this.productprice.clear();

	}

}
