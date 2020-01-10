package com.facebook.automation.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.facebook.automation.objectrepository.FacebookLoginPage;
import com.facebook.automation.utils.POJOComponentHolder;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookLoginSteps extends FacebookLoginPage {
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	public static TakesScreenshot ts;
	public static ChromeOptions cop;
	public static FirefoxOptions fop;
	private POJOComponentHolder pojo;

	@Test
	public void login(POJOComponentHolder pojo) throws IOException, InterruptedException {
		this.pojo=pojo;
		pojo.getBrowser();
		driver=pojo.getDriver();
		wait.until(ExpectedConditions.visibilityOfElementLocated(imgFacebookLogo));
		driver.findElement(eleEmailID).sendKeys(prop.getProperty("userID"));
		driver.findElement(elePassword).sendKeys(prop.getProperty("password"));
		driver.findElement(btnLogin).click();
		Thread.sleep(10000);
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Date d = new Date();
		String timestamp = d.toString().replace(":", "_").replace(" ", "_");
		FileUtils.copyFile(screenshot,new File(System.getProperty("user.dir") + "\\screenshot\\" + timestamp + ".jpeg"));
	}

}
