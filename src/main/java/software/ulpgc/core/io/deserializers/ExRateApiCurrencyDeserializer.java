package software.ulpgc.core.io;

import software.ulpgc.core.io.pojos.CurrencyGetResponse;
import com.google.gson.Gson;

public class ExRateApiCurrencyDeserializer implements CurrencyDeserializer {

    @Override
    public Object deserialize(String currencyJsonResponse) {
        System.out.println(currencyJsonResponse);
        return new Gson().fromJson(currencyJsonResponse, CurrencyGetResponse.class);
    }
}
