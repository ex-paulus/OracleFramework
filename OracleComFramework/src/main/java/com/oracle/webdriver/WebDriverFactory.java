package com.oracle.webdriver;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;


/**
 * A factory that returns a singleton of WebDriver object.
 */
public class WebDriverFactory {

	private static final String CHROME = "chrome";
	private static final String FIREFOX = "firefox";

	private static WebDriver webDriver;
	private static DesiredCapabilities dc;

	private WebDriverFactory() {
		
	}

	/**
	 * Gets the single instance of WebDriverFactory.
	 *
	 * @param browser the browser set in properties
	 * @return single instance of WebDriverFactory
	 * @throws Exception the exception of invalid browser property
	 */
	public static WebDriver getInstance(String browser) throws Exception {
			if (webDriver == null) {
				if (CHROME.equals(browser)) {	
					String chromeBinaryPath = "src/main/resources/drivers/chromedriver.exe";
					System.setProperty("webdriver.chrome.driver",chromeBinaryPath);
					ChromeOptions options = new ChromeOptions();
					options.addArguments("test-type");
					// not all elements visible in minimized mode
					options.addArguments("--start-maximized");
					DesiredCapabilities dc = DesiredCapabilities.chrome();
					dc.setCapability(ChromeOptions.CAPABILITY, options);
					
					webDriver = new ChromeDriver(dc);
					
				} else if (FIREFOX.equals(browser)) {
					FirefoxProfile fp = new FirefoxProfile();
					dc = DesiredCapabilities.firefox();
					dc.setCapability(FirefoxDriver.PROFILE, fp);
					
					webDriver = new FirefoxDriver(dc);
					
				} else
					throw new Exception("Invalid browser property set in configuration file");
			}
		return webDriver;
	}
	
	/**
	 * Kill driver instance.
	 * @throws Exception 
	 */
	public static void killDriverInstance() throws Exception {
		webDriver.quit();
		webDriver = null;
	}
}