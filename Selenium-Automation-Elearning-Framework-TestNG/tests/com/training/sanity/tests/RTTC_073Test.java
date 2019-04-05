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
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.RTTC_011POM;
import com.training.pom.RTTC_073POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_073Test {

	private WebDriver driver;
	private String baseUrl;
	private RTTC_011POM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private RTTC_073POM rttc_073POM;

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
		rttc_073POM = new RTTC_073POM(driver);
		baseUrl = properties.getProperty("baseURL");
		System.out.println("Open page");
		screenShot = new ScreenShot(driver);

		// open the browser
		driver.get(baseUrl);

		// Login as ADMIN

		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot("73_1");
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test(dataProvider = "db-inputs", dataProviderClass = LoginDataProviders.class)
	public void AddNewProduct(String productname, String Metatagtitle, String Model, String price, String Quantity,
			String Categories) throws InterruptedException {

		// Calling catalog method to navigate to catalog
		rttc_073POM.catalog();
		screenShot.captureScreenShot("73_2");

		// Calling products method to navigate to product
		rttc_073POM.products();
		screenShot.captureScreenShot("73_3");

		// Calling addnew method to add new product
		rttc_073POM.addnew();
		screenShot.captureScreenShot("73_4");

		// Calling Addproductname method to input productname
		rttc_073POM.Addproductname(productname);
		System.out.println(productname);
		screenShot.captureScreenShot("73_5");

		// Calling Metatagtitle method to input Metatagtitle
		rttc_073POM.Metatagtitle(Metatagtitle);
		System.out.println(Metatagtitle);
		screenShot.captureScreenShot("73_6");

		// Calling datatab method to navigate to datatab
		rttc_073POM.datatab();
		screenShot.captureScreenShot("73_7");

		// Calling AddModel method to input Model
		rttc_073POM.AddModel(Model);
		System.out.println(Model);
		screenShot.captureScreenShot("73_8");

		// Calling AddPrice method to input price
		rttc_073POM.AddPrice(price);
		System.out.println(price);
		screenShot.captureScreenShot("73_9");

		// Calling inputQuantity method to input Quantity
		rttc_073POM.inputQuantity(Quantity);
		System.out.println(Quantity);
		screenShot.captureScreenShot("73_10");

		// Calling Links method to navigate to Linkstab
		rttc_073POM.Links();
		screenShot.captureScreenShot("73_11");

		// Calling Category method to input Categories
		rttc_073POM.Category.click();
		screenShot.captureScreenShot("73_12");
		rttc_073POM.Category.sendKeys(Categories);
		System.out.println(Categories);
		screenShot.captureScreenShot("73_13");

		// Calling savebutton method to save
		rttc_073POM.savebutton();
		screenShot.captureScreenShot("73_14");

		// Verifying success message after click on Save button
		// successful add of new product from product list

		String message = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		String actual2 = message.replaceAll("\n", "").replaceAll("×", "");
		System.out.println(actual2);
		String Expected2 = "Success: You have modified products!";
		screenShot.captureScreenShot("73_15");

		// Assert on success message
		assertEquals(actual2, Expected2);

		// Assertions
		String Productname = "Finger Ring";
		String MetatagTitle = "Finger Ring for ladies";
		String MODEL = "SKU-012";
		String Price = "1000";
		String QUANTITY = "25";
		String CATEGORIES = "EARRINGS";
		Assert.assertEquals(productname, Productname);
		Assert.assertEquals(Metatagtitle, MetatagTitle);
		Assert.assertEquals(Model, MODEL);
		Assert.assertEquals(price, Price);
		Assert.assertEquals(Quantity, QUANTITY);
		Assert.assertEquals(Categories, CATEGORIES);

	}
}
