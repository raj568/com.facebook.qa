package com.facebook.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.facebook.qa.base.BaseClass;
import com.facebook.qa.util.ElementUtil;

public class LoginPage extends BaseClass {
	 WebDriver driver;
	 public ElementUtil el;
	 
	public LoginPage(WebDriver driver) {

		this.driver=driver;
		el=new ElementUtil(driver);
			}
	
	
	By fbtitle=By.xpath("//*[@id='blueBarDOMInspector']/div/div/div/div[1]/h1/a/i");
	By Email=By.xpath("//*[@id='email']");
	By Password=By.xpath("//*[@id='pass']");
	By Login=By.xpath("//*[@id='u_0_b']");
	By ForgotAccount=By.xpath("//*[@id='login_form']/table/tbody/tr[3]/td[2]/div/a");
	By Signup=By.xpath("//*[@id='content']/div/div/div/div[2]/div[1]/h2");
	By LastName=By.xpath("/*[@id='u_0_o']");
	By firstName=By.xpath("//*[@id='u_0_m']");
	
	
	public String doGetTitle()
	{
		return(driver.getTitle());
	}
public String dogetpagesource()
{
return(driver.getPageSource());
}
public String doGetCurrentUrl()
{
	return(driver.getCurrentUrl());
}

public String getTitleText(){
	
	return(el.doGetText(fbtitle));
	
}
public boolean checkSignUpLink() 
{
	return(el.isDisplayed(Signup));
}
public HomePage doLogin(String un,String pwd) throws InterruptedException
{
	el.doSendKeys(Email, un);
	el.doSendKeys(Password, pwd);
	return(new HomePage(el.doClick(Login)));
	
}

public void tearDown()
{
	driver.quit();
}

}
