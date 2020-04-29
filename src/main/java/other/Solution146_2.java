package other;

import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * @ClassName Solution146_2
 * @Description 146. LRU缓存机制
 * @Author shishi
 * @Date 2020/4/18 21:26
 **/

// 直接的方式是利用LinkedHashMap现有的API来实现
// 因为accessOrder值为true的时候，map维护的是LRU顺序
public class Solution146_2 {
    private LinkedHashMap<Integer, Integer> map;
    private int capacity;

    public Solution146_2(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>(capacity, 1, true);
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            return map.get(key);
        } else
            return -1;
    }

    public void put(int key, int value) {
        // 如果key已经存在，那么直接更新数据即可
        if (map.containsKey(key)){
            map.put(key,value);
            return;
        }

        if (map.size() >= capacity) {
            Iterator<Integer> iterator = map.keySet().iterator();
            map.remove(iterator.next());
        }
        map.put(key,value);
    }
}
