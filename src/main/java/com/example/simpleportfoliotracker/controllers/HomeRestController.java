package com.example.simpleportfoliotracker.controllers;

import com.example.simpleportfoliotracker.models.TimeSeries;
import com.example.simpleportfoliotracker.models.search.RealtimeQuote;
import com.example.simpleportfoliotracker.models.suggestion.SuggestionDetails;
import com.example.simpleportfoliotracker.services.HomeService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

// for non-login user
@RestController
@RequestMapping(path = "/api/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class HomeRestController {
    private final Logger logger = Logger.getLogger(HomeRestController.class.getName());

    Gson gson = new Gson();

    @Autowired
    private HomeService homeSvc;

    // /api/v1?query=aa
    @GetMapping
    public ResponseEntity<String> getSuggestion(@RequestParam String query) {
        logger.info("Query >> " + query);
        SuggestionDetails[] sdArr = this.homeSvc.getSuggestion(query);
        String result = gson.toJson(sdArr);
        logger.info("suggestion > " + result);
        return ResponseEntity.ok(result);
    }

    // api/v1/search?symbol=btc/usd
    @GetMapping(path = "/search/{symbol}")
    public ResponseEntity<String> getRealtimeQuote(@PathVariable String symbol) {
        logger.info("symbol search >> " + symbol);
        RealtimeQuote quote = this.homeSvc.getRealTime(symbol);
        String result = gson.toJson(quote);
        logger.info("search >> " + result);
        return ResponseEntity.ok(result);
    }

    // api/v1/home
    @GetMapping(path = "home")
    public ResponseEntity<String> getIndicesData() {
        List<String> list = new LinkedList<>();
        List<String> indicesList = Arrays.asList("DJI", "IXIC", "GSPC", "BTC/USD", "EUR/USD", "FTSE");

        for (String s: indicesList) {
            TimeSeries ts = this.homeSvc.getTimeSeries(s);
            list.add(gson.toJson(ts));
        }
        return ResponseEntity.ok(list.toString());
    }


}
