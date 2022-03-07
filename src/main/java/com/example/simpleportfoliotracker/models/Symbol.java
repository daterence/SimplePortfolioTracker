//package com.example.simpleportfoliotracker.models;
//
//import com.example.simpleportfoliotracker.models.entity.PortfolioModel;
//import com.google.gson.Gson;
//
//public class Symbol {
//    PortfolioModel symbolInventory;
//    SymbolProfileModel description;
//
//    public PortfolioModel getSymbolInventory() {
//        return symbolInventory;
//    }
//    public void setSymbolInventory(PortfolioModel symbolInventory) {
//        this.symbolInventory = symbolInventory;
//    }
//
//    public SymbolProfileModel getDescription() {
//        return description;
//    }
//    public void setDescription(SymbolProfileModel description) {
//        this.description = description;
//    }
//
//    public static Symbol combine(PortfolioModel pm, SymbolProfileModel sp) {
//        Gson gson = new Gson();
//        Symbol s = new Symbol();
//        s.setSymbolInventory(pm);
//        s.setDescription(sp);
//        return s;
//    }
//}
