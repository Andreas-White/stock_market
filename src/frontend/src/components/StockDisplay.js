import {React} from 'react';

export const StockDisplay = ({stock}) => {
    return (
        <div className={"StockDisplay"}>
            <p>Opened {stock} and closed {stock}</p>
        </div>
    );
}