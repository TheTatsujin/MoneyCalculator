package software.ulpgc.core.io.adapters;

import software.ulpgc.core.io.pojos.CurrencyGetResponse;
import software.ulpgc.core.model.Currency;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExRateApiCurrencyAdapter implements CurrencyAdapter {
    @Override
    public List<Currency> adapt(Object currencyResponse) {
        return adaptCurrencies(((CurrencyGetResponse) currencyResponse).symbols());
    }

    private List<Currency> adaptCurrencies(Map<String, String> responseTable) {
        List<Currency> currencies = new ArrayList<>();
        for (String entry : responseTable.keySet()) {
            currencies.add(new Currency(entry, responseTable.get(entry)));
        }
        return currencies;
    }

}
