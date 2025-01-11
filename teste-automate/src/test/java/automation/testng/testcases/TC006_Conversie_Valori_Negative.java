package automation.testng.testcases;

import automation.enums.Currency;
import automation.enums.Language;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static automation.enums.Currency.*;
import static automation.enums.Language.RO;

public class TC006_Conversie_Valori_Negative extends BaseTest {

    @Test(dataProvider = "conversionCases")
    public void TC006_Conversie_Valori_Negative(Language language, Currency currencyA,
                                                Currency currencyB, String amount,
                                                String expectedConvertedAmount) {
        mainPage.selectLanguage(language.getDisplayName());

        mainPage.convertAmount(currencyA, currencyB, amount);

        Assert.assertTrue(
                mainPage.getResult().endsWith(expectedConvertedAmount), "Conversia nu s-a efectuat corect.");
    }

    @DataProvider(name = "conversionCases")
    public Object[][] conversionCases() {
        return new Object[][]{
                {RO, USD, CAD, "-50", ""},
                {RO, GBP, EUR, "-50", ""},
                {RO, HUF, RON, "-50", ""}
        };
    }

}
