package com.frja.wifilocation.utils.wifi;
import com.frja.wifilocation.model.Wifi;
import com.frja.wifilocation.model.WifiMap;

import java.util.*;

public class WifiUtils {

    private Wifi wifiPoint;

    private ArrayList<Wifi> wifiPointStore;



    public WifiUtils(Wifi wifiPoint, ArrayList<Wifi> wifiPointStore) {

        this.wifiPoint = wifiPoint;
        this.wifiPointStore = wifiPointStore;
    }



    public WifiMap location(){
        WifiMap wifiMap = new WifiMap();
        wifiPoint = knnCal(1,wifiPoint,wifiPointStore);
        wifiMap.setWifiMapX(wifiPoint.getMapX());
        wifiMap.setWifiMapY(wifiPoint.getMapY());

        return wifiMap;
    }
    //欧式距离
    private static double disCal(Wifi i, Wifi td) {
        return Math.sqrt((i.getAp1() - td.getAp1())*(i.getAp1() - td.getAp1())+(i.getAp2() - td.getAp2())*(i.getAp2() - td.getAp2())+ (i.getAp3() - td.getAp3())*(i.getAp3() - td.getAp3())+(i.getAp4() - td.getAp4())*(i.getAp4() - td.getAp4()));
    }

    public static Wifi knnCal(int k, Wifi i, ArrayList<Wifi> ts) {
        //保存距离

        Map<Wifi, Double> mw = new HashMap<>();
        for (Wifi td : ts) {
            mw.put(td,disCal(i, td));
        }
        List<Map.Entry<Wifi, Double>> list = new ArrayList<>(mw.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Wifi, Double>>() {
            // 默认的是从小到大排序，
            @Override
            public int compare(Map.Entry<Wifi, Double> o1, Map.Entry<Wifi, Double> o2) {
                // 从大到小排序
                return (int) (o2.getValue() - o1.getValue());
                // 从小到大排序
                //return (int) (o1.getValue() - o2.getValue());
            }
        });
        //对ts进行排序
        return list.get(0).getKey();
    }


}
