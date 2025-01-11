package automation.testng.testcases;

import automation.contexts.AppTexts;
import automation.enums.Currency;
import automation.enums.Language;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static automation.enums.Language.*;
import static org.testng.Assert.assertEquals;

public class TC001_Selectarea_Limbii_Interfetei extends BaseTest {

    @Test(dataProvider = "languageEnumProvider")
    public void TC001_Selectarea_Limbii_Interfetei(Language language) {
        mainPage.selectLanguage(language.getDisplayName());
        assertEquals(language.getDisplayName(), mainPage.getSelectedLanguage(), "Limba selectata nu este aleasa dupa reincarcarea paginii.");

        AppTexts expectedTexts = AppTexts.loadFor(language);
        checkLabelsAreCorrect(expectedTexts);

        mainPage.convertAmount(Currency.RON, Currency.EUR, "1");
        assertEquals(mainPage.getResult(), expectedTexts.getResultExample(), "Rezultatul este tradus incorect.");
        
        checkLabelsAreCorrect(expectedTexts);
    }

    @DataProvider(name = "languageEnumProvider")
    public Object[][] provideEnums() {
        return new Object[][]{
                {EN},
                {FR},
                {HU},
                {RO}
        };
    }

    private void checkLabelsAreCorrect(AppTexts expectedTexts) {
        assertEquals(expectedTexts.getCurrencyALabel(), mainPage.getCurrencyALabel(), "Eticheta pentru valuta sursa este incorecta.");
        assertEquals(expectedTexts.getCurrencyBLabel(), mainPage.getCurrencyBLabel(), "Eticheta pentru valuta tinta este incorecta.");
        assertEquals(expectedTexts.getAmountLabel(), mainPage.getAmountLabel(), "Eticheta pentru suma este incorecta.");
    }
}
