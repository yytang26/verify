package com.tyy.balance;

import java.util.*;

/**
 * @author:tyy
 * @date:2021/6/16 完全轮询
 * 加权轮询
 * 滑加权轮询
 */
public class LunXunBalance {


    public static void main(String[] args) {

        //完全轮询
        int index = 0;
        for (int i = 0; i < 10; i++) {
            System.out.println(MyServer3.list.get((index++) % MyServer3.list.size()));
        }

        //加权轮询
        System.out.println("-------------");
        int sum = MyServer2.map.values().stream().mapToInt(a -> a).sum();

        index = 0;

        for (int i = 0; i < 10; i++) {
            int num = (index++) % sum;
            for (String key : MyServer2.map.keySet()) {
                if (num <= MyServer2.map.get(key)) {
                    System.out.println(key);
                    continue;
                }
                num -= MyServer2.map.get(key);
            }
        }
        System.out.println("-----------------");

        Servers servers = new Servers();
        Map<String, Server> map = servers.serverMap;
        //滑加权轮询
        //1.找到当前权重中，最大的那个
        for (int i = 0; i < 15; i++) {
            int max = -1;
            for (String key : map.keySet()) {
                max = Math.max(map.get(key).getCurrentWeight(), max);
            }

            //2.最大的权重处减去当前所有权重的和
            sum = map.values().stream().mapToInt(Server::getWeight).sum();

            for (String key : map.keySet()) {
                if (map.get(key).getCurrentWeight() == max) {
                    Server server = map.get(key);
                    server.setCurrentWeight(server.getCurrentWeight() - sum);
                    map.put(key, server);
                    System.out.println(key);
                }
            }

            //3.所有当前权重加上初始权重
            for (String key : map.keySet()) {
                Server server = map.get(key);
                server.setCurrentWeight(server.getCurrentWeight() + server.getWeight());
                map.put(key, server);
            }
        }
    }
}

class MyServer3 {

    static List<String> list = new ArrayList<>();

    static {

        list.add("127.0.0.1");
        list.add("127.0.0.2");
        list.add("127.0.0.3");
    }

}

class Server {

    public Server(int weight, int currentWeight, String ip) {
        this.weight = weight;
        this.currentWeight = currentWeight;
        this.ip = ip;
    }

    private int weight;

    private int currentWeight;

    private String ip;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}

class Servers {
    public Map<String, Server> serverMap = new HashMap<String, Server>() {
        {
            put("192.168.1.1", new Server(5, 5, "192.168.1.1"));
            put("192.168.1.2", new Server(1, 1, "192.168.1.2"));
            put("192.168.1.3", new Server(1, 1, "192.168.1.3"));
        }
    };
}
