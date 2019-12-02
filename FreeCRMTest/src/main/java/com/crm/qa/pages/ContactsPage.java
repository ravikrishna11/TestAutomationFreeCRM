package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement contactsLabel;
	
	@FindBy(xpath="//a[@href='/contacts/new']")
	WebElement newContactLink;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@name='address']")
	WebElement address;
	
	@FindBy(xpath="//i[@class='save icon']")
	WebElement saveBtn;

	public ContactsPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}
	
//	public void selectContactsByName() {
//		
//		driver.findElement(By.xpath("//td[text()='ravi krishna']//preceding-sibling::td//div[@class='ui checked fitted read-only checkbox']//input[@type='checkbox']")).click();
//	}
    public void newContactLink() {
    	newContactLink.click();
    }
    
    public void createNewContact(String ftName,String ltName,String add) {
    	firstName.sendKeys(ftName);
    	lastName.sendKeys(ltName);
    	address.sendKeys(add);
    	saveBtn.click();
    	
    }
	

}
