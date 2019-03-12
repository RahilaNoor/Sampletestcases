package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RTTC_012POM;
import com.training.pom.RTTC_011POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_012Test {
	private static final String catalog = null;
	private WebDriver driver;
	private String baseUrl;
	private RTTC_011POM loginPOM;
	private RTTC_012POM categoriesPOM;
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
		categoriesPOM = new RTTC_012POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		
		// open the browser 
		driver.get(baseUrl);
		
		//Calling sendUserName method & sending Username
		loginPOM.sendUserName("admin");
		
		//Calling sendPasswod method & sending password
		loginPOM.sendPassword("admin@123");
		
		//Calling ClickLoginBtn method
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("Second1");
		
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test
	public void listOfCategories() {
		String actual;
		String expected;
		
		//Calling catalog method to navigate to catalog
		categoriesPOM.catalog();
		screenShot.captureScreenShot("Second2");
		
		//Calling Categories method to navigate to categories
		categoriesPOM.Categories();
		screenShot.captureScreenShot("Second3");
		System.out.println("Categories list is displayed");
		
		//AssetEquals
		actual=driver.getTitle();
		expected="Categories";
		assertEquals(actual, expected);
				
	}		
		
}


