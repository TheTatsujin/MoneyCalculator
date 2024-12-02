package software.ulpgc.model;

public record ExchangeRate (Money to, Money from, double rate) {
}
