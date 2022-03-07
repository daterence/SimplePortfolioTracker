package com.example.simpleportfoliotracker.repositories;

import com.example.simpleportfoliotracker.models.entity.PortfolioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PortfolioRepo extends JpaRepository<PortfolioModel, Long> {

    List<PortfolioModel> findByUsername(String username);

    Optional<PortfolioModel> findAllBySymbol(String symbol);

    PortfolioModel findBySymbol(String symbol);

    Optional<PortfolioModel> findByUsernameAndSymbol(String username, String symbol);


}
