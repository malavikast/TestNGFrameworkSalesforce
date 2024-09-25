package com.training.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	// initializing the driver
	
	WebDriver driver;
	
	public WebDriver getDriver() {
		if(driver==null) {
			
			//1. Setup the WebDriverManager
			WebDriverManager.chromedriver().setup();
					
					
			//work-around for instatiating the WebDriver - as the ChromeDriver wasnt able to find the required binary.
			ChromeOptions options = new ChromeOptions();
			options.setBinary("/Applications/Google Chrome 2.app/Contents/MacOS/Google Chrome");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			
		}
		
		return driver;
	}

	
	public void close() {
		driver.close();
		driver=null;
	}
}
