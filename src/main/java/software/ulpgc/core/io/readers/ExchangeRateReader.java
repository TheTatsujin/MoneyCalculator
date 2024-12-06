package software.ulpgc.core.io.readers;

import software.ulpgc.core.model.Currency;

public interface ExchangeRateReader {
    String read(Currency from, Currency to);
}
