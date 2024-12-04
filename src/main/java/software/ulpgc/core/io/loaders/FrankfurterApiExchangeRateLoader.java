package software.ulpgc.core.io.loaders;

import software.ulpgc.core.io.adapters.ExchangeRateAdapter;
import software.ulpgc.core.io.deserializers.ExchangeRateDeserializer;
import software.ulpgc.core.io.readers.ExchangeRateReader;
import software.ulpgc.core.model.Currency;
import software.ulpgc.core.model.ExchangeRate;

public class RatesDbApiExchangeRateLoader implements ExchangeRateLoader {

    private final ExchangeRateReader reader;
    private final ExchangeRateDeserializer deserializer;
    private final ExchangeRateAdapter adapter;

    public RatesDbApiExchangeRateLoader(ExchangeRateReader reader, ExchangeRateDeserializer deserializer, ExchangeRateAdapter adapter) {
        this.reader = reader;
        this.deserializer = deserializer;
        this.adapter = adapter;
    }

    @Override
    public ExchangeRate load(Currency from, Currency to) {
        return adapter.adapt(from, to, deserializer.deserialize(reader.read(from, to)));
    }
}