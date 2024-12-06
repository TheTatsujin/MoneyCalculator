package software.ulpgc.core.io.loaders;

import software.ulpgc.core.model.Currency;
import software.ulpgc.core.model.ExchangeRate;

public interface ExchangeRateLoader {
    ExchangeRate load(Currency from, Currency to);
}
