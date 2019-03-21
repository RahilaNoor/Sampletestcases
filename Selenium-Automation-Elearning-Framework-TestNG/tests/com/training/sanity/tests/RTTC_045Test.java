package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.DoubleClickAction;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;

import com.training.pom.RTTC_011POM;
import com.training.pom.RTTC_045POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_045Test {

	private WebDriver driver;
	private String baseUrl;
	private RTTC_011POM loginPOM;
	private RTTC_045POM rttc_045POM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new RTTC_011POM(driver);
		rttc_045POM = new RTTC_045POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		Actions action = new Actions(driver);

		// open the browser
		driver.get(baseUrl);

		// Login as Admin
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot("45_1");
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test
	public void addnew() throws InterruptedException {
		rttc_045POM.orders.click();
		rttc_045POM.order1.click();

		rttc_045POM.newaddorder.click();
		rttc_045POM.inputcustomer("Rahila Noor");
		rttc_045POM.inputfirstname("Rahila");
		rttc_045POM.inputlastname("Noor");

		rttc_045POM.inputemail("rahila@gmail.com");
		rttc_045POM.inputtelepone("8121717722");
		rttc_045POM.ChooseProduct("Finger Ring");

		rttc_045POM.Quantity("12");

		Thread.sleep(3000);
		rttc_045POM.AddProduct.click();
		Thread.sleep(3000);
		rttc_045POM.continuetocart.click();
		rttc_045POM.paymentfirstname("Rahila");
		rttc_045POM.paymentlastname("Noor");
		rttc_045POM.paymentaddress("Manikonda");
		rttc_045POM.paymentcity("Hyderabad");

		rttc_045POM.paymentpostcode.click();
		rttc_045POM.paymentpostcode.sendKeys("500089");
		Select se1 = new Select(rttc_045POM.paymentcountry);
		se1.selectByVisibleText("India");
		Select se2 = new Select(rttc_045POM.Regionzone);
		se2.selectByVisibleText("Telangana");

		rttc_045POM.continuepaymentaddress.click();
		;
		rttc_045POM.shippingfirstname("Rahila");
		rttc_045POM.shippinglastname("Noor");
		rttc_045POM.shippingaddress("Mindspace");
		rttc_045POM.shippingcity("Hyderabad");
		Select se3 = new Select(rttc_045POM.shippingcountry);
		se1.selectByVisibleText("India");
		Select se4 = new Select(rttc_045POM.shippingzone);
		se4.selectByVisibleText("Telangana");
		rttc_045POM.continueshippingaddress.click();

		Select se5 = new Select(rttc_045POM.shippingmethod);
		se5.selectByIndex(1);

		rttc_045POM.shippingmethodApply.click();
		Select se6 = new Select(rttc_045POM.paymentmethod);
		se6.selectByVisibleText("Cash On Delivery");
		rttc_045POM.paymentmethodapply.click();
		rttc_045POM.buttonsave.click();

		// =================================================================================================//
		// ==========invoice generation==============================//

		rttc_045POM.orders.click();
		rttc_045POM.order1.click();
		rttc_045POM.firstorder.click();
		Thread.sleep(3000);
		rttc_045POM.invoicebutton.click();

		System.out.println(driver
				.findElement(By.xpath(
						"/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[2]"))
				.getText());
		String Actual = driver.findElement(By.xpath("//div[@class='alert-info']")).getText();
		String Expected = "At shipping postcode 500090 () :This pincode is servicable for cash on delivery";
		Assert.assertEquals(Actual, Expected);
	}

}
