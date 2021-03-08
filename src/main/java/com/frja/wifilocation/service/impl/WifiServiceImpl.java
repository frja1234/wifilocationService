package com.frja.wifilocation.service.impl;

import com.frja.wifilocation.dao.WifiMapper;
import com.frja.wifilocation.model.*;
import com.frja.wifilocation.service.WifiService;
import com.frja.wifilocation.utils.wifi.WifiUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class WifiServiceImpl implements WifiService {

    @Autowired
    private WifiMapper wifiMapper;

    @Override
    public boolean wifiPointStore(Wifi wifi) {
        int flag = 1;
        flag = wifiMapper.wifiPointStore(wifi);
        if(flag == 1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Wifi wifiAp(WifiMap wifiMap) {

        return wifiMapper.selectApByMap(wifiMap);
    }

    @Override
    public boolean wifiUpdateByMap(Wifi wifi) {
        int flag = 1;
        flag = wifiMapper.wifiUpdateByMap(wifi);
        if(flag == 1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public WifiMap wifiLocation(Wifi wifi) {

        ArrayList<Wifi> wifiPointStore = wifiMapper.selectAllWifiPoint();
        WifiUtils wifiUtils = new WifiUtils(wifi ,wifiPointStore);
        WifiMap wifiMap = wifiUtils.location();

        return wifiMap;
    }
}
