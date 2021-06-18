package com.antwhite.stock_market.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class StockDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String unixTimeStampStart;
    private String unixTimeStampEnd;
    private String date;
    private String open;
    private String high;
    private String low;
    private String close;
    private String adjClose;
    private String volume;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUnixTimeStampStart() {
        return unixTimeStampStart;
    }

    public void setUnixTimeStampStart(String unixTimeStampStart) {
        this.unixTimeStampStart = unixTimeStampStart;
    }

    public String getUnixTimeStampEnd() {
        return unixTimeStampEnd;
    }

    public void setUnixTimeStampEnd(String unixTimeStampEnd) {
        this.unixTimeStampEnd = unixTimeStampEnd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public String getAdjClose() {
        return adjClose;
    }

    public void setAdjClose(String adjClose) {
        this.adjClose = adjClose;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockDTO stockDTO = (StockDTO) o;
        return id == stockDTO.id && Objects.equals(name, stockDTO.name) && Objects.equals(unixTimeStampStart, stockDTO.unixTimeStampStart) && Objects.equals(unixTimeStampEnd, stockDTO.unixTimeStampEnd) && Objects.equals(date, stockDTO.date) && Objects.equals(open, stockDTO.open) && Objects.equals(high, stockDTO.high) && Objects.equals(low, stockDTO.low) && Objects.equals(close, stockDTO.close) && Objects.equals(adjClose, stockDTO.adjClose) && Objects.equals(volume, stockDTO.volume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, unixTimeStampStart, unixTimeStampEnd, date, open, high, low, close, adjClose, volume);
    }

    @Override
    public String toString() {
        return "StockDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", unixTimeStampStart='" + unixTimeStampStart + '\'' +
                ", unixTimeStampEnd='" + unixTimeStampEnd + '\'' +
                ", date='" + date + '\'' +
                ", open='" + open + '\'' +
                ", high='" + high + '\'' +
                ", low='" + low + '\'' +
                ", close='" + close + '\'' +
                ", adjClose='" + adjClose + '\'' +
                ", volume='" + volume + '\'' +
                '}';
    }
}
