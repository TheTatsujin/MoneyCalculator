package software.ulpgc.core.io.loaders;

import software.ulpgc.core.io.adapters.CurrencyAdapter;
import software.ulpgc.core.io.deserializers.CurrencyDeserializer;
import software.ulpgc.core.io.readers.CurrencyReader;
import software.ulpgc.core.model.Currency;

import java.io.IOException;
import java.util.List;

public class ExRateApiCurrencyLoader implements CurrencyLoader {
    private final CurrencyReader reader;
    private final CurrencyDeserializer deserializer;
    private final CurrencyAdapter adapter;

    public ExRateApiCurrencyLoader(CurrencyReader reader, CurrencyDeserializer deserializer, CurrencyAdapter adapter) {
        this.reader = reader;
        this.deserializer = deserializer;
        this.adapter = adapter;
    }

    @Override
    public List<Currency> load() {
        try {
            return adapter.adapt(deserializer.deserialize(reader.read()));
        }
        catch (RuntimeException e) {
            return List.of(Currency.);
        }
    }
}
