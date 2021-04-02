package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utilities.TestUtil;

public class HomePageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	public HomePageTest() {
		super();
		
	}
	//test cases should be independent of with each other, there should not be any dependency
	//before each test case launch the browser and login
	//after each test case close the browser
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialization();
		loginPage= new LoginPage();
		testUtil= new TestUtil();
		
		
	
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	

	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homePageTitle= homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle,"CRMPRO", "Home page title not match: ");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest() {
		testUtil.switchToFrame();
	boolean userNameLable=homePage.verifyUserCorrectName();
	Assert.assertTrue(userNameLable);
	}
	
	@Test(priority=3)
	public void verifyContactListText() {
		testUtil.switchToFrame();
		contactsPage= homePage.clickoncontactslink();
	}
	

	
	
	
	
	
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
