package com.example.simpleportfoliotracker.models;

public class AddNewSymbol {
    String symbol;
    int quantity;
    float unit_price;

    public String getSymbol() {
        return symbol;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(float unit_price) {
        this.unit_price = unit_price;
    }

    public AddNewSymbol(String symbol, int quantity, int unit_price) {
        this.symbol = symbol;
        this.quantity = quantity;
        this.unit_price = unit_price;
    }

    @Override
    public String toString() {
        return "AddNewSymbol{" +
                "symbol='" + symbol + '\'' +
                ", quantity=" + quantity +
                ", unit_price=" + unit_price +
                '}';
    }
}
