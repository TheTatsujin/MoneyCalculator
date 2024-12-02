package software.ulpgc.core.io.pojos;

import software.ulpgc.core.model.Currency;

import java.util.List;

public record CurrencyGetResponse(List<Currency> currencies) {
}
