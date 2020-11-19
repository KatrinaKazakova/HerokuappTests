package pageObjects;

import base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.awt.*;

public class ExitIntentPage extends BasePage {

   public ExitIntentPage(WebDriver driver) { super(driver); }

    @FindBy(xpath="//div[@class='modal-footer']/p")
    WebElement closeModal;
    @FindBy(xpath="//div[@class='example']/h3")
    WebElement exitIntent;

    public void closeModalWindow() throws AWTException, InterruptedException {
        waitForVisibilityOfElement(exitIntent);

        Robot robot = new Robot();
        robot.mouseMove(800,800);
        Thread.sleep(1000);
        robot.mouseMove(0,0);

        waitUntilElementIsClickable(closeModal);
        closeModal.click();
    }

    public void exitIntentDisplayed(){
        Assert.assertTrue(exitIntent.isDisplayed());
    }
}