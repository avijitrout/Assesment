package com.Assesment.testCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Assesment.pageObjects.LoginPage;

public class Testcase001 extends BaseClass{
	
	@Test
	public void logintest() throws IOException, InterruptedException
	
	{
		
		//driver.get(baseURL);
		
		logger.info("URL is entered.");
		
		LoginPage lp=new LoginPage(driver);
		lp.amazonLogin(username, password);
		logger.info("PASS:Login");
		
		Thread.sleep(3000);
		if (driver.getTitle().equalsIgnoreCase("Amazon.in - Your Account"))
		{
			Assert.assertTrue(true);
			System.out.println(driver.getTitle());
			
		}
		else
		{   
			System.out.println(driver.getTitle());
			captureScreenshot(driver,"logintest");
			Assert.assertTrue(false);
			
		}
		
		
		
		
		
	}
	
	
	
	
	
	

}
