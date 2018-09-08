package com.qa.tests;

import org.testng.annotations.Test;

import com.qa.base.TestBase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class WebTableTest extends TestBase{

	
	
  @Test
  public void deleteRowTest() {
	  driver.findElement(By.xpath("//table[@id='table1']//td[contains(text(),'http://www.jdoe.com')]/following-sibling::td/a[text()='delete']")).click();
	  
	  
  }
	
	/*@Test
	public void webTableTest(){
		System.out.println("Internet Explorer Test");
	}*/
  
  
  @BeforeTest
  @Parameters("browser")
  public void beforeTest(String browser) {
	  initialiseBrowser(browser);
	  //driver.get("http://the-internet.herokuapp.com/tables");
	
	 
  }

  @AfterTest
  public void afterTest() {
	  
	//  closeBrowser();
  }

}
