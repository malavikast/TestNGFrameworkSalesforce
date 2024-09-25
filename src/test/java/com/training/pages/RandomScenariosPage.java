package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.training.base.BasePage;

public class RandomScenariosPage extends BasePage {

	public RandomScenariosPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	// elements 
	
	@FindBy(xpath="//a[text()='Home']")
	WebElement home;
	
	@FindBy(xpath="/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[1]/div[1]/div/div[2]/span[1]/h1/a")
	WebElement user;
	
	@FindBy(id="AllTab_Tab")
	WebElement plusicon;
	
	@FindBy(xpath="//input[@title='Customize My Tabs']")
	WebElement customizemytabs;
	
	@FindBy(id="duel_select_1")
	WebElement selecttab;
	
	@FindBy(id="duel_select_0_left")
	WebElement removebtn;
	
	@FindBy(xpath="//input[@title='Save']")
	WebElement savebtn;
	
	
	//actions
	
	public void gotoHome() {
		waitforElement(home);
		home.click();
	}
	
	public void gotoUser() {
		waitforElement(user);
		user.click();
	}
	
	public void gotoPlusIcon() {
		waitforElement(plusicon);
		plusicon.click();
	}
	
	public void gotoCustomizeTabs() {
		waitforElement(customizemytabs);
		customizemytabs.click();
	}
	
	public void selectTabtoRemove() {
		waitforElement(selecttab);
		Select staboptions = new Select(selecttab);
		staboptions.selectByVisibleText("Subscriptions");
		
		waitforElement(removebtn);
		removebtn.click();
		
		waitforElement(savebtn);
		savebtn.click();
	}
	
	//TC-34
	
	@FindBy(xpath="//img[@title='Edit Profile']")
	WebElement editprofile;
	public void editProf() {
		editprofile.click();
	}
	
	@FindBy(xpath="//a[text()='Malavika Sreedhar Tankala']")
	WebElement fnamelname;
	public void clickfnamelname() {
		fnamelname.click();
	}
	@FindBy(xpath="//iframe[@id='contactInfoContentId']")
	WebElement popframe;
	
	public void popFrame() throws InterruptedException {
		Thread.sleep(2000);
		//switchFrame(popframe);
	}
	@FindBy(xpath="//a[contains(text(),'About')]")
	WebElement about;
	
	public void clickOnAbout() {
		about.click();
	}
	@FindBy(id="lastName")
	WebElement lastname;
	public void enterLastname() {
		lastname.clear();
		lastname.sendKeys("ABCD");
	}
	@FindBy(xpath="//input[@class='zen-btn zen-primaryBtn zen-pas']")
	WebElement saveall;
	
	public void clickSaveall() {
		saveall.click();
	}
	
	
	//TC-36
	@FindBy(xpath="//a[@href='/00U/c?md3=220&md0=2024']")
	WebElement currDate;
	public void clickCurrDate() {
		currDate.click();
	}
	@FindBy(xpath="//a[contains(text(),' 8:00 PM')]")
	WebElement selTime;
	public void selTime() {
		selTime.click();
	}
	@FindBy(xpath="//img[@title='Subject Combo (New Window)']")
	WebElement subCombo;
	public void clickSubCombo() {
		subCombo.click();
	}
	@FindBy(id="evt5")
	WebElement typeOther;
	public void enterOther() {
		typeOther.sendKeys("Other");
	}
	@FindBy(id="EndDateTime_time")
	WebElement endTime;
	public void selEndTime() {
		endTime.click();
	}
	@FindBy(id="timePickerItem_42")
	WebElement selectTime9;
	public void clickchoseTime() {
		selectTime9.click();
	}
	@FindBy(xpath="//input[@title='Save']")
	WebElement saveEvent;
	public void saveEvent() {
		saveEvent.click();
	}
	
	
	
// TC-37
	@FindBy(xpath="//a[contains(text(),' 4:00 PM')]")
	WebElement select4;
	public void sel4Time() {
		select4.click();
	}

	@FindBy(xpath="//img[@title='Subject Combo (New Window)']")
	WebElement subCombo7;
	public void clickSubCombo2() {
		subCombo7.click();
	}
//	@FindBy(id="evt5")
//	WebElement typeOther;
//	public void enterOther() {
//		typeOther.sendKeys("Other");
//	}
	
	@FindBy(xpath="//div[text()='7:00 PM']")
	WebElement selectTime7;
	public void clickSevenTime() {
		selectTime7.click();
	}
	@FindBy(id="IsRecurrence")
	WebElement recurrence;
	public void clickRecCheckBox() {
		recurrence.click();
	}
	@FindBy(xpath="//label[text()='Weekly']")
	WebElement weekly;
	public void clickWeekly() {
		weekly.click();
	}
//	@FindBy(id="RecurrenceEndDateOnly")
//	WebElement recEndDate;
//	public void enterRecDate() {
//		String futureDate = RandomPage.getFutureDate(14);
//		recEndDate.sendKeys(futureDate);
//	}
//	
//	
//	public static String getFutureDate(int daysToAdd) {
//        LocalDate today = LocalDate.now();
//        LocalDate futureDate = today.plusDays(daysToAdd);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy"); // Format as needed
//        return futureDate.format(formatter);
//    }
	
	@FindBy(xpath="//input[@title='Save']")
	WebElement saveanotherEvent;
	public void saveNextEvent() {
		saveEvent.click();	
	}
	@FindBy(xpath="//img[@title='Month View']")
	WebElement monthView;
	public void monthView() {
		monthView.click();
	}
	
	
	
	

}
