package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RTTC_071POM {

	private WebDriver driver;

	public RTTC_071POM(WebDriver driver) {
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

	// Metatagtitle-findelement by xpath
	@FindBy(xpath = "//input[@id='input-meta-title1']")
	public WebElement metatagtitle;

	// DataTab-findelement by xpath
	@FindBy(xpath = "//a[contains(text(),'Data')]")
	public WebElement Datatab;

	// Input Model field-findelement by xpath
	@FindBy(xpath = "//input[@name='model']")
	public WebElement AddModel;
	
//Input price-findelement by id
	@FindBy(id = "input-price")
	public WebElement inputprice;

	//input quantity-findelement by xpath
	@FindBy(xpath = "//input[@id='input-quantity']")
	public WebElement inputquantity;

	//linktab-findelement by xpath
	@FindBy(xpath = "//a[contains(text(),'Links')]")
	public WebElement Linktab;

	//input category-findelement by xpath
	@FindBy(xpath = "//input[@id='input-category']")
	public WebElement Category;

	//Discounttab-findelement by xpath
	@FindBy(xpath="//a[contains(text(),'Discount')]")
	public WebElement Discounttab;
	
	//Add Discount -findelement by xpath
	@FindBy(xpath="//table[@id='discount']//button[@type='button']")
	public WebElement AddDiscount;
	
	//discount Quantity-findelement by xpath
	@FindBy(xpath="//td[@class='text-right']//input[@placeholder='Quantity']")
	public WebElement discountquantity;
	
	//discountprice-findelement by xpath
	@FindBy(xpath="//td[@class='text-right']//input[@placeholder='Price']")
	public WebElement discountprice;
	
	//curentdatebutton-findelement by xpath
	@FindBy(xpath="//td[5]//div[1]//span[1]//button[1]")
	public WebElement currentdatebutton;
	
	//dateendutton-findelement by xpath
	@FindBy(xpath="//td[6]//div[1]//span[1]//button[1]")
	public WebElement dateendbutton;
	
	//Rewardtab-findelement by xpath
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/ul[1]/li[10]/a[1]")
	public WebElement Rewardtab;
	
	//Reward points-findelement by Id
	@FindBy(id="input-points")
	public WebElement rewardpoints;
	
	//Savebutton-findelement by xpath
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

	//defining inputquantity method to input quantity
	public void inputQuantity(String inputquantity) {
		this.inputquantity.click();
		this.inputquantity.sendKeys(inputquantity);
	}

	//defining Links method to navigate to Linktab
	public void Links() {
		this.Linktab.click();

	}
	
	//defining categeory method to input categeory
	public void categeory(String category) {
		this.Category.click();
		this.Category.sendKeys(category);
	}
	//defining Discounttab method to input discountquantity & discountpice
	public void Discounttab(String discountquantity,String discountpice) {
		this.Discounttab.click();
		this.AddDiscount.click();
		this.discountquantity.click();
		this.discountquantity.sendKeys(discountquantity);
		this.discountprice.click();
		this.discountprice.sendKeys(discountpice);
	}
	
	//defining rewardspointselect method to input rewardpoints
	public void rewardspointselect(String rewardpoints) {
		this.Rewardtab.click();
		this.rewardpoints.click();
		this.rewardpoints.sendKeys(rewardpoints);
	}

	//defining savebutton method to click on save
	public void savebutton() {

		this.savebutton.click();
	}
}
