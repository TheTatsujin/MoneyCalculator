package software.ulpgc.swingApp;

import software.ulpgc.core.commands.Command;
import software.ulpgc.core.ui.MoneyDialog;
import software.ulpgc.core.ui.CurrencyDialog;
import software.ulpgc.core.ui.MoneyDisplay;
import software.ulpgc.swingApp.dialogs.SwingCurrencyDialog;
import software.ulpgc.swingApp.dialogs.SwingMoneyDialog;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class SwingMainFrame extends JFrame {
    private final Map<String, Command> commands = new HashMap<>();
    private CurrencyDialog currencyDialog;
    private MoneyDialog moneyDialog;
    private MoneyDisplay moneyDisplay;

    public SwingMainFrame() {
        this.setTitle("Money Calculator");
        this.setSize(800, 800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridBagConstraints gridConstraint = initializeLayout();
        gridConstraint.gridx = 0;
        gridConstraint.gridy = 0;
        gridConstraint.fill = GridBagConstraints.HORIZONTAL;

        this.add(newMoneyDialog(), gridConstraint);

        gridConstraint.gridx = 2;
        this.add(newSwitchButton(), gridConstraint);

        gridConstraint.gridx = 3;
        this.add(newCurrencyDialog(), gridConstraint);


        gridConstraint.gridx = 4;
        this.add(newToolbar(), gridConstraint);

        gridConstraint.gridx = 2;
        gridConstraint.gridy = 4;
        this.add(newMoneyDisplay(), gridConstraint);
    }

    private GridBagConstraints initializeLayout(){
        this.setLayout(new GridBagLayout());
        return new GridBagConstraints();
    }

    public SwingMainFrame put(String name, Command command){
       this.commands.put(name, command);
       return this;
    }

    public CurrencyDialog getCurrencyDialog() {
        return currencyDialog;
    }

    public MoneyDialog getMoneyDialog() {
        return moneyDialog;
    }

    public MoneyDisplay getMoneyDisplay() {
        return moneyDisplay;
    }

    private Component newToolbar() {
        JButton exchangeButton = new JButton("Exchange");
        exchangeButton.addActionListener(ev -> commands.get("exchange").execute());
        return exchangeButton;
    }

    private Component newSwitchButton() {
        JButton switchButton = new JButton("↔");
        switchButton.addActionListener(e -> {
            commands.get("inverse").execute();
            commands.get("exchange").execute();
        });
        return switchButton;
    }

    private Component newMoneyDisplay() {
        SwingMoneyDisplay display = new SwingMoneyDisplay();
        this.moneyDisplay = display;
        return display;
    }

    private Component newMoneyDialog() {
        SwingMoneyDialog dialog = new SwingMoneyDialog();
        this.moneyDialog = dialog;
        return dialog;
    }

    private Component newCurrencyDialog() {
        SwingCurrencyDialog dialog = new SwingCurrencyDialog();
        this.currencyDialog = dialog;
        return dialog;
    }

    public SwingMainFrame resetValues(){
        commands.get("set-default").execute();
        return this;
    }

}
