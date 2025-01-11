package automation.testng.testcases;

import automation.config.EnvironmentVariables;
import automation.pages.MainPage;
import automation.selenium.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

import static automation.selenium.BrowserFactory.CHROME;

public abstract class BaseTest {

    protected WebDriver driver;
    protected MainPage mainPage;
    private String url = "http://localhost/ProiectTestare";

    @BeforeMethod
    @Parameters("browser")
    public void setup(@Optional String browserName) {
        browserName = java.util.Optional.ofNullable(browserName)
                .orElse(CHROME);
        driver = BrowserFactory.launch(browserName);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(EnvironmentVariables.WAIT_IMPLICIT));
        driver.manage().window().maximize();
        driver.get(url);

        mainPage = new MainPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}