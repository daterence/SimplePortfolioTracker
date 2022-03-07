package com.example.simpleportfoliotracker.models;

public class ChartData {
    String symbol;
    float total;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }


    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public static ChartData getTotal(String s) {
        System.out.println(s);
        return null;
    }

    @Override
    public String toString() {
        return "ChartData{" +
                "symbol='" + symbol + '\'' +
                ", total=" + total +
                '}';
    }
}
