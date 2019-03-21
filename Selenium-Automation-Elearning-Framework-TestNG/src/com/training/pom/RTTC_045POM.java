package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RTTC_045POM {

	private WebDriver driver;

	public RTTC_045POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// orders-findelement by xpath
	@FindBy(xpath = "//body/div[@id='container']/nav[@id='column-left']/ul[@id='menu']/li[@id='menu-sale']/a[1]")
	public WebElement orders;
	
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/nav[1]/ul[1]/li[6]/ul[1]/li[1]/a[1]")
 public WebElement order1;
	// add new order
	@FindBy(xpath = "//div[@class='pull-right']//a[@class='btn btn-primary']")
	public WebElement newaddorder;

	// customer details filling
 // inputcustomer-findelement by xpath
	@FindBy(xpath = "//input[@id='input-customer']")
	public WebElement inputcustomer;
	// inputfirstname-findelement by xpath
	@FindBy(xpath = "//input[@id='input-firstname']")
	public WebElement inputfirstname;
	@FindBy(xpath = "//input[@id='input-lastname']")
	public WebElement inputlastname;
	@FindBy(xpath = "//input[@id='input-email']")
	public WebElement inputemail;
	@FindBy(xpath = "//input[@id='input-telephone']")
	public WebElement inputtelepone;
	@FindBy(xpath = "//button[@id='button-customer']")
	public WebElement Continuebutton;
	@FindBy(xpath = "//input[@id='input-product']")
	public WebElement ChooseProduct;
	@FindBy(xpath = "//input[@id='input-quantity']")
	public WebElement Quantity;
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[1]/div[2]/div[2]/div[1]/div[1]/button[1]")
	//@FindBy(xpath = "//button[@id='button-product-add']")
	public WebElement AddProduct;
	@FindBy(xpath = "//button[@id='button-cart']")
	public WebElement continuetocart;
	@FindBy(xpath = "//input[@id='input-payment-firstname']")
	public WebElement paymentfirstname;
	@FindBy(xpath = "//input[@id='input-payment-lastname']")
	public WebElement paymentlastname;
	@FindBy(xpath = "//input[@id='input-payment-address-1']")
	public WebElement paymentaddress;
	@FindBy(xpath = "//input[@id='input-payment-city']")
	public WebElement paymentcity;
	@FindBy(xpath = "//input[@id='input-payment-postcode']")
	public WebElement paymentpostcode;
	@FindBy(xpath = "//select[@id='input-payment-country']")
	public WebElement paymentcountry;
	@FindBy(xpath = "//select[@id='input-payment-zone']")
	public WebElement Regionzone;
	@FindBy(xpath = "//button[@id='button-payment-address']")
	public WebElement continuepaymentaddress;
	@FindBy(xpath = "//input[@id='input-shipping-firstname']")
	public WebElement shippingfirstname;
	@FindBy(xpath = "//input[@id='input-shipping-lastname']")
	public WebElement shippinglastname;
	@FindBy(xpath = "//input[@id='input-shipping-address-1']")
	public WebElement shippingaddress;
	@FindBy(xpath = "//input[@id='input-shipping-city']")
	public WebElement shippingcity;
	@FindBy(xpath = "//input[@id='input-shipping-postcode']")
	public WebElement sippingpostcode;
	@FindBy(xpath = "//select[@id='input-shipping-country']")
	public WebElement shippingcountry;
	@FindBy(xpath = "//select[@id='input-shipping-zone']")
	public WebElement shippingzone;
	@FindBy(xpath = "//button[@id='button-shipping-address']")
	public WebElement continueshippingaddress;
	@FindBy(xpath = "//select[@id='input-shipping-method']")
	public WebElement shippingmethod;
	@FindBy(xpath = "// button[@id='button-shipping-method']")
	public WebElement shippingmethodApply;
	@FindBy(xpath = "// select[@id='input-payment-method']")
	public WebElement paymentmethod;
	@FindBy(xpath = "// button[@id='button-payment-method']")
	public WebElement paymentmethodapply;
	@FindBy(xpath = "// button[@id='button-save']")
	public WebElement buttonsave;

	// checking for invoice
	@FindBy(xpath = "// tr[1]//td[8]//a[1]")
	public WebElement firstorder;
	
	@FindBy(xpath="//button[@id='button-invoice']")
	public WebElement invoicebutton;
	@FindBy(xpath = "// div[@class='row']//tr[1]//td[3]")
	public WebElement invoice;

	//creating "
	public void inputcustomer(String inputcustomer) {
		//this.orders.click();
		//this.newaddorder.click();
		this.inputcustomer.click();
		this.inputcustomer.sendKeys(inputcustomer);
	}
	public void inputfirstname(String inputfirstname) {
		this.inputfirstname.click();
		this.inputfirstname.sendKeys(inputfirstname);
		
	}
	public void inputlastname(String inputlastname) {
		this.inputlastname.click();
		this.inputlastname.sendKeys(inputlastname);
		
	}
	public void inputemail(String inputemail) {
		this.inputemail.click();
		this.inputemail.sendKeys(inputemail);
		
	}
	public void inputtelepone(String inputtelepone) {
		this.inputtelepone.click();
		this.inputtelepone.sendKeys(inputtelepone);
		this.Continuebutton.click();
		
	}
	public void ChooseProduct(String ChooseProduct) {
		this.ChooseProduct.click();
		this.ChooseProduct.sendKeys(ChooseProduct);
		
	}
	public void Quantity (String Quantity) {
		this.Quantity.click();
		this.Quantity.clear();
		this.Quantity.sendKeys(Quantity);
		//this.AddProduct.click();
		//this.continuetocart.click();
	}
	public void paymentfirstname (String paymentfirstname) {
		this.paymentfirstname.click();
		this.paymentfirstname.sendKeys(paymentfirstname);
			}
	public void paymentlastname (String paymentlastname) {
		this.paymentlastname.click();
		this.paymentlastname.sendKeys(paymentlastname);
			}
	public void paymentaddress (String paymentaddress) {
		this.paymentaddress.click();
		this.paymentaddress.sendKeys(paymentaddress);
			}
	public void paymentcity (String paymentcity) {
		this.paymentcity.click();
		this.paymentcity.sendKeys(paymentcity);
			}
	public  void shippingfirstname (String shippingfirstname) {
		this.shippingfirstname.click();
		this.shippingfirstname.sendKeys(shippingfirstname);
			}
	public void shippinglastname (String shippinglastname) {
		this.shippinglastname.click();
		this.shippinglastname.sendKeys(shippinglastname);
			}
	public void shippingaddress (String shippingaddress) {
		this.shippingaddress.click();
		this.shippingaddress.sendKeys(shippingaddress);
			}
	public void shippingcity (String shippingcity) {
		this.shippingcity.click();
		this.shippingcity.sendKeys(shippingcity);
			}
	
	
}
