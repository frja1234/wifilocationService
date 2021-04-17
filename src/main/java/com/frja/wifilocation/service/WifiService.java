package com.frja.wifilocation.service;

import com.frja.wifilocation.model.Wifi;
import com.frja.wifilocation.model.WifiMap;

public interface WifiService {

    //存储wifi指纹
    boolean wifiPointStore(Wifi wifi);

    //获取某点指纹
    Wifi wifiAp(Wifi wifi);

    //wifi指纹更新
    boolean wifiUpdateByMap(Wifi wifi);

    //wifi定位
    WifiMap wifiLocation(Wifi wifi);

    //

    //
}
