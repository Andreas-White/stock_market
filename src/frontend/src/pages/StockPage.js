import { React, useEffect, useState } from 'react';
import {TodayResults} from "../components/TodayResults";
import {YesterdayResults} from "../components/YesterdayResults";

export const StockPage = () => {

    const [stock, setStock] = useState();

    useEffect(
        () => {
            const fetchStockData = async () => {
                const response = await fetch("http://localhost:8080/AAPL/2021-06-07/2021-06-11");
                const stockData = await response.json();
                setStock(stockData)
                //console.log(stockData);
            };
            fetchStockData();
        }
    );

  return (
    <div className="StockPage">
        <h1>Stock Market App</h1>
        <h2></h2>
        <TodayResults/>
        <h3>Yesterday's Results</h3>
        <YesterdayResults/>
    </div>
  );
}
