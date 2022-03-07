package com.example.simpleportfoliotracker.models.suggestion;

import com.google.gson.Gson;

public class SuggestionResult {

    SuggestionDetails[] data;
    String status;

    public static SuggestionDetails[] getSuggestion(String s) {
        Gson gson = new Gson();
        SuggestionResult suggestionResult = gson.fromJson(s, SuggestionResult.class);

        return suggestionResult.data;
    }
}
