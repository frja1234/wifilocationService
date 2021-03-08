package com.frja.wifilocation.model;

import java.util.Date;

public class WifiPoint {

    private String wifiPointId;

    private WifiMap wifiMap;

    private Date createTime;


    public WifiMap getWifiMap() {
        return wifiMap;
    }

    public void setWifiMap(WifiMap wifiMap) {
        this.wifiMap = wifiMap;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getWifiPointId() {
        return wifiPointId;
    }

    public void setWifiPointId(String wifiPointId) {
        this.wifiPointId = wifiPointId;
    }

    @Override
    public String toString() {
        return "WifiPoint{" +
                "wifiPointId='" + wifiPointId + '\'' +
                ", wifiMap=" + wifiMap +
                ", createTime=" + createTime +
                '}';
    }
}
