package automation.testng.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.Instant;

import static automation.enums.Currency.EUR;
import static automation.enums.Currency.RON;
import static automation.enums.Language.RO;

public class TC007_Performanta extends BaseTest {

    @Test(invocationCount = 10)
    public void TC007_Performanta() {
        mainPage.selectLanguage(RO.getDisplayName());

        Instant beforeSubmit = mainPage.convertAmount(EUR, RON, "100");
        Assert.assertTrue(mainPage.getResult().endsWith("498"));
        Duration conversionTime = Duration.between(beforeSubmit, Instant.now());
        Assert.assertTrue(conversionTime.getSeconds() <= 1, "Conversia a durat " + conversionTime.getSeconds());
    }

}
