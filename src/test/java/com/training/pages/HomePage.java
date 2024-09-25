package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.training.base.BasePage;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		//PageFactory.initElements(driver,this);  // assigning the driver coming from the HomeTest - common so in BasePage
		super(driver);
	}
	
	@FindBy(xpath="//a[text()='Home']")
	WebElement home;
	
	@FindBy(id="name")
	WebElement Firstname;
	
	
	
	public void clickHome() {
		waitforElement(home);
		home.click();
	}
	
	public void enterintofname() {
		waitforElement(Firstname);
		Firstname.sendKeys("Malavika");
	}

}
