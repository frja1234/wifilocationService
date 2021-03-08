package com.frja.wifilocation.model;

public class WifiMap {

    private String wifiMapX;

    private String wifiMapY;

    public String getWifiMapY() {
        return wifiMapY;
    }

    public void setWifiMapY(String wifiMapY) {
        this.wifiMapY = wifiMapY;
    }

    public String getWifiMapX() {
        return wifiMapX;
    }

    public void setWifiMapX(String wifiMapX) {
        this.wifiMapX = wifiMapX;
    }

    @Override
    public String toString() {
        return "WifiMap{" +
                "wifiMapX='" + wifiMapX + '\'' +
                ", wifiMapY='" + wifiMapY + '\'' +
                '}';
    }
}
