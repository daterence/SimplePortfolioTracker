package com.example.simpleportfoliotracker.models.entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.*;

@Entity
@Table(name = "portfolio")
public class PortfolioModel {

    @Id
    @GeneratedValue(
            strategy = IDENTITY
    )
    private Long id;
    private String symbol;
    private String username;
    private int quantity;
    private float unit_price;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

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

}
