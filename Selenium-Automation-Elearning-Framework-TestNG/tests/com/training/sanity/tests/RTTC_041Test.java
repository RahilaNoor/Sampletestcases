package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RTTC_011POM;
import com.training.pom.RTTC_041POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_041Test {

	private WebDriver driver;
	private String baseUrl;
	private RTTC_011POM loginPOM;
	private RTTC_041POM rttc_041POM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);

		// Setup Admin Login
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new RTTC_011POM(driver);
		rttc_041POM = new RTTC_041POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		Actions action = new Actions(driver);

		// open the browser
		driver.get(baseUrl);

		// Login as Admin
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot("41_1");
	}

	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test
	public void productsearchbyproductname() {

		// Calling catalog method
		rttc_041POM.catalog();
		screenShot.captureScreenShot("41_2");
		Actions action = new Actions(driver);
		action.moveToElement(rttc_041POM.products).build().perform();

		// Calling products method to navigate to products
		rttc_041POM.products();
		screenShot.captureScreenShot("41_3");

		// Calling clear method to clear all the searchfeilds
		rttc_041POM.cleartext();

		// Calling productnamesearch & passing the input value
		rttc_041POM.productnamesearch("Integer vitae iaculis massa");

		// calling clickFilter method in order to do Filter
		rttc_041POM.clickFilter();
		screenShot.captureScreenShot("41_4");
		System.out.println("productname search is successful");

		// Assert on productname value
		String actual = driver.findElement(By.xpath("//td[contains(text(),'Integer vitae iaculis massa')]")).getText();
		String expected = "Integer vitae iaculis massa";
		assertEquals(actual, expected);
	}

	@Test(priority=1)

	public void productsearchbyprice() {

		// Calling clear method to clear all the searchfeilds
		rttc_041POM.cleartext();

		// Calling productpricesearch & passing the input value
		rttc_041POM.productpricesearch("500");

		// calling clickFilter method in order to do Filter
		rttc_041POM.clickFilter();
		screenShot.captureScreenShot("41_5");

		// Assert on Product price
		String input = driver.findElement(By.xpath("//tbody//tr[1]//td[5]")).getText();
		String actual1 = String.valueOf(input).split("\\.")[0];
		System.out.println(actual1);
		String expected1 = "500";
		assertEquals(actual1, expected1);

	}

	@Test(priority=2)

	public void productsearchbystatus() {

		// Calling clear method to clear all the searchfeilds
		rttc_041POM.cleartext();

		// selecting status dropdown
		Select status = new Select(driver.findElement(By.xpath("//select[@id='input-status']")));
		// select text as "Enabled"
		status.selectByVisibleText("Enabled");
		rttc_041POM.clickFilter();
		screenShot.captureScreenShot("41_6");
		// select text as "Disabled"
		// status.selectByVisibleText("Disabled");
		// RTTC_041POM.clickFilter();

	}

	@Test(priority=3)
	public void productsearchbyModel() throws InterruptedException {

		// Calling clear method to clear all the searchfeilds
		rttc_041POM.cleartext();

		// Calling productmodelsearch to make a search with input
		rttc_041POM.productmodelsearch("SKU-003");
		rttc_041POM.clickFilter();
		Thread.sleep(3000);
		screenShot.captureScreenShot("41_7");

	}

	@Test(priority=4)

	public void productsearchbyQuantity() throws InterruptedException {

		// Calling clear method to clear all the searchfeilds
		rttc_041POM.cleartext();

		// Calling productQuantitysearch to make a search with input
		rttc_041POM.productQuantitysearch("50");
		rttc_041POM.clickFilter();
		Thread.sleep(3000);
		screenShot.captureScreenShot("41_8");

	}

	@Test(priority=5)

	public void productsearchbyImage() {

		// Calling clear method to clear all the searchfeilds
		rttc_041POM.cleartext();

		// selecting status dropdown
		Select status1 = new Select(driver.findElement(By.xpath("//select[@name='filter_image']")));

		// select text as "Enabled"
		status1.selectByVisibleText("Enabled");
		rttc_041POM.clickFilter();

		// select text as "Disabled"
		// status1.selectByVisibleText("Disabled");
		// rttc_041POM.clickFilter();

		screenShot.captureScreenShot("41_9");

	}

}
