package ali_leetcode_daily;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LRUCache
 * @Description 面试题 16.25. LRU缓存
 * @Author shishi
 * @Date 2020/6/22 21:25
 **/

// 利用双向链表
public class LRUCache {
    private int maxSize;
    private Node head;
    private Node tail;

    // map存储值和节点的关系，方便get的时候直接返回
    private Map<Integer, Node> map;

    // 双向链表
    private class Node {
        Node pre = null;
        Node next = null;
        int k;
        int value;

        public Node(int k, int value) {
            this.k = k;
            this.value = value;
        }
    }

    // 初始化
    // 将head和tail先连接起来
    public LRUCache(int capacity) {
        this.maxSize = capacity;
        this.map = new HashMap<>(maxSize * 4 / 3);
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.pre = head;
    }

    // get
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);

        // 访问完之后，需要把它和原来的断开连接
        unLink(node);

        // 再把它移动到头结点
        moveToHead(node);

        return node.value;

    }

    private void moveToHead(Node node) {
        Node next = head.next;

        head.next = node;
        node.next = next;

        next.pre = node;
        node.pre = head;

    }

    private void unLink(Node node) {
        Node pre = node.pre;
        Node next = node.next;

        pre.next = next;
        next.pre = pre;

        node.next = null;
        node.pre = null;
    }

    // put
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;

            unLink(node);
            moveToHead(node);
        } else {
            Node node = new Node(key, value);
            moveToHead(node);
            map.put(key, node);

            // 超出容量了就删除末尾的节点
            // 同时记得要删除map中对应的KV
            if (map.size() > maxSize) {
                Node removedTail = removeTail();
                map.remove(removedTail.k);
            }
        }
    }

    private Node removeTail() {
        Node node = tail.pre;
        Node pre = node.pre;

        pre.next = tail;
        tail.pre = pre;

        node.next = null;
        node.pre = null;

        return node;
    }
}
