package com.oracle.resulttest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.oracle.basetest.TestBase;
import com.oracle.resultpage.ResultPage;

public class ResultPageTest extends TestBase{
	
	@Test
	// TS 3.1
	public void enterResultPageView() throws InterruptedException {
		ResultPage result = home.openDownloadPageForSelectedItem();
		// Result Page should have the same logo as Home Page
		Assert.assertTrue(result.isLogoDisplayed());
		Assert.assertEquals("Instant Client Downloads", result.checkProperProductSelected());
	}
	
	@Test
	// TS 3.2
	public void checkNumberOfLinks() throws InterruptedException {	
		ResultPage result = home.openDownloadPageForSelectedItem();
		Assert.assertEquals(23, result.getNumberOfDownloadLinks());
	}
	
	@Test
	// TS 3.3
	public void checkJavaDownloadAvailable () throws InterruptedException {
		ResultPage result = home.openDownloadPageForSelectedItem();
		Assert.assertEquals("Java", result.checkProductNameInStore());
	}

}
