package se.kth.id1212.currencyConverter.server.model;

import java.io.Serializable;

/**
 * Created by Robin on 2017-12-13.
 */
public interface CurrencyDTO extends Serializable {
    String getName();
    double getRate();
}
