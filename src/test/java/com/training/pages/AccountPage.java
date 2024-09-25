package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.training.base.BasePage;

public class AccountPage extends BasePage {
	
	
	public AccountPage(WebDriver driver) {
		super(driver);
		
	}
	
	// elements 
	
	@FindBy(xpath="//a[text()='Accounts']")
	WebElement accounts;
	
	@FindBy(xpath="//input[@name='new']")
	WebElement newacc;
	
	@FindBy(id="acc2")
	WebElement accname;
	
	@FindBy(id="acc6")
	WebElement acctype;
	
	@FindBy(id="00Naj000003WHGw")
	WebElement custpriority;
	
	@FindBy(xpath="//input[@tabindex='34']")
	WebElement newaccsubmitbtn;
	
	
	// new view elements 
	
	@FindBy(xpath="//a[text()='Create New View']")
	WebElement newview;
	
	@FindBy(id="fname")
	WebElement viewname;
	
	@FindBy(id="devame")
	WebElement viewuniquename;
	
	@FindBy(xpath="//input[@data-uidsfdc='4']")
	WebElement viewsavebtn;
	
	
	// edit view elements
	
	@FindBy(id="fcf")
	WebElement editview;
	
	@FindBy(xpath="//a[text()='Edit']")
	WebElement edit;
	
	@FindBy(id="fcol1")
	WebElement field;
	
	@FindBy(id="fop1")
	WebElement operator;
	
	@FindBy(id="fval1")
	WebElement value;
	
	@FindBy(id="colselector_select_0")
	WebElement availableField;
	
	@FindBy(xpath="//a[@id='colselector_select_0_right']")
	WebElement addArrow;
	
	@FindBy(xpath="//input[@data-uidsfdc='5']")
	WebElement editViewsavebtn;
	
	
	// report elements 
	
	@FindBy(xpath="//a[text()='Accounts with last activity > 30 days']")
	WebElement lastActivity; 
	
	@FindBy(id="ext-gen148")
	WebElement datefield;
	
	@FindBy(xpath="//div[text()='Created Date']")
	WebElement createddate;
	
	@FindBy(id="ext-gen152")
	WebElement fromdate;
	
	@FindBy(id="ext-gen279")
	WebElement todaybtn1;
	
	@FindBy(id="ext-gen154")
	WebElement todate;
	
	@FindBy(id="ext-gen292")
	WebElement todaybtn2;
	
	@FindBy(id="ext-gen49")
	WebElement unsavedreportsavebtn;
	
	@FindBy(id="saveReportDlg_reportNameField")
	WebElement reportName;
	
	@FindBy(id="ext-gen313")
	WebElement savedreportsaveandrunbtn;
	
	
	// actions 
	
	public void clickonAccounts() {
		waitforElement(accounts);
		accounts.click();
	}
	
	public void clickonNewAccount() {
		waitforElement(newacc);
		newacc.click();
	}
	
	public void enterIntoAccName(String name) {
		waitforElement(accname);
		accname.sendKeys(name);
		
	}
	
	public void selectAccType() {
		waitforElement(acctype);
		Select accounttype = new Select(acctype);
		accounttype.selectByVisibleText("Technology Partner");
		
	}
	
	public void selectCustPriority() {
		waitforElement(custpriority);
		Select cpriority = new Select(custpriority);
		cpriority.selectByVisibleText("High");
		
	}
	
	public void selectNewAccountSubmitButton() {
		waitforElement(newaccsubmitbtn);
		newaccsubmitbtn.click();
	}
	
	public void clickonNewView() {
		waitforElement(newview);
		newview.click();
	}
	
	public void enterIntoViewName(String vname) {
		waitforElement(viewname);
		viewname.sendKeys(vname);
		
	}
	
	public void enterIntoViewUniqeName(String vuname) {
		waitforElement(viewuniquename);
		viewuniquename.sendKeys(vuname);
		
	}
	
	public void clickonViewSaveBtn() {
		waitforElement(viewsavebtn);
		viewsavebtn.click();
		
	}
	
	public void selectEditView(String editviewname) {
		waitforElement(editview);
		Select eview= new Select(editview);
		eview.selectByVisibleText(editviewname);
		
	}
	
	public void clickonedit() {
		waitforElement(edit);
		edit.click();
	}
	
	public void selectFields() {
		waitforElement(field);	
		Select viewfield = new Select(field);
		viewfield.selectByVisibleText("Account Name");
		
		waitforElement(operator);
		Select op = new Select(operator);
		op.selectByVisibleText("contains");
		
		waitforElement(value);
		value.sendKeys("a");
		
		waitforElement(availableField);
		Select afield=new Select(availableField);
		afield.selectByVisibleText("Last Activity");
		
		waitforElement(addArrow);
		addArrow.click();
	}
	
	public void clickonEditViewSaveBtn() {
		waitforElement(editViewsavebtn);
		editViewsavebtn.click();
		
	}
	
	public void clickonaccswithlast30dayactivity() {
		waitforElement(lastActivity);
		lastActivity.click();
	}
	
	public void makeselectionsonUnsavedReportandSave() {
		
		waitforElement(datefield);
		datefield.click();
		
		waitforElement(createddate);
		createddate.click();
		
		waitforElement(fromdate);
		fromdate.click();
		
		waitforElement(todaybtn1);
		todaybtn1.click();
		
		waitforElement(todate);
		todate.click();
		
		waitforElement(todaybtn2);
		todaybtn2.click();
		
		waitforElement(unsavedreportsavebtn);
		unsavedreportsavebtn.click();
		
	}
	
	public void enterintoSavedReportandSave(String savedreportname) {
		waitforElement(reportName);
		reportName.sendKeys(savedreportname);
		
		waitforElement(savedreportsaveandrunbtn);
		savedreportsaveandrunbtn.click();
		
	}
	
	
	
	@FindBy(xpath="//a[text()='Merge Accounts']")
	WebElement mergeaccount;
	
	public void clickMerge() {
	mergeaccount.click();
	}
	
	@FindBy(xpath="//input[@name='srch']")
	WebElement textaccname;
	public void enteraccName() {
		textaccname.sendKeys("kavi");
	}
	@FindBy(xpath="//input[@name='srchbutton']")
	WebElement findacc;
	public void clickFind() {
		findacc.click();
	}
	@FindBy(xpath="//input[@name='goNext']")
	WebElement nextbtn;
	public void nextButton() {
		nextbtn.click();
	}
	@FindBy(xpath="//input[@name='save']")
	WebElement merge;
	public void clickMergeAcc() {
		merge.click();
	}

}
