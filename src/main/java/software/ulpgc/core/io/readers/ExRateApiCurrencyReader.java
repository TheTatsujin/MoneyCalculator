package software.ulpgc.core.io;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;

public class ExRateApiCurrencyReader implements CurrencyReader {
    private static final String url = "https://api.exchangeratesapi.io/v1/symbols?access_key=";
    private final String apiEndpointUrl;


    public ExRateApiCurrencyReader(String apiKey) {
        this.apiEndpointUrl = ExRateApiCurrencyReader.url + apiKey;
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
        Connection.Response response = Jsoup.connect(apiEndpointUrl)
                .ignoreContentType(true)
                .header("accept", "text/*")
                .method(Connection.Method.GET)
                .execute();
        if (response.statusCode() != 200) throw new RuntimeException("Error Reading");
        return response.body();
    }
}
