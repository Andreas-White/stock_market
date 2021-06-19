package com.antwhite.stock_market.service;

import com.antwhite.stock_market.data.StockDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

@Service
public class StockService {

    private final static String TIME_START = " 06:00:01";
    private final static String TIME_END = " 23:59:59";
    private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Transactional
    public List<StockDTO> getStockDataList(String stockName, String dateStart, String dateEnd) throws ParseException {

        String stockData = getHttpResponseBody(stockName,getUnixTimestampStart(dateStart),getUnixTimestampEnd(dateEnd));

        StringTokenizer tokenizer = new StringTokenizer(stockData,"\n");
        tokenizer.nextToken();
        List<StockDTO> stockDataList = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            StringTokenizer innerToken = new StringTokenizer(tokenizer.nextToken(),",");
            StockDTO stockDTO = new StockDTO();
            while (innerToken.hasMoreTokens()) {
                stockDTO.setDate(innerToken.nextToken());
                stockDTO.setOpen(innerToken.nextToken());
                stockDTO.setHigh(innerToken.nextToken());
                stockDTO.setLow(innerToken.nextToken());
                stockDTO.setClose(innerToken.nextToken());
                stockDTO.setAdjClose(innerToken.nextToken());
                stockDTO.setVolume(innerToken.nextToken());
            }
            stockDataList.add(stockDTO);
        }
        return stockDataList;
    }

    private long getUnixTimestampStart(String date) throws ParseException {
        Date parseDate = DATE_FORMAT.parse(date + TIME_START);
        return parseDate.getTime()/1000;
    }

    private long getUnixTimestampEnd(String date) throws ParseException {
        Date parseDate = DATE_FORMAT.parse(date + TIME_END);
        return parseDate.getTime()/1000;
    }

    private String getHttpResponseBody (String stockName, long totalSecondsStart, long totalSecondsEnd) {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://query1.finance.yahoo.com/v7/finance/download/" + stockName +
                        "?period1=" + totalSecondsStart +
                        "&period2=" + totalSecondsEnd + "&interval=1d&events=history&includeAdjustedClose=true"))
                .build();

        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        assert response != null;
        return response.body();
    }
}
