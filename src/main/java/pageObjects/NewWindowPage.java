package pageObjects;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import java.util.Iterator;
import java.util.Set;

public class NewWindowPage extends BasePage {

	public NewWindowPage(WebDriver driver) { super(driver); }

	 @FindBy(xpath="//a[text()='Click Here']")
	 WebElement clickHere;

	public  void verifyNewWindow() {
		clickHere.click();

        Set<String> abc = driver.getWindowHandles();
        Iterator<String> it = abc.iterator();
		String parentWindowId = it.next();
		String childWindowId = it.next();

		driver.switchTo().window(parentWindowId);
		Assert.assertEquals(getPageTitle(), "The Internet");

		driver.switchTo().window(childWindowId);
		Assert.assertEquals(getPageTitle(), "New Window");
		}
}

