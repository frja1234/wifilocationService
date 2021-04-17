package com.frja.wifilocation.dao;

import com.frja.wifilocation.model.Map;
import com.frja.wifilocation.model.Wifi;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Component
public interface MapMapper {

    //存储地图
    @Insert("insert into map (name,url,sizeX,sizeY) values (#{name},#{url},#{sizeX},#{sizeY})")
    int saveMap(Map map);

    //获取所有地图
    @Select("select * from map")
    @ResultType(Map.class)
    ArrayList<Map> getAllMap();

    //根据地图名字获取地图信息
    @Select("select * from map where name = #{name}")
    Map getMapByName(String name);

    //删除地图
    @Delete("delete from map where name = #{name}")
    int deleteMapByName(String name);


}
