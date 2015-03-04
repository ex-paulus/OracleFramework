package oracle.com.resulttest;

import junit.framework.Assert;
import oracle.com.basetest.TestBase;
import oracle.com.resultpage.ResultPage;

import org.testng.annotations.Test;

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
