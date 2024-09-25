package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.training.base.BasePage;

public class OpportunityPage extends BasePage{

	public OpportunityPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//elements 
	
	@FindBy(xpath="//a[text()='Opportunities']")
	WebElement oppo;
	
	@FindBy(id="fcf")
	WebElement oppodropdown;
	
	
	// new opportunity elements 
	
	@FindBy(xpath="//input[@name='new']")
	WebElement newoppo;
	
	@FindBy(id="opp3")
	WebElement opponame;
	
	@FindBy(id="opp4")
	WebElement accname;
	
	@FindBy(id="opp6")
	WebElement leadsrc;
	
	@FindBy(id="opp11")
	WebElement stage;
	
	@FindBy(id="opp9")
	WebElement date;
	
	@FindBy(xpath="//a[text()='Today']")
	WebElement todaydate;
	
	@FindBy(xpath="//input[@tabindex='18']")
	WebElement newopposavebutton;
	
	// opportunity pipeline elements 
	
	@FindBy(xpath="//a[text()='Opportunity Pipeline']")
	WebElement oppopipeline;
	
	// stuck opportunity element
	@FindBy(xpath="//a[text()='Stuck Opportunities']")
	WebElement stuckoppo;
	
	
	//Quarterly Summary elements 
	
	@FindBy(id="quarter_q")
	WebElement interval;
	
	@FindBy(id="open")
	WebElement include;
	
	@FindBy(xpath="//input[@title='Run Report']")
	WebElement runreportbtn;
	

	
	//actions
	
	public void gotoOpportunities() {
		waitforElement(oppo);
		oppo.click();
	}
	
	public void clickonOpportunitiesDropdown() {
		waitforElement(oppodropdown);
		oppodropdown.click();
		
	}
	
	public void gotoNewOpportunity() {
		waitforElement(newoppo);
		newoppo.click();
	}
	
	public void addDetailsForNewOpportunity(String opportunityname, String oppoaccname) {
		waitforElement(opponame);
		opponame.sendKeys(opportunityname);
		
		waitforElement(accname);
		accname.sendKeys(oppoaccname);
		
		waitforElement(leadsrc);
		Select leadsrcoption = new Select(leadsrc);
		leadsrcoption.selectByVisibleText("Web");
		
		waitforElement(stage);
		Select stageoption = new Select(stage);
		stageoption.selectByVisibleText("Qualification");
		
		waitforElement(date);
		date.click();
		
		waitforElement(todaydate);
		todaydate.click();
		
		waitforElement(newopposavebutton);
		newopposavebutton.click();
	}
	
	public void gotoOpportunityPipeline() {
		waitforElement(oppopipeline);
		oppopipeline.click();
	}
	
	public void gotoStuckOpportunities() {
		waitforElement(stuckoppo);
		stuckoppo.click();
	}
	
	public void makeSelectionsforQSummaryReport() {
		waitforElement(interval);
		Select intervaloption= new Select(interval);
		intervaloption.selectByVisibleText("Previous FQ");
		
		waitforElement(include);
		Select includeoption= new Select(include);
		includeoption.selectByVisibleText("All Opportunities");
		
		waitforElement(runreportbtn);
		runreportbtn.click();
	}

}
