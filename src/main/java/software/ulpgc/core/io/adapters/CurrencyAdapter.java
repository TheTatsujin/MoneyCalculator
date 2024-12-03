package software.ulpgc.core.io;

import software.ulpgc.core.model.Currency;

import java.util.List;

public interface CurrencyAdapter {
    List<Currency> adapt(Object currency);
}
