package automation.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Currency {
    RON, EUR, USD, CAD, GBP, HUF;

    public static List<String> asStrings() {
        return Arrays.stream(values())
                .map(currency -> currency.name())
                .collect(Collectors.toList());
    }

}
