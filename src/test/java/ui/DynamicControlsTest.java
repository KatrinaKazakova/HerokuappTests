package ui;

import configuration.Setup;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DynamicControlsPage;

public class DynamicControlsTest extends Setup {

    public WebDriver driver;
    DynamicControlsPage dynamicControlsPage;
    String url= "https://the-internet.herokuapp.com/dynamic_controls";
    String text ="this is test";

    @BeforeTest
    public void initialize() {
        driver = initializeDriver();
        hitUrl(url);
    }

    @Test
    public void enableTest() {
       dynamicControlsPage = new DynamicControlsPage(driver);
       dynamicControlsPage.clickEnable();
    }
    @Test (dependsOnMethods={"enableTest"})
    public void submitStringTest() {
        dynamicControlsPage.submitString(text);
        dynamicControlsPage.verifyStringIsPresent(text);
    }
    @Test (dependsOnMethods={"submitStringTest"})
    public void disableTest() {
        dynamicControlsPage.clickDisable();
        dynamicControlsPage.verifyStringIsPresent(text);
    }

    @AfterTest
    public void teardown() {
        driver.close();
        driver = null;
    }
}
