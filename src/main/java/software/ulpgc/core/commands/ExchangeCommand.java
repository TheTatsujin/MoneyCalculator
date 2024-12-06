package software.ulpgc.core.commands;


import software.ulpgc.core.io.loaders.ExchangeRateLoader;
import software.ulpgc.core.ui.CurrencyDialog;
import software.ulpgc.core.ui.MoneyDialog;
import software.ulpgc.core.ui.MoneyDisplay;

import software.ulpgc.core.model.*;

import java.util.HashMap;
import java.util.Map;


public class ExchangeCommand implements Command {
    private final MoneyDialog moneyDialog;
    private final CurrencyDialog currencyDialog;
    private final ExchangeRateLoader exchangeRateLoader;
    private final MoneyDisplay moneyDisplay;

    private final Map<Integer, ExchangeRate> ratesMemory;

    public ExchangeCommand(MoneyDialog moneyDialog, CurrencyDialog currencyDialog, ExchangeRateLoader exchangeRateLoader, MoneyDisplay moneyDisplay) {
        this.ratesMemory = new HashMap<>();
        this.moneyDialog = moneyDialog;
        this.currencyDialog = currencyDialog;
        this.exchangeRateLoader = exchangeRateLoader;
        this.moneyDisplay = moneyDisplay;
    }

    @Override
    public void execute() {
        Money result = new Money(
                calculateExchange(moneyDialog.get(), currencyDialog.get()),
                currencyDialog.get()
        );

        moneyDisplay.show(result);
    }

    private long calculateExchange(Money money, Currency to) {
        if (money.currency().equals(to) || money.amount() == 0) return money.amount();
        return (long) (money.amount() * fetchExchangeRate(money, to).rate());
    }

    private ExchangeRate fetchExchangeRate(Money money, Currency currency) {
        ExchangeRate fetched = ratesMemory.computeIfAbsent(getExchangeKey(money.currency(), currency),
                key -> exchangeRateLoader.load(money.currency(), currency));

        ratesMemory.putIfAbsent(getExchangeKey(currency, money.currency()), fetched.inverse());
        return fetched;
    }

    private int getExchangeKey(Currency from, Currency to) {
        return ExchangeRate.key(from, to);
    }
}
