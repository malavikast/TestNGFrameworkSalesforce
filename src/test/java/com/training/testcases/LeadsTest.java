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
import com.training.pages.LeadsPage;
import com.training.pages.LoginPage;
import com.training.utilities.PropertiesFileRead;
import com.training.utilities.ScreenshotUtility;

public class LeadsTest extends BaseTest {
	
	LoginPage loginpage;// creating object of LoginPage as it has the elements and actions required for this test case.
	//AccountPage accpage;
	//OpportunityPage oppopage;
	LeadsPage leadspage;
	WebDriver driver;
	PropertiesFileRead properties;
	ScreenshotUtility screenshot = new ScreenshotUtility();
	
	
	@BeforeMethod
	public void beforeMethod() throws IOException {
		driver = getDriver();  // getDriver() method in base class to initialize the driver
		
		properties = new PropertiesFileRead();
		String url = properties.getProperties("url");
		driver.get(url);
		
		// the same driver has to be passed to the Loginpage & LeadsPage to find the elements and perform the actions. 
		//so create a constructor and pass the driver
		loginpage = new LoginPage(driver);
		leadspage = new LeadsPage(driver);
		//accpage = new AccountPage(driver);
		//oppopage = new OpportunityPage(driver);
		
		DOMConfigurator.configure("log4j.xml");
	}
	
	
	
	
	//TC-20
	@Test
	@Parameters({"username","password"})
	public void GoToLeads(String username, String password) {
		Log.startTestCase("GoToLeads Test Started");
		loginpage.enterintousername(username);
		loginpage.enterintopassword(password);
		loginpage.clickonloginbtn();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		leadspage.gotoLeads();
	}
	
	
	//TC-21
	@Test
	@Parameters({"username","password"})
	public void GoToLeadsDropDown(String username, String password) {
		Log.startTestCase("GoToLeadsDropDown Test Started");
		loginpage.enterintousername(username);
		loginpage.enterintopassword(password);
		loginpage.clickonloginbtn();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		leadspage.gotoLeads();
		leadspage.clickonLeadsDropdown();
	}
	
	
	//TC-22
	@Test
	@Parameters({"username","password"})
	public void defaultView(String username, String password) {
		Log.startTestCase("defaultView Test Started");
		loginpage.enterintousername(username);
		loginpage.enterintopassword(password);
		loginpage.clickonloginbtn();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		leadspage.gotoLeads();
		leadspage.selectonLeadsDropdown();
		loginpage.clickonuserMenu();
		loginpage.clickonLogout();
		
		loginpage.enterintousername(username);
		loginpage.enterintopassword(password);
		loginpage.clickonloginbtn();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		leadspage.gotoLeads();
		leadspage.clickonLeadsGoButton();
		
	}
	
	//TC-23
	@Test
	@Parameters({"username","password"})
	public void todaysLeads(String username, String password) {
		Log.startTestCase("todaysLeads Test Started");
		loginpage.enterintousername(username);
		loginpage.enterintopassword(password);
		loginpage.clickonloginbtn();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		leadspage.gotoLeads();
		leadspage.selectTodaysLeadsDropdown();
		leadspage.clickonLeadsGoButton();	
	}
	
	//TC-24
	@Test
	@Parameters({"username","password"})
	public void createNewLead(String username, String password) {
		Log.startTestCase("createNewLead Test Started");
		loginpage.enterintousername(username);
		loginpage.enterintopassword(password);
		loginpage.clickonloginbtn();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		leadspage.gotoLeads();
		leadspage.createNewLead();
	}
	
	
	@AfterMethod
	public void teardown() {
		screenshot.takescreenshot(driver);
		close();
	}
	
	

}
