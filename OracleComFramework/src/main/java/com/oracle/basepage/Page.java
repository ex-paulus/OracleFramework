package com.oracle.basepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public abstract class Page {
	
	protected WebDriver webDriver;

	/*
	 * @param webDriver
	 * constructor for web driver instance
	 */
	public Page(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	@FindBy(how = How.CSS, using = ".u01logo>a")
	public WebElement logo; 

	public WebDriver getWebDriver() {
		return webDriver;
	}

	public boolean isLogoDisplayed() {
		return logo.isDisplayed();		
	}
	
}
