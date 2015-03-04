package oracle.com.hometest;

import junit.framework.Assert;
import oracle.com.basetest.TestBase;

import org.testng.annotations.Test;

public class HomePageTest extends TestBase{
	
	@Test
	// TS 1.1
	public void findHomePageLogo() throws InterruptedException {
		Assert.assertTrue(home.isLogoDisplayed());
	}
	
	@Test
	// TS 1.2
	public void findHomePageSignIn() throws InterruptedException {
		Assert.assertTrue(home.isSignInLinkDisplayed());
	}
	
	@Test
	// TS 1.3
	public void checkMenuBarsConsistency() throws InterruptedException {
		Assert.assertEquals(9, home.countMenuBarsNumber());
	}
	
}
