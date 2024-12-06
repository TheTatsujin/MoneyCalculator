package software.ulpgc.core.io.readers;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import software.ulpgc.core.model.Currency;

import java.io.IOException;

public class FrankfurterApiExchangeRateReader implements ExchangeRateReader {
    private static final String url = "https://api.frankfurter.dev/v1/latest";


    public FrankfurterApiExchangeRateReader() {
    }

    @Override
    public String read(Currency from, Currency to) {
        try {
            return readApi(from, to);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String getExchangeEndpointURL(Currency from, Currency to) {
        return url + "?base=" + from.code() + "&symbols=" + to.code();
    }

    private String readApi(Currency from, Currency to) throws IOException {
        Connection.Response response = Jsoup.connect(getExchangeEndpointURL(from, to))
                .ignoreContentType(true)
                .header("accept", "text/*")
                .method(Connection.Method.GET)
                .execute();
        if (response.statusCode() != 200) throw new RuntimeException("Error Reading");
        return response.body();
    }
}

