package software.ulpgc.core.io.adapters;

import software.ulpgc.core.io.pojos.ExchangeRateGetResponse;
import software.ulpgc.core.model.Currency;
import software.ulpgc.core.model.ExchangeRate;

public class RatesDbApiExchangeRateAdapter implements ExchangeRateAdapter {
    @Override
    public ExchangeRate adapt(Currency from, Currency to, Object jsonResponse) {
        return new ExchangeRate(from, to, getRate(to.code(), jsonResponse));
    }

    private double getRate(String currencyCode, Object jsonObject) {
        return ((ExchangeRateGetResponse) jsonObject).data().rates().get(currencyCode);
    }
}
