package software.ulpgc.swingApp.dialogs;

import software.ulpgc.core.model.Currency;
import software.ulpgc.core.ui.CurrencyDialog;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SwingCurrencyDialog extends JPanel implements CurrencyDialog {

    private JComboBox<Currency> currencySelector;


    public SwingCurrencyDialog() {
        currencySelector = new JComboBox<>();
    }

    @Override
    public CurrencyDialog define(List<Currency> currencyList) {
        add(newCurrencySelector(currencyList));
        return this;
    }

    @Override
    public void setValue(Currency currency) {
        this.currencySelector.setSelectedItem(currency);
    }

    @Override
    public Currency get() {
        return currencySelector.getItemAt(currencySelector.getSelectedIndex());
    }


    private Component newCurrencySelector(List<Currency> currencyList) {
        JComboBox<Currency> currencySelector = new JComboBox<>();
        currencyList.forEach(currencySelector::addItem);
        this.currencySelector = currencySelector;
        return currencySelector;
    }
}
