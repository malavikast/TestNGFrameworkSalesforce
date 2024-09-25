package com.training.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.pages.HomePage;
import com.training.pages.LoginPage;

public class HomeTest extends BaseTest {
	
	WebDriver driver;
	HomePage homepage;
	LoginPage loginpage; // need instance of this to login to the app 
	
	@BeforeMethod
	public void beforeMethod() {
		
		driver = getDriver();
		driver.get("https://selenium-prd.firebaseapp.com/");
		
		homepage= new HomePage(driver);
		loginpage = new LoginPage(driver);
		
	}
	
	
	@Test
	@Parameters({"username","password"})
	public void validatefirstname(String username, String password) {
		loginpage.enterintousername(username);
		loginpage.enterintopassword(password);
		loginpage.clickonloginbtn();
		homepage.clickHome();
		homepage.enterintofname();
		
	}
	
	@AfterMethod
	public void teardown() {
		//driver.close();
		//driver=null;
		close();
	}

}
