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
import com.training.pom.RTTC_013POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_013Test {

	
	private WebDriver driver;
	private String baseUrl;
	private RTTC_011POM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private RTTC_013POM categoiesdeletePOM;
	
	
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
		categoiesdeletePOM = new RTTC_013POM(driver);
		baseUrl = properties.getProperty("baseURL");
		System.out.println("Opening page");
		screenShot = new ScreenShot(driver); 
		
		// open the browser 
		driver.get(baseUrl);
		
		//Login as ADMIN
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("13_1");
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
}
	@Test
	public void DeleteCategory() throws InterruptedException {
		//Calling catalog method to navigate to catalog
		categoiesdeletePOM.catalog();
		screenShot.captureScreenShot("13_2");
		
		//Calling Categories method to navigate to categories
		categoiesdeletePOM.categories();
		screenShot.captureScreenShot("13_3");
		
		//Calling selectcategory method to select one of the category
		categoiesdeletePOM.selectcategory();
		Thread.sleep(3000);
		screenShot.captureScreenShot("13_4");
		
		//delete the selected category
		Actions action=new Actions(driver);
		WebElement delete = driver.findElement(By.xpath("//button[@type='button']"));
		action.moveToElement(delete).click().perform();
		
		
		//Switch to Alert
		//Verifying Alert message
		Alert alert = driver.switchTo().alert();
		String actual=alert.getText();
		String Expected="Are you sure?";
		System.out.println(actual);
		screenShot.captureScreenShot("13_5");
    	alert.accept();
    	Thread.sleep(3000);
    	
    	//Assert on alert message
    	assertEquals(actual, Expected);
    	
    	//Verifying success message after click on Ok button of pop up window
    	//successful removal of category from category list
    	String message=driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
    	String actual2 = message.replaceAll("\n", "").replaceAll("×", "");
    	System.out.println(actual2);
    	String Expected2="Success: You have modified categories!";
    	screenShot.captureScreenShot("13_5");
    	
    	//Assert on success message
		assertEquals(actual2, Expected2);
		
		
	}
}
