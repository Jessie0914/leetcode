package ali_leetcode_daily.bytedance;

import java.util.HashMap;

/**
 * @ClassName Solution146
 * @Description LRU缓存机制
 * @Author shishi
 * @Date 2020/7/28 21:38
 **/
public class Solution146 {

    class Node {
        int key;
        int val;
        Node pre = null;
        Node next = null;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    // 双向链表+map
    Node head = null;
    Node tail = null;
    HashMap<Integer, Node> map = new HashMap<>();
    int capacity = 0;

    public Solution146(int capacity) {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        this.capacity = capacity;
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        Node node = map.get(key);

        unLink(node);
        moveToHead(node);
        return node.val;
    }

    private void moveToHead(Node node) {
        Node next = head.next;

        head.next = node;
        node.next = next;

        next.pre = node;
        node.pre = head;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;

            unLink(node);
            moveToHead(node);
        } else {
            Node node = new Node(key, value);
            moveToHead(node);
            map.put(key, node);

            if (map.size() > capacity) {
                Node removed = removeTailNode();
                map.remove(removed.key);
            }
        }
    }

    private Node removeTailNode() {
        Node node = tail.pre;
        Node pre = node.pre;

        pre.next = tail;
        tail.pre = pre;

        node.pre = null;
        node.next = null;

        return node;
    }

    private void unLink(Node node) {
        Node pre = node.pre;
        Node next = node.next;

        pre.next = next;
        next.pre = pre;

        node.pre = null;
        node.next = null;
    }
}
