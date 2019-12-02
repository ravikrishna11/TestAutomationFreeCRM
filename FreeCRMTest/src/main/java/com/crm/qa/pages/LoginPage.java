package com.crm.qa.pages;

import java.io.IOException;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//PageFactory or OR
		@FindBy(name="email")
		WebElement username;
		
		@FindBy(name="password")
		WebElement password;
		
		@FindBy(xpath="//div[text()='Login']")
		WebElement loginBtn;
		
		@FindBy(xpath="//a[contains(text(),'Sign Up')]")
		WebElement signupBtn;
		
		public LoginPage() throws IOException {
			PageFactory.initElements(driver, this);
		}
		
		//Actions
		public String validateLoginPageTile() {
			return driver.getTitle();
			
		}
		public HomePage login(String un,String pwd) throws IOException {
			username.sendKeys(un);
			password.sendKeys(pwd);
			loginBtn.click();
			
			return new HomePage();
		}
		
		

}
