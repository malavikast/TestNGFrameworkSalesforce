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
import com.training.pages.ContactsPage;
import com.training.pages.LoginPage;
import com.training.utilities.PropertiesFileRead;
import com.training.utilities.ScreenshotUtility;

public class ContactsTest extends BaseTest{
	
	LoginPage loginpage;// creating object of LoginPage as it has the elements and actions required for this test case.
	ContactsPage contactspage;
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
		contactspage = new ContactsPage(driver);
		
		DOMConfigurator.configure("log4j.xml");
	}
	
	
	//TC-25
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
		
		contactspage.gotoContacts();
		contactspage.createNewContact();
	}
	
	
	//TC-26
	@Test
	@Parameters({"username","password"})
	public void createNewViewinContactPage(String username, String password) {
		Log.startTestCase("createNewViewinContactPage Test Started");
		loginpage.enterintousername(username);
		loginpage.enterintopassword(password);
		loginpage.clickonloginbtn();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		contactspage.gotoContacts();
		contactspage.createNewViewinContactsPage();
	}
	
	
	//TC-27
	@Test
	@Parameters({"username","password"})
	public void selectRecentlyCreated(String username, String password) {
		Log.startTestCase("createNewViewinContactPage Test Started");
		loginpage.enterintousername(username);
		loginpage.enterintopassword(password);
		loginpage.clickonloginbtn();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		contactspage.gotoContacts();
		contactspage.selectRecentlyCreated();
	}
	
	
	//TC-28
	@Test
	@Parameters({"username","password"})
	public void gotoMyContactsView(String username, String password) {
		Log.startTestCase("gotoMyContactsView Test Started");
		loginpage.enterintousername(username);
		loginpage.enterintopassword(password);
		loginpage.clickonloginbtn();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		contactspage.gotoContacts();
		contactspage.gotoContactView();
	}
	
	
	//TC-29
	@Test
	@Parameters({"username","password"})
	public void viewContactName(String username, String password) {
		Log.startTestCase("viewContactName Test Started");
		loginpage.enterintousername(username);
		loginpage.enterintopassword(password);
		loginpage.clickonloginbtn();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		contactspage.gotoContacts();
		contactspage.viewContactName();
	}
	
	
	//TC-30
	@Test
	@Parameters({"username","password"})
	public void newViewinContactPageError(String username, String password) {
		Log.startTestCase("newViewinContactPageError Test Started");
		loginpage.enterintousername(username);
		loginpage.enterintopassword(password);
		loginpage.clickonloginbtn();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		contactspage.gotoContacts();
		contactspage.createNewViewinContactsPageError();
	}
	
	
	//TC-31
	@Test
	@Parameters({"username","password"})
	public void newViewinContactPageCancel(String username, String password) {
		Log.startTestCase("newViewinContactPageCancel Test Started");
		loginpage.enterintousername(username);
		loginpage.enterintopassword(password);
		loginpage.clickonloginbtn();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		contactspage.gotoContacts();
		contactspage.createNewViewinContactsPageCancel();
	}
	
	
	//TC-32
	@Test
	@Parameters({"username","password"})
	public void createNewContactError(String username, String password) {
		Log.startTestCase("createNewContactError Test Started");
		loginpage.enterintousername(username);
		loginpage.enterintopassword(password);
		loginpage.clickonloginbtn();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		contactspage.gotoContacts();
		contactspage.createNewContactError();
	}
	
	
	
	
	
	@AfterMethod
	public void teardown() {
		screenshot.takescreenshot(driver);
		close();
	}
	

}
