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

        assertEquals(mainPage.getResult(), expectedMessage, "Mesajul afisat nu este cel corect.");
    }

    @DataProvider(name = "conversionCases")
    public Object[][] conversionCases() {
        return new Object[][]{
                {EN, CAD, USD, "100", ""},
                {FR, CAD, USD, "100", ""},
                {HU, CAD, USD, "100", ""},
                {RO, CAD, USD, "100", ""}
        };
    }
}
