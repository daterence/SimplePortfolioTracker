package com.example.simpleportfoliotracker.services;

import com.example.simpleportfoliotracker.models.Logo;
//import com.example.simpleportfoliotracker.models.SymbolProfileModel;
import com.example.simpleportfoliotracker.models.TimeSeries;
import com.example.simpleportfoliotracker.models.search.GetPortfolio;
import com.example.simpleportfoliotracker.models.search.RealtimeQuote;
import com.example.simpleportfoliotracker.models.suggestion.SuggestionDetails;
import com.example.simpleportfoliotracker.models.suggestion.SuggestionResult;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Objects;
import java.util.logging.Logger;

@Service
public class HomeService {
    // this service is for api that does not require user to login

    public static final String URL_TWELVE_API = "https://api.twelvedata.com";
    public static final String ENV_TWELVE_KEY = "TWELVE_KEY";

    private final Logger logger = Logger.getLogger(HomeService.class.getName());

    private String key;

    public HomeService() {
        key = System.getenv(ENV_TWELVE_KEY);
        if (Objects.isNull(key)) {
            logger.warning("%s key is not set".formatted(ENV_TWELVE_KEY));
        }
    }

    // auto suggest query search
    public SuggestionDetails[] getSuggestion(String query) {
        final String url = UriComponentsBuilder
                .fromUriString(URL_TWELVE_API + "/symbol_search")
                .queryParam("symbol", query)
                .queryParam("outputsize", 20)
                .toUriString();
        logger.info("URL >> " + url);

        final RequestEntity<Void> request = RequestEntity.get(url).build();
        final RestTemplate template = new RestTemplate();
        final ResponseEntity<String> response = template.exchange(request, String.class);

        return SuggestionResult.getSuggestion(response.getBody());
    }

    // get symbol logo
    public String getLogo(String symbol) {
        final String url = UriComponentsBuilder
                .fromUriString(URL_TWELVE_API + "/logo")
                .queryParam("symbol", symbol)
                .queryParam("apikey", key)
                .toUriString();
        final RequestEntity<Void> request = RequestEntity.get(url).build();
        final RestTemplate template = new RestTemplate();
        final ResponseEntity<String> response = template.exchange(request, String.class);
        return Logo.getLogo(response.getBody());
    }

    // search for real-time quote
    public RealtimeQuote getRealTime(String symbol) {
        String logoUrl = getLogo(symbol);
        logger.info("URL >> " + logoUrl);
        final String quoteUrl = UriComponentsBuilder
                .fromUriString(URL_TWELVE_API + "/quote")
                .queryParam("symbol", symbol)
                .queryParam("apikey", key)
                .toUriString();
        final RequestEntity<Void> request = RequestEntity.get(quoteUrl).build();
        final RestTemplate template = new RestTemplate();
        final ResponseEntity<String> response = template.exchange(request, String.class);
        return RealtimeQuote.getQuote(response.getBody(), logoUrl);
    }


    // search for time-series
    public TimeSeries getTimeSeries(String symbol) {
        final String url = UriComponentsBuilder
                .fromUriString(URL_TWELVE_API + "/time_series")
                .queryParam("symbol", symbol)
                .queryParam("interval", "15min")
                .queryParam("apikey", key)
                .toUriString();

        final RequestEntity<Void> request = RequestEntity.get(url).build();
        final RestTemplate template = new RestTemplate();
        final ResponseEntity<String> response = template.exchange(request, String.class);
        return TimeSeries.getTimeSeries(response.getBody());
    }

    public float getCurrentPrice(String symbol) {
        final String url = UriComponentsBuilder
                .fromUriString(URL_TWELVE_API + "/price")
                .queryParam("symbol", symbol)
                .queryParam("apikey", key)
                .toUriString();
        final RequestEntity<Void> request = RequestEntity.get(url).build();
        final RestTemplate template = new RestTemplate();
        final ResponseEntity<String> response = template.exchange(request, String.class);
        return GetPortfolio.getCurrentPrice(response.getBody());
    }
}
