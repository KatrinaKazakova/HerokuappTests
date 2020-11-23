package pages;

import base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id="username")
    WebElement username;
    @FindBy(id="password")
    WebElement password;
    @FindBy(xpath="//button[@type='submit']")
    WebElement login;
    @FindBy(xpath="//div[@class='flash success']")
    WebElement successMessage;
    @FindBy(xpath="//div[@id='flash']")
    WebElement errorMessage;

    public LoginPage(WebDriver driver) {   super(driver); }

    public void login(String usr, String psw) {
        driver.get("https://the-internet.herokuapp.com/login");
        username.sendKeys(usr);
        password.sendKeys(psw);
        login.click();
    }

    public void successMessageDisplayed(){
        waitForVisibilityOfElement(successMessage);
        Assert.assertTrue(successMessage.isDisplayed());
    }
    public void errorMessageDisplayed(){
        waitForVisibilityOfElement(errorMessage);
        Assert.assertTrue(errorMessage.isDisplayed());
    }
}
