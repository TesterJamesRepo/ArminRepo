package com.qa.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestUtil {
	
	 static Workbook book;
	 static Sheet sheet;
	 static FileInputStream file = null;
	 static String TESTDATA_SHEET_PATH ="C:\\Users\\admin\\git\\ArminRepo\\jabong\\src\\test\\java\\com\\qa\\testdata\\xlstestdata.xlsx";
	 static String sheetName="RegTestData";
	 static Xls_Reader reader;
	 
	 public static void setDataToCell(int rowNum){
		 
		
		 reader.setCellData("RegTestData", "status", rowNum, "Pass");
		 
		 
	 }
		
		
	 public static ArrayList<Object[]> getDataFromExcel(){

			ArrayList<Object[]> myData = new ArrayList<Object[]>();
			
			try {
				reader = new Xls_Reader(TESTDATA_SHEET_PATH);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		for (int rowNum = 2; rowNum <= reader.getRowCount("RegTestData"); rowNum++) {
				
					String firstName = reader.getCellData("RegTestData", "firstname", rowNum);
					String lastName = reader.getCellData("RegTestData", "lastname", rowNum);
					String gender = reader.getCellData("RegTestData", "gender", rowNum);
					String country = reader.getCellData("RegTestData", "country", rowNum);
					String language = reader.getCellData("RegTestData", "language", rowNum);
					String mb = reader.getCellData("RegTestData", "mb", rowNum);
					String emailid = reader.getCellData("RegTestData", "emailid", rowNum);
					String address = reader.getCellData("RegTestData", "address", rowNum);
					String alertmessage = reader.getCellData("RegTestData", "alertmessage", rowNum);
					
					
					Object ob[] = {firstName, lastName, gender, country, language, mb, emailid, address, alertmessage,rowNum};
					myData.add(ob);
				}
		return myData;
	 }
	 
	 public static void takeSnapShot(WebDriver driver,String fileWithPath) throws Exception{

	        //Convert web driver object to TakeScreenshot

	        TakesScreenshot scrShot =((TakesScreenshot)driver);

	        //Call getScreenshotAs method to create image file

	                File srcFile=scrShot.getScreenshotAs(OutputType.FILE);

	            //Move image file to new destination

	                File destFile=new File(fileWithPath);

	                //Copy file at destination

	                FileUtils.copyFile(srcFile, destFile);

	    }

	 	 
}

