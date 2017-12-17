package se.kth.id1212.currencyConverter.server.controller;

import se.kth.id1212.currencyConverter.server.integration.CurrencyDAO;
import se.kth.id1212.currencyConverter.server.model.CurrencyDTO;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 * Created by Robin on 2017-12-13.
 */
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@Stateless
public class Controller {
    @EJB
    CurrencyDAO currencyDAO;

    public CurrencyDTO getCurrency(String currencyName) {
        return currencyDAO.findCurrencyByName(currencyName);
    }
}
