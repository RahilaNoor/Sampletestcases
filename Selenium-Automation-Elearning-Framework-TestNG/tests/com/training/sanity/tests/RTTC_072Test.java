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
import com.training.pom.RTTC_072POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_072Test {

	private WebDriver driver;
	private String baseUrl;
	private RTTC_011POM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private RTTC_072POM rttc_072POM;

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
		rttc_072POM = new RTTC_072POM(driver);
		baseUrl = properties.getProperty("baseURL");
		System.out.println("Open page");
		screenShot = new ScreenShot(driver);

		// open the browser
		driver.get(baseUrl);

		// Login as ADMIN

		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot("72_1");
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test(dataProvider = "excel-inputs1", dataProviderClass = LoginDataProviders.class)
	public void AddNewProduct(String productname,String MetaTitle,String Model,String dataPrice,String inputSEOURL,String Category,String Quantity, String Price,String Points) throws InterruptedException {

		// Calling catalog method to navigate to catalog
		rttc_072POM.catalog();
		screenShot.captureScreenShot("72_2");

		// Calling products method to navigate to product
		rttc_072POM.products();
		screenShot.captureScreenShot("72_3");

		// Calling addnew method to add new product
		rttc_072POM.addnew();
		screenShot.captureScreenShot("72_4");

		// Calling Addproductname method to input productname
		rttc_072POM.Addproductname(productname);
		screenShot.captureScreenShot("72_5");

		// Calling Metatagtitle method to input Metatagtitle
		rttc_072POM.Metatagtitle(MetaTitle);
		screenShot.captureScreenShot("72_6");

		// Calling datatab method to navigate to datatab
		rttc_072POM.datatab();
		screenShot.captureScreenShot("72_7");

		// Calling AddModel method to input Model in datatab
		rttc_072POM.AddModel(Model);
		screenShot.captureScreenShot("72_8");

		// Calling AddPrice method to input price in datatab
		rttc_072POM.AddPrice(dataPrice);
		screenShot.captureScreenShot("72_9");

		// Calling inputQuantity method to input Quantity in data tab
		rttc_072POM.inputQuantity("3");
		screenShot.captureScreenShot("72_10");
		
		rttc_072POM.inputSEOURL(inputSEOURL);
		screenShot.captureScreenShot("72_11");
		
		// Calling Links method to navigate to Linkstab
		rttc_072POM.Links();
		screenShot.captureScreenShot("72_12");

		// Calling Category method to input Categories in links tab
		rttc_072POM.Category.click();
		screenShot.captureScreenShot("72_13");
		rttc_072POM.Category.sendKeys(Category);
		screenShot.captureScreenShot("72_14");
		
		//Calling Discount tab
		rttc_072POM.Discounttab(Quantity, Price);
		screenShot.captureScreenShot("72_14");
		
		//start date
		//end date
		
		//calling reward points tab
		rttc_072POM.rewardspointselect(Points);
		screenShot.captureScreenShot("72_15");

		// Calling savebutton method to save
		rttc_072POM.savebutton();
		screenShot.captureScreenShot("72_14");

		// Verifying success message after click on Save button
		// successful add of new product from product list

		String message = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
		String actual2 = message.replaceAll("\n", "").replaceAll("×", "");
		System.out.println(actual2);
		String Expected2 = "Warning: Please check the form carefully for errors!";
		screenShot.captureScreenShot("72_15");

		// Assert on success message
		assertEquals(actual2, Expected2);

	}
}
