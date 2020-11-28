package com.example.labpertama.models;

public class Record {

    private String date;
    private String wifiList;

    public Record() {
    }

    public Record(String date, String wifiList) {
        this.date = date;
        this.wifiList = wifiList;
    }

    public String getDate() {
        return date;
    }

    public String getWifiList() {
        return wifiList;
    }
}
