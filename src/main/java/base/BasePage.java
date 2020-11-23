package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class BasePage  {

    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 130);
        PageFactory.initElements(driver, this);
    }


    public String getPageTitle() {
        return driver.getTitle();
    }

    public void waitForVisibilityOfElement(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            System.out.println("some exception/error occurred while waiting for the element " + element.toString());
        }
    }

    public void waitForInvisibilityOfElement(WebElement element) {
        try {
            wait.until(ExpectedConditions.invisibilityOf(element));
        } catch (Exception e) {
            System.out.println("some exception/error occurred while waiting for the element " + element.toString());
        }
    }

    public void waitUntilElementIsClickable(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            System.out.println("some exception/error occurred while waiting for the element " + element.toString());
        }
    }
    public void refreshPage() {
        try {
            driver.navigate().refresh();
        } catch (Exception e) {
            System.out.println("error occurred while refreshing the page");
        }
    }

    /**
     * Select methods
     */
    public void ddlByVisibleText(WebElement locator, String value) {
        Select ddl = new Select(locator);
        ddl.selectByVisibleText(value);
    }

    /**
     * Actions methods
     */
    public void aMoveToElement (WebElement locator){
        Actions actions = new Actions(driver);
        actions.moveToElement(locator);
    }
    public void aClick(WebElement locator){
        Actions actions = new Actions(driver);
        actions.moveToElement(locator).click().build().perform();
    }
    public void aSendKeys(WebElement locator,String value){
        Actions actions = new Actions(driver);
        actions.moveToElement(locator).sendKeys(value).build().perform();
    }
    public void aEnterKeys(WebElement locator){
        Actions actions = new Actions(driver);
        actions.moveToElement(locator).sendKeys(Keys.ENTER).build().perform();
    }
    public void aArrowDownKeys(WebElement locator, Integer numberOfTimes){
        Actions actions = new Actions(driver);
        actions.moveToElement(locator).click();
        int i=1;
        while(i<numberOfTimes) {
            actions.sendKeys(Keys.ARROW_DOWN).build().perform();
            i++;
        }
        actions.sendKeys(Keys.ENTER).build().perform();
    }
}
