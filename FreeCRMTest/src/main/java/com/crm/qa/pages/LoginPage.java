package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	
	//page factory/ object repository
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(css="#loginForm > div > div > input")
	WebElement loginBtn;
	
	
	@FindBy(xpath="/html/body/div[2]/div/div[2]/ul/li[2]/a")
	WebElement signUpBtn;
	
	@FindBy(className="img-responsive")
	WebElement crmLogo;
	
	//initialize all this object repository or element of page factory, so create constructor
	
	public LoginPage() {
		PageFactory.initElements(driver, this);//to initilise page factory, insted of 'this' we can use LoginPage also, 'this' is pointing to current class object
		
	}
	//actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validatecrmLogo (){
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}
	
}
