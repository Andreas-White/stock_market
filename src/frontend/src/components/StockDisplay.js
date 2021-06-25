import {React} from 'react';

export const StockDisplay = ({stock}) => {
    return (
        <div className={"StockDisplay"}>
            <p>{stock.date}</p>
            <p>{stock.open}</p>
            <p>{stock.high}</p>
            <p>{stock.low}</p>
            <p>{stock.close}</p>
            <p>{stock.adjClose}</p>
            <p>{stock.volume}</p>
        </div>
    );
}