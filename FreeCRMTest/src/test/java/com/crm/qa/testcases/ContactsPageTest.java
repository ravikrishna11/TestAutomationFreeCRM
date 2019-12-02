package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	
   String sheetName= "Sheet1";


	public ContactsPageTest() throws IOException {
		super();
		
	}
	
	@BeforeMethod
	public void setup() throws IOException {
		initialization();
	    loginPage = new LoginPage();
	    contactsPage = new ContactsPage();
	    homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	    contactsPage=homePage.clickOnContactsLink();
		
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabelTest() {
		Assert.assertTrue(contactsPage.verifyContactsLabel(),"contact label is missing on the page");
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data [][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=2,dataProvider="getCRMTestData")
	public void validateCreateNewContact(String firstName,String lastName,String address) {
		contactsPage.newContactLink();
		//contactsPage.createNewContact("rahul","dravid","india"); 
		contactsPage.createNewContact(firstName,lastName,address); 
	}
	
		
	
  
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
 
	
	
	 

}
