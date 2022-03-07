package com.example.simpleportfoliotracker.services;


import com.example.simpleportfoliotracker.models.AddNewSymbol;
import com.example.simpleportfoliotracker.models.entity.PortfolioModel;
import com.example.simpleportfoliotracker.repositories.PortfolioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PortfolioService {

    @Autowired
    private PortfolioRepo portfolioRepo;

    @Autowired
    private HomeService homeService;

    private Logger logger = Logger.getLogger(PortfolioService.class.getName());

    // get the whole portfolio
    public List<PortfolioModel> getPortfolio(String username) {
        return portfolioRepo.findByUsername(username);
    }

    // check if symbol already exist in user portfolio
    public List<PortfolioModel> addNewSymbolToPortfolio(AddNewSymbol addNewSymbol, String username) {
//        if (!portfolioRepo.findByUsernameAndSymbol(username, addNewSymbol.getSymbol()).isPresent()) {
        if (!portfolioRepo.findAllBySymbol(addNewSymbol.getSymbol()).isPresent()) {
            logger.info("Finding all symbol");
            addNewSymbol(addNewSymbol, username);

            return getPortfolio(username);
        } else {
            addExistedSymbol(addNewSymbol, username);
            return getPortfolio(username);
        }
    }

    public PortfolioModel getSymbolByUsernameAndSymbol(String username, String symbol) {
        return portfolioRepo.findByUsernameAndSymbol(username, symbol)
                .orElseThrow(() -> new RuntimeException(String.format("Symbol with username '%' is not found", username)));
    }


    public void deleteSymbol(Long id) {
        portfolioRepo.deleteById(id);
    }

    public void addNewSymbol(AddNewSymbol addNewSymbol, String username) {
        PortfolioModel newSymbol = new PortfolioModel();
        newSymbol.setSymbol(addNewSymbol.getSymbol());
        newSymbol.setUsername(username);
        newSymbol.setQuantity(addNewSymbol.getQuantity());
        newSymbol.setUnit_price(addNewSymbol.getUnit_price());
        portfolioRepo.save(newSymbol);
        System.out.println("New symbol added");
    }

    public void addExistedSymbol(AddNewSymbol addNewSymbol, String username) {
        PortfolioModel existedSymbol = portfolioRepo.findBySymbol(addNewSymbol.getSymbol());
        float updatedUnitPrice =
                ((addNewSymbol.getUnit_price() * addNewSymbol.getQuantity()) +
                        (existedSymbol.getUnit_price() * existedSymbol.getQuantity()))
                / (addNewSymbol.getQuantity() + existedSymbol.getQuantity());

        int updatedQuantity = addNewSymbol.getQuantity() + existedSymbol.getQuantity();


        PortfolioModel updated = new PortfolioModel();
        updated.setId(existedSymbol.getId());
        updated.setSymbol(addNewSymbol.getSymbol());
        updated.setUsername(username);
        updated.setQuantity(updatedQuantity);
        updated.setUnit_price(updatedUnitPrice);
        portfolioRepo.save(updated);
        System.out.println("Existed symbol updated");
    }



 }
