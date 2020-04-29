package other;

/**
 * @ClassName Solution146
 * @Description 146. LRU缓存机制
 * @Author shishi
 * @Date 2020/4/18 20:14
 * <p>
 * LRUCache cache = new LRUCache(2)
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // 返回  1
 * cache.put(3, 3);    // 该操作会使得密钥 2 作废
 * cache.get(2);       // 返回 -1 (未找到)
 * cache.put(4, 4);    // 该操作会使得密钥 1 作废
 * cache.get(1);       // 返回 -1 (未找到)
 * cache.get(3);       // 返回  3
 * cache.get(4);       // 返回  4
 **/

import java.util.HashMap;

/**
 * 可以用LinkedHashMap API来弄，因为默认有accessOrder为true的话，就是维护一个LRU顺序
 * https://blog.csdn.net/ZeromaXHe/article/details/89424332
 */

/**
 * 双向链表的数据结构
 * 需要有pre和next结点
 */
class Node {
    int key;
    int val;
    Node pre;
    Node next;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.pre = this;
        this.next = this;
    }
}

public class Solution146 {
    private int capacity;
    private HashMap<Integer, Node> map;
    // 双向链表的head结点
    // head的pre就是尾部结点，尾部结点的pre就是head
    private Node head = new Node(-1, -1);

    // 初始化
    public Solution146(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
    }

    // 如果map中有这个key，那么直接返回值
    // 并且需要移动到双向链表的最前面
    public int get(int key) {
        if (map.containsKey(key)) {
            moveNodeToFirst(map.get(key));
            return map.get(key).val;
        } else
            return -1;
    }

    public void put(int key, int value) {
        // 如果已经存在，直接更新
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            moveNodeToFirst(node);
            return;
        }

        // 生成一个新的结点
        Node node = new Node(key, value);

        // 判断空间够不够
        if (map.size() >= capacity) {
            del();
        }
        map.put(key, node);
        moveNodeToFirst(node);
    }

    // 删除尾部结点
    private void del() {
        Node last = head.pre;

        head.pre = last.pre;
        last.pre.next = head;

        map.remove(last.key);
    }


    // 将结点移动至链表的头部
    private void moveNodeToFirst(Node node) {
        // 将node的左右结点相连
        node.next.pre = node.pre;
        node.pre.next = node.next;

        // 将node和原本head的下一个结点相连
        node.next = head.next;
        head.next.pre = node;

        // 将node和head相连
        node.pre = head;
        head.next = node;
    }
}
