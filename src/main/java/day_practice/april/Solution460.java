package day_practice.april;

/**
 * @ClassName Solution460
 * @Description 460. LFU缓存
 * @Author shishi
 * @Date 2020/4/18 20:00
 **/

import java.util.HashMap;

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

class Node {
    int key;
    int val;
    int frequency;
    Node pre;
    Node next;

    Node(int k, int val, int frequency) {
        this.key = k;
        this.val = val;
        this.frequency = frequency;
    }
}

// 这题和146一起看
public class Solution460 {
    private int capacity;
    private HashMap<Integer, Node> map;
    private Node head = new Node(-1, -1, 0);

    public Solution460(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
    }

    public int get(int key) {

        return 0;
    }

    public void put(int key, int value) {

    }

}
