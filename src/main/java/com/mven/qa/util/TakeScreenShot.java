package com.mven.qa.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.mven.qa.base.TestBase;

public class TakeScreenShot extends TestBase {
	
public static void takeScreenshotOnFailure(String fileName) {
    	
    	File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	try {
    	FileUtils.copyFile(file, new File("C:\\Users\\LENOVO\\eclipse-workspace\\HackathonTest2\\Screenshots_Failure\\"+fileName+ ".png"));
    	}catch(IOException e) {
    		e.printStackTrace();
    	}
     	System.out.println("testing in branch2");
    }

public static void takeScreenshotOnSuccess(String fileName) {
	
	File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	try {
	FileUtils.copyFile(file, new File("C:\\Users\\LENOVO\\eclipse-workspace\\HackathonTest2\\Screenshots_Success\\"+fileName+ ".png"));
	}catch(IOException e) {
		e.printStackTrace();
	}
 	
}

}
