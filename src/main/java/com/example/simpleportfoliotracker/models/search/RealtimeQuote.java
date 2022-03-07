package com.example.simpleportfoliotracker.models.search;

import com.google.gson.Gson;

import java.util.logging.Logger;

public class RealtimeQuote {
    String symbol, name, exchange, currency, datatime,
            open, close, volume, previous_close,
            percent_change, url;

    FiftyTwoWk fifty_two_week;

    private static final Logger logger = Logger.getLogger(RealtimeQuote.class.getName());

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

    public String getExchange() {
        return exchange;
    }
    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDatatime() {
        return datatime;
    }
    public void setDatatime(String datatime) {
        this.datatime = datatime;
    }

    public String getOpen() {
        return open;
    }
    public void setOpen(String open) {
        this.open = open;
    }

    public String getClose() {
        return close;
    }
    public void setClose(String close) {
        this.close = close;
    }

    public String getVolume() {
        return volume;
    }
    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getPrevious_close() {
        return previous_close;
    }
    public void setPrevious_close(String previous_close) {
        this.previous_close = previous_close;
    }

    public String getPercent_change() {
        return percent_change;
    }
    public void setPercent_change(String percent_change) {
        this.percent_change = percent_change;
    }

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public FiftyTwoWk getFifty_two_week() {
        return fifty_two_week;
    }
    public void setFifty_two_week(FiftyTwoWk fifty_two_week) {
        this.fifty_two_week = fifty_two_week;
    }

    public static RealtimeQuote getQuote(String s, String url) {
        Gson gson = new Gson();
        RealtimeQuote quote = gson.fromJson(s, RealtimeQuote.class);
        quote.setUrl(url);
        return quote;
    }

    @Override
    public String toString() {
        return "RealtimeQuote{" +
                "symbol='" + symbol + '\'' +
                ", name='" + name + '\'' +
                ", exchange='" + exchange + '\'' +
                ", currency='" + currency + '\'' +
                ", datatime='" + datatime + '\'' +
                ", open='" + open + '\'' +
                ", close='" + close + '\'' +
                ", volume='" + volume + '\'' +
                ", previous_close='" + previous_close + '\'' +
                ", percent_change='" + percent_change + '\'' +
                ", url='" + url + '\'' +
                ", fifty_two_week=" + fifty_two_week +
                '}';
    }
}
