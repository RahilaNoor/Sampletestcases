package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RTTC_011POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_011Test {

	private WebDriver driver;
	private String baseUrl;
	private RTTC_011POM loginPOM;
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
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test
	public void validLoginTest() {
		String expected;
		String Actual;
		
		//Calling sendUserName method & sending admin Username
		loginPOM.sendUserName("admin");
		
		//Calling sendPasswod method & sending admin password
		loginPOM.sendPassword("admin@123");
		
		//Calling ClickLoginBtn method
		loginPOM.clickLoginBtn(); 
		
		//capturing screenshot
		screenShot.captureScreenShot("First");
		System.out.println("Admin logged in successfully");
		
		//AssetEquals
		expected="Dashboard";
		Actual=driver.getTitle();
		assertEquals(Actual, expected);
		
	}
}
