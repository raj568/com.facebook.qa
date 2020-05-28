package com.facebook.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	public Properties prop;
	/**
	 * This method  initialize the driver on basis of given browser
	 * @param browser
	 * @param headless
	 */
	public WebDriver setup(Properties prop)
	{
		String browser=prop.getProperty("browser");
		String headless=prop.getProperty("headless");
		if(browser.equals("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		if(headless.equalsIgnoreCase("yes"))
		{
			ChromeOptions co=new ChromeOptions();
			co.addArguments("--headless");        //co.addArguments("--incognito");
			driver=new ChromeDriver(co);
		}
		else
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			if(headless.equalsIgnoreCase("yes"))
			{
				FirefoxOptions fo=new FirefoxOptions();
				fo.addArguments("--headless");        //co.addArguments("--incognito");
				driver=new FirefoxDriver(fo);
			}
			else
				driver=new FirefoxDriver();
			}
		else if (browser.equalsIgnoreCase("safari")) {
			WebDriverManager.getInstance(SafariDriver.class).setup();
			driver = new SafariDriver();
		}else System.out.println(browser+ "is not found,please pass the correct browserName");
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;
		}// end of setup() method;
	/**
	 * This method is used to load the properties from config file
	 * @return prop
	 */
	public Properties init_prop()
	{
		prop=new Properties();
		try {
			FileInputStream fs=new FileInputStream("C:\\webdriverkit\\workspace2\\com.facebook.qa\\src\\test\\java\\com\\facebook\\qa\\config\\Config.Properties");
		prop.load(fs);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
}
