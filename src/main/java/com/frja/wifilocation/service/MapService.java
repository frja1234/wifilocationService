package com.frja.wifilocation.service;


import com.frja.wifilocation.model.Map;

import java.util.ArrayList;

public interface MapService {

    //存储地图
    boolean saveMap(Map map);

    //获取所有地图
    ArrayList<Map> getAllMap();

    //通过名字获取地图信息
    Map getMapByName(String name);

    //删除地图
    boolean deleteMapByName(String name);


}
