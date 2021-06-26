import {React, useEffect, useState} from 'react';
import {StockDisplay} from '../components/StockDisplay';
import './StockPage.css'

export const StockPage = () => {

    const [stocks, setStocks] = useState([]);

    useEffect(
        () => {
            const fetchStockData = async () => {
                const response = await fetch("http://localhost:8080/stock/AAPL/2021-06-14/2021-06-18");
                const stockData = await response.json();
                setStocks(stockData)
                console.log(stockData);
            };
            fetchStockData();
        }, []
    );

    return (
        <div className="stockPage">
            <div>
                <h2>Stock Data</h2>
            </div>
            <div className="header-section">
                <table className="tableData">
                    <thead>
                    <tr>
                        <th>Date</th>
                        <th>Open</th>
                        <th>High</th>
                        <th>Low</th>
                        <th>Close</th>
                        <th>Adjusted Closing Price</th>
                        <th>Volume</th>
                    </tr>
                    </thead>

                </table>
                {stocks.map(stock => <StockDisplay key={stock.date} stock={stock}/>)}
            </div>
        </div>
    );
}
