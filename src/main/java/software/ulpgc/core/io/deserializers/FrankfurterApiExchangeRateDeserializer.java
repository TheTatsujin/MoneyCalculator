package software.ulpgc.core.io.deserializers;

import com.google.gson.Gson;
import software.ulpgc.core.io.pojos.ExchangeRateGetResponse;

public class FrankfurterApiExchangeRateDeserializer implements ExchangeRateDeserializer {
    @Override
    public Object deserialize(String jsonResponse) {
        return new Gson().fromJson(jsonResponse, ExchangeRateGetResponse.class);
    }
}
