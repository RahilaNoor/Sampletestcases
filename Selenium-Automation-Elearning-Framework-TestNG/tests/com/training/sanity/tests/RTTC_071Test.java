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

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.RTTC_011POM;
import com.training.pom.RTTC_071POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_071Test {

	private WebDriver driver;
	private String baseUrl;
	private RTTC_011POM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private RTTC_071POM rttc_071POM;

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
		rttc_071POM = new RTTC_071POM(driver);
		baseUrl = properties.getProperty("baseURL");
		System.out.println("Open page");
		screenShot = new ScreenShot(driver);

		// open the browser
		driver.get(baseUrl);

		// Login as ADMIN

		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot("71_1");
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test(dataProvider = "excel-inputs", dataProviderClass = LoginDataProviders.class)
	public void AddNewProduct(String productname,String MetaTitle,String Model,String dataPrice,String Category,String Quantity, String Price,String Points) throws InterruptedException {

		// Calling catalog method to navigate to catalog
		rttc_071POM.catalog();
		screenShot.captureScreenShot("71_2");

		// Calling products method to navigate to product
		rttc_071POM.products();
		screenShot.captureScreenShot("71_3");

		// Calling addnew method to add new product
		rttc_071POM.addnew();
		screenShot.captureScreenShot("71_4");

		// Calling Addproductname method to input productname
		rttc_071POM.Addproductname(productname);
		screenShot.captureScreenShot("71_5");

		// Calling Metatagtitle method to input Metatagtitle
		rttc_071POM.Metatagtitle(MetaTitle);
		screenShot.captureScreenShot("71_6");

		// Calling datatab method to navigate to datatab
		rttc_071POM.datatab();
		screenShot.captureScreenShot("71_7");

		// Calling AddModel method to input Model in datatab
		rttc_071POM.AddModel(Model);
		screenShot.captureScreenShot("71_8");

		// Calling AddPrice method to input price in datatab
		rttc_071POM.AddPrice(dataPrice);
		screenShot.captureScreenShot("71_9");

		// Calling inputQuantity method to input Quantity in data tab
		rttc_071POM.inputQuantity("3");
		screenShot.captureScreenShot("71_10");

		// Calling Links method to navigate to Linkstab
		rttc_071POM.Links();
		screenShot.captureScreenShot("71_11");

		// Calling Category method to input Categories in links tab
		rttc_071POM.Category.click();
		screenShot.captureScreenShot("71_12");
		rttc_071POM.Category.sendKeys(Category);
		screenShot.captureScreenShot("71_13");
		
		//Calling Discount tab
		rttc_071POM.Discounttab(Quantity, Price);
		screenShot.captureScreenShot("71_14");
		
		//calling reward points tab
		rttc_071POM.rewardspointselect(Points);
		screenShot.captureScreenShot("71_15");

		// Calling savebutton method to save
		rttc_071POM.savebutton();
		screenShot.captureScreenShot("71_14");

		// Verifying success message after click on Save button
		// successful add of new product from product list

		String message = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		String actual2 = message.replaceAll("\n", "").replaceAll("×", "");
		System.out.println(actual2);
		String Expected2 = "Success: You have modified products!";
		screenShot.captureScreenShot("71_15");

		// Assert on success message
		assertEquals(actual2, Expected2);

	}
}
