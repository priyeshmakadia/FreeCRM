package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'User: group automation')]")
	WebElement usernamelabel;
	
	
	//Xpath=//*[contains(@name,'btn')]
	
	@FindBy(css="#navmenu > ul > li:nth-child(4) > a")
	WebElement contactlink;
	
	@FindBy(css="#navmenu > ul > li:nth-child(5) > a")
	WebElement dealslink;
	
	@FindBy(css="#navmenu > ul > li:nth-child(6) > a")
	WebElement taskslink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	
	//initializing the page object, by creating constructor
	
	public  HomePage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
		
	}
	public ContactsPage clickoncontactslink() {
		contactlink.click();
		return new ContactsPage();
		
	}
	
	public DealsPage clickoncdealslink() {
		dealslink.click();
		return new DealsPage();

		
	}
	public TasksPage taskslink() {
		taskslink.click();
		return new TasksPage();
	}
	
	public boolean verifyUserCorrectName() {
	return	usernamelabel.isDisplayed();
	}
	//i want to mouse hover on contact link
	public void clickOnNewContactLink() {
		Actions action=new Actions(driver);
		action.moveToElement(contactlink).build().perform();
		newContactLink.click();
	}
	
	
}
