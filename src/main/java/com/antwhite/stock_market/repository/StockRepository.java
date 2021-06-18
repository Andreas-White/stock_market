package com.antwhite.stock_market.repository;

import com.antwhite.stock_market.data.StockDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<StockDTO,Long> {
}
