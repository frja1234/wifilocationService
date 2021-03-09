package com.frja.wifilocation.service;

import com.frja.wifilocation.model.Wifi;
import com.frja.wifilocation.model.WifiMap;

public interface WifiService {

    //存储wifi指纹
    public boolean wifiPointStore(Wifi wifi);

    //获取某点指纹
    public Wifi wifiAp(WifiMap wifiMap);

    //wifi指纹更新
    public boolean wifiUpdateByMap(Wifi wifi);

    //wifi定位
    public WifiMap wifiLocation(Wifi wifi);

    //

    //
}
