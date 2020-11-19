package pageObjects;

import base.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class DynamicControlsPage extends BasePage {

    public DynamicControlsPage(WebDriver driver) { super(driver);}

    @FindBy(xpath="//form[@id='input-example']/input")
    WebElement inputfield;
    @FindBy(xpath="//form[@id='input-example']/button")
    WebElement button;
    @FindBy(xpath="//form[@id='input-example']/p")
    WebElement text;

    public void clickEnable() {
        button.click();   // click enable
        waitForVisibilityOfElement(text);  // wait for It`s enabled/disabled message
        Assert.assertEquals(text.getText(),"It's enabled!"); // verify text "It's enabled!" display
    }
    public void submitString(String text) {
       inputfield.sendKeys(text);
    }

    public void clickDisable() {
        button.click();    // click on disable button
        waitForVisibilityOfElement(text);  //  wait for It`s enabled/disabled message
        Assert.assertEquals(text.getText(),"It's disabled!");       // verify text "It's disabled!" display
    }

    public void verifyStringIsPresent(String text) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String actualvalue2 = (String) js.executeScript("return arguments[0].value", inputfield);
        Assert.assertEquals(actualvalue2,text);
    }
}
