package com.example.simpleportfoliotracker.models.search;

import com.google.gson.Gson;

public class GetPortfolio {
//    PortfolioModel portfolioModel;
    private Long id;
    private String symbol;
    private String username;
    private int quantity;
    private float unit_price;
    float price, total;

    public float getTotal() {
        return total;
    }
    public void setTotal(float total) {
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "GetPortfolio{" +
                "id=" + id +
                ", symbol='" + symbol + '\'' +
                ", username='" + username + '\'' +
                ", quantity=" + quantity +
                ", unit_price=" + unit_price +
                ", price=" + price +
                ", total=" + total +
                '}';
    }

    public static float getCurrentPrice(String s) {
        Gson gson = new Gson();
        GetPortfolio cp = gson.fromJson(s, GetPortfolio.class);
        return cp.price;
    }
}
