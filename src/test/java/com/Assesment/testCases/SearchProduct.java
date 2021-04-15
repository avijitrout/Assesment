package com.Assesment.testCases;

import org.testng.annotations.Test;

import com.Assesment.pageObjects.HomePage;
import com.Assesment.pageObjects.LoginPage;

public class SearchProduct extends BaseClass {
     
	
	@Test
	public void serach() throws InterruptedException
	{
		
		LoginPage lp=new LoginPage(driver);
		lp.amazonLogin(username, password);
		
		HomePage hp=new HomePage(driver);
		hp.EnterSearchtext("Ringke Back Cover for OnePlus 7 Pro (Hard|PC and TPU|Black)");
		hp.clickSearchbutton();
		
		hp.searchresult("Ringke Back Cover for OnePlus 7 Pro (Hard|PC and TPU|Black)");
		
		
		
		
	}
	
}
