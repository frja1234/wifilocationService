package com.frja.wifilocation.controller;

import com.frja.wifilocation.model.*;
import com.frja.wifilocation.service.WifiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/wifilocation/wifi", produces = "application/json;charset=UTF-8")
public class WifiController {
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private WifiService wifiService;

    //wifi指纹存储
    @RequestMapping(value = "/wifipointstore",method = RequestMethod.POST)
    public Map<String, Object> wifiPointStore(@RequestBody Wifi wifi){
        Map<String, Object> resultMap = new HashMap<>();
        try {
            boolean flag = wifiService.wifiPointStore(wifi);
            System.out.println(" vfjd");
            if(flag){
                resultMap.put("data",wifi.getWifiPointId());
                resultMap.put("code", "200");
                resultMap.put("msg", "存储成功");
            }else{
                resultMap.put("data","");
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
    //wifi指纹更新
    @RequestMapping(value = "/wifiUpdateByMap",method = RequestMethod.POST)
    public Map<String, Object> wifiUpdateByMap(@RequestBody Wifi wifi){
        Map<String, Object> resultMap = new HashMap<>();
        try {
            boolean flag = wifiService.wifiUpdateByMap(wifi);
            System.out.println(" vfjd");
            if(flag){
                resultMap.put("data",wifi.getWifiPointId());
                resultMap.put("code", "200");
                resultMap.put("msg", "更新成功");
            }else{
                resultMap.put("data","");
                resultMap.put("code", "500");
                resultMap.put("msg", "更新失败");
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

    //获取某点指纹
    @RequestMapping(value = "/wifiApByMap",method = RequestMethod.POST)
    public Map<String, Object> wifiApByMap(@RequestBody WifiMap wifiMap){
        Map<String, Object> resultMap = new HashMap<>();
        try {
            Wifi wifi = wifiService.wifiAp(wifiMap);
            System.out.println(" vfjd");
            if(wifi!=null){
                resultMap.put("data",wifi.toString());
                resultMap.put("code", "200");
                resultMap.put("msg", "存储成功");
            }else{
                resultMap.put("data","");
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

    //wifi定位
    @RequestMapping(value = "/wifiLocation")
    public Map<String, Object> wifiLocation(Wifi wifi){
        Map<String, Object> resultMap = new HashMap<>();
        boolean flag = false;
        try {
            WifiMap wifiMap = wifiService.wifiLocation(wifi);
            if(wifi!=null) flag=true;
            System.out.println(" vfjd");
            if(flag){
                resultMap.put("data",wifiMap);
                resultMap.put("code", "200");
                resultMap.put("msg", "定位成功");
            }else{
                resultMap.put("data","");
                resultMap.put("code", "500");
                resultMap.put("msg", "定位失败");
            }

        } catch (NumberFormatException e) {
            logger.error("error", e);
            resultMap.put("code", "500");
            resultMap.put("msg", "定位失败，userId必须为数字");
        } catch (Exception e) {
            logger.error("error", e);
            resultMap.put("code", "500");
            resultMap.put("msg", "定位失败" + e.getMessage());
        }
        return resultMap;
    }

}
