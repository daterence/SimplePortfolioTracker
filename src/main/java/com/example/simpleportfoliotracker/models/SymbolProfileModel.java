//package com.example.simpleportfoliotracker.models;
//
//import com.google.gson.Gson;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "description")
//public class SymbolProfileModel {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Integer id;
//    private String symbol;
//    private String url; // logo url
//    private String name; // symbol name
//    private String exchange; // exchange name
//    private String industry;
//    private String website; // symbol website url
//
//    public Integer getId() {
//        return id;
//    }
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getSymbol() {
//        return symbol;
//    }
//    public void setSymbol(String symbol) {
//        this.symbol = symbol;
//    }
//
//    public String getUrl() {
//        return url;
//    }
//    public void setUrl(String url) {
//        this.url = url;
//    }
//
//    public String getName() {
//        return name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getExchange() {
//        return exchange;
//    }
//    public void setExchange(String exchange) {
//        this.exchange = exchange;
//    }
//
//    public String getIndustry() {
//        return industry;
//    }
//    public void setIndustry(String industry) {
//        this.industry = industry;
//    }
//
//    public String getWebsite() {
//        return website;
//    }
//    public void setWebsite(String website) {
//        this.website = website;
//    }
//
//    public static SymbolProfileModel getProfile(String s, String url) {
//        Gson gson = new Gson();
//        SymbolProfileModel profile = gson.fromJson(s, SymbolProfileModel.class);
//        profile.setUrl(url);
//        return profile;
//    }
//
//    @Override
//    public String toString() {
//        return "SymbolProfileModel{" +
//                "id=" + id +
//                ", symbol='" + symbol + '\'' +
//                ", url='" + url + '\'' +
//                ", name='" + name + '\'' +
//                ", exchange='" + exchange + '\'' +
//                ", industry='" + industry + '\'' +
//                ", website='" + website + '\'' +
//                '}';
//    }
//}
