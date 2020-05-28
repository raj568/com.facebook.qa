package com.facebook.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.facebook.qa.util.ElementUtil;

public class HomePage {
	WebDriver driver;
	 public ElementUtil el;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		el=new ElementUtil(driver);
	}
	By username=By.xpath("//*[@id='mount_0_0']/div/div/div[1]/div[4]/div[1]/div[1]/a/span");
	public String getTitleMethod()
	{
		return driver.getTitle();
	}
	public String verifyUserName()
	{
		return el.doGetText(username);
	}

}
