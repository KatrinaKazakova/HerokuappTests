package configuration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Setup {

    public WebDriver driver;
    public static long PAGE_LOAD_TIMEOUT = 40;
    public static long IMPLICIT_WAIT = 30;

    public WebDriver initializeDriver() {

        String browserName = "chrome";

        WebDriverManager.chromedriver().setup();

        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", System.getProperty("user.dir"));

        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=1920,1080");
        options.setExperimentalOption("prefs", chromePrefs);

        if (browserName.contains("headless")) {
            options.addArguments("headless");
            options.addArguments("window-size=1920,1080");
        }
        driver = new ChromeDriver(options);
        return driver;
}
    public void hitUrl(String url) {
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.get(url);
        }
}