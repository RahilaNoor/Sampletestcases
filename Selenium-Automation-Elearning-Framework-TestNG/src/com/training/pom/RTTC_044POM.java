package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RTTC_044POM {

	private WebDriver driver;

	public RTTC_044POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// catalog-findelement by id
	@FindBy(id = "menu-catalog")
	private WebElement catalog;

	// products-findelement by xpath
	@FindBy(xpath = "/html[1]/body[1]/div[1]/nav[1]/ul[1]/li[3]/ul[1]/li[2]/a[1]")
	public WebElement products;

	// Product to be deleted-findelement by xpath
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/input[1]")
	private WebElement target1;
	
	// Product to be deleted-findelement by xpath
		@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/input[1]")
		private WebElement target2;

	// delete button-findelement by xpath
	@FindBy(xpath = "//div[@class='pull-right']//button[@type='button']")
	private WebElement delete;

	// defining catalog method to navigate to catalog
	public void catalog() {
		this.catalog.click();
	}

	// defining products method to navigate to products
	public void products() {
		this.products.click();
	}

	// defining selectproduct method to select the product to be deleted
	public void selectproduct() {
		Actions action = new Actions(driver);
		action.moveToElement(target1).click().perform();
		action.moveToElement(target2).click().perform();

	}

}
