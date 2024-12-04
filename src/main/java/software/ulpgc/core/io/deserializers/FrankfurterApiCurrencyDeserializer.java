package software.ulpgc.core.io.deserializers;

import software.ulpgc.core.io.pojos.CurrencyGetResponse;
import com.google.gson.Gson;

public class ExRateApiCurrencyDeserializer implements CurrencyDeserializer {

    @Override
    public Object deserialize(String currencyJsonResponse) {
        return new Gson().fromJson(currencyJsonResponse, CurrencyGetResponse.class);
    }
}
