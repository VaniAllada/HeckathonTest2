package com.mven.qa.testcases;  // package

//Import statements
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mven.qa.base.TestBase;
import com.mven.qa.pages.HomePage;
import com.mven.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {    //class

	//declaring variables
	LoginPage loginPage;
	HomePage hmePage;

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

	@Test (priority=1,enabled=true)
	public void mainLoginButtonClicked() {      //login button click method

		hmePage = loginPage.login(prop.getProperty("mobilenumber"), prop.getProperty("password"));

	}
	@Test(priority=2,enabled=true)      //Test Annotations with priorities
	public void loginPageTitleTest() {
		String titleStr = loginPage.validateLoginPageTitle();
		Assert.assertEquals(titleStr, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");

		System.out.println(titleStr);
	}

	@Test (priority=3,enabled=true)
	public void validateLogoImage() {  //validate logo image is there or not

		boolean flag =loginPage.validateCompanyLogoImageVisible();
		Assert.assertTrue(flag);   //checking the flag using Assert
		System.out.println(flag);

	}

	@Test (priority=4,enabled=true)
	public void incorrectLoginCredentials() {   //validating login giving incorrect credentials

		loginPage.incorrectLogin(prop.getProperty("wrongmblnum"), prop.getProperty("wrongpwd"));
	}

	@Test (priority=5,enabled=true)
	public void moveCursorToElectronics() {    //validating the elecronics highlited or not to move the cursor on it

		loginPage.cursorElectronicsHighlighted();
	}

	@Test (priority=6,enabled=true)
	public void validateTheSearchBar() {    //search the items using search bara

		loginPage.searchTheItems();
	}


//	@Test (priority=7,enabled=false)
//	public void logOffFromAccount() {   // logout
//
//		loginPage.logout();
//	}

	//	@Test (priority=8)
	//	public void babiesToysPageValidation() {
	//		
	//		loginPage.babiesToysPageNavigation();
	//	}



	//	@Test (priority=9)
	//	public void validateIncorrectUrl() {
	//		
	//		loginPage.TestIncorrectUrl();
	//		
	//	}

	//	@Test (priority=10)
	//	public void productNavigation() {
	//		loginPage.navigateToGroceryProduct();
	//	}

}
