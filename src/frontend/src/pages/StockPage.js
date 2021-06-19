import { React, useEffect, useState } from 'react';
import { StockDisplay } from '../components/StockDisplay';

export const StockPage = () => {

    const [stock, setStock] = useState({});

    useEffect(
        () => {
            const fetchStockData = async () => {
                const response = await fetch("http://localhost:8080/stock/AAPL/2021-06-07/2021-06-11");
                const stockData = await response.json();
                setStock(stockData)
                console.log(stockData);
            };
            fetchStockData();
        },[]
    );

  return (
    <div className="StockPage">

        <div className="header-section">
            <h1 className="app-name">Stock Market App</h1>
            <h3>{stock.open}</h3>
            <h3>{stock.close}</h3>
            <h3>{stock.high}</h3>
            <h3>{stock.low}</h3>
            <h3>{stock.open}</h3>
            <StockDisplay/>
            {stock.toString().toLocaleLowerCase()}
        </div>
    </div>
  );
}
