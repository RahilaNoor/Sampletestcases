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
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RTTC_012POM;
import com.training.pom.RTTC_011POM;
import com.training.pom.RTTC_014POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_014Test {

	private WebDriver driver;
	private String baseUrl;
	private RTTC_011POM loginPOM;
	private RTTC_014POM productdetailsPOM;
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
		productdetailsPOM = new RTTC_014POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		Actions action = new Actions(driver);
		
		// open the browser
		driver.get(baseUrl);
		
		// Login as Admin
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot("14_1");
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test
	public void productdeatils() {

		// Calling catalog method
		productdetailsPOM.catalog();
		screenShot.captureScreenShot("14_2");
		Actions action = new Actions(driver);
		action.moveToElement(productdetailsPOM.products).build().perform();

		// Calling products method to navigate to products
		productdetailsPOM.products();
		screenShot.captureScreenShot("14_3");

		// Calling productnamesearch & passing the input value
		productdetailsPOM.productnamesearch("Integer vitae iaculis massa");

		// calling clickFilter method in order to do Filter
		productdetailsPOM.clickFilter();
		screenShot.captureScreenShot("14_4");
		System.out.println("productname search is successful");

		// Assert on productname value
		String actual = driver.findElement(By.xpath("//td[contains(text(),'Integer vitae iaculis massa')]")).getText();
		String expected = "Integer vitae iaculis massa";
		assertEquals(actual, expected);

		// Calling cleartext method
		productdetailsPOM.cleartext();

		// Calling productpricesearch & passing the input value
		productdetailsPOM.productpricesearch("7000");

		// calling clickFilter method in order to do Filter
		productdetailsPOM.clickFilter();
		screenShot.captureScreenShot("14_5");
		
		String input = driver.findElement(By.xpath("//tbody//tr[1]//td[5]")).getText();
		String actual1=String.valueOf(input).split("\\.")[0];
		System.out.println(actual1);
		String expected1="7000";
		assertEquals(actual1, expected1);
		
		
			}

}
