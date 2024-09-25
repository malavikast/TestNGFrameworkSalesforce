package com.training.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {
	
public void takescreenshot(WebDriver driver) {
		
		//Take screenshot object
		TakesScreenshot screenshot = ((TakesScreenshot) driver);
		
		File scrFile = screenshot.getScreenshotAs(OutputType.FILE);
		
		Date current = new Date();
		
		String timestamp = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(current);
		
		String filepath = "/Users/malavikastankala/eclipse-workspace/TestNGFrameworkSalesforce/screenshots/Salesforce" + timestamp + ".jpeg";
		
		File destFile = new File(filepath);
		
		try {
			FileUtils.copyFile(scrFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}
		

}
