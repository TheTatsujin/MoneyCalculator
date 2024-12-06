package software.ulpgc.core.ui;

import software.ulpgc.core.model.Currency;

import java.util.List;

public interface CurrencyDialog {
    CurrencyDialog define(List<Currency> currencyList);

    void setValue(Currency currency);
    Currency get();
}
