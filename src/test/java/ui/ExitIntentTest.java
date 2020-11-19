package ui;

import configuration.Setup;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.ExitIntentPage;

import java.awt.*;

public class ExitIntentTest extends Setup {
    public WebDriver driver;
    String url = "https://the-internet.herokuapp.com/exit_intent";
    ExitIntentPage exitIntentPage;

    @BeforeTest
    public void initialize(){
        driver = initializeDriver();
        hitUrl(url);
    }

    @Test
    public void exitIntentShown() throws AWTException, InterruptedException {
        exitIntentPage = new ExitIntentPage(driver);
        exitIntentPage.closeModalWindow();
        exitIntentPage.exitIntentDisplayed();

    }
    @AfterTest
    public void teardown() {
        driver.close();
        driver = null;
    }
}