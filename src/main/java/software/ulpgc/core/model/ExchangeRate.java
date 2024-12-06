package software.ulpgc.core.model;

public record ExchangeRate (Currency from, Currency to, double rate) {

    public static int key(Currency from, Currency to) {
        return 31*from.name().hashCode() + to.name().hashCode();
    }

    public ExchangeRate inverse() {
        return new ExchangeRate(to, from, 1/rate);
    }

    @Override
    public String toString() {
        return "[" + from.toString() + " -> " + to.toString() + "] = " + rate;
    }

    @Override
    public int hashCode() {
        return ExchangeRate.key(from, to);
    }
}
