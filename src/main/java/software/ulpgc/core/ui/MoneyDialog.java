package software.ulpgc.core.ui;

import software.ulpgc.core.model.Currency;
import software.ulpgc.core.model.Money;

import java.util.List;

public interface MoneyDialog {
    MoneyDialog define(List<Currency> currencyList);
    CurrencyDialog getCurrencyDialog();
    Money get();
}
