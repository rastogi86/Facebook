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

import com.facebook.automation.objectrepository.LoginFacebookPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginFacebookSteps extends LoginFacebookPage {
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	public static TakesScreenshot ts;
	public static ChromeOptions cop;
	public static FirefoxOptions fop;

	@BeforeSuite
	public void setUp() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
		System.getProperty("user.dir") + "\\com\\facebook\\automation\\resources\\RunProperties.properties");
		prop.load(fis);

		if (prop.getProperty("browser").toLowerCase().equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			cop = new ChromeOptions();
			cop.addArguments("--start-maximized");
			cop.addArguments("--ignore-certificate-errors");
			cop.addArguments("--disable-popup-blocking");
			cop.addArguments("--incognito");
			driver = new ChromeDriver(cop);

		} else if (prop.getProperty("browser").toLowerCase().equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			fop = new FirefoxOptions();
			fop.addArguments("--start-maximized");
			fop.addArguments("--ignore-certificate-errors");
			fop.addArguments("--disable-popup-blocking");
			fop.addArguments("--incognito");
			driver = new FirefoxDriver(fop);
		}
		wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void login() throws IOException, InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(imgFacebookLogo));
		driver.findElement(eleEmailID).sendKeys(prop.getProperty("userID"));
		driver.findElement(elePassword).sendKeys(prop.getProperty("password"));
		driver.findElement(btnLogin).click();
		Thread.sleep(10000);
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Date d = new Date();
		String timestamp = d.toString().replace(":", "_").replace(" ", "_");
		FileUtils.copyFile(screenshot,
				new File(System.getProperty("user.dir") + "\\screenshot\\" + timestamp + ".jpeg"));
	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
	}

}
