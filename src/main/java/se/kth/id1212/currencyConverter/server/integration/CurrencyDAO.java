package se.kth.id1212.currencyConverter.server.integration;

import se.kth.id1212.currencyConverter.server.model.Currency;
import se.kth.id1212.currencyConverter.server.model.CurrencyDTO;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

/**
 * Created by Robin on 2017-12-13.
 */
@TransactionAttribute(TransactionAttributeType.MANDATORY)
@Stateless
public class CurrencyDAO {
    @PersistenceContext(unitName = "currencyPU")
    private EntityManager em;

    public CurrencyDTO findCurrencyByName(String currencyName) {
            Currency currency = em.find(Currency.class, currencyName);
            if (currency == null) {
                throw new EntityNotFoundException("No currency found for: " + currencyName);
            }

            return currency;
    }

    public void storeCurrency(Currency currency) {
        em.persist(currency);
    }
}
