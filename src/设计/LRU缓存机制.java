package 设计;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRU缓存机制 {
}

class LRUCache {
    int capacity;
    Map<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>((int) ((float) capacity / 0.75f + 1.0f), 0.75f, true);
    }

    public int get(int key) {
        Integer value = map.get(key);
        if (value == null)
            return -1;
        return value;
    }


    public void put(int key, int value) {
        map.put(key, value);
        if (map.size() > capacity) {
            map.remove(map.entrySet().iterator().next().getKey());
        }
    }

}