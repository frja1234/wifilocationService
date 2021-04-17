package com.frja.wifilocation.service.impl;

import com.frja.wifilocation.dao.MapMapper;
import com.frja.wifilocation.model.Map;
import com.frja.wifilocation.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MapServiceImpl implements MapService {

    @Autowired
    private MapMapper mapMapper;

    @Override
    public boolean saveMap(Map map) {
        int flag = 0;
        flag = mapMapper.saveMap(map);
        if(flag == 1) return true;
        return false;
    }

    @Override
    public ArrayList<Map> getAllMap() {

        return mapMapper.getAllMap();
    }

    @Override
    public Map getMapByName(String name) {
        return mapMapper.getMapByName(name);
    }

    @Override
    public boolean deleteMapByName(String name) {
        int flag = 0;
        flag = mapMapper.deleteMapByName(name);
        if(flag == 1) return true;
        return false;
    }
}
