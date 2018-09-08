package com.qa.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class MakeMyTrip {

	WebDriver driver;
	
  @Test
  public void bookFlight() {
	  
	  driver.findElement(By.xpath("//a[@href='https://www.makemytrip.com/bus-tickets/']")).click();
	  driver.findElement(By.xpath("//input[@id='hp-widget__sfrom']")).sendKeys("Pune");
	  driver.findElement(By.xpath("//input[@id='hp-widget__sTo']")).sendKeys("Delhi");
	  
	  Timestamp timestamp = new Timestamp(System.currentTimeMillis());
      System.out.println(timestamp);
      System.out.println(timestamp.getTime());   
      Calendar cal = Calendar.getInstance();
      cal.setTime(timestamp);
      cal.add(Calendar.DAY_OF_WEEK, 10);
      cal.set(Calendar.HOUR_OF_DAY, 0);
      cal.set(Calendar.MINUTE, 0);
      cal.set(Calendar.SECOND, 0);
      cal.set(Calendar.MILLISECOND, 0);
      timestamp.setTime(cal.getTime().getTime()); 
      System.out.println(timestamp);
      System.out.println(timestamp.getTime());
      
     // List<WebElement> departDay =
    		  driver.findElement(By.xpath("//td[@fare-date='"+timestamp.getTime()+"']/a")).click();
			  driver.findElement(By.xpath("//button[@id='searchBtn']")).click();
	  
	   }
  @BeforeTest
  public void beforeTest() {
	  
	  System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	  driver.get("https://www.makemytrip.com/");

  }

  @AfterTest
  public void afterTest() {
  }

}
