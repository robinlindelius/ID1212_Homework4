package se.kth.id1212.currencyConverter.server.view;

import se.kth.id1212.currencyConverter.server.controller.Controller;
import se.kth.id1212.currencyConverter.server.model.CurrencyDTO;

import javax.ejb.EJB;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by Robin on 2017-12-14.
 */
@Named("currencyManager")
@SessionScoped
public class CurrencyManager implements Serializable {
    @EJB
    private Controller controller;
    private CurrencyDTO fromCurrency;
    private CurrencyDTO toCurrency;
    private String fromCurrencyName;
    private String toCurrencyName;
    private String currencyAmount;
    private double conversionRate;
    private double convertedValue;
    private boolean converted;

    public boolean isConverted() {
        return converted;
    }

    public void setConverted(boolean converted) {
        this.converted = converted;
    }

    public CurrencyDTO getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(CurrencyDTO fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public CurrencyDTO getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(CurrencyDTO toCurrency) {
        this.toCurrency = toCurrency;
    }

    public String getFromCurrencyName() {
        return fromCurrencyName;
    }

    public void setFromCurrencyName(String fromCurrencyName) {
        this.fromCurrencyName = fromCurrencyName.toUpperCase();
    }

    public String getToCurrencyName() {
        return toCurrencyName;
    }

    public void setToCurrencyName(String toCurrencyName) {
        this.toCurrencyName = toCurrencyName.toUpperCase();
    }

    public String getCurrencyAmount() {
        return currencyAmount;
    }

    public void setCurrencyAmount(String currencyAmount) {
        this.currencyAmount = currencyAmount;
    }

    public double getConvertedValue() {
        return convertedValue;
    }

    public void setConvertedValue(double convertedValue) {
        this.convertedValue = convertedValue;
    }

    public double getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(double conversionRate) {
        this.conversionRate = conversionRate;
    }

    public void convertCurrency() {
        if (!fromCurrencyName.equals("") && !toCurrencyName.equals("")) {
            converted = true;
            fromCurrency = controller.getCurrency(fromCurrencyName);
            toCurrency = controller.getCurrency(toCurrencyName);
            conversionRate = fromCurrency.getRate() / toCurrency.getRate();
            convertedValue = Double.valueOf(currencyAmount) * conversionRate;
        }
    }
}
