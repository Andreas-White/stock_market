import {React} from 'react';
import './StockDisplay.css'

export const StockDisplay = ({stock}) => {
    return (
        <div className={"StockDisplay"}>
            <table>
                <tbody>
                <tr>
                    <td>{stock.date}</td>
                    <td>{stock.open}</td>
                    <td>{stock.high}</td>
                    <td>{stock.low}</td>
                    <td>{stock.close}</td>
                    <td>{stock.adjClose}</td>
                    <td>{stock.volume}</td>
                </tr>
                </tbody>
            </table>
        </div>
    );
}