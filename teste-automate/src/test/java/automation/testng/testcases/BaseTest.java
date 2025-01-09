package automation.testng.testcases;

import automation.enums.Browsers;
import automation.selenium.BrowserFactory;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import automation.config.EnvironmentVariables;

import java.time.Duration;

public abstract class BaseTest {

    protected WebDriver driver;
    private Browsers browser = Browsers.CHROME;
    private String url = "http://localhost/ProiectTestare";

    @BeforeMethod
    @Parameters("browser")
    public void setup(String browserName) {
        browser = Browsers.valueOf(browserName.toUpperCase());
        driver = BrowserFactory.launch(browser);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(EnvironmentVariables.WAIT_IMPLICIT));
        driver.manage().window().maximize();
        driver.get(url);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}