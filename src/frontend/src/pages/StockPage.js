//import { React } from 'react';
import {TodayResults} from "../components/TodayResults";
import {YesterdayResults} from "../components/YesterdayResults";

export const StockPage = () => {
  return (
    <div className="StockPage">
        <h1>Stock Market App</h1>
        <h2>Today's Results</h2>
        <TodayResults/>
        <h3>Yesterday's Results</h3>
        <YesterdayResults/>
    </div>
  );
}
