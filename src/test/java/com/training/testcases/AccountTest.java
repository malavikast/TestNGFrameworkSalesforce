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
import com.training.utilities.PropertiesFileRead;
import com.training.utilities.ScreenshotUtility;

public class AccountTest extends BaseTest {
	
	LoginPage loginpage;// creating object of LoginPage as it has the elements and actions required for this test case.
	AccountPage accpage;
	WebDriver driver;
	PropertiesFileRead properties;
	ScreenshotUtility screenshot = new ScreenshotUtility();
	
	@BeforeMethod
	public void beforeMethod() throws IOException {
		driver = getDriver();  // getDriver() method in base class to initialize the driver
		
		properties = new PropertiesFileRead();
		String url = properties.getProperties("url");
		driver.get(url);
		
		// the same driver has to be passed to the Loginpage & AccountPage to find the elements and perform the actions. 
		//so create a constructor and pass the driver
		loginpage = new LoginPage(driver);
		accpage = new AccountPage(driver);
		
		DOMConfigurator.configure("log4j.xml");
		}
	
	
	// Account test cases 
	
	
	//TC-10
	@Test
	@Parameters({"username","password","accname"})
	public void createNewAccount(String username, String password, String accname) {
		Log.startTestCase("Account Test Started");
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
		
		accpage.clickonAccounts();
		accpage.clickonNewAccount();
		accpage.enterIntoAccName(accname);
		accpage.selectAccType();
		accpage.selectCustPriority();
		screenshot.takescreenshot(driver);
		accpage.selectNewAccountSubmitButton();
		
		
	}
	
	
	//TC-11
	@Test
	@Parameters({"username","password","viewname","viewuniquename"})
	public void createNewView(String username, String password, String viewname, String viewuniquename) {
		Log.startTestCase("New View Test Started");
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
		
		accpage.clickonAccounts();
		accpage.clickonNewView();
		accpage.enterIntoViewName(viewname);
		//accpage.enterIntoViewUniqeName(viewuniquename);
		screenshot.takescreenshot(driver);
		accpage.clickonViewSaveBtn();
		
		
	}
	
	//TC-12
	@Test
	@Parameters({"username","password","viewname","viewuniquename","editviewname"})
	public void editView(String username, String password, String viewname, String viewuniquename, String editviewname) {
		Log.startTestCase("Edit View Test Started");
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
		
		accpage.clickonAccounts();
		accpage.selectEditView(viewname);
		accpage.clickonedit();
		accpage.enterIntoViewName(editviewname);
		accpage.selectFields();
		screenshot.takescreenshot(driver);
		accpage.clickonEditViewSaveBtn();
			
	}
	
	
	//TC-13
	@Test
	@Parameters({"username","password"})
	public void mergeAccounts(String username, String password) throws InterruptedException {
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
		accpage.clickonAccounts();
		accpage.clickMerge();
		Thread.sleep(1000);
		accpage.enteraccName();
		accpage.clickFind();
		accpage.nextButton();
		accpage.clickMergeAcc();
		driver.switchTo().alert().accept();	
	}
	
	
	//TC-14
	@Test
	@Parameters({"username","password","viewname","viewuniquename","savedreportname"})
	public void createAccountReport(String username, String password, String viewname, String viewuniquename, String savedreportname) {
		Log.startTestCase("Create Account Report Test Started");
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
		
		accpage.clickonAccounts();
		accpage.clickonaccswithlast30dayactivity();
		accpage.makeselectionsonUnsavedReportandSave();
		accpage.enterintoSavedReportandSave(savedreportname);
			
	}		
	
	
	
	@AfterMethod
	public void teardown() {
		screenshot.takescreenshot(driver);
		close();
	}
	

}
