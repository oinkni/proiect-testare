package automation.testng.testcases;

import automation.enums.Currency;
import automation.enums.Language;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static automation.enums.Currency.*;
import static automation.enums.Language.*;
import static org.testng.Assert.assertEquals;

public class TC005_Conversie_Neaplicata extends BaseTest {

    @Test(dataProvider = "languageEnumProvider")
    public void TC005_Conversie_Neaplicata(Language language, Currency currencyA,
                                           Currency currencyB, String amount,
                                           String expectedMessage) throws InterruptedException {
        mainPage.selectLanguage(language.getDisplayName());
        mainPage.convertAmount(currencyA, currencyB, amount);

        assertEquals(mainPage.getResult(), expectedMessage, "Mesajul afisat nu este cel corect.");
    }

    @DataProvider(name = "languageEnumProvider")
    public Object[][] provideEnums() {
        return new Object[][]{
                {RO, RON, "23", "Suma rămâne neschimbată"},
                {RO, EUR, "23", "Suma rămâne neschimbată"}
        };
    }
}
