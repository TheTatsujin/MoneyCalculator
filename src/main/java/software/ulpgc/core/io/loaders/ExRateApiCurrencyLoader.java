package software.ulpgc.core.io;

import software.ulpgc.core.model.Currency;

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
        return adapter.adapt(deserializer.deserialize(reader.read()));
    }
}