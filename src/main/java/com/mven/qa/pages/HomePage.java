package com.mven.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.mven.qa.base.TestBase;

public class HomePage extends TestBase{
	
	public void navigateTo() {
		driver.navigate().to("https://www.flipkart.com");
		Actions actions = new Actions(driver);
		Action act = actions.sendKeys(Keys.ESCAPE).build();
		act.perform();
	}

}
