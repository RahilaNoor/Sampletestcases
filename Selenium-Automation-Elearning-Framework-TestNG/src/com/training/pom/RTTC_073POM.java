package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RTTC_073POM {

	private WebDriver driver;

	public RTTC_073POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// catalog-findelement by id
	@FindBy(id = "menu-catalog")
	private WebElement catalog;

	// products-findelement by xpath
	@FindBy(xpath = "/html[1]/body[1]/div[1]/nav[1]/ul[1]/li[3]/ul[1]/li[2]/a[1]")
	public WebElement products;

	// Add new icon-findelement by xpath
	@FindBy(xpath = "//div[@class='pull-right']//a[@class='btn btn-primary']")
	public WebElement addnew;

	// Add productname-findelement by xpath
	@FindBy(xpath = "//input[@id='input-name1']")
	public WebElement addproductname;

	// Metatagtitle-findelement by id
	@FindBy(id = "input-meta-title1")
	public WebElement metatagtitle;

	// DataTab-findelement by xpath
	@FindBy(xpath = "//a[contains(text(),'Data')]")
	public WebElement Datatab;

	// Input Model field-findelement by xpath
	@FindBy(xpath = "//input[@name='model']")
	public WebElement AddModel;

	@FindBy(id = "input-price")
	public WebElement inputprice;

	@FindBy(xpath = "//input[@id='input-quantity']")
	public WebElement inputquantity;

	@FindBy(xpath = "//a[contains(text(),'Links')]")
	public WebElement Linktab;

	@FindBy(xpath = "//input[@id='input-category']")
	public WebElement Category;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement savebutton;

	// defining catalog method to navigate to catalog
	public void catalog() {
		this.catalog.click();
	}

	// defining products method to navigate to products
	public void products() {
		this.products.click();
	}

	// defining addnew method to create new product
	public void addnew() {
		this.addnew.click();
	}

	// defining Addproductname method to input productname
	public void Addproductname(String addproductname) {
		this.addproductname.click();
		this.addproductname.sendKeys(addproductname);
	}
	// defining Metatagtitle method to input metatagtitle
	public void Metatagtitle(String metatagtitle) {
		this.metatagtitle.click();
		this.metatagtitle.sendKeys(metatagtitle);

	}
	//defining datatab method to navigate to data tab
	public void datatab() {
		this.Datatab.click();
	}
	//defining AddModel method to input Model
	public void AddModel(String AddModel) {
		this.AddModel.click();
		this.AddModel.sendKeys(AddModel);
	}
	//defining AddPrice method to input Price
	public void AddPrice(String inputprice) {
		this.inputprice.click();
		this.inputprice.sendKeys(inputprice);
	}
	//defining inputQuantity method to input Quantity
	public void inputQuantity(String inputquantity) {
		this.inputquantity.click();
		this.inputquantity.sendKeys(inputquantity);
	}
	//defining Links method to navigate to Linktab
	public void Links() {
		this.Linktab.click();

	}
	//defining savebutton method to save
	public void savebutton() {

		this.savebutton.click();
	}
}
