package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RTTC_012POM {

	
		private WebDriver driver; 
		
		public RTTC_012POM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}

//catalog-findelement by id	
  @FindBy(id="menu-catalog")
  private WebElement catalog;
  
  //Categories-findelement by xpath
  @FindBy(xpath="//a[contains(text(),'Categories')]")
  private WebElement Categories;
  
//defining catalog method to navigate to catalog
  public void catalog() {
	  this.catalog.click();
  }
  
//defining categories method to navigate to categories
  public void Categories() {
	  this.Categories.click();
	  
  }
}
