package com.antwhite.stock_market.controller;

import com.antwhite.stock_market.data.StockDTO;
import com.antwhite.stock_market.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
@CrossOrigin // So the react can fetch data from this controller
public class StockController {

    private final StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping(value = "/{stockName}/{dateStart}/{dateEnd}")
    public List<StockDTO> getStock(@PathVariable String stockName,
                                   @PathVariable String dateStart,
                                   @PathVariable String dateEnd) throws ParseException {
        return stockService.getStockDataList(stockName,dateStart,dateEnd);
    }
}
