package automation.testng.testcases;

import automation.enums.Currency;
import automation.enums.Language;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static automation.enums.Currency.CAD;
import static automation.enums.Currency.USD;
import static automation.enums.Language.*;
import static org.testng.Assert.assertEquals;

public class TC004_Validare_Date_Introduse extends BaseTest {

    @Test(dataProvider = "conversionCases")
    public void TC004_Validare_Date_Introduse(Language language, Currency currencyA,
                                              Currency currencyB, String amount, String expectedMessage) throws InterruptedException {
        mainPage.selectLanguage(language.getDisplayName());
        mainPage.convertAmount(currencyA, currencyB, amount);

        checkEquals(mainPage.getErrorText(), expectedMessage);
    }

    @DataProvider(name = "conversionCases")
    public Object[][] conversionCases() {
        return new Object[][]{
                {EN, CAD, USD, "", "You must enter a number."},
                {RO, CAD, USD, "abc", "Trebuie introdus un număr."},
                {FR, CAD, USD, "@123", "Vous devez entrer un nombre."},
                {HU, CAD, USD, "10..0", "Meg kell adnia egy számot."},
                {EN, CAD, USD, "+10", "You must enter a number."},
                // Accesibility
                {EN, CAD, USD, "10,50", "You must enter a number."},
                {RO, CAD, USD, "10.50", "Trebuie introdus un număr."},
                {FR, CAD, USD, "10.50", "Vous devez entrer un nombre."},
                {HU, CAD, USD, "10.50", "Meg kell adnia egy számot."}
        };
    }
}
