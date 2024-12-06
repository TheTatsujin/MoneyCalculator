package software.ulpgc.core.commands;

import software.ulpgc.core.model.Currency;
import software.ulpgc.core.ui.CurrencyDialog;
import software.ulpgc.core.ui.MoneyDialog;

public class SwitchCurrenciesCommand implements Command {
    private final CurrencyDialog currencyDialog;
    private final MoneyDialog moneyDialog;

    public SwitchCurrenciesCommand(MoneyDialog moneyDialog, CurrencyDialog currencyDialog) {
        this.currencyDialog = currencyDialog;
        this.moneyDialog = moneyDialog;
    }

    @Override
    public void execute() {
        Currency from = moneyDialog.getCurrencyDialog().get();
        Currency to = currencyDialog.get();

        moneyDialog.getCurrencyDialog().setValue(to);
        currencyDialog.setValue(from);
    }
}
