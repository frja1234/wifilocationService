package com.frja.wifilocation.model;

public class WifiAp {

    private String wifiPointId;

    private String wifiName;

    private String wifiBssid;

    private String wifiRssi;

    public String getWifiPointId() {
        return wifiPointId;
    }

    public void setWifiPointId(String wifiPointId) {
        this.wifiPointId = wifiPointId;
    }

    public String getWifiName() {
        return wifiName;
    }

    public void setWifiName(String wifiName) {
        this.wifiName = wifiName;
    }

    public String getWifiRssi() {
        return wifiRssi;
    }

    public void setWifiRssi(String wifiRssi) {
        this.wifiRssi = wifiRssi;
    }

    public String getWifiBssid() {
        return wifiBssid;
    }

    public void setWifiBssid(String wifiBssid) {
        this.wifiBssid = wifiBssid;
    }

    @Override
    public String toString() {
        return "Wifi{" +
                "wifiPointId='" + wifiPointId + '\'' +
                ", wifiName='" + wifiName + '\'' +
                ", wifiBssid='" + wifiBssid + '\'' +
                ", wifiRssi='" + wifiRssi + '\'' +
                '}';
    }
}
