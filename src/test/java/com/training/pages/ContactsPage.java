package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.training.base.BasePage;

public class ContactsPage extends BasePage {

	public ContactsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//a[text()='Contacts']")
	WebElement contacts;
	
	@FindBy(xpath="//input[@value=' New ']")
	WebElement newcontactbtn;
	
	@FindBy(id="name_lastcon2")
	WebElement lastname;
	
	@FindBy(id="con4")
	WebElement accountname;
	
	@FindBy(xpath="//input[@tabindex='31']")
	WebElement newcontactsavebtn;
	
	// new view elements
	
	@FindBy(xpath="//a[text()='Create New View']")
	WebElement contactpagenewview;
	
	@FindBy(id="fname")
	WebElement viewname;
	
	@FindBy(id="devname")
	WebElement viewuniquename;
	
	@FindBy(xpath="//input[@data-uidsfdc='4']")
	WebElement newviewsavebtn;
	
	@FindBy(xpath="//input[@title='Cancel']")
	WebElement newviewcancelbtn;
	
	//recently created
	
	@FindBy(id="hotlist_mode")
	WebElement rc;
	
	// my contacts view
	@FindBy(id="fcf")
	WebElement contactviewdd;
	
	// view contact name 
	@FindBy(xpath="//a[text()='EFGH']")
	WebElement contactname;
	
	// actions 
	
	public void gotoContacts() {
		waitforElement(contacts);
		contacts.click();
	}
	
	public void createNewContact() {
		waitforElement(newcontactbtn);
		newcontactbtn.click();
		
		waitforElement(lastname);
		lastname.sendKeys("XYZ");
		
		waitforElement(accountname);
		accountname.sendKeys("Ayaan");
		
		waitforElement(newcontactsavebtn);
		newcontactsavebtn.click();
	}
	
	public void createNewViewinContactsPage() {
		
		waitforElement(contactpagenewview);
		contactpagenewview.click();
		
		waitforElement(viewname);
		viewname.sendKeys("ContactPageViewOne");
		
		waitforElement(newviewsavebtn);
		newviewsavebtn.click();
		
	}
	
	public void selectRecentlyCreated() {
		waitforElement(rc);
		Select rcoptions = new Select(rc);
		rcoptions.selectByVisibleText("Recently Created");
	}
	
	
	public void gotoContactView() {
		waitforElement(contactviewdd);
		Select viewddoption = new Select(contactviewdd);
		viewddoption.selectByVisibleText("My Contacts");
	}
	
	public void viewContactName() {
		waitforElement(contactname);
		contactname.click();
	}
	
	public void createNewViewinContactsPageError() {
		
		waitforElement(contactpagenewview);
		contactpagenewview.click();
		
		waitforElement(viewuniquename);
		viewuniquename.sendKeys("ContactPageViewTwo");
		
		waitforElement(newviewsavebtn);
		newviewsavebtn.click();
		
	}
	
	public void createNewViewinContactsPageCancel() {
		
		waitforElement(contactpagenewview);
		contactpagenewview.click();
		
		waitforElement(viewname);
		viewname.sendKeys("ContactPageViewThree");
		
		waitforElement(newviewcancelbtn);
		newviewcancelbtn.click();
		
	}
	
	public void createNewContactError() {
		waitforElement(newcontactbtn);
		newcontactbtn.click();
		
		waitforElement(lastname);
		lastname.sendKeys("Indian");
		
		waitforElement(accountname);
		accountname.sendKeys("Global Media");
		
		waitforElement(newcontactsavebtn);
		newcontactsavebtn.click();
	}
	
	

}
