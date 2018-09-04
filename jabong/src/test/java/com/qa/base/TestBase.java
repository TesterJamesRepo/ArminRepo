package com.qa.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase {

	public static WebDriver driver;
	
	public static void initialiseBrowser(String browser){
		
		if(browser.equalsIgnoreCase("chrome")){
			  
			  System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
			  driver = new ChromeDriver();
			  driver.manage().window().maximize();
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		}
		
		else if(browser.equalsIgnoreCase("ie")){
			
			  System.setProperty("webdriver.ie.driver", "C:\\IEDriverServer.exe");
			  driver = new InternetExplorerDriver();
			  //driver.manage().window().maximize();
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		}
		
	}
	
	public static void closeBrowser(){
		
		driver.close();
		driver.quit();
	}
	
}
