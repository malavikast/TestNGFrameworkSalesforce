package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.training.base.BasePage;

public class LeadsPage extends BasePage {

	public LeadsPage(WebDriver driver) {
		super(driver);
	}
	
	
	//elements 
	
	@FindBy(xpath="//a[text()='Leads']")
	WebElement leads;
	
	@FindBy(id="fcf")
	WebElement leadsdropdown;
	
	@FindBy(xpath="//input[@value=' Go! ']")
	WebElement leadsgobtn;
	
	// new lead elements 
	@FindBy(xpath="//input[@value=' New ']")
	WebElement newbtn;
	
	@FindBy(id="name_lastlea2")
	WebElement lastname;
	
	@FindBy(id="lea3")
	WebElement company;
	
	@FindBy(xpath="//input[@tabindex='30']")
	WebElement savebtn;
	


	//actions 
	
	public void gotoLeads() {
		waitforElement(leads);
		leads.click();
	}
	
	public void clickonLeadsDropdown() {
		waitforElement(leadsdropdown);
		leadsdropdown.click();
		
	}
	
	public void selectonLeadsDropdown() {
		waitforElement(leadsdropdown);
		Select leadselect = new Select(leadsdropdown);
		leadselect.selectByVisibleText("Recently Viewed Leads");
	}
	
	public void selectTodaysLeadsDropdown() {
		waitforElement(leadsdropdown);
		Select leadselect = new Select(leadsdropdown);
		leadselect.selectByVisibleText("Today's Leads");
	}
	
	public void clickonLeadsGoButton() {
		waitforElement(leadsgobtn);
		leadsgobtn.click();
	}
	
	public void createNewLead() {
		waitforElement(newbtn);
		newbtn.click();
		
		waitforElement(lastname);
		lastname.sendKeys("LMNO");
		
		waitforElement(company);
		company.sendKeys("LMNO");
		
		waitforElement(savebtn);
		savebtn.click();
	}
	
	
	
	
	
	
}
