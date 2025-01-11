package automation.testng.testcases;

import automation.enums.Currency;
import automation.enums.Language;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static automation.enums.Language.*;
import static org.testng.Assert.assertEquals;

public class TC001_Selectarea_Limbii_Interfetei extends BaseTest {

    @Test(dataProvider = "languageEnumProvider")
    public void TC001_Selectarea_Limbii_Interfetei(Language language, String expectedResult) {
        mainPage.selectLanguage(language.getDisplayName());
        assertEquals(language.getDisplayName(), mainPage.getSelectedLanguage(), "Limba selectata nu este aleasa dupa reincarcarea paginii.");

        mainPage.convertAmount(Currency.RON, Currency.EUR, "1");

        checkEndsWith(mainPage.getResult(), expectedResult);
    }

    @DataProvider(name = "languageEnumProvider")
    public Object[][] provideEnums() {
        return new Object[][]{
                {RO, "Conform cursului BNR din 19.11.2024, suma convertită în EUR este: 0,2 EUR"},
                {FR, "Selon le taux de change de la BNR du 19.11.2024, le montant converti en EUR est: 0,2 EUR"},
                {HU, "A 2024.11.19-i BNR árfolyam szerint az átváltott összeg EUR-ban: 0,2 EUR"},
                {EN, "According to the BNR exchange rate from 19.11.2024, the exchanged amount in EUR is: 0.2 EUR"}
        };
    }


}
