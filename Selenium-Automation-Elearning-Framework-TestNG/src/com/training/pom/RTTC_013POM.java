package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RTTC_013POM {
	private WebDriver driver;

	public RTTC_013POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// catalog-findelement by id
	@FindBy(id = "menu-catalog")
	private WebElement catalog;

	// Categories-findelement by xpath
	@FindBy(xpath = "//a[contains(text(),'Categories')]")
	private WebElement categories;

//Select one of the categories to be deleted by xpath
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/input[1]")
	private WebElement target;

	

	//defining catalog method to navigate to catalog
	public void catalog() {
		this.catalog.click();
	}

	//defining categories method to navigate to categories
	public void categories() {
		this.categories.click();
	}

	public void selectcategory() {

		Actions action = new Actions(driver);
		action.moveToElement(target).click().perform();

	}

}
