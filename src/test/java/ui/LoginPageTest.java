package ui;

import configuration.Setup;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

import java.io.IOException;

public class LoginPageTest extends Setup{
    public WebDriver driver;
    LoginPage loginPage;
    String url= "https://the-internet.herokuapp.com/login";

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        hitUrl(url);
    }

    @Test
    public void loginSuccessScenario(){
        loginPage = new LoginPage(driver);
        loginPage.login("tomsmith","SuperSecretPassword!");
        loginPage.successMessageDisplayed();
    }

    @Test
    public void loginErrorScenario() {
        loginPage = new LoginPage(driver);
        loginPage.login("wrongUsername","wrongPassword");
        loginPage.errorMessageDisplayed();
    }

    @AfterTest
    public void teardown() {
        driver.close();
        driver = null;
    }
}
