package com.qa.tests;

import org.testng.annotations.Test;

import com.qa.base.TestBase;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;
import org.testng.annotations.AfterTest;

public class ColorPickerTest extends TestBase {
  @Test
  public void f() {
	  System.out.println("hih");  
  }
  @BeforeTest
  public void beforeTest() {
	  
	  initialiseBrowser("firefox");
	  /*driver.get("http://demo.guru99.com/test/ajax.html");
	  System.out.println(driver.findElement(By.id("yes")).getAttribute("value"));
	  */
	  driver.get("https://www.guru99.com/");
	  String color = driver.findElement(By.xpath("//h4[1]")).getCssValue("background-color");
	  System.out.println(color);
	  String hex = Color.fromString(color).asHex();
	  System.out.println(hex);
  }

  @AfterTest
  public void afterTest() {
  }

}
