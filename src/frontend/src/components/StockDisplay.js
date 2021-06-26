import {React} from 'react';

export const StockDisplay = ({stock}) => {
    return (
        <div className={"StockDisplay"}>
            <p>Date: {stock.date} - Open: {stock.open} - High: {stock.high} - Low: {stock.low}
                - Close: {stock.close} - Adjusted Closing Price: {stock.adjClose} - Volume: {stock.volume}</p>
        </div>
    );
}