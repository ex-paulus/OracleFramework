package oracle.com.resultpage;

import java.util.List;

import oracle.com.basepage.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultPage extends Page{

	public ResultPage(WebDriver webDriver) {
		super(webDriver);
	}
	
	@FindBy(how = How.XPATH, using = "//h1")
	public WebElement product;
	
	@FindBy(how = How.XPATH, using = "//p/a[contains(text(),'Instant Client')]")
	public List<WebElement> downloadLinks;
	
	@FindBy(how = How.XPATH, using = "//h3[contains(text(),'Store')]")
	public WebElement storeMenu;
	
	@FindBy(how = How.XPATH, using = "//div[@data-lbl='store']//a[@data-lbl='java']")
	public WebElement selectItem;	
	
	public By slideDown = By.xpath("//div[@data-lbl='store']");
	
	public String checkProperProductSelected() {
		return product.getText();	
	}
	
	public int getNumberOfDownloadLinks() {
		return downloadLinks.size();	
	}

	public String checkProductNameInStore() {
		Actions builder = new Actions(webDriver);
		builder.moveToElement(storeMenu).build().perform();
		WebDriverWait wait = new WebDriverWait(webDriver, 100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(slideDown));
		return selectItem.getText();
	}
}
