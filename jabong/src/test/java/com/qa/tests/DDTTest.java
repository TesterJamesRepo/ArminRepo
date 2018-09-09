 package com.qa.tests;

import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import com.qa.base.TestBase;
import com.qa.util.TestUtil;
import com.qa.util.Xls_Reader;

import extentreports.ExtentTestManager;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class DDTTest extends TestBase{
	
	Logger log = Logger.getLogger(DDTTest.class);
	boolean flag=true;


@DataProvider
public Iterator<Object[]> getTestData(){
	ArrayList<Object[]> testData = TestUtil.getDataFromExcel();
	return testData.iterator();
}

@Test(dataProvider="getTestData",priority=1,description="Invalid Login Scenario with empty username and password.")
public void regPageTest(String firstName, String lastName, String gender, String countryName,
		String language, String mb, String emailid, String address, String alertmessage, int rowNum){
	//ExtentTestManager.getTest().setDescription("Invalid Login Scenario with wrong username and password.");
	//enter data:
	
	log.info("****************************** starting test case *****************************************");
	driver.findElement(By.id("firstname")).clear();
	driver.findElement(By.id("firstname")).sendKeys(firstName);
	
	driver.findElement(By.id("lastname")).clear();
	driver.findElement(By.id("lastname")).sendKeys(lastName);
	
	driver.findElement(By.xpath("//*[@value='"+gender+"']")).click();
	
	Select countryDropdown = new Select (driver.findElement(By.xpath("//*[@id='country']"))); 
	countryDropdown.selectByVisibleText(countryName);
	
	driver.findElement(By.xpath("//*[@value='"+language+"']")).click();
	
	driver.findElement(By.id("mobilenumber")).clear();
	driver.findElement(By.id("mobilenumber")).sendKeys(mb);
	
	driver.findElement(By.id("emailid")).clear();
	driver.findElement(By.id("emailid")).sendKeys(emailid);
	
	driver.findElement(By.id("address")).clear();
	driver.findElement(By.id("address")).sendKeys(address);
	
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	
	Alert alert = driver.switchTo().alert();
	
	if(alert.getText().contains(alertmessage))
	//if(Assert.assertTrue(alert.getText().contains(alertmessage)))
		TestUtil.setDataToCell(rowNum,flag);
	else
		{
		flag=false;
		TestUtil.setDataToCell(rowNum,flag);
		}
	
	alert.accept();	
	
	
	
	
	log.info("****************************** ending test case *****************************************");
}


  @BeforeMethod
  @Parameters("browser")
  public void setUp(String browser) {
	  log.info("****************************** Starting test cases execution  *****************************************");

	  initialiseBrowser(browser);
	  driver.get("file:///D:/shital/Prognosticsoft/nilesh_html/html_task/Task1/signup.html");
  	  
	  
  }

  @AfterMethod
  public void tearDown() {
	  
	 closeBrowser();
	 log.info("****************************** Browser is closed *****************************************");
  }

}
