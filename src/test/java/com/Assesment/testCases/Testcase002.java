package com.Assesment.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Assesment.pageObjects.LoginPage;
import com.Assesment.Utilities.ExcelUtils;

public class Testcase002 extends BaseClass {
	
	
	@Test(dataProvider="Data")
	public void DDT(String Username,String Password) throws InterruptedException
	
	{
	    LoginPage lp=new LoginPage(driver);
	    Boolean bol=lp.amazonLogin(Username, Password);
	    
	    
	    if (bol==true)
	    {   
	    	System.out.println("The Login was successfull :"+Username + " " +Password);
	    	Assert.assertTrue(true);
	    	Thread.sleep(3000);
	    	lp.amazonLogout();	
	 	    Thread.sleep(2000);
	    	}
	    		
	    
	    else
	    {
	    	Assert.assertTrue(true);
	    	System.out.println("Login not suceesfull for :"+ Username  +"  " + Password);
	    }
	   
	    
		
	}	
		
	public boolean loginValidation()
	
	{
		String Title=driver.getTitle();
		System.out.println(Title);
		if (Title.contains("Amazon"))
		{
			return true;
		}
		
		else
		{
			
			return false;
		}
	
	
	}
    
	@DataProvider(name="Data")
	public String [] [] getDataFromExcel() throws IOException
	
	{
		String Exelpath=System.getProperty("user.dir") + "/src/test/java/com/Assesment/Testdata/Testdata.xlsx";
		int rownum=ExcelUtils.getRowcount(Exelpath, "Sheet1");
		int colnum=ExcelUtils.getcolCount(Exelpath, "Sheet1", 1);
		System.out.println(Exelpath);
		String logindata [] []=new String [rownum] [colnum];
		
		for (int i=1;i<=rownum;i++)
		{
			for (int j = 0; j < colnum; j++) 
				
			{
				System.out.println(ExcelUtils.getCelldata(Exelpath, "Sheet1", i,j));
				logindata [i-1] [j]= ExcelUtils.getCelldata(Exelpath, "Sheet1", i,j);
				
				
			}
		}
		
		return logindata;		
	     	
	}

}
