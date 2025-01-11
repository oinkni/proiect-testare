package automation.testng.testcases;

import automation.enums.Currency;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class TC002_Existentei_Optiunilor_Valutare extends BaseTest {

    @Test
    public void TC002_Existentei_Optiunilor_Valutare() {
        List<String> currencyAOptions = mainPage.getCurrencyAOptions();
        assertEquals(currencyAOptions, Currency.asStrings(), "Lista de optiuni valutare sursa difera.");

        List<String> currencyBOptions = mainPage.getCurrencyBOptions();
        assertEquals(currencyBOptions, Currency.asStrings(), "Lista de optiuni valutare tinta difera.");
    }

}
