package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utilities.TestUtil;

public class ContactsPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	String sheetName="contacts";
	public ContactsPageTest() {
		super();
		
	}
		@BeforeMethod
		public void setUp() throws InterruptedException{
			initialization();
			loginPage= new LoginPage();
			contactsPage= new ContactsPage();
			testUtil= new TestUtil();
			homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
			testUtil.switchToFrame();
			contactsPage=homePage.clickoncontactslink();
		
			
		}
		
		@Test(priority=1)
		public void verifyContactPageLabel() {
			Assert.assertTrue(contactsPage.verifyContactsLable(), "Contact label is missing on the page");
		}
		
		@Test(priority=2)
		public void selectContactsText() {
		contactsPage.selectContactsByName("Akshay Lange");
		}
		
		@DataProvider
		public Object [] [] getTestData() {
		Object data [] [] =	TestUtil.getTestData(sheetName);
		return data;
		}
		
		@Test(priority=3, dataProvider="getTestData")
		public void validateCreateNewContact(String title, String firstname, String lastname, String company ) {// to run this specific method select the method and run as testng, so this method will be called only
			homePage.clickOnNewContactLink();
			//contactsPage.createNewContact("Mr.", "priyesh", "patel", "kahnputers");
			contactsPage.createNewContact(title, firstname, lastname, company);
		}
		
		
		
		
		
		 @AfterMethod public void tearDown() { 
			 driver.quit(); } 
		 
		
}
