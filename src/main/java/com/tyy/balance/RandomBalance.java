package com.tyy.balance;

import java.util.*;

/**
 * @author:tyy
 * @date:2021/6/16 随机负载均衡
 * 完全随机
 * 加权随机
 */
public class RandomBalance {

    public static void main(String[] args) {
        //完全随机
        Random random = new Random();

        int sum = MyServer1.list.size();

        for (int i = 0; i < 10; i++) {
            int num = random.nextInt(sum);
            System.out.println(MyServer1.list.get(num));
        }

        System.out.println("--------------------");


        //加权随机
        sum = MyServer2.map.values().stream().mapToInt(a -> a).sum();

        for (int i = 0; i < 10; i++) {
            int num = random.nextInt(sum);
            for(String key : MyServer2.map.keySet()){
                if(num<=MyServer2.map.get(key)){
                    System.out.println(key);
                    continue;
                }
                num-=MyServer2.map.get(key);
            }
        }

    }


}


class MyServer1 {

    static List<String> list = new ArrayList<>();

    static {

        list.add("127.0.0.1");
        list.add("127.0.0.2");
        list.add("127.0.0.3");
    }

}

class MyServer2 {

    static Map<String, Integer> map = new HashMap<>();

    static {

//        map.put("127.0.0.1".hashCode(),"127.0.0.1");
//        map.put("127.0.0.2".hashCode(),"127.0.0.2");
//        map.put("127.0.0.3".hashCode(),"127.0.0.3");


        map.put("127.0.0.1", 2);
        map.put("127.0.0.2", 7);
        map.put("127.0.0.3", 1);

    }
}