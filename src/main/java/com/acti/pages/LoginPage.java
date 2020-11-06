package com.acti.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acti.base.DriverScript;

public class LoginPage  extends DriverScript{
	
	//***************************************Page Elements****************************//
	
	@FindBy(id="username") WebElement usernameTextbox;
	@FindBy(name="pwd") WebElement passwordTextbox;
	@FindBy(id="loginButton") WebElement loginButton;
	@FindBy(className="atLogoImg") WebElement actitimeLogo;
	
	//***************************************Page Initialization****************************//
	
	// use of pageFactory class in POM is to initialize the page Elements
	
	public LoginPage() 
	{
		PageFactory.initElements(driver, this);
	}
	//***************************************Page Actions****************************//
	
	public void loginToApplication(String username,String password)
	{
		usernameTextbox.sendKeys("admin");
		passwordTextbox.sendKeys("manager");
		loginButton.click();
	}
	public boolean verifyActiLogo()
	{
		return actitimeLogo.isDisplayed();
	}
	public String verifypageTitle()
	{
		return driver.getTitle();
	}

}
