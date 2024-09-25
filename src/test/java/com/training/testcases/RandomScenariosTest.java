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
import com.training.pages.RandomScenariosPage;
import com.training.utilities.PropertiesFileRead;
import com.training.utilities.ScreenshotUtility;

public class RandomScenariosTest extends BaseTest {
	
	LoginPage loginpage;// creating object of LoginPage as it has the elements and actions required for this test case.
	RandomScenariosPage rspage;
	WebDriver driver;
	PropertiesFileRead properties;
	ScreenshotUtility screenshot = new ScreenshotUtility();
	
	
	@BeforeMethod
	public void beforeMethod() throws IOException {
		driver = getDriver();  // getDriver() method in base class to initialize the driver
		
		properties = new PropertiesFileRead();
		String url = properties.getProperties("url");
		driver.get(url);
		
		// the same driver has to be passed to the Loginpage & RandomScenariosPage to find the elements and perform the actions. 
		//so create a constructor and pass the driver
		loginpage = new LoginPage(driver);
		rspage = new RandomScenariosPage(driver);
		
		DOMConfigurator.configure("log4j.xml");
	}
	
	//TC-33
	@Test
	@Parameters({"username","password"})
	public void createNewAccount(String username, String password) {
		Log.startTestCase("createNewAccount Test Started");
		loginpage.enterintousername(username);
		loginpage.enterintopassword(password);
		loginpage.clickonloginbtn();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		rspage.gotoHome();
		rspage.gotoUser();
	}
	
	
	
	//TC-34
	@Test
	@Parameters({"username","password"})
	public void verifyEditedLastName(String username, String password) throws InterruptedException {
		loginpage.enterintousername(username);
		loginpage.enterintopassword(password);
		loginpage.clickonloginbtn();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rspage.gotoHome();
		rspage.clickfnamelname();
		rspage.editProf();
		rspage.popFrame();
		rspage.clickOnAbout();
		rspage.enterLastname();
		rspage.clickSaveall();
		Thread.sleep(2000);
	}
	
	//TC-35
	@Test
	@Parameters({"username","password"})
	public void verifyTabCustomization(String username, String password) {
		Log.startTestCase("verifyTabCustomization Test Started");
		loginpage.enterintousername(username);
		loginpage.enterintopassword(password);
		loginpage.clickonloginbtn();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		rspage.gotoPlusIcon();
		rspage.gotoCustomizeTabs();
		rspage.selectTabtoRemove();
		
		loginpage.clickonuserMenu();
		loginpage.clickonLogout();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		loginpage.enterintousername(username);
		loginpage.enterintopassword(password);
		loginpage.clickonloginbtn();
		
	}
	
	
	//TC-36
	@Test
	@Parameters({"username","password"})
	public void blockEventCalendar(String username, String password) throws InterruptedException {
		
		loginpage.enterintousername(username);
		loginpage.enterintopassword(password);
		loginpage.clickonloginbtn();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rspage.gotoHome();
		Thread.sleep(1000);
		rspage.clickCurrDate();
		rspage.selTime();
		rspage.clickSubCombo();
		rspage.enterOther();
		rspage.selEndTime();
		rspage.clickchoseTime();
		rspage.saveEvent();
	}
	
	
	//TC-37
	@Test
	@Parameters({"username","password"})
	public void blockRecurrence(String username, String password) throws InterruptedException {
		loginpage.enterintousername(username);
		loginpage.enterintopassword(password);
		loginpage.clickonloginbtn();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rspage.gotoHome();
		Thread.sleep(1000);
		rspage.clickCurrDate();
		rspage.sel4Time();
		rspage.clickSubCombo2();
		rspage.enterOther();
		Thread.sleep(1000);
		rspage.selEndTime();
		rspage.clickSevenTime();
		rspage.clickRecCheckBox();
		rspage.clickWeekly();
		//rspage.enterRecDate();
		rspage.saveNextEvent();
		rspage.monthView();
	}
	
	
	
	@AfterMethod
	public void teardown() {
		screenshot.takescreenshot(driver);
		close();
	}
	

}
