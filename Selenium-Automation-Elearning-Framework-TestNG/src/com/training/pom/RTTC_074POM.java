package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RTTC_074POM {
	private WebDriver driver;

	public RTTC_074POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// products-findelement by xpath
	@FindBy(xpath = "/html[1]/body[1]/div[1]/header[1]/div[1]/div[1]/div[3]/div[3]/nav[1]/ul[1]/li[2]/a[1]")
	public WebElement login;
	// products-findelement by xpath
	@FindBy(xpath = "//input[@id='input-email']")
	public WebElement email;
	// products-findelement by xpath
	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement password;
	// products-findelement by xpath
	@FindBy(xpath = "//input[@value='Login']")
	public WebElement loginbutton;
	// products-findelement by xpath
	@FindBy(xpath = "//a[@id='search_button']")
	public WebElement searchbutton;
	// products-findelement by xpath
	@FindBy(xpath = "//input[@id='filter_keyword']")
	public WebElement findby;
	// products-findelement by xpath
	@FindBy(xpath = "/html[1]/body[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")
	public WebElement product;
	// products-findelement by xpath
	@FindBy(xpath = "/html[1]/body[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/a[1]/span[1]/span[1]/img[1]")
	private WebElement selectIntegerProduct;
	// products-findelement by xpath
	@FindBy(xpath = "//*[@id='button-cart']")
	private WebElement addToCart;
	// products-findelement by xpath
	@FindBy(xpath = " //a[contains(text(),'Checkout')]")
	private WebElement checkout;
	// products-findelement by xpath
	@FindBy(xpath = "/html[1]/body[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/a[1]/img[1]")
	private WebElement viewTocartImage;
	// products-findelement by xpath
	@FindBy(xpath = "//div[@class='cart-info tb_min_w_500']//a[contains(text(),'Integer vitae iaculis massa')]")
	private WebElement viewTocartProductName;
	// products-findelement by xpath
	@FindBy(xpath = " //td[contains(text(),'SKU-003')]")
	private WebElement viewTocartModel;
	// products-findelement by xpath
	@FindBy(xpath = "//td[@class='price'][contains(text(),'Rs.829')]")
	private WebElement viewTocartUnitprice;
	// products-findelement by xpath
	@FindBy(xpath = "//div[@class='cart-info tb_min_w_500']//td[@class='total'][contains(text(),'Rs.829')]")
	private WebElement viewTocartTotalPrice;
	// products-findelement by xpath
	@FindBy(xpath = "//input[@value='new']")
	private WebElement guestpaymentRadio;
	// products-findelement by xpath
	@FindBy(xpath = "//input[@value='guest']]")
	private WebElement guestRadio;
	// products-findelement by xpath
	public void guestradio() {
		this.guestRadio.click();
		this.guestContinue.click();
	}
	// guestContinue-findelement by xpath
	@FindBy(xpath = "//input[@id='button-account']")
	private WebElement guestContinue;
	// guestpaymentfirstName-findelement by xpath
	@FindBy(xpath = "//input[@id='input-payment-firstname']")
	
	private WebElement guestpaymentfirstName;
	// guestpaymentLastname-findelement by xpath
	
	@FindBy(xpath = "//input[@id='input-payment-lastname']")
	private WebElement guestpaymentLastname;
	
	// guestpaymentEmail-findelement by xpath
	@FindBy(xpath = "//input[@id='input-payment-email']")
	private WebElement guestpaymentEmail;
	
	// guestpaymentelepone-findelement by xpath
	@FindBy(xpath = "//input[@id='input-payment-telephone']")
	private WebElement guestpaymentelepone;
	
	// guestPaymentaddress1-findelement by xpath
	@FindBy(xpath = "//input[@id='input-payment-address-1']")
	private WebElement guestPaymentaddress1;
	
	// guestpaymentcity-findelement by xpath
	@FindBy(xpath = "//input[@id='input-payment-city']")
	private WebElement guestpaymentcity;
	
	// guestpaymentPostcode-findelement by xpath
	@FindBy(xpath = "//input[@id='input-payment-postcode']")
	private WebElement guestpaymentPostcode;
	
	// guestpaymentCountry-findelement by xpath
	@FindBy(xpath = "//select[@id='input-payment-country']")
	private WebElement guestpaymentCountry;
	
	// guestpaymentZone-findelement by xpath
	@FindBy(xpath = "//select[@id='input-payment-zone']")
	private WebElement guestpaymentZone;
	
	// deliveryandbillingsame-findelement by xpath
	@FindBy(xpath = "//label[@class='checkbox']//input[@value='1']")
	private WebElement deliveryandbillingsame;
	
	// guestcontinuebutton-findelement by xpath
	@FindBy(xpath = "//input[@id='button-guest']")
	private WebElement guestcontinuebutton;
	
	// textarea-findelement by xpath
	@FindBy(xpath = "//textarea[@name='comment']")
	private WebElement textarea;
	
	// shippingbutton-findelement by xpath
	@FindBy(xpath = "//input[@id='button-shipping-method']")
	private WebElement shippingbutton;
	
	// agreeConditions-findelement by xpath
	@FindBy(xpath = "//*[@name='agree']")
	private WebElement agreeConditions;
	
	// PaymentMetod-findelement by xpath
	@FindBy(xpath = "//input[@id='button-payment-method']")
	private WebElement PaymentMetod;
	
	// confirmOrder-findelement by xpath
	@FindBy(xpath = "//input[@id='button-confirm']")
	private WebElement confirmOrder;
	
	// Successmessage-findelement by xpath
	@FindBy(xpath = "//div[@class='tb_text_wrap tb_sep']")
	public WebElement Successmessage;
	

//	Your order has been successfully processed!
//
//	Please direct any questions you have to the store owner.
//
//	Thanks for shopping with us online!

//====================Admin================================================
	// sales-findelement by xpath
	@FindBy(xpath = "//i[@class='fa fa-shopping-cart fw']")
	private WebElement sales;
	
	// Orders-findelement by xpath
	@FindBy(xpath = "/html[1]/body[1]/div[1]/nav[1]/ul[1]/li[6]/ul[1]/li[1]/a[1]")
	private WebElement Orders;
	
	// vieworder-findelement by xpath
	@FindBy(xpath = "//tr[1]//td[8]//a[1]")
	private WebElement vieworder;
	
	// Orderstatus-findelement by xpath
	@FindBy(xpath = "//select[@id='input-order-status']")
	private WebElement Orderstatus;
	
	// Addhistory-findelement by xpath
	@FindBy(xpath = "//button[@id='button-history']")
	private WebElement Addhistory;
	
	// successalert-findelement by xpath
	@FindBy(xpath = "//div[@class='alert alert-success']")
	private WebElement successalert;

	// Success: You have modified orders!

	// ===============================User Login=====================

	@FindBy(xpath = "//a[contains(text(),'View your order history')]")
	private WebElement useroderhistory;

	public void login(String username) {
		this.email.click();
		this.email.sendKeys(username);
	}

	public void password(String password) {
		this.password.click();
		this.password.sendKeys(password);
	}

	public void productClick() {
		this.selectIntegerProduct.click();
	}

	public void addtocarttClick() {
		this.addToCart.click();
	}

	public void checkoutClick() {
		this.checkout.click();
	}

	public String viewcartProdname() {
		return this.viewTocartProductName.getText();
	}

	public String viewcartModel() {
		return this.viewTocartModel.getText();
	}

	public void guestpaymentDetails(String pafirstname, String palastname, String paemail, String patelepone,
			String paaddress1, String pacity, String papostcode, String pacountry, String pazone, String text) {
		this.guestpaymentfirstName.click();
		this.guestpaymentfirstName.sendKeys(pafirstname);
		this.guestpaymentLastname.click();
		this.guestpaymentLastname.sendKeys(palastname);
		this.guestPaymentaddress1.click();
		this.guestpaymentEmail.click();
		this.guestpaymentEmail.sendKeys(paemail);
		this.guestpaymentelepone.click();
		this.guestpaymentelepone.sendKeys(patelepone);
		this.guestPaymentaddress1.click();
		this.guestPaymentaddress1.sendKeys(paaddress1);
		this.guestpaymentcity.click();
		this.guestpaymentcity.sendKeys(pacity);
		this.guestpaymentPostcode.click();
		this.guestpaymentPostcode.sendKeys(papostcode);
		this.guestpaymentCountry.click();
		Select select = new Select(this.guestpaymentCountry);
		select.selectByVisibleText(pacountry);
		this.guestpaymentZone.click();
		Select select1 = new Select(this.guestpaymentZone);
		select1.selectByVisibleText(pazone);
		this.guestcontinuebutton.click();
		this.textarea.click();
		this.textarea.sendKeys(text);
		this.shippingbutton.click();
		this.agreeConditions.click();
		this.PaymentMetod.click();
		this.confirmOrder.click();
	}
//defining method for admin to complete te order
	public void adminrole(String Orderstatus) {
		this.sales.click();
		this.Orders.click();
		this.vieworder.click();
		this.Orderstatus.click();
		Select select4 = new Select(this.Orderstatus);
		select4.selectByVisibleText(Orderstatus);
		this.Addhistory.click();

	}
}