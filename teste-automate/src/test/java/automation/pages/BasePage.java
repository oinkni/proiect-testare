package automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public abstract class BasePage {

    protected final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected List<String> getOptions(By by) {
        WebElement selectElement = driver.findElement(by);
        Select select = new Select(selectElement);

        return select.getOptions()
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    protected void selectByVisibleText(By by, String visibleText) {
        WebElement selectElement = driver.findElement(by);
        Select select = new Select(selectElement);
        select.selectByVisibleText(visibleText);
    }

    protected String getSelectedOptionText(By by) {
        WebElement selectElement = driver.findElement(by);
        Select select = new Select(selectElement);
        return select.getFirstSelectedOption().getText();
    }

}
