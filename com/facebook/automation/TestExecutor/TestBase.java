package com.facebook.automation.TestExecutor;

import java.io.File;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.facebook.automation.browser.ChromeBrowser;
import com.facebook.automation.utils.POJOComponentHolder;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase 
{

	public WebDriver driver;
	public Object options;
	POJOComponentHolder pojo= new POJOComponentHolder();
	File fis=new File(System.getProperty("user.dir")+"\\com\facebook\\automation\\resources\\RunProperties.properties");
	Properties prop=new Properties();
	@Parameters("browser")
	@BeforeTest
	public void beforeTest(@Optional("") String browser)
	{
		browser=browser.toLowerCase();
		pojo.setBrowser(browser);
		
		switch(browser)
		{
		case "chrome": 
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver(new ChromeBrowser().getChromeOptions());
			pojo.setDriver(driver);
			break;
		}
		
		driver.get(prop.getProperty("url"));
		
	}
	
	
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}


	
}
	