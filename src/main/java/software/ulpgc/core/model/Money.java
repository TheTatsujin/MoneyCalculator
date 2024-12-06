package software.ulpgc.core.model;

public record Money(long amount, Currency currency) {
    public static Money Null(Currency currency) {return new Money(0, currency);}
    @Override
    public String toString() {
        return String.valueOf(amount);
    }
}
