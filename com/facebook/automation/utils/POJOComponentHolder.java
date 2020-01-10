package com.facebook.automation.utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class POJOComponentHolder 
{
	private String browser;
	public WebDriver driver;
	public String getBrowser()
	{
		return browser;
	}
	public void setBrowser(String browser)
	{
		this.browser=browser;
	}

	public void setDriver(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebDriver getDriver()
	{
		return driver;
	}

}
