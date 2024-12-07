package software.ulpgc.core.model;

public record Currency (String code, String name) {
    public static Currency ofDefault() { return  new Currency("EUR", "Euro"); }

    public static Currency Null() { return  new Currency("Error", "No Data Available"); }

    @Override
    public String toString() {
        return code + ": " + name;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Currency other)) return false;
        return other.code.equals(this.code) && other.name.equals(this.name);
    }
}
