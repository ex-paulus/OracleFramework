package oracle.com.loginpage;

import oracle.com.basepage.Page;
import oracle.com.homepage.HomePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Page{

	public LoginPage(WebDriver webDriver) {
		super(webDriver);
	}
	
	@FindBy(how = How.CSS, using = "#sso_username")
	public WebElement loginBox;
	
	@FindBy(how = How.CSS, using = "#ssopassword")
	public WebElement passwordBox;
	
	@FindBy(how = How.CSS, using = ".submit_btn")
	public WebElement submitButton; 
	
	@FindBy(how = How.CSS, using = "#errormsg")
	public WebElement errorMessage; 

	
	public boolean isSubmitButtonDisplayed() {	
		return submitButton.isDisplayed();
	}
	
	public boolean loginWithWrongCredentials(String loginName, String password) {
		loginBox.sendKeys(loginName);
		passwordBox.sendKeys(password);
		submitButton.click();
		return errorMessage.isDisplayed();
	}
	
	public HomePage loginWithProperCredentials(String loginName, String password) {
		loginBox.sendKeys(loginName);
		passwordBox.sendKeys(password);
		submitButton.click();
		return PageFactory.initElements(webDriver, HomePage.class);
	}	
}
