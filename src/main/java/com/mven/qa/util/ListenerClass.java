package com.mven.qa.util;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.mven.qa.base.TestBase;

public class ListenerClass extends TestBase implements ITestListener {
	
	@Override  
	public void onTestStart(ITestResult result) {  
	// TODO Auto-generated method stub  
	}  
	  
	@Override  
	public void onTestSuccess(ITestResult result) {  
	// TODO Auto-generated method stub  
	System.out.println("Success of test cases and its details are : "+result.getName()); 
	 
	try {
	TakeScreenShot.takeScreenshotOnSuccess(result.getMethod().getMethodName());
	}catch(Exception e) {
		e.printStackTrace();
	}
	}  
	  
	@Override  
	public void onTestFailure(ITestResult result) {  
	// TODO Auto-generated method stub  
	System.out.println("Failure of test cases and its details are : "+result.getName());  
	try {
	TakeScreenShot.takeScreenshotOnFailure(result.getMethod().getMethodName());
	}catch(Exception e) {
		e.printStackTrace();
	}
	}  
	  
	@Override  
	public void onTestSkipped(ITestResult result) {  
	// TODO Auto-generated method stub  
	System.out.println("Skip of test cases and its details are : "+result.getName());  
	}  
	  
	@Override  
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {  
	// TODO Auto-generated method stub  
	System.out.println("Failure of test cases and its details are : "+result.getName());  
	}  
	  
	@Override  
	public void onStart(ITestContext context) {  
	// TODO Auto-generated method stub  
	}  
	  
	@Override  
	public void onFinish(ITestContext context) {  
	// TODO Auto-generated method stub  
	}  
	}  
