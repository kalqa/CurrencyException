package com.rpajdak.excercise;

import com.rpajdak.excercise.Model.ResultSet;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/currency")
public class CurrencyController {
    private Map<String, Double> currencies = new HashMap<>();

    public CurrencyController() {
        fillCurrenciesMap();
    }

    private void fillCurrenciesMap() {
        this.currencies.put("PLN", 4.87);
        this.currencies.put("USD", 5.56);
        this.currencies.put("EUR", 4.55);
    }

    @GetMapping(value = "/{currency}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String attempToShowCurrency(@PathVariable("currency") String currency) {
        try {
            if (checkIfCurrencyExists(currency)) {
                return showCurrency(currency).getValue().toString();
            }
        } catch (NoCurrencyException e) {
            return showNoCurrencyExists(currency).getMessage();
        }
        return null;
    }

    private ResultSet showNoCurrencyExists(String currency) {
        return new ResultSet(currency);
    }

    private ResultSet showCurrency(String currency) {
        return new ResultSet(currencies.get(currency), currency);
    }

    private Boolean checkIfCurrencyExists(String currency) throws NoCurrencyException {
        if (currencies.get(currency) != null) {
            return true;
        } else {
            throw new NoCurrencyException(currency);
        }
    }
}
