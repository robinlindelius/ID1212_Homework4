package se.kth.id1212.currencyConverter.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Robin on 2017-12-13.
 */
@Entity
public class Currency implements CurrencyDTO {
    @Id
    private String name;
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private double rate;

    public Currency() {
        name = "";
        rate = 0;
    }

    public Currency(CurrencyDTO currencyDTO) {
        this.name = currencyDTO.getName();
        this.rate = currencyDTO.getRate();
    }

    public String getName() {
        return name;
    }

    public double getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return "Currency: [" + name + ", rate: " + rate + "]";
    }
}
