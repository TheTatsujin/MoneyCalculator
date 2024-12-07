package software.ulpgc.swingApp;

import software.ulpgc.core.model.Money;
import software.ulpgc.core.ui.MoneyDisplay;

import javax.swing.*;

public class SwingMoneyDisplay extends JLabel implements MoneyDisplay {
    @Override
    public void show(Money money) {
        this.setText(money.toString());
    }

    @Override
    public void showError(String message) {
        this.setText(message);
    }
}
