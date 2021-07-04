package com.mven.qa.testcases;  // package

import java.util.concurrent.TimeUnit;

//Import statements
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mven.qa.base.TestBase;
import com.mven.qa.pages.HomePage;
import com.mven.qa.pages.LoginPage;
import com.mven.qa.testdata.ImportantLoginData;
import com.mven.qa.util.TestUtil;

public class LoginPageTest extends TestBase {    //class

	//declaring variables
	LoginPage loginPage;
	HomePage hmePage;
	ImportantLoginData excelLoginData;

	public LoginPageTest() {   //constructor
		super();
	}

	@BeforeMethod         //BeforeMethod Annotation
	public void setUp() {

		initialization();
		//hmePage.navigateTo();
		loginPage = new LoginPage();    //creating login page object
	}


	@AfterMethod    //AfterMethod Annotation
	public void closeDriver() {

		driver.quit();     //closing the driver
	}

	@Test (priority=1,enabled=true)    //Test Case execution annotations
	public void mainLoginButtonClicked() {      //login button click method

		//Getting data from config.properties file
		//hmePage = loginPage.login(prop.getProperty("mobilenumber"), prop.getProperty("password"));
		
		//Getting from Excell sheet
        excelLoginData = new ImportantLoginData();		
		hmePage = loginPage.login(excelLoginData.getMobileNumber(), excelLoginData.getPassword());		
	}
	
	@Test(priority=2,enabled=true)      //Test Annotations with priorities
	public void loginPageTitleTest() { 
		excelLoginData = new ImportantLoginData();			
		hmePage = loginPage.login(excelLoginData.getMobileNumber(), excelLoginData.getPassword());	
		
		//driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);   
  		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		String titleStr = loginPage.validateLoginPageTitle();
		Assert.assertEquals(titleStr, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");

		System.out.println(titleStr);
	}

	@Test (priority=3,enabled=true)
	public void validateLogoImage() {  //validate logo image is there or not
		excelLoginData = new ImportantLoginData();		
		hmePage = loginPage.login(excelLoginData.getMobileNumber(), excelLoginData.getPassword());	
		
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		boolean flag =loginPage.validateCompanyLogoImageVisible();
		Assert.assertTrue(flag);   //checking the flag using Assert
		System.out.println(flag);

	}

	@Test (priority=4,enabled=true)
	public void incorrectLoginCredentials() {   //validating login giving incorrect credentials

		loginPage.incorrectLogin(prop.getProperty("wrongmblnum"), prop.getProperty("wrongpwd"));
	}

	@Test (priority=5,enabled=true)
	public void moveCursorToElectronics() throws InterruptedException {    //validating the elecronics highlited or not to move the cursor on it

		excelLoginData = new ImportantLoginData();			
		hmePage = loginPage.login(excelLoginData.getMobileNumber(), excelLoginData.getPassword());
		
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		loginPage.cursorElectronicsHighlighted();
	}

	@Test (priority=6,enabled=true)
	public void validateTheSearchBar() throws InterruptedException {    //search the items using search bara

		excelLoginData = new ImportantLoginData();			
		hmePage = loginPage.login(excelLoginData.getMobileNumber(), excelLoginData.getPassword());
		
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		loginPage.searchTheItems();
	}

	@Test (priority=7,enabled=true)
	public void travelFlightsClick() throws Exception { 
		excelLoginData = new ImportantLoginData();			
		hmePage = loginPage.login(excelLoginData.getMobileNumber(), excelLoginData.getPassword());
		
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	
		loginPage.travelFlightsClick();
		//loginPage.VerifyingNavigationHomepage();
	}
	@Test (priority=8,enabled=true)
	public void babiesToysPageValidation() throws Exception {
		excelLoginData = new ImportantLoginData();			
		hmePage = loginPage.login(excelLoginData.getMobileNumber(), excelLoginData.getPassword());
			
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);		
		loginPage.babiesToysPageNavigation();
			
		}
	
	@Test (priority=9,enabled=true)
	public void selectProductAndAddToCart() {    
		
	loginPage.addItemToCart();
	//loginPage.VerifyingNavigationHomepage();
	}

	@Test (priority=10,enabled=true)
	public void logOffFromAccount() {   // logout

		loginPage.logout();
	}

	@Test (priority=11,enabled=true)
	public void productNavigation() {
			loginPage.navigateToGroceryProduct();
	}
		
		//	@Test (priority=12)
		//	public void validateIncorrectUrl() {
		//		
		//		loginPage.TestIncorrectUrl();
		//		
		//	}

}
