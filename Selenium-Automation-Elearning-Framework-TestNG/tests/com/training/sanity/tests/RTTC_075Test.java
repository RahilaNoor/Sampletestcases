package com.training.sanity.tests;

//Package com.training.sanity.tests.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
//import com.training.pom.LoginPOM;
import com.training.pom.RTTC_075POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_075Test {

	private WebDriver driver;
	private String baseUrl;
	// private LoginPOM loginPOM;
	private RTTC_075POM rttc075POM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeTest
	public void setUp() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		// loginPOM = new LoginPOM(driver);
		rttc075POM = new RTTC_075POM(driver);
		String baseUrl1 = properties.getProperty("baseURL1");
		screenShot = new ScreenShot(driver);
		// String baseUrl1;
		// open the browser
		driver.get(baseUrl1);
		// Login to the applications
		rttc075POM.login("rahila@gmail.com");
		rttc075POM.password("Welcome@243");
		rttc075POM.loginbutton.click();
		screenShot.captureScreenShot("First");
	}

	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	// ***************** Placing order************************************
	@Test(dataProvider = "excel-inputs2", dataProviderClass = LoginDataProviders.class)
	public void productintegerclick(String reason,String Productisopened,String falutyreasons)
			throws InterruptedException {
		// String reason,String Productisopened,String falutyreasons
		Actions action = new Actions(driver);

		Thread.sleep(4000);
		rttc075POM.searchbutton.click();
		Thread.sleep(4000);
		rttc075POM.findby.sendKeys("sku-003");
		System.out.println("====================");
		rttc075POM.searchbutton.click();

		Thread.sleep(3000);
		Actions action2 = new Actions(driver);
		action2.moveToElement(rttc075POM.product).perform();
		rttc075POM.product.click();
		action2.doubleClick(rttc075POM.product);

		Thread.sleep(4000);

		rttc075POM.addtocarttClick();

		Thread.sleep(4000);

		Actions actionshop = new Actions(driver);
		WebElement shopbag = driver.findElement(By.xpath("//i[@class='tb_icon ico-linea-ecommerce-bag']"));
		action.moveToElement(shopbag).build().perform();
		Thread.sleep(3000);
		rttc075POM.checkoutClick();
		rttc075POM.checkout_Continue();
		Thread.sleep(3000);

		rttc075POM.panel_Continue();
		Thread.sleep(3000);
		rttc075POM.input_Continue();
		Thread.sleep(3000);
		rttc075POM.input_value_Continue();
		Thread.sleep(3000);
		rttc075POM.payment_Continue();
		rttc075POM.confirm_order();
		rttc075POM.last_Continue();

		// **************************** RetunOrder*****************************
		// ****************************************************************************
		Actions action1 = new Actions(driver);
		WebElement usericon = driver.findElement(By.xpath("//i[@class='fa fa-user-o']"));
		action1.moveToElement(usericon).build().perform();
		Thread.sleep(500);
		System.out.println(usericon.getText());

		Thread.sleep(3000);
		rttc075POM.myorderClick();
		rttc075POM.viewOrder();
		rttc075POM.returnOrderlink();
		WebElement element = driver.switchTo().activeElement();
		element.sendKeys(Keys.PAGE_DOWN);

		rttc075POM.return_For_reason("Dead On Arrival");
		//System.out.println(reason);
		Thread.sleep(3000);
		rttc075POM.isProductOpen("Yes");
		
		Thread.sleep(3000);
		rttc075POM.falutyreasons(falutyreasons);
		Thread.sleep(3000);
		rttc075POM.submit_prod_info();
		String returnText = rttc075POM.Return_confir_Msg();
		// System.out.println(reason + Productisopened + falutyreasons);
		System.out.println("Product Return Message: " + returnText);
		// Thank you for submitting your return request. Your request has been sent to
		// the relevant department for processing.
		// You will be notified via e-mail as to the status of your request.

	}

}