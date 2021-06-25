import { React, useEffect, useState } from 'react';
import { StockDisplay } from '../components/StockDisplay';

export const StockPage = () => {

    //date,open,high,low,close,adjClose,volume
    const [stocks, setStocks] = useState([]);

    useEffect(
        () => {
            const fetchStockData = async () => {
                const response = await fetch("http://localhost:8080/stock/AAPL/2021-06-07/2021-06-11");
                const stockData = await response.json();
                setStocks(stockData)
                console.log(stockData);
            };
            fetchStockData();
        },[]
    );

  return (
    <div className="StockPage">
        <h2>Stock Data</h2>
        <div className="header-section">
            {stocks.map(stock => <p>Date: {stock.date} - Open: {stock.open} - High: {stock.high} - Low: {stock.low}
            - Close: {stock.close} - Adjusted Closing Price: {stock.adjClose} - Volume: {stock.volume}</p>)}
        </div>
    </div>
  );
}
