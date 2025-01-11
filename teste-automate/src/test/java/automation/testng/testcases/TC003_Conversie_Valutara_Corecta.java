package automation.testng.testcases;

import automation.enums.Currency;
import automation.enums.Language;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static automation.enums.Currency.*;
import static automation.enums.Language.RO;
import static org.testng.Assert.assertEquals;

public class TC003_Conversie_Valutara_Corecta extends BaseTest {

    @Test(dataProvider = "conversionCases")
    public void TC003_Conversie_Valutara_Corecta(Language language, Currency currencyA,
                                                 Currency currencyB, String amount,
                                                 String expectedConvertedAmount) throws InterruptedException {
        mainPage.selectLanguage(language.getDisplayName());

        mainPage.convertAmount(currencyA, currencyB, amount);

        checkEndsWith(mainPage.getResult(), expectedConvertedAmount);

        // verificare ca nu s-au schimbat valorile din formular la refresh
        assertEquals(mainPage.getSelectedCurrencyA(), currencyA, "Valuta sursa s-a schimbat la reincarcarea paginii");
        assertEquals(mainPage.getSelectedCurrencyB(), currencyA, "Valuta tinta s-a schimbat la reincarcarea paginii");
        assertEquals(mainPage.getSetAmount(), amount, "Valuta tinta s-a schimbat la reincarcarea paginii");

    }

    @DataProvider(name = "conversionCases")
    public Object[][] conversionCases() {
        return new Object[][]{
                {RO, CAD, USD, "100", "140 USD"},
                {RO, EUR, GBP, "100", "84 GBP"},
                {RO, RON, HUF, "100", "8175 HUF"}
        };
    }

}
