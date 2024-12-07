package software.ulpgc.core.io.readers;

import java.io.IOException;
import java.net.UnknownHostException;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

public class FrankfurterApiCurrencyReader implements CurrencyReader {
    private static final String currencyEndpointURL = "https://api.frankfurter.dev/v1/currencies";

    public FrankfurterApiCurrencyReader() {
    }

    @Override
    public String read() {
        try {
            return readApi();
        }
        catch (UnknownHostException e) {
            throw new RuntimeException("Could not resolve host: " + e.getMessage(), e);
        }
        catch (IOException e) {
            throw new RuntimeException("Error occurred while reading the API: " + e.getMessage(), e);
        }
    }

    private String readApi() throws IOException {
        try {
            Connection.Response response = Jsoup.connect(currencyEndpointURL)
                    .ignoreContentType(true)
                    .header("accept", "text/*")
                    .method(Connection.Method.GET)
                    .execute();

            if (response.statusCode() != 200) {
                throw new RuntimeException("Error Reading: Status Code " + response.statusCode());
            }

            return response.body();
        } catch (UnknownHostException e) {
            throw new UnknownHostException("Error: Unable to resolve the host for the endpoint.");
        }
    }
}
