package com.acti.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.acti.base.DriverScript;
import com.acti.pages.LoginPage;

public class TC01_LoginTest extends DriverScript{
	@BeforeMethod
	public void preCondition()
	{
		initBrowser();
		launchApplication();
	}
	@Test
	public void testLoginFunction()
	{
		LoginPage loginpage = new LoginPage();
		loginpage.loginToApplication("admin", "manager");
		
		
	}
	@Test
	public void testVerifyLogoDisplayed()
	{
		LoginPage loginpage = new LoginPage();
		boolean flag = loginpage.verifyActiLogo();
		System.out.println(flag);
	}

	@AfterMethod
	public void postCondition()
	{
		closeApplication();
	}

}
