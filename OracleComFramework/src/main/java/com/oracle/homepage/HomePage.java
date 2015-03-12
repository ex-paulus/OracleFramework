package com.oracle.homepage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.oracle.basepage.Page;
import com.oracle.loginpage.LoginPage;
import com.oracle.resultpage.ResultPage;

public class HomePage extends Page{

	public HomePage(WebDriver webDriver) {
		super(webDriver);
	}
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Sign In')]")
	public WebElement signInlink; 
	
	@FindBy(how = How.XPATH, using = "//ul[@data-trackas='hnav']/li")
	public List <WebElement> menuBars;
	
	@FindBy(how = How.CSS, using = "#pfile-wlcm")
	public WebElement welcomeUser;
	
	@FindBy(how = How.XPATH, using = "//h3[contains(text(),'Downloads')]")
	public WebElement menuBar;

	// condition after which a sub-menu item is clickable  
	public By slidingMenu = By.xpath("//div[@data-lbl='downloads']");

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Oracle Instant Client')]")
	public WebElement menuItem;
	
	public boolean isSignInLinkDisplayed() {
		return signInlink.isDisplayed();
	}
	
	public int countMenuBarsNumber() {
		return menuBars.size();
	}
	
	public String getUserName() {
		return welcomeUser.getText();		
	}
	
	public LoginPage enterLoginPage() {
		signInlink.click();
		return PageFactory.initElements(webDriver, LoginPage.class);
	}
	
	public ResultPage openDownloadPageForSelectedItem () {
		Actions builder = new Actions(webDriver);
		builder.moveToElement(menuBar).build().perform();
		WebDriverWait wait = new WebDriverWait(webDriver, 100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(slidingMenu));
		menuItem.click();
		return PageFactory.initElements(webDriver, ResultPage.class);	
	}	
}
