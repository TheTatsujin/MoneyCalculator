package software.ulpgc.core.io;

import software.ulpgc.core.io.pojos.CurrencyGetResponse;
import software.ulpgc.core.model.Currency;

import java.util.List;

public class ExRateApiCurrencyAdapter implements CurrencyAdapter {
    @Override
    public List<Currency> adapt(Object currencyResponse) {
        System.out.println(((CurrencyGetResponse) currencyResponse).success());
        return adaptCurrencies(((CurrencyGetResponse) currencyResponse).currencyTable());
    }

    private List<Currency> adaptCurrencies(List<CurrencyGetResponse.Entry> response) {
        return response.stream()
                .map(entry -> new Currency(entry.key(), entry.value()))
                .toList();
    }

}
