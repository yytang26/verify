package com.tyy.balance;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author:tyy
 * @date:2021/6/16 哈希算法
 */
public class HashBalance {

    private static String go(String client) {
        int nodeCount = 20;
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        for (String key : new Servers().serverMap.keySet()) {
            for(int i=0;i<nodeCount;i++){
                treeMap.put((key +i).hashCode(),key);
            }
        }
        Integer hash = client.hashCode();
        //该hash以后的hash
        SortedMap<Integer,String> stringSortedMap = treeMap.tailMap(hash);
        if(stringSortedMap.size()>=1){
            return treeMap.get(stringSortedMap.firstKey());
        }
        return treeMap.get(treeMap.firstKey());

    }

    public static void main(String[] args) {
        System.out.println(go("今天天气不错啊"));
        System.out.println(go("192.168.5.258"));
        System.out.println(go("0"));
        System.out.println(go("-110000"));
        System.out.println(go("风雨交加"));
    }
}
