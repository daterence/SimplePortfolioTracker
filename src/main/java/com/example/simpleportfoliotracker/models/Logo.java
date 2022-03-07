package com.example.simpleportfoliotracker.models;

import com.google.gson.Gson;

public class Logo {
    String url;

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public static String getLogo(String s) {
        Gson gson = new Gson();
        Logo logo = gson.fromJson(s, Logo.class);
        return logo.url;
    }
}
