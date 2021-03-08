package com.frja.wifilocation.dao;

import com.frja.wifilocation.model.Wifi;
import com.frja.wifilocation.model.WifiAp;
import com.frja.wifilocation.model.WifiMap;
import com.frja.wifilocation.model.WifiPoint;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public interface WifiMapper {

    //存储wifi指纹
    @Insert("insert into wifiPoint (wifiPointId,mapX,mapY,ap1,ap2,ap3,ap4,createTime) values (#{wifiPointId},#{mapX},#{mapY},#{ap1},#{ap2},#{ap3},#{ap4},#{createTime})")
    int wifiPointStore(Wifi wifi);

    //查询某点指纹
    @Select("select * from wifiPoint where mapX = #{wifiMapX} and mapY = #{wifiMapY}")
    @ResultType(Wifi.class)
    Wifi selectApByMap(WifiMap wifiMap);

    //删除指纹
    @Delete("delete from wifiPoint where mapX = #{wifiMapX} and mapY = #{wifiMapY}")
    int wifiDeleteByMap(WifiMap wifiMap);

    //删除所有指纹
    @Delete("delete from wifiPoint")
    int wifiAllDelete();


    //修改指纹bymap
    @Update("update wifiPoint set ap1 = #{ap1},ap2 = #{ap2},ap3 = #{ap3},ap4 = #{ap4},createTime = #{createTime} where mapX = #{mapX} and mapY = #{mapY}")
    int wifiUpdateByMap(Wifi wifi);

    //存储相应ap点
    @Insert("insert into tbl_wifi_ap (WIFI_POINT_ID,WIFI_NAME,WIFI_BSSID,WIFI_RSSI) values (#{wifiPointId},#{wifiName},#{wifiBssid},#{wifiRssi})")
    int wifiApStore(WifiAp wifi);

    //获取所有wifi指纹
    @Select("select * from wifiPoint")
    @ResultType(Wifi.class)
    ArrayList<Wifi> selectAllWifiPoint();

    //获取相应wifi指纹ap点
    @Select("select * from tbl_wifi_point where WIFI_POINT_ID = #{wifiPointId}")
    @ResultType(WifiAp.class)
    ArrayList<WifiAp> selectApByWifiPointId(String wifiPointId);

    //根据id获取wifi指纹
    @Select("select * from tbl_wifi_point where WIFI_POINT_ID = #{wifiPointId}")
    @ResultType(WifiPoint.class)
    WifiPoint selectWifiPointByWifiPointId(String wifiPointId);

    //
}
