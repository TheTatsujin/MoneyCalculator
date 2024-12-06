package software.ulpgc.core.io.loaders;

import software.ulpgc.core.model.Currency;

import java.util.List;

public interface CurrencyLoader {
    List<Currency> load();
}
