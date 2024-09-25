package com.training.testcases;

import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.log.Log;
import com.training.pages.LoginPage;
import com.training.utilities.PropertiesFileRead;
import com.training.utilities.ScreenshotUtility;

public class LoginTest extends BaseTest{
	
	
	LoginPage loginpage;  // creating object of LoginPage as it has the elements and actions required for this test case.
	WebDriver driver;
	PropertiesFileRead properties;
	ScreenshotUtility screenshot = new ScreenshotUtility();
	
	@BeforeMethod
	public void beforeMethod() throws IOException {
		driver = getDriver();  // getDriver() method in base class to initialize the driver
		
		properties = new PropertiesFileRead();
		String url = properties.getProperties("url");
		driver.get(url);
		//driver.get("https://selenium-prd.firebaseapp.com/");
		
		// the same driver has to be passed to the Loginpage to find the elements and perform the actions. 
		//so create a constructor and pass the driver
		loginpage = new LoginPage(driver);
		
		DOMConfigurator.configure("log4j.xml");
		}
	
	
	//TC-1 
	@Test(priority=1, enabled=false)
	@Parameters({"username"})
	public void invalidlogin(String username) {
		Log.startTestCase("Login Test Started");
		loginpage.enterintousername(username);
		Log.info("Sucessfully entered the username" +username);
		loginpage.clickonloginbtn();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	// TC-2
	@Test(priority=2)
	@Parameters({"username","password"})
	public void validatelogin(String username, String password) {
		Log.startTestCase("Login Test Started");
		loginpage.enterintousername(username);
		Log.info("Sucessfully entered the username" +username);
		loginpage.enterintopassword(password);
		Log.info("Sucessfully entered the password" +password);
		loginpage.clickonloginbtn();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//TC-3
	@Test(priority=3,enabled=false)
	@Parameters({"username","password"})
	public void validateRememberMe(String username, String password) {
		//validatelogin(username,password);
		Log.startTestCase("Login Test Started");
		loginpage.enterintousername(username);
		Log.info("Sucessfully entered the username" +username);
		loginpage.enterintopassword(password);
		Log.info("Sucessfully entered the password" +password);
		loginpage.checkRememberMe();
		Log.info("Sucessfully checked RememberMe checkbox");
		loginpage.clickonloginbtn();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		loginpage.clickonuserMenu();
		Log.info("Sucessfully clicked on usermenu");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		loginpage.clickonLogout();
		Log.info("Sucessfully clicked on logout");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	//TC-4A
		@Test(priority=4,enabled=false)
		@Parameters({"wrongusername","wrongpassword"})
		public void validateLoginForgotPassword(String username) {
			Log.startTestCase("Login Test Started");
			loginpage.enterintousername(username);
			Log.info("Sucessfully entered the username" +username);
			loginpage.clickonforgotpasswordbtn();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			loginpage.enterintofrogotpasswordusername(username);
			loginpage.clickoncontinuebtn();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
	//TC-4B
	@Test(priority=4,enabled=false)
	@Parameters({"wrongusername","wrongpassword"})
	public void validateLoginErrorMessage(String wusername, String wpassword) {
		Log.startTestCase("Login Test Started");
		loginpage.enterintousername(wusername);
		Log.info("Sucessfully entered the username" +wusername);
		loginpage.enterintopassword(wpassword);
		Log.info("Sucessfully entered the password" +wpassword);
		loginpage.clickonloginbtn();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//USERMENU TEST CASES 
	
	//TC-5
	@Test(priority=5,enabled=false)
	@Parameters({"username","password"})
	public void validateUserMenu(String username, String password) {
		//validatelogin(username,password);
		Log.startTestCase("Login Test Started");
		loginpage.enterintousername(username);
		Log.info("Sucessfully entered the username" +username);
		loginpage.enterintopassword(password);
		Log.info("Sucessfully entered the password" +password);
		loginpage.clickonloginbtn();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		loginpage.clickonuserMenu();
		Log.info("Sucessfully clicked on usermenu");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		screenshot.takescreenshot(driver);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		loginpage.clickonLogout();
		Log.info("Sucessfully clicked on logout");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	//TC-6
	@Test(priority=6,enabled=false)
	@Parameters({"username","password"})
	public void myProfile(String username, String password) throws InterruptedException {
		loginpage.enterintousername(username);
		Log.info("Sucessfully entered the username" +username);
		loginpage.enterintopassword(password);
		Log.info("Sucessfully entered the password" +password);
		loginpage.clickonloginbtn();
		Thread.sleep(2000);
		loginpage.clickonuserMenu();
		loginpage.clickOnProfile();
		loginpage.editProfile();
		loginpage.clickOnAbout();
		loginpage.enterLastname();
		loginpage.clickSaveall();
		Thread.sleep(2000);
		loginpage.clickPost();
		loginpage.sharePost();
		
	}
	
	
	//TC-7
	@Test(priority=7,enabled=false)
	@Parameters({"username","password"})
	public void mySettings(String username, String password) throws InterruptedException {
		loginpage.enterintousername(username);
		Log.info("Sucessfully entered the username" +username);
		loginpage.enterintopassword(password);
		Log.info("Sucessfully entered the password" +password);
		loginpage.clickonloginbtn();
		Thread.sleep(2000);
		loginpage.clickonuserMenu();
		loginpage.clickMySetting();
		loginpage.clickPersonal();
		loginpage.clickLogHistory();
		loginpage.clickDownload();
		Thread.sleep(2000);
		loginpage.displayLayout();
		loginpage.clickCustomTab();
		loginpage.clickCustomApp();
		loginpage.reportTab();
		loginpage.addReport();
//		loginpage.saveTab();
		loginpage.clickEmail();
		loginpage.clickMyEmailSet();
		loginpage.enterName();
		loginpage.enterEmailAdd();
		loginpage.clickBCC();
		loginpage.clickCalendar();
		loginpage.clickActivity();
		loginpage.clickTestButton();
		Thread.sleep(2000);
	}
	
	
	//TC-8
	@Test(priority=8,enabled=false)
	@Parameters({"username","password"})
	public void validateDevConsole(String username, String password) {
		//validatelogin(username,password);
		Log.startTestCase("Login Test Started");
		loginpage.enterintousername(username);
		Log.info("Sucessfully entered the username" +username);
		loginpage.enterintopassword(password);
		Log.info("Sucessfully entered the password" +password);
		loginpage.clickonloginbtn();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		loginpage.clickonuserMenu();
		Log.info("Sucessfully clicked on usermenu");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		loginpage.clickDevConsole();
		
		String parentHandle = driver.getWindowHandle();
		
		for(String handle:driver.getWindowHandles()) {
			System.out.println(handle);
			driver.switchTo().window(handle);
		}
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		screenshot.takescreenshot(driver);
		
		close();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.switchTo().window(parentHandle);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		screenshot.takescreenshot(driver);
		
		loginpage.clickonLogout();
		Log.info("Sucessfully clicked on logout");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//TC-9
	@Test(priority=9,enabled=false)
	@Parameters({"username","password"})
	public void validateLogout(String username, String password) {
		//validatelogin(username,password);
		Log.startTestCase("Login Test Started");
		loginpage.enterintousername(username);
		Log.info("Sucessfully entered the username" +username);
		loginpage.enterintopassword(password);
		Log.info("Sucessfully entered the password" +password);
		loginpage.clickonloginbtn();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		loginpage.clickonuserMenu();
		Log.info("Sucessfully clicked on usermenu");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		loginpage.clickonLogout();
		Log.info("Sucessfully clicked on logout");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	@AfterMethod
	public void teardown() {
		screenshot.takescreenshot(driver);
		//driver.close();
		//driver=null;
		close();
	}
	

}
