package com.mven.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.mven.qa.base.TestBase;
import com.mven.qa.util.TestUtil;

public class LoginPage extends TestBase {

	//Page Factory - Object Repository

	@FindBy(xpath="//a[text()='Login']")
	WebElement loginBtn;

	@FindBy(xpath="//img[@title='Flipkart']")
	WebElement companyLogoImage;

	@FindBy(xpath="/*[@id='main-frame-error']")
	WebElement incorrectUrl;

	//@FindBy(xpath="//input[@class='_2IX_2- _2LYh3d VJZDxU']")
	@FindBy(xpath="/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")
	WebElement mobileNumber;

	//@FindBy(xpath="//input[@type='password']")
	@FindBy(xpath="/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input")
	WebElement password;

	//@FindBy(xpath="//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")
	@FindBy(xpath="/html/body/div[2]/div/div/div/div/div[2]/div/form/div[4]/button")
	WebElement mainLoginBtn;


	//@FindBy(xpath="/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/span[3]/span")
	@FindBy(xpath="//span[contains(text(),'enter valid')]")
	WebElement invalidMailPassword;


	//@FindBy(xpath="//*[@id='container']/div/div[2]/div/div/div[2]/a/div[2]")
	//@FindBy(xpath="//*[@id='container']/div/div[2]/div/div/div[2]/a/div[1]/div/img")
	//@FindBy(xpath="//img[@src='Grocery']")
	@FindBy(xpath="//img[@src='https://rukminim1.flixcart.com/flap/128/128/image/29327f40e9c4d26b.png?q=100']")
	WebElement groceryProduct;

	@FindBy(xpath="//img[@alt='Electronics']")
	WebElement cursorElectronics;

	@FindBy(xpath="//input[@name='q']")
	WebElement searchBar;
	

	//@FindBy(xpath="//img[@alt='Top Offers']")
	@FindBy(xpath="//*[@id=\"container\"]/div/div[2]/div/div/div[1]/a/div[2]")
	WebElement topOffers;
	
	
	//@FindBy(xpath="//*[@id="container"]/div/div[2]/div/div/span[5]")
	@FindBy(xpath="//span[text()='Baby & Kids']")
	WebElement babiesToys;
	
	//@FindBy(xpath="//*[@id=\"container\"]/div/div[2]/div/div/div[9]/a/div[2]/div/div")
	@FindBy(xpath="//*[text()='Remote Control Toys']")
	WebElement remoteControlToys;


	@FindBy(xpath="//a[text()='View All'")
	WebElement viewAll;

	@FindBy(xpath="//span[text()='Baby & Kids']")
	WebElement babyKidsSubPage;
	

	@FindBy(xpath="//*[@id=\'container\']/div/div[1]/div[1]/div[2]/div[3]/div/div/div/div")
	WebElement myAccountClick;

	@FindBy(xpath="//div[text()='Logout']']")
	WebElement logOut;

	
	//@FindBy(xpath="//div[@class='xtXmba' and text()='Travel']")
	//@FindBy(xpath="//*[@id='container']/div/div[2]/div/div/div[8]/a/div[2]")
	//@FindBy(xpath="(//div[@class='eFQ30H'])[8]")
	@FindBy(xpath="//*[@alt='Travel']")
	WebElement travelClick;

	
	@FindBy(xpath="//img[@alt='Mobiles']")
	WebElement selectItemCart;

	//Initialization of page objects
	public LoginPage() {

		PageFactory.initElements(driver, this);
	}

	// Actions:  

	//validation of company logo
	public boolean validateCompanyLogoImageVisible() {
		return companyLogoImage.isDisplayed();
	}

	//validating loginpage title
	public String validateLoginPageTitle() {

		return driver.getTitle();
	} 

	//login button click	
	public void loginBtnClicked() {

		loginBtn.click();

	}

   //Validating url with incorrect username and password
	public void TestIncorrectUrl()
	{
		driver.get("http://www.flipcar.com/");

		// This will capture error message
	//	incorrectUrl.isDisplayed();      
		String actual_msg = driver.findElement(By.id("main-frame-error")).getText();
		// Store message in variable
		String expect="plz enter valid link";

		// Verify error message
		Assert.assertEquals(actual_msg, expect);

	}

	//Main Login Button Clicked
	public void mainLoginBtnClicked() {
		mainLoginBtn.click();
	}

	//Login with correct user
	public HomePage login(String un, String pwd) {
		mobileNumber.sendKeys(un);
		password.sendKeys(pwd);
		mainLoginBtn.click();

		return new HomePage();
	}

	//Incorrect User
	public void incorrectLogin(String inun, String inpwd) {
		
		mobileNumber.sendKeys(inun);
		password.sendKeys(inpwd);
		mainLoginBtn.click();

		String invalidStr = invalidMailPassword.getText();
		System.out.println(invalidStr);

	}


	//validating the Electonics is highlighting or not to give 
	public void cursorElectronicsHighlighted() throws InterruptedException {
		
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.moveToElement(cursorElectronics).perform();
		//  System.out.println("Tooltip: "+ cursorElectronics.getText());

	}

	//Search the items
	public void searchTheItems() throws InterruptedException {
			
		Thread.sleep(2000);
	//	new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(searchBar));
	    searchBar.sendKeys("mobiles");
	}

	//goto babiesToys page navigation and select remote toys
	public void babiesToysPageNavigation() throws Exception {

		topOffers.click();
		topOffers.click();
		Thread.sleep(2000);
		
		Actions act = new Actions(driver);
		act.moveToElement(babiesToys).perform();
		//System.out.println(babiesToys.getText());

		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		babiesToys.click();
		Thread.sleep(2000);
		remoteControlToys.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

	}
	  //click the travels and navigating to home  
		public void travelFlightsClick() throws Exception {
			//WebDriverWait wait=new WebDriverWait(driver, 20);
			//wait.until(ExpectedConditions.visibilityOf(travelClick));
			
			Thread.sleep(2000);
			//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			travelClick.click();
			//Thread.sleep(2000);
			driver.navigate().back();
			
		}

	//Logout functionality
	public void logout() {

		Actions act = new Actions(driver);
		act.moveToElement(myAccountClick).perform();
		System.out.println(myAccountClick.getText());

		Select select = new Select(logOut);
		select.selectByVisibleText("logOut");

	}

   // Navigation of homepage
     public void VerifyingNavigationHomepage() {
         driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
         PageFactory.initElements(driver, this);
     }
   
 
	
	//Adding items to cart
	public void addItemToCart() {
		
		selectItemCart.click();
		
	}

	//varify user able to navigate to grocery product page 		
	public GroceriesPage navigateToGroceryProduct() {
		//groceryProduct.click();

		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(groceryProduct)).click();
		return new GroceriesPage();
		//new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(groceryProduct)).click();
	}
	



}
