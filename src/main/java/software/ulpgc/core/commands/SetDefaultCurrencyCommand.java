package software.ulpgc.core.commands;

import software.ulpgc.core.model.Currency;
import software.ulpgc.core.ui.CurrencyDialog;
import software.ulpgc.core.ui.MoneyDialog;

public class SetDefaultCurrencyCommand implements Command {
    public static Currency defaultCurrency;
    private final MoneyDialog moneyDialog;
    private final CurrencyDialog currencyDialog;

    public SetDefaultCurrencyCommand(MoneyDialog moneyDialog, CurrencyDialog currencyDialog) {
        this.moneyDialog = moneyDialog;
        this.currencyDialog = currencyDialog;
    }

    @Override
    public void execute() {
        moneyDialog.getCurrencyDialog().setValue(defaultCurrency);
        currencyDialog.setValue(defaultCurrency);
    }
}
