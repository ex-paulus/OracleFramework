package oracle.com.basetest;

import java.util.concurrent.TimeUnit;

import oracle.com.homepage.HomePage;
import oracle.com.webdriver.WebDriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class TestBase {
	
	protected WebDriver webDriver;
	protected HomePage home;

	@BeforeMethod
	@Parameters({ "browserName" })
	public void setup(String browserName) throws Exception {
		webDriver = WebDriverFactory.getInstance(browserName);
		webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		webDriver.get("http://www.oracle.com");
		home = PageFactory.initElements(webDriver, HomePage.class);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		if (webDriver != null) {
			WebDriverFactory.killDriverInstance();
		}
	}
}
