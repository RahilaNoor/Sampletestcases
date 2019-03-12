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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RTTC_011POM;
//import com.training.pom.RTTC_014POM;
import com.training.pom.RTTC_015POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_015Test {

	private WebDriver driver;
	private String baseUrl;
	private RTTC_011POM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private RTTC_015POM productdeletePOM;

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
		productdeletePOM = new RTTC_015POM(driver);
		baseUrl = properties.getProperty("baseURL");
		System.out.println("Open page");
		screenShot = new ScreenShot(driver);
		
		// open the browser
		driver.get(baseUrl);
		
		// Login as ADMIN
		
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot("15_1");
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test
	public void DeleteProduct() throws InterruptedException {
		
		//Calling catalog method to navigate to catalog
		productdeletePOM.catalog();
		screenShot.captureScreenShot("15_2");
		
		//Calling products method to navigate to product
		productdeletePOM.products();
		screenShot.captureScreenShot("15_3");
		
		//Calling selectproduct method to select one of the product
		productdeletePOM.selectproduct();
		Thread.sleep(3000);
		screenShot.captureScreenShot("15_4");
		
		//delete the selected product
		Actions action = new Actions(driver);
		WebElement delete = driver.findElement(By.xpath("//div[@class='pull-right']//button[@type='button']"));
		action.moveToElement(delete).click().perform();
		
		//Switch to Alert
				//Verifying Alert message
		Alert alert = driver.switchTo().alert();
		String actual = alert.getText();
		String Expected = "Are you sure?";
		System.out.println(actual);
		screenShot.captureScreenShot("15_5");
		alert.accept();
		Thread.sleep(3000);
		
		//Assert on alert message
		assertEquals(actual, Expected);
		
		//Verifying success message after click on Ok button of pop up window
    	//successful removal of product from product list
		
		String message = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		String actual2 = message.replaceAll("\n", "").replaceAll("×", "");
		System.out.println(actual2);
		String Expected2 = "Success: You have modified products!";
        screenShot.captureScreenShot("15_5");
		
      //Assert on success message
		assertEquals(actual2, Expected2);

	}
}
