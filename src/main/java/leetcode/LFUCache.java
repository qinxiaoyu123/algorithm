package leetcode;

import java.util.*;

public class LFUCache {
    //最近最不经常使用，需要记录次数，双hash链表
    //最外层hashmap, key值是次数
    HashMap<Integer, LinkedHashMap<Integer,Integer>> map = new LinkedHashMap<>();
    //key键对应的次数
    HashMap<Integer, Integer> frequent = new LinkedHashMap<>();
    int capacity;
    int minCount;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minCount = 1;
    }

    public int get(int key) {
        if(capacity == 0) return -1;
        if(frequent.containsKey(key)){
            int tmpCount = frequent.get(key);
            LinkedHashMap<Integer, Integer> tmpMap = map.get(tmpCount);

            int value = tmpMap.get(key);
            //更新该key的访问次数
            int newCount = tmpCount+1;
            //在map中更新
            tmpMap.remove(key);
            if(tmpMap.size() == 0 && tmpCount == minCount ){
                minCount++;
            }
            if(!map.containsKey(newCount)){
                map.put(newCount, new LinkedHashMap<>());
            }
            tmpMap = map.get(newCount);
            tmpMap.put(key, value);
            //在frequent中更新
            frequent.put(key, newCount);
            return value;
        }
        else return -1;
    }

    public void put(int key, int value) {
        if(capacity == 0) return;
        if(frequent.containsKey(key)){
            int tmpCount = frequent.get(key);
            HashMap<Integer, Integer> tmpMap = map.get(tmpCount);
            //更新该key的访问次数
            int newCount = tmpCount+1;
            //在map中更新
            tmpMap.remove(key);
            if(tmpMap.size() == 0 && tmpCount == minCount ){
                minCount++;
            }
            if(!map.containsKey(newCount)){
                map.put(newCount, new LinkedHashMap<>());
            }
            tmpMap = map.get(newCount);
            tmpMap.put(key, value);
            //在frequent中更新
            frequent.put(key, newCount);
        }
        else{
            if(frequent.size() == capacity){
                //删除次数最小的最近的
//                System.out.println("delete");
                LinkedHashMap<Integer, Integer> tmp = map.get(minCount);
                Iterator<Map.Entry<Integer, Integer>> iter = tmp.entrySet().iterator();
                Map.Entry<Integer, Integer> entry = iter.next();
                int keyTmp = entry.getKey();
                frequent.remove(keyTmp);
                iter.remove();
            }
            //一个新值，那么minCount一定为1
            minCount = 1;
            frequent.put(key, 1);
            if(!map.containsKey(1)){
                map.put(1,new LinkedHashMap<>());
            }
            LinkedHashMap tmp1 = map.get(1);
            tmp1.put(key, value);

        }
    }
    public static void main(String []args){
        LFUCache cache = new LFUCache( 0/* capacity (缓存容量) */ );

        cache.put(0, 0);

        System.out.println(cache.get(0)+" aaa");// 返回 1

    }
}
