package automation.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    public static String CHROME = "Chrome";
    public static String FIREFOX = "Firefox";

    public static WebDriver launch(String browser) {
        if (browser.equals(CHROME)) {
            return new ChromeDriver();
        } else if (browser.equals(FIREFOX)) {
            return new FirefoxDriver();
        }

        // default
        return new ChromeDriver();
    }
}
