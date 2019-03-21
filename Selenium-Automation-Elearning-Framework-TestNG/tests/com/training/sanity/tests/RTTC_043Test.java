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
import com.training.pom.RTTC_043POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_043Test {

	private WebDriver driver;
	private String baseUrl;
	private RTTC_011POM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private RTTC_043POM rttc_043POM;

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
		rttc_043POM = new RTTC_043POM(driver);
		baseUrl = properties.getProperty("baseURL");
		System.out.println("Open page");
		screenShot = new ScreenShot(driver);
		
		// open the browser
		driver.get(baseUrl);
		
		// Login as ADMIN
		
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot("43_1");
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test
	public void ModifyProducts() throws InterruptedException {
		
		//Calling catalog method to navigate to catalog
		rttc_043POM.catalog();
		screenShot.captureScreenShot("43_2");
		
		//Calling products method to navigate to product
		rttc_043POM.products();
		screenShot.captureScreenShot("43_3");
		
		
		//Calling Edit metod to navigate to edit page
		rttc_043POM.editproduct();
		screenShot.captureScreenShot("43_4");
		
		//Calling data method to navigate to data link
		rttc_043POM.data();
		
		//Modifying the Quantity field by sending new value
		rttc_043POM.Quantity.clear();
		screenShot.captureScreenShot("43_5");
		rttc_043POM.Quantity.sendKeys("12");
		
		//Modifying the SEOURL
		rttc_043POM.SEOURL.click();
		rttc_043POM.SEOURL.sendKeys("home1");
		screenShot.captureScreenShot("43_6");
		
		//Click on Save
		rttc_043POM.Save.click();
		screenShot.captureScreenShot("43_7");
		
		//Verifying the success message
	String message = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		String actual2 = message.replaceAll("\n", "").replaceAll("×", "");
		System.out.println(actual2);
		String Expected2 = "Success: You have modified products!";
        screenShot.captureScreenShot("43_8");
		
      //Assert on success message
		assertEquals(actual2, Expected2);
	}
		
		
		
		
		
}
