package software.ulpgc.core.io.pojos;

import java.util.Map;

public record ExchangeRateGetResponse(int amount, String base, String date, Map<String, Double> rates) {
}
