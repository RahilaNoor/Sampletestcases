package com.training.sanity.tests;

//Package com.training.sanity.tests.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.RTTC_011POM;
//import com.training.pom.LoginPOM;
import com.training.pom.RTTC_074POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_074Test {

	private WebDriver driver;
	private String baseUrl;
	private RTTC_011POM loginPOM;
	private RTTC_074POM rttc074POM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeTest
	public void setUp() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new RTTC_011POM(driver);
		rttc074POM = new RTTC_074POM(driver);
		String baseUrl1 = properties.getProperty("baseURL1");
		String baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		driver.get(baseUrl1);

		// Login to the applications as User

		rttc074POM.login("rahila@gmail.com");
		rttc074POM.password("Welcome@243");
		rttc074POM.loginbutton.click();
		screenShot.captureScreenShot("74_01");
	}

	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	// ***************** Placing order************************************

	@Test
	public void adminrole() throws InterruptedException {
		// handling wit windows
		Actions action = new Actions(driver);
		String currentWindow = driver.getWindowHandle();
		Set<String> availableWindows = driver.getWindowHandles();
		int count = availableWindows.size();

		rttc074POM.searchbutton.click();
		Thread.sleep(4000);
		rttc074POM.findby.sendKeys("Integer Vitae Iaculis Massa");
		System.out.println("====================");
		rttc074POM.searchbutton.click();
		Thread.sleep(3000);
		Actions action2 = new Actions(driver);
		action2.moveToElement(rttc074POM.product).perform();
		rttc074POM.product.click();
		// double click te element
		action2.doubleClick(rttc074POM.product);
		Thread.sleep(4000);
		rttc074POM.addtocarttClick();
		Thread.sleep(4000);
		WebElement shopbag = driver.findElement(By.xpath("//i[@class='tb_icon ico-linea-ecommerce-bag']"));
		action.moveToElement(shopbag).build().perform();
		Thread.sleep(3000);
		rttc074POM.checkoutClick();
		Thread.sleep(3000);
		rttc074POM.guestradio();
		Thread.sleep(3000);
		rttc074POM.guestpaymentDetails("Jani", "Darga", "janura@gmail.com", "98213467441", "manikonda", "Hyderabad",
				"500090", "India", "Telangana", "test1");
		Thread.sleep(3000);
		// rttc074POM.payment_Continue();
		String actual = rttc074POM.Successmessage.getText();
		System.out.println("actual");

		for (String child : availableWindows)
			if (!availableWindows.isEmpty()) {
				for (String windowId : availableWindows) {
					driver.switchTo().window(windowId);

					driver.get(baseUrl);
					// Calling sendUserName method & sending admin Username
					loginPOM.sendUserName("admin");

					// Calling sendPasswod method & sending admin password
					loginPOM.sendPassword("admin@123");

					// Calling ClickLoginBtn method
					loginPOM.clickLoginBtn();

					// calling admin role to complete the order
					rttc074POM.adminrole("completed");
					String message = rttc074POM.Successmessage.getText();
					String actual2 = message.replaceAll("\n", "").replaceAll("×", "");
					String Expected2 = "Success: You have modified orders!";
					Assert.assertEquals(actual2, Expected2);

				}
			}
	}
}
