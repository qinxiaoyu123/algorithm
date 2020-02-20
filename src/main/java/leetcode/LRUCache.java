package leetcode;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {

    private int cap;
    private Map<Integer, Integer> map = new LinkedHashMap<>();

    public LRUCache(int capacity) {
        this.cap = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            int value = map.get(key);
            map.remove(key);
            map.put(key, value);
            return value;
        }
        else return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.remove(key);
        }
        //检查容量满的情况
        else if(map.size() == cap){
            Iterator<Integer> iter = map.keySet().iterator();
            iter.next();
            iter.remove();
        }
        map.put(key, value);
    }
}