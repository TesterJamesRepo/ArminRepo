package com.qa.tests;

//author shital pashankar

import org.testng.annotations.Test;

import com.qa.base.TestBase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class WebDriverBasicsTest extends TestBase{
	
/*@Test
	public void webDriverBasicsTest(){
		System.out.println("Chrome Test");
	}*/

 @Test
  public void checkboxTest() {
	  
	  //select the checkbox parking sensor
	  
	  WebElement parkingSensor = driver.findElement(By.cssSelector("input[value='ParkingSensor']"));
	  if(!parkingSensor.isSelected()){
		  parkingSensor.click();
		  }
  }
  
 /* @Test
  public void selectFromDropdown(){
	  //Select the car
	  WebElement dropDown = driver.findElement(By.name("make"));
	  Select carDropdown = new Select(dropDown);  
	  carDropdown.selectByVisibleText("Mercedes");
  }
  
  @Test
  public void selectFromMultipleDropdown(){
	  //Select the car
	  WebElement multiDropdown = driver.findElement(By.name("color"));
	  Select colorDropdown = new Select(multiDropdown);
	  Assert.assertTrue(colorDropdown.isMultiple());
	  colorDropdown.selectByVisibleText("White");
	  colorDropdown.selectByIndex(4); 
	  colorDropdown.selectByValue("rd");
	  
	  List<String> act_opt = new ArrayList<String>();
	  
	  for(WebElement oneColor : colorDropdown.getAllSelectedOptions()){
		  act_opt.add(oneColor.getText());
	  }
	  
	  for(String oneOpt : act_opt){
		  System.out.println(oneOpt);
	  }
	  
	  Iterator<String> it = act_opt.iterator();
	  
	  while(it.hasNext()){
		  
		  System.out.println(it.next());
		  
	  } 
	  
	  List<String> exp_opt = Arrays.asList(new String[]{"White","Red","Silver"});
	  Assert.assertEquals(act_opt, exp_opt);
	  
	   
  }
  */
  
  @BeforeTest
  @Parameters("browser")
  public void beforeTest(String browser) {
	  initialiseBrowser(browser);
	  driver.get("http://cookbook.seleniumacademy.com/Config.html");
  
  }

  @AfterTest
  public void afterTest() {
	  closeBrowser();
  }

}
