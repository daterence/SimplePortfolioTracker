package com.example.simpleportfoliotracker.models.suggestion;

public class SuggestionDetails {
    String symbol, instrument_name, exchange;

    public String getSymbol() {
        return symbol;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getInstrument_name() {
        return instrument_name;
    }
    public void setInstrument_name(String instrument_name) {
        this.instrument_name = instrument_name;
    }

    public String getExchange() {
        return exchange;
    }
    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    @Override
    public String toString() {
        return "SuggestionDetails{" +
                "symbol='" + symbol + '\'' +
                ", instrument_name='" + instrument_name + '\'' +
                ", exchange='" + exchange + '\'' +
                '}';
    }
}
