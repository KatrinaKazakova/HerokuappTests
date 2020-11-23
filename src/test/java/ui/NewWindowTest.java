package ui;

import configuration.Setup;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.NewWindowPage;

import java.io.IOException;

public class NewWindowTest extends Setup {
	public WebDriver driver;
	String url= "https://the-internet.herokuapp.com/windows";
	NewWindowPage newWindowPage;

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		hitUrl(url);
	}

	@Test
	public void verifyNewTabOpens() {
		newWindowPage = new NewWindowPage(driver);
		newWindowPage.verifyNewWindow();
	}

	@AfterTest
	public void teardown() {
		driver.quit();
		driver = null;
	}
}

