package software.ulpgc.core.io.adapters;

import software.ulpgc.core.model.Currency;
import software.ulpgc.core.model.ExchangeRate;

public interface ExchangeRateAdapter {
    ExchangeRate adapt(Currency from, Currency to, Object jsonObject);
}
