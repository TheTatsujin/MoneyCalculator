package software.ulpgc.swingApp.dialogs;

import software.ulpgc.core.model.Currency;
import software.ulpgc.core.model.Money;
import software.ulpgc.core.ui.CurrencyDialog;
import software.ulpgc.core.ui.MoneyDialog;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SwingMoneyDialog extends JPanel implements MoneyDialog {
    private JTextField moneyField;
    private CurrencyDialog currencyDialog;

    public SwingMoneyDialog() {
        this.setLayout(new FlowLayout());
    }

    @Override
    public MoneyDialog define(List<Currency> currencyList) {
        add(newAmountField());
        add(newCurrencyDialog(currencyList));
        return this;
    }

    public CurrencyDialog getCurrencyDialog() {
        return currencyDialog;
    }

    private Component newCurrencyDialog(List<Currency> currencyList) {
        SwingCurrencyDialog dialog = new SwingCurrencyDialog();
        dialog.define(currencyList);
        this.currencyDialog = dialog;
        return dialog;
    }

    @Override
    public Money get() {
        return new Money(getAmount(), currencyDialog.get());
    }

    private Long getAmount() {
        if (moneyField.getText().isEmpty()) return 0L;
        try {
            return Long.parseLong(moneyField.getText());
        }
        catch (NumberFormatException e) {
            return 0L;
        }
    }

    private Component newAmountField() {
        JTextField amountField = new JTextField();
        amountField.setColumns(5);
        moneyField = amountField;
        return amountField;
    }
}
