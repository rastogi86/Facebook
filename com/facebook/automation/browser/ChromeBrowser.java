package com.facebook.automation.browser;

import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeBrowser 
{
		private ChromeOptions options;
		

		public ChromeBrowser() {
			this.options = new ChromeOptions();
		}

		public ChromeOptions getChromeOptions() 
		{
				options.addArguments("incognito");
				options.addArguments("start-maximized");
				options.addArguments("window-size=1680,1050");
				options.addArguments("disable-infobars");
				options.addArguments("disable-extensions");
				options.addArguments("--start-maximized");
				return options;
		}
}