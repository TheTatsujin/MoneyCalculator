package software.ulpgc.core.io.deserializers;

import com.google.gson.Gson;

import java.util.Map;

public class FrankfurterApiCurrencyDeserializer implements CurrencyDeserializer {

    @Override
    public Object deserialize(String currencyJsonResponse) {
        return new Gson().fromJson(currencyJsonResponse, Map.class);
    }
}
