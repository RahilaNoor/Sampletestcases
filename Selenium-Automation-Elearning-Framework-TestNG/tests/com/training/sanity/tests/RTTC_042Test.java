package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RTTC_011POM;
import com.training.pom.RTTC_042POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_042Test {

	private WebDriver driver;
	private String baseUrl;
	private RTTC_011POM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private RTTC_042POM rttc_042POM;

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
		rttc_042POM = new RTTC_042POM(driver);
		baseUrl = properties.getProperty("baseURL");
		System.out.println("Open page");
		screenShot = new ScreenShot(driver);

		// open the browser
		driver.get(baseUrl);

		// Login as ADMIN

		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot("42_1");
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test
	public void AddNewProduct() throws InterruptedException {

		// Calling catalog method to navigate to catalog
		rttc_042POM.catalog();
		screenShot.captureScreenShot("42_2");

		// Calling products method to navigate to product
		rttc_042POM.products();
		screenShot.captureScreenShot("42_3");

		// Calling addnew method to add new product
		rttc_042POM.addnew();
		screenShot.captureScreenShot("42_4");

		// Calling Addproductname method to input productname
		rttc_042POM.Addproductname("Finger Ring");
		screenShot.captureScreenShot("42_5");

		// Calling Metatagtitle method to input Metatagtitle
		rttc_042POM.Metatagtitle("Finger Ring for ladies");
		screenShot.captureScreenShot("42_6");

		// Calling datatab method to navigate to datatab
		rttc_042POM.datatab();
		screenShot.captureScreenShot("42_7");

		// Calling AddModel method to input Model
		rttc_042POM.AddModel("SKU-012");
		screenShot.captureScreenShot("42_8");

		// Calling AddPrice method to input price
		rttc_042POM.AddPrice("7000");
		screenShot.captureScreenShot("42_9");

		// Calling inputQuantity method to input Quantity
		rttc_042POM.inputQuantity("15");
		screenShot.captureScreenShot("42_10");

		// Calling Links method to navigate to Linkstab
		rttc_042POM.Links();
		screenShot.captureScreenShot("42_11");

		// Calling Category method to input Categories
		rttc_042POM.Category.click();
		screenShot.captureScreenShot("42_12");
		rttc_042POM.Category.sendKeys("EARRINGS");
		screenShot.captureScreenShot("42_13");

		// Calling savebutton method to save
		rttc_042POM.savebutton();
		screenShot.captureScreenShot("42_14");

		// Verifying success message after click on Save button
		// successful add of new product from product list

		String message = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		String actual2 = message.replaceAll("\n", "").replaceAll("×", "");
		System.out.println(actual2);
		String Expected2 = "Success: You have modified products!";
		screenShot.captureScreenShot("42_15");

		// Assert on success message
		assertEquals(actual2, Expected2);

	}
}
