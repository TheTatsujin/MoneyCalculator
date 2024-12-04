import software.ulpgc.core.commands.Command;
import software.ulpgc.core.io.*;
import software.ulpgc.core.model.Currency;
import software.ulpgc.swingApp.SwingMainFrame;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
/*
        CurrencyLoader loader = new ExRateApiCurrencyLoader(
                new ExRateApiCurrencyReader("5d8b760ea5b0a3798f39d50c81835cb7"),
                new ExRateApiCurrencyDeserializer(),
                new ExRateApiCurrencyAdapter()
        );

        List<Currency> currencies = loader.load();
        currencies.forEach(System.out::println);
*/

        List<Currency> currencies = new ArrayList<>();
        currencies.add(new Currency("USD", "US Dollar"));
        currencies.add(new Currency("EUR", "Euro"));
        currencies.add(new Currency("GBP", "Great Britain Pound"));
        currencies.add(new Currency("JPY", "Japanese Yen"));

        SwingMainFrame frame = new SwingMainFrame();
        Command

    }
}
