package automation.pages;

import automation.enums.Currency;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class MainPage extends BasePage {

    By language = By.id("language");
    By currencyA = By.id("currency_a");
    By currencyB = By.id("currency_b");
    By amount = By.id("amount");
    By sendBtn = By.id("send");
    By resultBox = By.cssSelector(".result-box");
    By errorText = By.cssSelector(".result-box p");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getCurrencyAOptions() {
        return getOptions(currencyA);
    }

    public List<String> getCurrencyBOptions() {
        return getOptions(currencyB);
    }

    public void selectLanguage(String languageName) {
        WebElement selectElement = driver.findElement(language);
        Select select = new Select(selectElement);
        if (false == select.getFirstSelectedOption().getText().equals(languageName)) {
            // only select and reload the page if not selected
            select.selectByVisibleText(languageName);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            wait.until(ExpectedConditions.stalenessOf(selectElement));
        }
    }

    public String getSelectedCurrencyA() {
        return getSelectedOptionText(currencyA);
    }

    public String getSelectedCurrencyB() {
        return getSelectedOptionText(currencyB);
    }

    public String getSetAmount() {
        return driver.findElement(amount).getText();
    }

    public String getSelectedLanguage() {
        return getSelectedOptionText(language);
    }

    public Duration convertAmount(Currency currencyAInput, Currency currencyBInput, String amountInput) {
        selectByVisibleText(currencyA, currencyAInput.name());
        selectByVisibleText(currencyB, currencyBInput.name());
        driver.findElement(amount).sendKeys(amountInput);

        WebElement sendBtnElement = driver.findElement(sendBtn);
        Instant beforeSubmit = Instant.now();
        sendBtnElement.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.stalenessOf(sendBtnElement));
        return Duration.between(beforeSubmit, Instant.now());
    }

    public String getResult() {
        return driver.findElement(resultBox).getText();
    }

    public String getErrorText() {
        return driver.findElement(errorText).getText();
    }
}
