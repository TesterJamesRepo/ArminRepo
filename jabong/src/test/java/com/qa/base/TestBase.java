package com.qa.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestBase {

	public static WebDriver driver;
	
	public static void initialiseBrowser(String browser){
		
		String hubUrl;
		//baseUrl = "https://www.facebook.com";
		//hubUrl = "http://192.168.1.5:4444/wd/hub";
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		//DesiredCapabilities capability = DesiredCapabilities.chrome();
		//DesiredCapabilities capability = DesiredCapabilities.firefox();
		//capability.setBrowserName(browser);
		//capability.setPlatform(Platform.WIN10);

		
		
		//if(browser.equalsIgnoreCase("chrome")){
			  
			 
			  /* driver = new ChromeDriver();
			  driver.manage().window().maximize();
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			  */
			/*try {
				driver = new RemoteWebDriver(new URL(hubUrl),capability);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);*/
			
			
		//}
		/*
		else if(browser.equalsIgnoreCase("ie")){
			
			  System.setProperty("webdriver.ie.driver", "C:\\IEDriverServer.exe");
			  driver = new InternetExplorerDriver();
			  //driver.manage().window().maximize();
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		}*/
		
	}
	
	public static void closeBrowser(){
		
		driver.close();
		driver.quit();
	}
	
}
