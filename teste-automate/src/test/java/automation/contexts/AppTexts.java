package automation.contexts;

import automation.enums.Language;
import lombok.Data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Data
public class AppTexts {

    private String currencyALabel;
    private String currencyBLabel;
    private String amountLabel;
    private String sendBtnLabel;
    private String resultExample;
    private String sameConversionMessage;

    public static AppTexts loadFor(Language language) {
        Properties properties = new Properties();
        AppTexts appTexts = new AppTexts();

        try (FileInputStream inputStream = new FileInputStream(language.getTextsFile())) {
            properties.load(inputStream);

            appTexts.setCurrencyALabel(properties.getProperty("currencyALabel"));
            appTexts.setCurrencyBLabel(properties.getProperty("currencyBLabel"));
            appTexts.setAmountLabel(properties.getProperty("amountLabel"));
            appTexts.setSendBtnLabel(properties.getProperty("sendBtnLabel"));
            appTexts.setSameConversionMessage(properties.getProperty("sameConversionMessage"));
            appTexts.setResultExample(properties.getProperty("resultPattern"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return appTexts;
    }
}
