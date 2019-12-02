package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath="//span[contains(text(),'Ravi Krishna')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//span[contains(text(),'Tasks')]")
    WebElement tasksLink;
	
	//initializing page objects
	public HomePage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	public boolean correctUserName() {
		return userNameLabel.isDisplayed();
	}
	
	public String verifyHomePageTile() {
		return driver.getTitle();
	}
	public ContactsPage clickOnContactsLink() throws IOException{
		contactsLink.click();
		return new ContactsPage();
		
		
	}
	public DealsPage clickOnDealsLink() throws IOException {
		dealsLink.click();
		return new DealsPage();
		
	}
	public TasksPage clickOnTasksLink() throws IOException {
		tasksLink.click();
		return new TasksPage();
		
	}
}

