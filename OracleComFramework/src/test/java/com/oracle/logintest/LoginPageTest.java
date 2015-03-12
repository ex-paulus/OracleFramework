package com.oracle.logintest;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.oracle.basetest.TestBase;
import com.oracle.homepage.HomePage;
import com.oracle.loginpage.LoginPage;

public class LoginPageTest extends TestBase {
	
	Map<String, String> userData;
	
	@BeforeMethod
	public void setUserData(){
		userData = new HashMap<String, String> ();
		userData.put("expaulus@i.ua", "Павло");
		userData.put("expaulus33@gmail.com", "Pavlo");
	}

	@DataProvider(name = "properAuth")
	public static Object[][] credentials() {
		return new Object[][] { { "expaulus@i.ua", "LitsAt006" },
				{ "expaulus33@gmail.com", "LitsAt006" } };
	}
	
	@DataProvider(name = "wrongAuth")
	public static Object[][] bullshit() {
		return new Object[][] { { "expaulus@ua.fm", "qwerty" },
				{ "expaulus@gmail.com", "1234567890" } };
	}
	
	@Test
	// TS 2.1
	public void enterLoginPageView() throws InterruptedException {
		LoginPage login = home.enterLoginPage();
		Assert.assertTrue(login.isSubmitButtonDisplayed());
	}
	
	@Test(dataProvider = "properAuth")
	/*
	 *  TS 2.2 check if Login Page brings back to Home Page
	 *  if proper credentials were submitted
	 */
	public void submitCredentialForLogin (String userName, String userPwd) throws InterruptedException {
		LoginPage login = home.enterLoginPage();
		HomePage home = login.loginWithProperCredentials(userName, userPwd);
		// check site logo after entering a Home Page view
		Assert.assertTrue(login.isLogoDisplayed());
		//Check whether welcome user sign at Home Page has a proper name
		Assert.assertTrue(home.getUserName().contains(userData.get(userName)));
	}

	@Test(dataProvider = "wrongAuth")
	/*
	 *  TS 2.3 check if Login Page informs about wrong login
	 *  if improper credentials were submitted
	 */
	public void submitBullshitForLogin (String userName, String userPwd) throws InterruptedException {
		LoginPage login = home.enterLoginPage();
		Assert.assertTrue(login.loginWithWrongCredentials(userName, userPwd));
	}
	
}
