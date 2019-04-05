package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RTTC_072POM {

	private WebDriver driver;

	public RTTC_072POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// catalog-findelement by id
	@FindBy(id = "menu-catalog")
	private WebElement catalog;

	// products-findelement by xpath
	@FindBy(xpath = "/html[1]/body[1]/div[1]/nav[1]/ul[1]/li[3]/ul[1]/li[2]/a[1]")
	public WebElement products;

	// Add new icon
	@FindBy(xpath = "//div[@class='pull-right']//a[@class='btn btn-primary']")
	public WebElement addnew;

	// Add productname
	@FindBy(xpath = "//input[@id='input-name1']")
	public WebElement addproductname;

	// Metatagtitle
	@FindBy(xpath = "//input[@id='input-meta-title1']")
	public WebElement metatagtitle;

	// DataTab
	@FindBy(xpath = "//a[contains(text(),'Data')]")
	public WebElement Datatab;

	// Input Model field
	@FindBy(xpath = "//input[@name='model']")
	public WebElement AddModel;

	@FindBy(id = "input-price")
	public WebElement inputprice;

	@FindBy(xpath = "//input[@id='input-quantity']")
	public WebElement inputquantity;
	
	@FindBy(xpath="//input[@id='input-keyword']")
	public WebElement inputSEOURL;

	@FindBy(xpath = "//a[contains(text(),'Links')]")
	public WebElement Linktab;

	@FindBy(xpath = "//input[@id='input-category']")
	public WebElement Category;

	@FindBy(xpath="//a[contains(text(),'Discount')]")
	public WebElement Discounttab;
	
	@FindBy(xpath="//table[@id='discount']//button[@type='button']")
	public WebElement AddDiscount;
	
	@FindBy(xpath="//td[@class='text-right']//input[@placeholder='Quantity']")
	public WebElement discountquantity;
	
	@FindBy(xpath="//td[@class='text-right']//input[@placeholder='Price']")
	public WebElement discountprice;
	
	@FindBy(xpath="//td[5]//div[1]//span[1]//button[1]")
	public WebElement currentdatebutton;
	
	@FindBy(xpath="//td[6]//div[1]//span[1]//button[1]")
	public WebElement dateendbutton;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/ul[1]/li[10]/a[1]")
	public WebElement Rewardtab;
	
	@FindBy(xpath="//input[@id='input-points']")
	public WebElement rewardpoints;
	
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

	// defining generaltab method to input productname & metatagtitle
	public void Addproductname(String addproductname) {
		this.addproductname.click();
		this.addproductname.sendKeys(addproductname);
	}

	public void Metatagtitle(String metatagtitle) {
		this.metatagtitle.click();
		this.metatagtitle.sendKeys(metatagtitle);

	}

	public void datatab() {
		this.Datatab.click();
	}

	public void AddModel(String AddModel) {
		this.AddModel.click();
		this.AddModel.sendKeys(AddModel);
	}

	public void AddPrice(String inputprice) {
		this.inputprice.click();
		this.inputprice.sendKeys(inputprice);
	}

	public void inputQuantity(String inputquantity) {
		this.inputquantity.click();
		this.inputquantity.sendKeys(inputquantity);
	}
	public void inputSEOURL(String inputSEOURL) {
		this.inputSEOURL.click();
		this.inputSEOURL.sendKeys(inputSEOURL);
	}

	public void Links() {
		this.Linktab.click();

	}
	
	public void categeory(String category) {
		this.Category.click();
		this.Category.sendKeys(category);
	}
	public void Discounttab(String discountquantity,String discountpice) {
		this.Discounttab.click();
		this.AddDiscount.click();
		this.discountquantity.click();
		this.discountquantity.sendKeys(discountquantity);
		this.discountprice.click();
		this.discountprice.sendKeys(discountpice);
	}
	public void rewardspointselect(String rewardpoints) {
		this.Rewardtab.click();
		this.rewardpoints.click();
		this.rewardpoints.sendKeys(rewardpoints);
	}

	public void savebutton() {

		this.savebutton.click();
	}
}
