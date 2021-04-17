package com.frja.wifilocation.dao;

import com.frja.wifilocation.model.Wifi;
import com.frja.wifilocation.model.WifiMap;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public interface WifiMapper {

    //存储wifi指纹
    @Insert("insert into wifiPoint (mapName,mapX,mapY,ap1,ap2,ap3,ap4,createTime) values (#{mapName},#{mapX},#{mapY},#{ap1},#{ap2},#{ap3},#{ap4},#{createTime})")
    int wifiPointStore(Wifi wifi);

    //查询某点指纹
    @Select("select * from wifiPoint where mapX = #{mapX} and mapY = #{mapY} and mapName = #{mapName}")
    @ResultType(Wifi.class)
    Wifi selectApByMap(Wifi wifi);

    //删除指纹
    @Delete("delete from wifiPoint where mapX = #{wifiMapX} and mapY = #{wifiMapY}")
    int wifiDeleteByMap(WifiMap wifiMap);

    //删除所有指纹
    @Delete("delete from wifiPoint")
    int wifiAllDelete();


    //修改指纹bymap
    @Update("update wifiPoint set ap1 = #{ap1},ap2 = #{ap2},ap3 = #{ap3},ap4 = #{ap4},createTime = #{createTime} where mapX = #{mapX} and mapY = #{mapY}")
    int wifiUpdateByMap(Wifi wifi);

    //获取所有wifi指纹
    @Select("select * from wifiPoint")
    @ResultType(Wifi.class)
    ArrayList<Wifi> selectAllWifiPoint();

}
