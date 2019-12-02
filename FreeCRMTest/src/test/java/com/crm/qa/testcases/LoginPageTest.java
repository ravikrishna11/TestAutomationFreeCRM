package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() throws IOException {
		super();
	
	}

	@BeforeMethod
	public void setup() throws IOException {
		initialization();
	    loginPage = new LoginPage();
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title=loginPage.validateLoginPageTile();
		System.out.println(title);
		Assert.assertEquals(title, "Cogmento CRM");
	}
	@Test(priority=2)
	public void loginTest() throws IOException {
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	


}
