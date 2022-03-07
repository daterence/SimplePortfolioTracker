package com.example.simpleportfoliotracker.controllers;

import com.example.simpleportfoliotracker.models.AddNewSymbol;
import com.example.simpleportfoliotracker.models.ChartData;
import com.example.simpleportfoliotracker.models.entity.PortfolioModel;
import com.example.simpleportfoliotracker.models.search.GetPortfolio;
import com.example.simpleportfoliotracker.services.HomeService;
import com.example.simpleportfoliotracker.services.PortfolioService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sound.sampled.Port;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(path = "/api/v1/{username}/portfolio", produces = MediaType.APPLICATION_JSON_VALUE)
public class PortfolioRestController {

    Gson gson = new Gson();
    private Logger logger = Logger.getLogger(PortfolioRestController.class.getName());

    @Autowired
    private PortfolioService portfolioSvc;

    @Autowired
    private HomeService homeSvc;

    @GetMapping
    public ResponseEntity<String> getPortfolio(@PathVariable String username) {
        System.out.println("Getting portfolio");
        System.out.println(username);
        List<PortfolioModel> portfolioModelList =  portfolioSvc.getPortfolio(username);
        List<GetPortfolio> current = new LinkedList<>();

        for (PortfolioModel portfolio: portfolioModelList) {
            float price = homeSvc.getCurrentPrice(portfolio.getSymbol());
            GetPortfolio getPortfolio = new GetPortfolio();
            getPortfolio.setId(portfolio.getId());
            getPortfolio.setSymbol(portfolio.getSymbol());
            getPortfolio.setQuantity(portfolio.getQuantity());
            getPortfolio.setUnit_price(portfolio.getUnit_price());
            getPortfolio.setPrice(price);
            getPortfolio.setTotal(portfolio.getUnit_price()*portfolio.getQuantity());
            current.add(getPortfolio);
        }

        String result = gson.toJson(current);
        return ResponseEntity.ok(result);
    }

    @GetMapping(path = "chart")
    public ResponseEntity<String> getPortfolioData(@PathVariable String username) {
        List<ChartData> cleanDataList = new ArrayList<>();
        List<PortfolioModel> portfolioModelList =  portfolioSvc.getPortfolio(username);

        for (PortfolioModel portfolio: portfolioModelList) {
            ChartData cd = new ChartData();
            cd.setSymbol(portfolio.getSymbol());
            cd.setTotal(portfolio.getUnit_price()*portfolio.getQuantity());
            cleanDataList.add(cd);
        }
        String result = gson.toJson(cleanDataList);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<String> addSymbol(@RequestBody AddNewSymbol symbol,
                            @PathVariable String username) {
        logger.info("SYMBOL RECEIVED " + symbol.getSymbol());
//        logger.info("SYMBOL RECEIVED " + symbol.getQuantity());
//        logger.info("SYMBOL RECEIVED " + symbol.getUnit_price());
        List<GetPortfolio> current1 = new LinkedList<>();
        List<PortfolioModel> portfolioModelList = portfolioSvc.addNewSymbolToPortfolio(symbol, username);

        for (PortfolioModel portfolio: portfolioModelList) {
            float price = homeSvc.getCurrentPrice(portfolio.getSymbol());
            GetPortfolio getPortfolio = new GetPortfolio();
            getPortfolio.setId(portfolio.getId());
            getPortfolio.setSymbol(portfolio.getSymbol());
            getPortfolio.setQuantity(portfolio.getQuantity());
            getPortfolio.setPrice(price);
            current1.add(getPortfolio);
        }

        String result = gson.toJson(current1);

        return ResponseEntity.ok(result);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteSymbol(@PathVariable String username,
                                               @RequestParam String symbol){
        PortfolioModel delete = portfolioSvc.getSymbolByUsernameAndSymbol(username, symbol);
        portfolioSvc.deleteSymbol(delete.getId());

        List<PortfolioModel> portfolioModelList =  portfolioSvc.getPortfolio(username);

        String result = gson.toJson(portfolioModelList);

        return ResponseEntity.ok(result);
    }
}
