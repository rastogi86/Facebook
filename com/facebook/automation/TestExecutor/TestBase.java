package com.facebook.automation.TestExecutor;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	/*
	 * public static WebDriver driver; public static Properties prop;
	 * 
	 * @BeforeSuite public static WebDriver setUp() throws IOException { prop = new
	 * Properties(); FileInputStream fis = new FileInputStream(
	 * System.getProperty("user.dir") +
	 * "com\\facebook\\automation\\resources\\RunProperties.properties");
	 * prop.load(fis);
	 * if(prop.getProperty("browser").toLowerCase().equals("chrome")) {
	 * WebDriverManager.chromedriver().setup(); driver=new ChromeDriver(); } else
	 * if(prop.getProperty("browser").toLowerCase().equals("firefox")) {
	 * WebDriverManager.firefoxdriver().setup(); driver=new FirefoxDriver(); }
	 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 * driver.get(prop.getProperty("url")); return driver; }
	 * 
	 * @AfterSuite public void tearDown() { driver.quit();
	 * 
	 * }
	 */
}
