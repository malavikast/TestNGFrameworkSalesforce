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
import com.training.pages.AccountPage;
import com.training.pages.LoginPage;
import com.training.pages.OpportunityPage;
import com.training.utilities.PropertiesFileRead;
import com.training.utilities.ScreenshotUtility;

public class OpportunityTest extends BaseTest {
	
	LoginPage loginpage;// creating object of LoginPage as it has the elements and actions required for this test case.
	AccountPage accpage;
	OpportunityPage oppopage;
	WebDriver driver;
	PropertiesFileRead properties;
	ScreenshotUtility screenshot = new ScreenshotUtility();
	
	
	@BeforeMethod
	public void beforeMethod() throws IOException {
		driver = getDriver();  // getDriver() method in base class to initialize the driver
		
		properties = new PropertiesFileRead();
		String url = properties.getProperties("url");
		driver.get(url);
		
		// the same driver has to be passed to the Loginpage & OpportunityPage to find the elements and perform the actions. 
		//so create a constructor and pass the driver
		loginpage = new LoginPage(driver);
		accpage = new AccountPage(driver);
		oppopage = new OpportunityPage(driver);
		
		DOMConfigurator.configure("log4j.xml");
	}
	
	// Opportunities Test Cases
	
	
	//TC-15
	@Test
	@Parameters({"username","password"})
	public void OpportunitiesDropdown(String username, String password) {
		Log.startTestCase("Opportunities Drop Down Test Started");
		loginpage.enterintousername(username);
		loginpage.enterintopassword(password);
		loginpage.clickonloginbtn();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		oppopage.gotoOpportunities();
		oppopage.clickonOpportunitiesDropdown();
	}
	
	
	//TC-16
	@Test
	@Parameters({"username","password", "newoptyname","newoptyaccname"})
	public void CreateNewOpportunity(String username, String password, String newoptyname, String newoptyaccname) {
		Log.startTestCase("CreateNewOpportunity Test Started");
		loginpage.enterintousername(username);
		loginpage.enterintopassword(password);
		loginpage.clickonloginbtn();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		oppopage.gotoOpportunities();
		oppopage.gotoNewOpportunity();
		oppopage.addDetailsForNewOpportunity(newoptyname, newoptyaccname);
	}
	
	
	//TC-17
	@Test
	@Parameters({"username","password"})
	public void OpportunitiesPipeline(String username, String password) {
		Log.startTestCase("OpportunitiesPipeline Test Started");
		loginpage.enterintousername(username);
		loginpage.enterintopassword(password);
		loginpage.clickonloginbtn();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		oppopage.gotoOpportunities();
		oppopage.gotoOpportunityPipeline();
	}
	
	
	//TC-18
	@Test
	@Parameters({"username","password"})
	public void StuckOpportunities(String username, String password) {
		Log.startTestCase("StuckOpportunities Test Started");
		loginpage.enterintousername(username);
		loginpage.enterintopassword(password);
		loginpage.clickonloginbtn();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		oppopage.gotoOpportunities();
		oppopage.gotoStuckOpportunities();
	}
	
	
	//TC-19
	@Test
	@Parameters({"username","password"})
	public void QSummaryReport(String username, String password) {
		Log.startTestCase("QSummaryReport Test Started");
		loginpage.enterintousername(username);
		loginpage.enterintopassword(password);
		loginpage.clickonloginbtn();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		oppopage.gotoOpportunities();
		oppopage.makeSelectionsforQSummaryReport();
	}	

	
	@AfterMethod
	public void teardown() {
		screenshot.takescreenshot(driver);
		close();
	}
	

}
