package com.frja.wifilocation.controller;

import com.frja.wifilocation.service.MapService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



@RestController
@RequestMapping(value = "/wifilocation/map", produces = "application/json;charset=UTF-8")
public class MapController {
    private final static Logger logger = LoggerFactory.getLogger(MapController.class);
    @Autowired
    private MapService mapService;

    //地图存储
    @RequestMapping(value = "/mapSave", method = RequestMethod.POST)
    public Map<String, Object> mapSave(@RequestBody com.frja.wifilocation.model.Map map) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            boolean flag = mapService.saveMap(map);
            if (flag) {
                resultMap.put("data", map.getName());
                resultMap.put("code", "200");
                resultMap.put("msg", "存储成功");
            } else {
                resultMap.put("data", "");
                resultMap.put("code", "500");
                resultMap.put("msg", "存储失败");
            }

        } catch (NumberFormatException e) {
            logger.error("error", e);
            resultMap.put("code", "500");
            resultMap.put("msg", "存储失败，userId必须为数字");
        } catch (Exception e) {
            logger.error("error", e);
            resultMap.put("code", "500");
            resultMap.put("msg", "存储失败" + e.getMessage());
        }
        return resultMap;
    }
    //获取地图
    @RequestMapping(value = "/getAllMap", method = RequestMethod.POST)
    public Map<String, Object> getAllMap() {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            ArrayList<com.frja.wifilocation.model.Map> mapList = mapService.getAllMap();
            if (mapList!=null) {
                resultMap.put("data", mapList.toString());
                resultMap.put("code", "200");
                resultMap.put("msg", "获取成功");
            } else {
                resultMap.put("data", "");
                resultMap.put("code", "500");
                resultMap.put("msg", "获取失败失败");
            }

        } catch (NumberFormatException e) {
            logger.error("error", e);
            resultMap.put("code", "500");
            resultMap.put("msg", "存储失败，userId必须为数字");
        } catch (Exception e) {
            logger.error("error", e);
            resultMap.put("code", "500");
            resultMap.put("msg", "存储失败" + e.getMessage());
        }
        return resultMap;
    }

    //根据名字获取地图
    @RequestMapping(value = "/getMapByName", method = RequestMethod.POST)
    public Map<String, Object> getMapByName(@RequestBody String name) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            com.frja.wifilocation.model.Map map = mapService.getMapByName(name);
            if (map != null) {
                resultMap.put("data", map.toString());
                resultMap.put("code", "200");
                resultMap.put("msg", "获取成功");
            } else {
                resultMap.put("data", "");
                resultMap.put("code", "500");
                resultMap.put("msg", "获取失败");
            }

        } catch (NumberFormatException e) {
            logger.error("error", e);
            resultMap.put("code", "500");
            resultMap.put("msg", "存储失败，userId必须为数字");
        } catch (Exception e) {
            logger.error("error", e);
            resultMap.put("code", "500");
            resultMap.put("msg", "存储失败" + e.getMessage());
        }
        return resultMap;
    }
    //删除地图
    @RequestMapping(value = "/deleteMap", method = RequestMethod.POST)
    public Map<String, Object> deleteMap(@RequestBody String name) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            boolean flag = mapService.deleteMapByName(name);
            if (flag) {
                resultMap.put("data",name);
                resultMap.put("code", "200");
                resultMap.put("msg", "存储成功");
            } else {
                resultMap.put("data", "");
                resultMap.put("code", "500");
                resultMap.put("msg", "存储失败");
            }

        } catch (NumberFormatException e) {
            logger.error("error", e);
            resultMap.put("code", "500");
            resultMap.put("msg", "存储失败，userId必须为数字");
        } catch (Exception e) {
            logger.error("error", e);
            resultMap.put("code", "500");
            resultMap.put("msg", "存储失败" + e.getMessage());
        }
        return resultMap;
    }

}
