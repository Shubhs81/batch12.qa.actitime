package com.acti.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class DriverScript {
	
	public static WebDriver driver;
	static Properties prop;
	
	
	public DriverScript() 
	{
		try
		{
			File file = new File("./src/test/resources/Config/config.properties");
			FileInputStream fis = new FileInputStream(file);
			Properties prop = new Properties();
			prop.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("Unabke to load the file"+e.getMessage());
		}
	}
	
	public static void initBrowser()
	{
		String browser = prop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./src/test/resources/Browsers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./src/test/resources/Browsers/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("unsupported browser name");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		launchApplication();
		closeApplication();
	}
	public static void launchApplication()
	{
		String url = prop.getProperty("qaurl");
		driver.get(url);
	}
	public static void closeApplication()
	{
		driver.close();
	}

}
