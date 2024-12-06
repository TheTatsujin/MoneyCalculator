package software.ulpgc.swingApp;

import software.ulpgc.core.commands.*;
import software.ulpgc.core.io.adapters.*;
import software.ulpgc.core.io.readers.*;
import software.ulpgc.core.io.deserializers.*;
import software.ulpgc.core.io.loaders.*;
import software.ulpgc.core.model.Currency;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // TODO:
        //  Catch 'Number too long' Exception
        //  Catch 'No Internet Connection' Exception


        CurrencyLoader currencyLoader = getCurrencyLoader();
        List<Currency> currencies = currencyLoader.load();

        SwingMainFrame mainframe = new SwingMainFrame();
        mainframe
                .put("exchange", getExchangeCommand(mainframe, currencies))
                .put("inverse", getSwitchCurrenciesCommand(mainframe))
                .put("set-default", getDefaultCurrencyCommand(mainframe, Currency.ofDefault()))
                .resetValues()
                .setVisible(true);
    }

    private static Command getSwitchCurrenciesCommand(SwingMainFrame mainframe) {
        return new SwitchCurrenciesCommand(
                mainframe.getMoneyDialog(),
                mainframe.getCurrencyDialog()
        );
    }

    public static Command getExchangeCommand(SwingMainFrame mainFrame, List<Currency> currencies) {
        return new ExchangeCommand(
                mainFrame.getMoneyDialog().define(currencies),
                mainFrame.getCurrencyDialog().define(currencies),
                getExchangeRateLoader(),
                mainFrame.getMoneyDisplay()

        );
    }

    private static Command getDefaultCurrencyCommand(SwingMainFrame mainFrame, Currency defaultCurrency) {
        SetDefaultCurrencyCommand.defaultCurrency = defaultCurrency;
        return new SetDefaultCurrencyCommand(
                mainFrame.getMoneyDialog(),
                mainFrame.getCurrencyDialog()
        );
    }


    public static ExchangeRateLoader getExchangeRateLoader() {
        return new FrankfurterApiExchangeRateLoader(
                new FrankfurterApiExchangeRateReader(),
                new FrankfurterApiExchangeRateDeserializer(),
                new FrankfurterApiExchangeRateAdapter()
        );
    }
    public static CurrencyLoader getCurrencyLoader() {
        return new ExRateApiCurrencyLoader(
                new FrankfurterApiCurrencyReader(),
                new FrankfurterApiCurrencyDeserializer(),
                new FrankfurterApiCurrencyAdapter()
        );
    }

}
