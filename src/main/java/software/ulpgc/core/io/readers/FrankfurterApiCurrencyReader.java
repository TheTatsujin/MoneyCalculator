package software.ulpgc.core.io.readers;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;

public class FrankfurterApiCurrencyReader implements CurrencyReader {
    private static final String currencyEndpointURL = "https://api.frankfurter.dev/v1/currencies";

    public FrankfurterApiCurrencyReader() {
    }

    @Override
    public String read() {
        try {
            return readApi();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private String readApi() throws IOException {
        Connection.Response response = Jsoup.connect(currencyEndpointURL)
                .ignoreContentType(true)
                .header("accept", "text/*")
                .method(Connection.Method.GET)
                .execute();
        if (response.statusCode() != 200) throw new RuntimeException("Error Reading");
        return response.body();
    }
}
