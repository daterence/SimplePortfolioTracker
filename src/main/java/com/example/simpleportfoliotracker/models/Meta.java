package com.example.simpleportfoliotracker.models;

import java.util.Arrays;

public class Meta {
    String symbol, name, currency, exchange, exchange_timezone, type;
    TimeSeriesValue[] values;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getExchange_timezone() {
        return exchange_timezone;
    }
    public void setExchange_timezone(String exchange_timezone) {
        this.exchange_timezone = exchange_timezone;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Meta{" +
                "symbol='" + symbol + '\'' +
                ", name='" + name + '\'' +
                ", currency='" + currency + '\'' +
                ", exchange='" + exchange + '\'' +
                ", exchange_timezone='" + exchange_timezone + '\'' +
                ", type='" + type + '\'' +
                ", values=" + Arrays.toString(values) +
                '}';
    }

}
